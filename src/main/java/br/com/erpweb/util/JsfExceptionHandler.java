/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.util;

import br.com.erpweb.exception.ErpWebException;
import br.com.erpweb.view.util.JsfUtil;
import java.io.IOException;
import java.util.Iterator;
import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author everaldo
 */
public class JsfExceptionHandler extends ExceptionHandlerWrapper {

    private final Logger LOGGER = LoggerFactory.getLogger(JsfExceptionHandler.class);
    
    private ExceptionHandler wrapped;

    public JsfExceptionHandler(ExceptionHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public ExceptionHandler getWrapped() {
        return this.wrapped;
    }

    @Override
    public void handle() throws FacesException {
        Iterator<ExceptionQueuedEvent> events = getUnhandledExceptionQueuedEvents().iterator();

        while (events.hasNext()) {
            ExceptionQueuedEvent event = events.next();
            ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();

            Throwable exception = context.getException();
            ErpWebException negocioException = getBusinessException(exception);

            boolean handled = false;

            try {
                if (exception instanceof ViewExpiredException) {
                    handled = true;
                    redirect("/");
                } else if (negocioException != null) {
                    handled = true;
                    JsfUtil.addErrorMessage(negocioException.getMessage());
                } else {
                    handled = true;
                    LOGGER.error("Erro de sistema: " + exception.getMessage(), exception);
                    redirect("/Erro.xhtml");
                }
            } finally {
                if (handled) {
                    events.remove();
                }
            }
        }

        getWrapped().handle();
    }

    private ErpWebException getBusinessException(Throwable exception) {
        if (exception instanceof ErpWebException) {
            return (ErpWebException) exception;
        } else if (exception.getCause() != null) {
            return getBusinessException(exception.getCause());
        }

        return null;
    }

    private void redirect(String page) {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            String contextPath = externalContext.getRequestContextPath();

            externalContext.redirect(contextPath + page);
            facesContext.responseComplete();
        } catch (IOException e) {
            throw new FacesException(e);
        }
    }

}

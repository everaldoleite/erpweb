/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.view.upload;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
import org.primefaces.event.FileUploadEvent;
 
@ManagedBean
public class FileUploadView {
 
    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Successo", event.getFile().getFileName() + " foi enviado.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
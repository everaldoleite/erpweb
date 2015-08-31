/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.view.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author everaldo
 */
@FacesConverter("inscricaoEstadualConverter")
public class InscricaoEstadualConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {

        String inscricaoEstadual = value;
        if (value != null && !value.equals("")) {
            inscricaoEstadual = value.replaceAll("\\.", "").replaceAll("\\-", "").replaceAll("/", "");
        }

        return inscricaoEstadual;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
        return (String) value;
    }

}

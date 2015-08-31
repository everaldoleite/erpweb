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
@FacesConverter("cnaeConverter")
public class CNAEConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {

        String cnae = value;
          if (value!= null && !value.equals(""))
               cnae = value.replaceAll("\\.", "").replaceAll("\\-", "").replaceAll("/", "");
 
          return cnae;
     }
 
    @Override
     public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {

         String cnae;
          cnae = (String) value;
          if (cnae != null && cnae.length() == 7)
              cnae = cnae.substring(0, 4) + "-" + cnae.substring(4, 5) + "/" + cnae.substring(5, 7);
 
          return cnae;
     }
    
    
    
}

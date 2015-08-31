/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.view.converters;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author everaldo
 */
@FacesConverter("moedaConverter")
public class MoedaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        FacesContext fc = FacesContext.getCurrentInstance();
        Locale l = fc.getViewRoot().getLocale();

        if (value != null) {
            value = value.trim();
            if (value.length() > 0) {
                try {
                    return new BigDecimal(NumberFormat.getNumberInstance(l).parse(value).doubleValue());
                } catch (ParseException e) {
                    /// Logar
                }
            }
        }
        return null;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value == null) {
            return "";
        }
        if (value instanceof String) {
            return (String) value;
        }
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            Locale l = fc.getViewRoot().getLocale();
            NumberFormat formatador = NumberFormat.getNumberInstance(l);
            formatador.setGroupingUsed(true);
            return formatador.format(value);

        } catch (Exception e) {
            throw new ConverterException("Valor Invalido.");
        }
    }

}

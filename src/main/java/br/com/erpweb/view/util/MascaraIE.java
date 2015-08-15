/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.view.util;

/**
 *
 * @author everaldo
 */
public enum MascaraIE {
    
    RS("999-9999999"),
    SC("999.999.999"),
    PR("99999999-99"),
    SP("999.999.999.999"),
    MG("999.999.999/9999"),
    RJ("99.999.99-9"),
    ES("999.999.99-9"),
    BA("999.999.99-9"),
    SE("999999999-9"),
    AL("999999999"),
    PE("99.9.999.9999999-9"),
    PB("99999999-9"),
    RN("99.999.999-9"),
    PI("999999999"),
    MA("999999999"),
    CE("99999999-9"),
    GO("99.999.999-9"),
    TO("99999999999"),
    MT("999999999"),
    MS("999999999"),
    DF("99999999999-99"),
    AM("99.999.999-9"),
    AC("99.999.999/999-99"),
    PA("99-999999-9"),
    RO("999.99999-9"),
    RR("99999999-9"),
    AP("999999999");
    
    private final String mascara;
    
    MascaraIE(String mascara){
        this.mascara = mascara;
    }

    /**
     * @return the mascara
     */
    public String getMascara() {
        return mascara;
    }
    
    
}

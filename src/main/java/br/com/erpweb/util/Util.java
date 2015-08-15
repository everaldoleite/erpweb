/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.util;

import java.util.HashMap;

/**
 *
 * @author everaldo
 */
public class Util {

    public static String getMascaraIE(String chave) {

        HashMap<String, String> mascara = new HashMap<>();

        mascara.put("RS", "999-9999999");
        mascara.put("SC", "999.999.999");
        mascara.put("PR", "99999999-99");
        mascara.put("SP", "999.999.999.999");
        mascara.put("MG", "999.999.999/9999");
        mascara.put("RJ", "99.999.99-9");
        mascara.put("ES", "999.999.99-9");
        mascara.put("BA", "999.999.99-9");
        mascara.put("SE", "999999999-9");
        mascara.put("AL", "999999999");
        mascara.put("PE", "99.9.999.9999999-9");
        mascara.put("PB", "99999999-9");
        mascara.put("RN", "99.999.999-9");
        mascara.put("PI", "999999999");
        mascara.put("MA", "999999999");
        mascara.put("CE", "99999999-9");
        mascara.put("GO", "99.999.999-9");
        mascara.put("TO", "99999999999");
        mascara.put("MT", "999999999");
        mascara.put("MS", "999999999");
        mascara.put("DF", "99999999999-99");
        mascara.put("AM", "99.999.999-9");
        mascara.put("AC", "99.999.999/999-99");
        mascara.put("PA", "99-999999-9");
        mascara.put("RO", "999.99999-9");
        mascara.put("RR", "99999999-9");
        mascara.put("AP", "999999999");
        
        return mascara.get(chave);

    }

    
    public static int modulo11(String chave) {
        int total = 0;
        int peso = 2;

        for (int i = 0; i < chave.length(); i++) {
            total += (chave.charAt((chave.length() - 1) - i) - '0') * peso;
            peso++;
            if (peso == 10) {
                peso = 2;
            }
        }
        int resto = total % 11;
        return (resto == 0 || resto == 1) ? 0 : (11 - resto);
    }

    public static String lpadTo(String input, int width, char ch) {
        
        String retorno;
        
        StringBuilder sb = new StringBuilder(input.trim());
        while (sb.length() < width) {
            sb.insert(0, ch);
        }
        retorno = sb.toString();

        if (retorno.length() > width) {
            retorno = retorno.substring(0, width);
        }
        return retorno;
    }

}

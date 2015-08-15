/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.view.util;

import java.io.Serializable;

/**
 *
 * @author everaldo
 */
public enum UF implements Serializable {

    AC("Acre"),
    AL("Alagoas"),
    AM("Amazonas"),
    AP("Amapa"),
    BA("Bahia"),
    CE("Ceara"),
    DF("Distrito Federal"),
    ES("Espirito Santo"),
    GO("Goias"),
    MA("Maranhao"),
    MG("Minas Gerais"),
    MT("Mato Grosso"),
    MS("Mato Grosso do Sul"),
    PA("Para"),
    PB("Paraiba"),
    PE("Pernambuco"),
    PI("Piaui"),
    PR("Parana"),
    RJ("Rio de Janeiro"),
    RN("Rio Grande do Norte"),
    RO("Rondonia"),
    RR("Roraima"),
    RS("Rio Grande do Sul"),
    SC("Santa Catarina"),
    SE("Sergipe"),
    SP("Sao Paulo"),
    TO("Tocantins");

    private final String nome;

    /**
     * Construtor do enum, com parametro nomeExtenso.
     *
     * @param nome String - O nome por extenso do enum
     */
    private UF(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o nome em extenso do enum.
     *
     * @return String - O nome por extenso
     */
    public String getNome() {
        return nome;
    }

}

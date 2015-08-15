/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.exception;

/**
 *
 * @author everaldo
 */
public class ErpWebException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ErpWebException(String msg) {
        super(msg);
    }

}

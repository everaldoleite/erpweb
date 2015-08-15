/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.nfe.exception;

/**
 *
 * @author everaldo
 */
public class NFEException extends Exception {

    public NFEException(String message) {
        super(message);
    }

    public NFEException(String message, Throwable ex) {
        super(message, ex);
    }

}

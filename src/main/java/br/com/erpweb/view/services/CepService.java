/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.view.services;

import br.com.erpweb.persistence.entities.LogLogradouro;
import javax.ejb.EJB;

/**
 *
 * @author everaldo
 */
public class CepService {

    @EJB
    private br.com.erpweb.persistence.entities.LogLogradouroFacade ejbFacade;
    
    public void getEnderecoByCep(String cep){
    
        LogLogradouro resultado = ejbFacade.find("08280040");
   
    
    }

}

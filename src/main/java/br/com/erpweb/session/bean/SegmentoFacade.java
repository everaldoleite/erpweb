/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.session.bean;

import br.com.erpweb.persistence.entities.Segmento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author everaldo
 */
@Stateless
public class SegmentoFacade extends AbstractFacade<Segmento> {
    @PersistenceContext(unitName = "br.com.erpweb_erpweb_war_1.0.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegmentoFacade() {
        super(Segmento.class);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.view;

import br.com.erpweb.view.util.UF;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author everaldo
 */
@ManagedBean
@ApplicationScoped
public class DataUtil {

    public UF[] getNFs() {
        return UF.values();
    }
}

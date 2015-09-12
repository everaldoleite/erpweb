/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.g10sistemas.security;

import br.com.erpweb.persistence.entities.Usuarios;
import br.com.erpweb.util.Util;
import br.com.erpweb.view.util.JsfUtil;
import java.io.IOException;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author everaldo
 */
@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String password;
    private String message;
    private String uname;

    @PersistenceContext
    private EntityManager em;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String loginProject() {

        boolean autenticado = false;

        Usuarios usuarios = null;

        try {

            usuarios = (Usuarios) em.createNamedQuery("Usuarios.findByUsername").setParameter("username", uname).getSingleResult();

        } catch (NoResultException nr) {

            autenticado = false;
        }

        if (usuarios != null) {

            try {
                if (usuarios.getPassword().equals(Util.gerarMD5(password))) {

                    HttpSession session = JsfUtil.getSession();
                    session.setAttribute("username", uname);

                    autenticado = true;

                }
            } catch (NoSuchAlgorithmException ex) {
                JsfUtil.addErrorMessage("Autenticação Inválida. Tente novamente");
                autenticado = false;
            }

        } else {
            JsfUtil.addErrorMessage("Autenticação Inválida. Tente novamente");
            autenticado = false;
        }

        if (autenticado) {
            return "index";
                } else {
            return "login_error";
                }

        }

    public void logout() {
        HttpSession session = JsfUtil.getSession();
        session.invalidate();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml?faces-redirect=true");
        } catch (IOException ex) {
            // Logar com slf4j
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.persistence.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author everaldo
 */
@Entity
@Table(name = "NCM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ncm.findAll", query = "SELECT n FROM Ncm n"),
    @NamedQuery(name = "Ncm.findByIdNcm", query = "SELECT n FROM Ncm n WHERE n.idNcm = :idNcm")})
public class Ncm implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "ncm")
    private String ncm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome")
    private String nome;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNcm")
    private Integer idNcm;

    public Ncm() {
    }

    public Ncm(Integer idNcm) {
        this.idNcm = idNcm;
    }

    public Integer getIdNcm() {
        return idNcm;
    }

    public void setIdNcm(Integer idNcm) {
        this.idNcm = idNcm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNcm != null ? idNcm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ncm)) {
            return false;
        }
        Ncm other = (Ncm) object;
        if ((this.idNcm == null && other.idNcm != null) || (this.idNcm != null && !this.idNcm.equals(other.idNcm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.Ncm[ idNcm=" + idNcm + " ]";
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}

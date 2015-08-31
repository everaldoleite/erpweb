/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.persistence.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author everaldo
 */
@Entity
@Table(name = "REGIME_TRIBUTARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegimeTributario.findAll", query = "SELECT r FROM RegimeTributario r"),
    @NamedQuery(name = "RegimeTributario.findByIdRegimeTributario", query = "SELECT r FROM RegimeTributario r WHERE r.idRegimeTributario = :idRegimeTributario"),
    @NamedQuery(name = "RegimeTributario.findByDescricaoRegimeTributario", query = "SELECT r FROM RegimeTributario r WHERE r.descricaoRegimeTributario = :descricaoRegimeTributario")})
public class RegimeTributario implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRegimeTributario")
    private Collection<TipoTributacao> tipoTributacaoCollection;
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRegimeTributario")
    private Integer idRegimeTributario;
    
    @Size(max = 45)
    @Column(name = "descricaoRegimeTributario")
    private String descricaoRegimeTributario;
    
    public RegimeTributario() {
    }

    public RegimeTributario(Integer idRegimeTributario) {
        this.idRegimeTributario = idRegimeTributario;
    }

    public Integer getIdRegimeTributario() {
        return idRegimeTributario;
    }

    public void setIdRegimeTributario(Integer idRegimeTributario) {
        this.idRegimeTributario = idRegimeTributario;
    }

    public String getDescricaoRegimeTributario() {
        return descricaoRegimeTributario;
    }

    public void setDescricaoRegimeTributario(String descricaoRegimeTributario) {
        this.descricaoRegimeTributario = descricaoRegimeTributario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegimeTributario != null ? idRegimeTributario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegimeTributario)) {
            return false;
        }
        RegimeTributario other = (RegimeTributario) object;
        if ((this.idRegimeTributario == null && other.idRegimeTributario != null) || (this.idRegimeTributario != null && !this.idRegimeTributario.equals(other.idRegimeTributario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.RegimeTributario[ idRegimeTributario=" + idRegimeTributario + " ]";
    }

    @XmlTransient
    public Collection<TipoTributacao> getTipoTributacaoCollection() {
        return tipoTributacaoCollection;
    }

    public void setTipoTributacaoCollection(Collection<TipoTributacao> tipoTributacaoCollection) {
        this.tipoTributacaoCollection = tipoTributacaoCollection;
    }
    
}

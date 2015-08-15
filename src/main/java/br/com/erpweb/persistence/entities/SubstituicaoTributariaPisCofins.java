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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author everaldo
 */
@Entity
@Table(name = "SUBSTITUICAO_TRIBUTARIA_PIS_COFINS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubstituicaoTributariaPisCofins.findAll", query = "SELECT s FROM SubstituicaoTributariaPisCofins s"),
    @NamedQuery(name = "SubstituicaoTributariaPisCofins.findByIdsubstituicaoTributariaPIS", query = "SELECT s FROM SubstituicaoTributariaPisCofins s WHERE s.idsubstituicaoTributariaPIS = :idsubstituicaoTributariaPIS")})
public class SubstituicaoTributariaPisCofins implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsubstituicaoTributariaPIS")
    private Integer idsubstituicaoTributariaPIS;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsubstituicaoTributariaPIS")
    private Collection<NaturezaOperacao> naturezaOperacaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsubstituicaoTributariaCOFINS")
    private Collection<NaturezaOperacao> naturezaOperacaoCollection1;

    public SubstituicaoTributariaPisCofins() {
    }

    public SubstituicaoTributariaPisCofins(Integer idsubstituicaoTributariaPIS) {
        this.idsubstituicaoTributariaPIS = idsubstituicaoTributariaPIS;
    }

    public Integer getIdsubstituicaoTributariaPIS() {
        return idsubstituicaoTributariaPIS;
    }

    public void setIdsubstituicaoTributariaPIS(Integer idsubstituicaoTributariaPIS) {
        this.idsubstituicaoTributariaPIS = idsubstituicaoTributariaPIS;
    }

    @XmlTransient
    public Collection<NaturezaOperacao> getNaturezaOperacaoCollection() {
        return naturezaOperacaoCollection;
    }

    public void setNaturezaOperacaoCollection(Collection<NaturezaOperacao> naturezaOperacaoCollection) {
        this.naturezaOperacaoCollection = naturezaOperacaoCollection;
    }

    @XmlTransient
    public Collection<NaturezaOperacao> getNaturezaOperacaoCollection1() {
        return naturezaOperacaoCollection1;
    }

    public void setNaturezaOperacaoCollection1(Collection<NaturezaOperacao> naturezaOperacaoCollection1) {
        this.naturezaOperacaoCollection1 = naturezaOperacaoCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsubstituicaoTributariaPIS != null ? idsubstituicaoTributariaPIS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubstituicaoTributariaPisCofins)) {
            return false;
        }
        SubstituicaoTributariaPisCofins other = (SubstituicaoTributariaPisCofins) object;
        if ((this.idsubstituicaoTributariaPIS == null && other.idsubstituicaoTributariaPIS != null) || (this.idsubstituicaoTributariaPIS != null && !this.idsubstituicaoTributariaPIS.equals(other.idsubstituicaoTributariaPIS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.SubstituicaoTributariaPisCofins[ idsubstituicaoTributariaPIS=" + idsubstituicaoTributariaPIS + " ]";
    }
    
}

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
@Table(name = "NATUREZA_OPERACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NaturezaOperacao.findAll", query = "SELECT n FROM NaturezaOperacao n"),
    @NamedQuery(name = "NaturezaOperacao.findByIdNaturezaOperacao", query = "SELECT n FROM NaturezaOperacao n WHERE n.idNaturezaOperacao = :idNaturezaOperacao"),
    @NamedQuery(name = "NaturezaOperacao.findByCodigoOperacao", query = "SELECT n FROM NaturezaOperacao n WHERE n.codigoOperacao = :codigoOperacao"),
    @NamedQuery(name = "NaturezaOperacao.findByDescricaoOperacao", query = "SELECT n FROM NaturezaOperacao n WHERE n.descricaoOperacao = :descricaoOperacao")})
public class NaturezaOperacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNaturezaOperacao")
    private Integer idNaturezaOperacao;
    @Column(name = "codigoOperacao")
    private Integer codigoOperacao;
    @Size(max = 45)
    @Column(name = "descricaoOperacao")
    private String descricaoOperacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNaturezaOperacao")
    private Collection<Cliente> clienteCollection;

    public NaturezaOperacao() {
    }

    public NaturezaOperacao(Integer idNaturezaOperacao) {
        this.idNaturezaOperacao = idNaturezaOperacao;
    }

    public Integer getIdNaturezaOperacao() {
        return idNaturezaOperacao;
    }

    public void setIdNaturezaOperacao(Integer idNaturezaOperacao) {
        this.idNaturezaOperacao = idNaturezaOperacao;
    }

    public Integer getCodigoOperacao() {
        return codigoOperacao;
    }

    public void setCodigoOperacao(Integer codigoOperacao) {
        this.codigoOperacao = codigoOperacao;
    }

    public String getDescricaoOperacao() {
        return descricaoOperacao;
    }

    public void setDescricaoOperacao(String descricaoOperacao) {
        this.descricaoOperacao = descricaoOperacao;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNaturezaOperacao != null ? idNaturezaOperacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NaturezaOperacao)) {
            return false;
        }
        NaturezaOperacao other = (NaturezaOperacao) object;
        if ((this.idNaturezaOperacao == null && other.idNaturezaOperacao != null) || (this.idNaturezaOperacao != null && !this.idNaturezaOperacao.equals(other.idNaturezaOperacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.NaturezaOperacao[ idNaturezaOperacao=" + idNaturezaOperacao + " ]";
    }
    
}

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TIPO_TRIBUTACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoTributacao.findAll", query = "SELECT t FROM TipoTributacao t"),
    @NamedQuery(name = "TipoTributacao.findByIdTipoTributacao", query = "SELECT t FROM TipoTributacao t WHERE t.idTipoTributacao = :idTipoTributacao"),
    @NamedQuery(name = "TipoTributacao.findByCodigoTipoTributacao", query = "SELECT t FROM TipoTributacao t WHERE t.codigoTipoTributacao = :codigoTipoTributacao"),
    @NamedQuery(name = "TipoTributacao.findByDescricaoTipoTributacao", query = "SELECT t FROM TipoTributacao t WHERE t.descricaoTipoTributacao = :descricaoTipoTributacao")})
public class TipoTributacao implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoTributacao")
    private Collection<Produto> produtoCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoTributacao")
    private Integer idTipoTributacao;
    @Column(name = "codigoTipoTributacao")
    private Integer codigoTipoTributacao;
    @Size(max = 300)
    @Column(name = "descricaoTipoTributacao")
    private String descricaoTipoTributacao;
    @JoinColumn(name = "idRegimeTributario", referencedColumnName = "idRegimeTributario")
    @ManyToOne(optional = false)
    private RegimeTributario idRegimeTributario;
    
    public TipoTributacao() {
    }

    public TipoTributacao(Integer idTipoTributacao) {
        this.idTipoTributacao = idTipoTributacao;
    }

    public Integer getIdTipoTributacao() {
        return idTipoTributacao;
    }

    public void setIdTipoTributacao(Integer idTipoTributacao) {
        this.idTipoTributacao = idTipoTributacao;
    }

    public Integer getCodigoTipoTributacao() {
        return codigoTipoTributacao;
    }

    public void setCodigoTipoTributacao(Integer codigoTipoTributacao) {
        this.codigoTipoTributacao = codigoTipoTributacao;
    }

    public String getDescricaoTipoTributacao() {
        return descricaoTipoTributacao;
    }

    public void setDescricaoTipoTributacao(String descricaoTipoTributacao) {
        this.descricaoTipoTributacao = descricaoTipoTributacao;
    }

    public RegimeTributario getIdRegimeTributario() {
        return idRegimeTributario;
    }

    public void setIdRegimeTributario(RegimeTributario idRegimeTributario) {
        this.idRegimeTributario = idRegimeTributario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoTributacao != null ? idTipoTributacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTributacao)) {
            return false;
        }
        TipoTributacao other = (TipoTributacao) object;
        if ((this.idTipoTributacao == null && other.idTipoTributacao != null) || (this.idTipoTributacao != null && !this.idTipoTributacao.equals(other.idTipoTributacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.TipoTributacao[ idTipoTributacao=" + idTipoTributacao + " ]";
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }
    
}

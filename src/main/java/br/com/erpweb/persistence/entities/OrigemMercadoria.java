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
@Table(name = "ORIGEM_MERCADORIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrigemMercadoria.findAll", query = "SELECT o FROM OrigemMercadoria o"),
    @NamedQuery(name = "OrigemMercadoria.findByIdOrigemMercadoria", query = "SELECT o FROM OrigemMercadoria o WHERE o.idOrigemMercadoria = :idOrigemMercadoria"),
    @NamedQuery(name = "OrigemMercadoria.findByCodigoOrigemMercadoria", query = "SELECT o FROM OrigemMercadoria o WHERE o.codigoOrigemMercadoria = :codigoOrigemMercadoria"),
    @NamedQuery(name = "OrigemMercadoria.findByDescricaoOrigemMercadoria", query = "SELECT o FROM OrigemMercadoria o WHERE o.descricaoOrigemMercadoria = :descricaoOrigemMercadoria")})
public class OrigemMercadoria implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrigemMercadoria")
    private Collection<Produto> produtoCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOrigemMercadoria")
    private Integer idOrigemMercadoria;
    @Column(name = "codigoOrigemMercadoria")
    private Integer codigoOrigemMercadoria;
    @Size(max = 300)
    @Column(name = "descricaoOrigemMercadoria")
    private String descricaoOrigemMercadoria;

    public OrigemMercadoria() {
    }

    public OrigemMercadoria(Integer idOrigemMercadoria) {
        this.idOrigemMercadoria = idOrigemMercadoria;
    }

    public Integer getIdOrigemMercadoria() {
        return idOrigemMercadoria;
    }

    public void setIdOrigemMercadoria(Integer idOrigemMercadoria) {
        this.idOrigemMercadoria = idOrigemMercadoria;
    }

    public Integer getCodigoOrigemMercadoria() {
        return codigoOrigemMercadoria;
    }

    public void setCodigoOrigemMercadoria(Integer codigoOrigemMercadoria) {
        this.codigoOrigemMercadoria = codigoOrigemMercadoria;
    }

    public String getDescricaoOrigemMercadoria() {
        return descricaoOrigemMercadoria;
    }

    public void setDescricaoOrigemMercadoria(String descricaoOrigemMercadoria) {
        this.descricaoOrigemMercadoria = descricaoOrigemMercadoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrigemMercadoria != null ? idOrigemMercadoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrigemMercadoria)) {
            return false;
        }
        OrigemMercadoria other = (OrigemMercadoria) object;
        if ((this.idOrigemMercadoria == null && other.idOrigemMercadoria != null) || (this.idOrigemMercadoria != null && !this.idOrigemMercadoria.equals(other.idOrigemMercadoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.OrigemMercadoria[ idOrigemMercadoria=" + idOrigemMercadoria + " ]";
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }
    
}

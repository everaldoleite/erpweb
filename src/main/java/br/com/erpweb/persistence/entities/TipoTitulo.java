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
@Table(name = "TIPO_TITULO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoTitulo.findAll", query = "SELECT t FROM TipoTitulo t"),
    @NamedQuery(name = "TipoTitulo.findByIdTipoTitulo", query = "SELECT t FROM TipoTitulo t WHERE t.idTipoTitulo = :idTipoTitulo"),
    @NamedQuery(name = "TipoTitulo.findByDescricaoTipoTitulo", query = "SELECT t FROM TipoTitulo t WHERE t.descricaoTipoTitulo = :descricaoTipoTitulo"),
    @NamedQuery(name = "TipoTitulo.findByTipo", query = "SELECT t FROM TipoTitulo t WHERE t.tipo = :tipo")})
public class TipoTitulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoTitulo")
    private Integer idTipoTitulo;
    @Size(max = 45)
    @Column(name = "descricaoTipoTitulo")
    private String descricaoTipoTitulo;
    @Column(name = "tipo")
    private Character tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoTitulo")
    private Collection<NaturezaOperacao> naturezaOperacaoCollection;

    public TipoTitulo() {
    }

    public TipoTitulo(Integer idTipoTitulo) {
        this.idTipoTitulo = idTipoTitulo;
    }

    public Integer getIdTipoTitulo() {
        return idTipoTitulo;
    }

    public void setIdTipoTitulo(Integer idTipoTitulo) {
        this.idTipoTitulo = idTipoTitulo;
    }

    public String getDescricaoTipoTitulo() {
        return descricaoTipoTitulo;
    }

    public void setDescricaoTipoTitulo(String descricaoTipoTitulo) {
        this.descricaoTipoTitulo = descricaoTipoTitulo;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<NaturezaOperacao> getNaturezaOperacaoCollection() {
        return naturezaOperacaoCollection;
    }

    public void setNaturezaOperacaoCollection(Collection<NaturezaOperacao> naturezaOperacaoCollection) {
        this.naturezaOperacaoCollection = naturezaOperacaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoTitulo != null ? idTipoTitulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTitulo)) {
            return false;
        }
        TipoTitulo other = (TipoTitulo) object;
        if ((this.idTipoTitulo == null && other.idTipoTitulo != null) || (this.idTipoTitulo != null && !this.idTipoTitulo.equals(other.idTipoTitulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.TipoTitulo[ idTipoTitulo=" + idTipoTitulo + " ]";
    }
    
}

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
@Table(name = "ESPECIE_DOCUMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EspecieDocumento.findAll", query = "SELECT e FROM EspecieDocumento e"),
    @NamedQuery(name = "EspecieDocumento.findByIdEspecieDocumento", query = "SELECT e FROM EspecieDocumento e WHERE e.idEspecieDocumento = :idEspecieDocumento"),
    @NamedQuery(name = "EspecieDocumento.findByCodigoEspecieDocumento", query = "SELECT e FROM EspecieDocumento e WHERE e.codigoEspecieDocumento = :codigoEspecieDocumento"),
    @NamedQuery(name = "EspecieDocumento.findByDescricaoEspecieDocumento", query = "SELECT e FROM EspecieDocumento e WHERE e.descricaoEspecieDocumento = :descricaoEspecieDocumento")})
public class EspecieDocumento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEspecieDocumento")
    private Integer idEspecieDocumento;
    @Size(max = 2)
    @Column(name = "codigoEspecieDocumento")
    private String codigoEspecieDocumento;
    @Size(max = 45)
    @Column(name = "descricaoEspecieDocumento")
    private String descricaoEspecieDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEspecieDocumento")
    private Collection<TipoCobranca> tipoCobrancaCollection;

    public EspecieDocumento() {
    }

    public EspecieDocumento(Integer idEspecieDocumento) {
        this.idEspecieDocumento = idEspecieDocumento;
    }

    public Integer getIdEspecieDocumento() {
        return idEspecieDocumento;
    }

    public void setIdEspecieDocumento(Integer idEspecieDocumento) {
        this.idEspecieDocumento = idEspecieDocumento;
    }

    public String getCodigoEspecieDocumento() {
        return codigoEspecieDocumento;
    }

    public void setCodigoEspecieDocumento(String codigoEspecieDocumento) {
        this.codigoEspecieDocumento = codigoEspecieDocumento;
    }

    public String getDescricaoEspecieDocumento() {
        return descricaoEspecieDocumento;
    }

    public void setDescricaoEspecieDocumento(String descricaoEspecieDocumento) {
        this.descricaoEspecieDocumento = descricaoEspecieDocumento;
    }

    @XmlTransient
    public Collection<TipoCobranca> getTipoCobrancaCollection() {
        return tipoCobrancaCollection;
    }

    public void setTipoCobrancaCollection(Collection<TipoCobranca> tipoCobrancaCollection) {
        this.tipoCobrancaCollection = tipoCobrancaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEspecieDocumento != null ? idEspecieDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EspecieDocumento)) {
            return false;
        }
        EspecieDocumento other = (EspecieDocumento) object;
        if ((this.idEspecieDocumento == null && other.idEspecieDocumento != null) || (this.idEspecieDocumento != null && !this.idEspecieDocumento.equals(other.idEspecieDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.exception.EspecieDocumento[ idEspecieDocumento=" + idEspecieDocumento + " ]";
    }
    
}

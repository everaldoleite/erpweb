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
@Table(name = "TIPO_TRANSPORTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoTransporte.findAll", query = "SELECT t FROM TipoTransporte t"),
    @NamedQuery(name = "TipoTransporte.findByIdTipoTransporte", query = "SELECT t FROM TipoTransporte t WHERE t.idTipoTransporte = :idTipoTransporte"),
    @NamedQuery(name = "TipoTransporte.findByDescricaoTipoTransporte", query = "SELECT t FROM TipoTransporte t WHERE t.descricaoTipoTransporte = :descricaoTipoTransporte")})
public class TipoTransporte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoTransporte")
    private Integer idTipoTransporte;
    @Size(max = 45)
    @Column(name = "descricaoTipoTransporte")
    private String descricaoTipoTransporte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoTransporte")
    private Collection<Cliente> clienteCollection;

    public TipoTransporte() {
    }

    public TipoTransporte(Integer idTipoTransporte) {
        this.idTipoTransporte = idTipoTransporte;
    }

    public Integer getIdTipoTransporte() {
        return idTipoTransporte;
    }

    public void setIdTipoTransporte(Integer idTipoTransporte) {
        this.idTipoTransporte = idTipoTransporte;
    }

    public String getDescricaoTipoTransporte() {
        return descricaoTipoTransporte;
    }

    public void setDescricaoTipoTransporte(String descricaoTipoTransporte) {
        this.descricaoTipoTransporte = descricaoTipoTransporte;
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
        hash += (idTipoTransporte != null ? idTipoTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTransporte)) {
            return false;
        }
        TipoTransporte other = (TipoTransporte) object;
        if ((this.idTipoTransporte == null && other.idTipoTransporte != null) || (this.idTipoTransporte != null && !this.idTipoTransporte.equals(other.idTipoTransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.TipoTransporte[ idTipoTransporte=" + idTipoTransporte + " ]";
    }
    
}

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author everaldo
 */
@Entity
@Table(name = "TRANSPORTADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transportador.findAll", query = "SELECT t FROM Transportador t"),
    @NamedQuery(name = "Transportador.findByIdCodigoTransportador", query = "SELECT t FROM Transportador t WHERE t.idCodigoTransportador = :idCodigoTransportador")})
public class Transportador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCodigoTransportador")
    private Integer idCodigoTransportador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCodigoTransportador")
    private Collection<Cliente> clienteCollection;

    public Transportador() {
    }

    public Transportador(Integer idCodigoTransportador) {
        this.idCodigoTransportador = idCodigoTransportador;
    }

    public Integer getIdCodigoTransportador() {
        return idCodigoTransportador;
    }

    public void setIdCodigoTransportador(Integer idCodigoTransportador) {
        this.idCodigoTransportador = idCodigoTransportador;
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
        hash += (idCodigoTransportador != null ? idCodigoTransportador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transportador)) {
            return false;
        }
        Transportador other = (Transportador) object;
        if ((this.idCodigoTransportador == null && other.idCodigoTransportador != null) || (this.idCodigoTransportador != null && !this.idCodigoTransportador.equals(other.idCodigoTransportador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.Transportador[ idCodigoTransportador=" + idCodigoTransportador + " ]";
    }
    
}

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
@Table(name = "SEGMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Segmento.findAll", query = "SELECT s FROM Segmento s"),
    @NamedQuery(name = "Segmento.findByIdCodigoSegmento", query = "SELECT s FROM Segmento s WHERE s.idCodigoSegmento = :idCodigoSegmento"),
    @NamedQuery(name = "Segmento.findByDescricaoSegmento", query = "SELECT s FROM Segmento s WHERE s.descricaoSegmento = :descricaoSegmento")})
public class Segmento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCodigoSegmento")
    private Integer idCodigoSegmento;
    @Size(max = 45)
    @Column(name = "descricaoSegmento")
    private String descricaoSegmento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCodigoSegmento")
    private Collection<Cliente> clienteCollection;

    public Segmento() {
    }

    public Segmento(Integer idCodigoSegmento) {
        this.idCodigoSegmento = idCodigoSegmento;
    }

    public Integer getIdCodigoSegmento() {
        return idCodigoSegmento;
    }

    public void setIdCodigoSegmento(Integer idCodigoSegmento) {
        this.idCodigoSegmento = idCodigoSegmento;
    }

    public String getDescricaoSegmento() {
        return descricaoSegmento;
    }

    public void setDescricaoSegmento(String descricaoSegmento) {
        this.descricaoSegmento = descricaoSegmento;
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
        hash += (idCodigoSegmento != null ? idCodigoSegmento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Segmento)) {
            return false;
        }
        Segmento other = (Segmento) object;
        if ((this.idCodigoSegmento == null && other.idCodigoSegmento != null) || (this.idCodigoSegmento != null && !this.idCodigoSegmento.equals(other.idCodigoSegmento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.Segmento[ idCodigoSegmento=" + idCodigoSegmento + " ]";
    }
    
}

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author everaldo
 */
@Entity
@Table(name = "REPRESENTANTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Representantes.findAll", query = "SELECT r FROM Representantes r"),
    @NamedQuery(name = "Representantes.findByIdRepresentante", query = "SELECT r FROM Representantes r WHERE r.idRepresentante = :idRepresentante")})
public class Representantes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRepresentante")
    private Integer idRepresentante;
    
    @Size(max = 45)
    @Column(name = "nomeRepresentante")
    private String nomeRepresentante;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRepresentante")
    private Collection<PedidoVenda> pedidoVendaCollection;

    public Representantes() {
    }

    public Representantes(Integer idRepresentante) {
        this.idRepresentante = idRepresentante;
    }

    public Integer getIdRepresentante() {
        return idRepresentante;
    }

    public void setIdRepresentante(Integer idRepresentante) {
        this.idRepresentante = idRepresentante;
    }

    @XmlTransient
    public Collection<PedidoVenda> getPedidoVendaCollection() {
        return pedidoVendaCollection;
    }

    public void setPedidoVendaCollection(Collection<PedidoVenda> pedidoVendaCollection) {
        this.pedidoVendaCollection = pedidoVendaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRepresentante != null ? idRepresentante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Representantes)) {
            return false;
        }
        Representantes other = (Representantes) object;
        if ((this.idRepresentante == null && other.idRepresentante != null) || (this.idRepresentante != null && !this.idRepresentante.equals(other.idRepresentante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.exception.Representantes[ idRepresentante=" + idRepresentante + " ]";
    }

    /**
     * @return the nomeRepresentante
     */
    public String getNomeRepresentante() {
        return nomeRepresentante;
    }

    /**
     * @param nomeRepresentante the nomeRepresentante to set
     */
    public void setNomeRepresentante(String nomeRepresentante) {
        this.nomeRepresentante = nomeRepresentante;
    }
    
}

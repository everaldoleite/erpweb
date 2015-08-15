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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CARTEIRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carteira.findAll", query = "SELECT c FROM Carteira c"),
    @NamedQuery(name = "Carteira.findByIdCarteira", query = "SELECT c FROM Carteira c WHERE c.idCarteira = :idCarteira")})
public class Carteira implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCarteira")
    private Integer idCarteira;
    @JoinColumn(name = "BANCO_idBanco", referencedColumnName = "idBanco")
    @ManyToOne(optional = false)
    private Banco bANCOidBanco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCarteira")
    private Collection<Cliente> clienteCollection;

    public Carteira() {
    }

    public Carteira(Integer idCarteira) {
        this.idCarteira = idCarteira;
    }

    public Integer getIdCarteira() {
        return idCarteira;
    }

    public void setIdCarteira(Integer idCarteira) {
        this.idCarteira = idCarteira;
    }

    public Banco getBANCOidBanco() {
        return bANCOidBanco;
    }

    public void setBANCOidBanco(Banco bANCOidBanco) {
        this.bANCOidBanco = bANCOidBanco;
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
        hash += (idCarteira != null ? idCarteira.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carteira)) {
            return false;
        }
        Carteira other = (Carteira) object;
        if ((this.idCarteira == null && other.idCarteira != null) || (this.idCarteira != null && !this.idCarteira.equals(other.idCarteira))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.Carteira[ idCarteira=" + idCarteira + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.persistence.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author everaldo
 */
@Entity
@Table(name = "CENTRO_RESULTADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CentroResultado.findAll", query = "SELECT c FROM CentroResultado c"),
    @NamedQuery(name = "CentroResultado.findByIdCentroResultado", query = "SELECT c FROM CentroResultado c WHERE c.idCentroResultado = :idCentroResultado")})
public class CentroResultado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCentroResultado")
    private Integer idCentroResultado;

    public CentroResultado() {
    }

    public CentroResultado(Integer idCentroResultado) {
        this.idCentroResultado = idCentroResultado;
    }

    public Integer getIdCentroResultado() {
        return idCentroResultado;
    }

    public void setIdCentroResultado(Integer idCentroResultado) {
        this.idCentroResultado = idCentroResultado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCentroResultado != null ? idCentroResultado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CentroResultado)) {
            return false;
        }
        CentroResultado other = (CentroResultado) object;
        if ((this.idCentroResultado == null && other.idCentroResultado != null) || (this.idCentroResultado != null && !this.idCentroResultado.equals(other.idCentroResultado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.CentroResultado[ idCentroResultado=" + idCentroResultado + " ]";
    }
    
}

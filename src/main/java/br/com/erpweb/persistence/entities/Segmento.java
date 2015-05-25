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
    @NamedQuery(name = "Segmento.findByIdSEGMENTO", query = "SELECT s FROM Segmento s WHERE s.idSEGMENTO = :idSEGMENTO"),
    @NamedQuery(name = "Segmento.findByDescricaoSegmento", query = "SELECT s FROM Segmento s WHERE s.descricaoSegmento = :descricaoSegmento")})
public class Segmento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSEGMENTO")
    private Integer idSEGMENTO;
    @Size(max = 45)
    @Column(name = "descricaoSegmento")
    private String descricaoSegmento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSEGMENTO")
    private Collection<Empresa> empresaCollection;

    public Segmento() {
    }

    public Segmento(Integer idSEGMENTO) {
        this.idSEGMENTO = idSEGMENTO;
    }

    public Integer getIdSEGMENTO() {
        return idSEGMENTO;
    }

    public void setIdSEGMENTO(Integer idSEGMENTO) {
        this.idSEGMENTO = idSEGMENTO;
    }

    public String getDescricaoSegmento() {
        return descricaoSegmento;
    }

    public void setDescricaoSegmento(String descricaoSegmento) {
        this.descricaoSegmento = descricaoSegmento;
    }

    @XmlTransient
    public Collection<Empresa> getEmpresaCollection() {
        return empresaCollection;
    }

    public void setEmpresaCollection(Collection<Empresa> empresaCollection) {
        this.empresaCollection = empresaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSEGMENTO != null ? idSEGMENTO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Segmento)) {
            return false;
        }
        Segmento other = (Segmento) object;
        if ((this.idSEGMENTO == null && other.idSEGMENTO != null) || (this.idSEGMENTO != null && !this.idSEGMENTO.equals(other.idSEGMENTO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.Segmento[ idSEGMENTO=" + idSEGMENTO + " ]";
    }
    
}

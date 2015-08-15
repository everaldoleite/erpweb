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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author everaldo
 */
@Entity
@Table(name = "MUNICIPIOS_IBGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MunicipiosIbge.findAll", query = "SELECT m FROM MunicipiosIbge m"),
    @NamedQuery(name = "MunicipiosIbge.findByIdMunicipiosIBGE", query = "SELECT m FROM MunicipiosIbge m WHERE m.idMunicipiosIBGE = :idMunicipiosIBGE"),
    @NamedQuery(name = "MunicipiosIbge.findByCodigoIBGE", query = "SELECT m FROM MunicipiosIbge m WHERE m.codigoIBGE = :codigoIBGE"),
    @NamedQuery(name = "MunicipiosIbge.findByUfIBGE", query = "SELECT m FROM MunicipiosIbge m WHERE m.ufIBGE = :ufIBGE"),
    @NamedQuery(name = "MunicipiosIbge.findByCidadeIBGE", query = "SELECT m FROM MunicipiosIbge m WHERE m.cidadeIBGE = :cidadeIBGE")})
public class MunicipiosIbge implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMunicipiosIBGE")
    private Integer idMunicipiosIBGE;
    @Size(max = 10)
    @Column(name = "codigoIBGE")
    private String codigoIBGE;
    @Size(max = 45)
    @Column(name = "ufIBGE")
    private String ufIBGE;
    @Size(max = 45)
    @Column(name = "cidadeIBGE")
    private String cidadeIBGE;

    public MunicipiosIbge() {
    }

    public MunicipiosIbge(Integer idMunicipiosIBGE) {
        this.idMunicipiosIBGE = idMunicipiosIBGE;
    }

    public Integer getIdMunicipiosIBGE() {
        return idMunicipiosIBGE;
    }

    public void setIdMunicipiosIBGE(Integer idMunicipiosIBGE) {
        this.idMunicipiosIBGE = idMunicipiosIBGE;
    }

    public String getCodigoIBGE() {
        return codigoIBGE;
    }

    public void setCodigoIBGE(String codigoIBGE) {
        this.codigoIBGE = codigoIBGE;
    }

    public String getUfIBGE() {
        return ufIBGE;
    }

    public void setUfIBGE(String ufIBGE) {
        this.ufIBGE = ufIBGE;
    }

    public String getCidadeIBGE() {
        return cidadeIBGE;
    }

    public void setCidadeIBGE(String cidadeIBGE) {
        this.cidadeIBGE = cidadeIBGE;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMunicipiosIBGE != null ? idMunicipiosIBGE.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MunicipiosIbge)) {
            return false;
        }
        MunicipiosIbge other = (MunicipiosIbge) object;
        if ((this.idMunicipiosIBGE == null && other.idMunicipiosIBGE != null) || (this.idMunicipiosIBGE != null && !this.idMunicipiosIBGE.equals(other.idMunicipiosIBGE))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.MunicipiosIbge[ idMunicipiosIBGE=" + idMunicipiosIBGE + " ]";
    }
    
}

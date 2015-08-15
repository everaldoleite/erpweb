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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author everaldo
 */
@Entity
@Table(name = "log_bairro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogBairro.findAll", query = "SELECT l FROM LogBairro l"),
    @NamedQuery(name = "LogBairro.findByBaiNuSequencial", query = "SELECT l FROM LogBairro l WHERE l.baiNuSequencial = :baiNuSequencial"),
    @NamedQuery(name = "LogBairro.findByUfeSg", query = "SELECT l FROM LogBairro l WHERE l.ufeSg = :ufeSg"),
    @NamedQuery(name = "LogBairro.findByBaiNo", query = "SELECT l FROM LogBairro l WHERE l.baiNo = :baiNo"),
    @NamedQuery(name = "LogBairro.findByBaiNoAbrev", query = "SELECT l FROM LogBairro l WHERE l.baiNoAbrev = :baiNoAbrev")})
public class LogBairro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "bai_nu_sequencial")
    private Integer baiNuSequencial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ufe_sg")
    private String ufeSg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 72)
    @Column(name = "bai_no")
    private String baiNo;
    @Size(max = 36)
    @Column(name = "bai_no_abrev")
    private String baiNoAbrev;
    @JoinColumn(name = "loc_nu_sequencial", referencedColumnName = "loc_nu_sequencial")
    @ManyToOne(optional = false)
    private LogLocalidade locNuSequencial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baiNuSequencialIni")
    private Collection<LogLogradouro> logLogradouroCollection;

    public LogBairro() {
    }

    public LogBairro(Integer baiNuSequencial) {
        this.baiNuSequencial = baiNuSequencial;
    }

    public LogBairro(Integer baiNuSequencial, String ufeSg, String baiNo) {
        this.baiNuSequencial = baiNuSequencial;
        this.ufeSg = ufeSg;
        this.baiNo = baiNo;
    }

    public Integer getBaiNuSequencial() {
        return baiNuSequencial;
    }

    public void setBaiNuSequencial(Integer baiNuSequencial) {
        this.baiNuSequencial = baiNuSequencial;
    }

    public String getUfeSg() {
        return ufeSg;
    }

    public void setUfeSg(String ufeSg) {
        this.ufeSg = ufeSg;
    }

    public String getBaiNo() {
        return baiNo;
    }

    public void setBaiNo(String baiNo) {
        this.baiNo = baiNo;
    }

    public String getBaiNoAbrev() {
        return baiNoAbrev;
    }

    public void setBaiNoAbrev(String baiNoAbrev) {
        this.baiNoAbrev = baiNoAbrev;
    }

    public LogLocalidade getLocNuSequencial() {
        return locNuSequencial;
    }

    public void setLocNuSequencial(LogLocalidade locNuSequencial) {
        this.locNuSequencial = locNuSequencial;
    }

    @XmlTransient
    public Collection<LogLogradouro> getLogLogradouroCollection() {
        return logLogradouroCollection;
    }

    public void setLogLogradouroCollection(Collection<LogLogradouro> logLogradouroCollection) {
        this.logLogradouroCollection = logLogradouroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (baiNuSequencial != null ? baiNuSequencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogBairro)) {
            return false;
        }
        LogBairro other = (LogBairro) object;
        if ((this.baiNuSequencial == null && other.baiNuSequencial != null) || (this.baiNuSequencial != null && !this.baiNuSequencial.equals(other.baiNuSequencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.LogBairro[ baiNuSequencial=" + baiNuSequencial + " ]";
    }
    
}

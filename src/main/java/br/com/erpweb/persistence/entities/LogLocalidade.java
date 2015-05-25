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
@Table(name = "log_localidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogLocalidade.findAll", query = "SELECT l FROM LogLocalidade l"),
    @NamedQuery(name = "LogLocalidade.findByLocNuSequencial", query = "SELECT l FROM LogLocalidade l WHERE l.locNuSequencial = :locNuSequencial"),
    @NamedQuery(name = "LogLocalidade.findByLocNosub", query = "SELECT l FROM LogLocalidade l WHERE l.locNosub = :locNosub"),
    @NamedQuery(name = "LogLocalidade.findByLocNo", query = "SELECT l FROM LogLocalidade l WHERE l.locNo = :locNo"),
    @NamedQuery(name = "LogLocalidade.findByCep", query = "SELECT l FROM LogLocalidade l WHERE l.cep = :cep"),
    @NamedQuery(name = "LogLocalidade.findByLocInSituacao", query = "SELECT l FROM LogLocalidade l WHERE l.locInSituacao = :locInSituacao"),
    @NamedQuery(name = "LogLocalidade.findByLocInTipoLocalidade", query = "SELECT l FROM LogLocalidade l WHERE l.locInTipoLocalidade = :locInTipoLocalidade"),
    @NamedQuery(name = "LogLocalidade.findByLocNuSequencialSub", query = "SELECT l FROM LogLocalidade l WHERE l.locNuSequencialSub = :locNuSequencialSub"),
    @NamedQuery(name = "LogLocalidade.findByTemp", query = "SELECT l FROM LogLocalidade l WHERE l.temp = :temp")})
public class LogLocalidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "loc_nu_sequencial")
    private Integer locNuSequencial;
    @Size(max = 50)
    @Column(name = "loc_nosub")
    private String locNosub;
    @Size(max = 60)
    @Column(name = "loc_no")
    private String locNo;
    @Size(max = 16)
    @Column(name = "cep")
    private String cep;
    @Column(name = "loc_in_situacao")
    private Integer locInSituacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "loc_in_tipo_localidade")
    private String locInTipoLocalidade;
    @Column(name = "loc_nu_sequencial_sub")
    private Integer locNuSequencialSub;
    @Size(max = 8)
    @Column(name = "temp")
    private String temp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locNuSequencial")
    private Collection<LogLogradouro> logLogradouroCollection;
    @JoinColumn(name = "ufe_sg", referencedColumnName = "ufe_sg")
    @ManyToOne
    private LogFaixaUf ufeSg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locNuSequencial")
    private Collection<LogBairro> logBairroCollection;

    public LogLocalidade() {
    }

    public LogLocalidade(Integer locNuSequencial) {
        this.locNuSequencial = locNuSequencial;
    }

    public LogLocalidade(Integer locNuSequencial, String locInTipoLocalidade) {
        this.locNuSequencial = locNuSequencial;
        this.locInTipoLocalidade = locInTipoLocalidade;
    }

    public Integer getLocNuSequencial() {
        return locNuSequencial;
    }

    public void setLocNuSequencial(Integer locNuSequencial) {
        this.locNuSequencial = locNuSequencial;
    }

    public String getLocNosub() {
        return locNosub;
    }

    public void setLocNosub(String locNosub) {
        this.locNosub = locNosub;
    }

    public String getLocNo() {
        return locNo;
    }

    public void setLocNo(String locNo) {
        this.locNo = locNo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getLocInSituacao() {
        return locInSituacao;
    }

    public void setLocInSituacao(Integer locInSituacao) {
        this.locInSituacao = locInSituacao;
    }

    public String getLocInTipoLocalidade() {
        return locInTipoLocalidade;
    }

    public void setLocInTipoLocalidade(String locInTipoLocalidade) {
        this.locInTipoLocalidade = locInTipoLocalidade;
    }

    public Integer getLocNuSequencialSub() {
        return locNuSequencialSub;
    }

    public void setLocNuSequencialSub(Integer locNuSequencialSub) {
        this.locNuSequencialSub = locNuSequencialSub;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    @XmlTransient
    public Collection<LogLogradouro> getLogLogradouroCollection() {
        return logLogradouroCollection;
    }

    public void setLogLogradouroCollection(Collection<LogLogradouro> logLogradouroCollection) {
        this.logLogradouroCollection = logLogradouroCollection;
    }

    public LogFaixaUf getUfeSg() {
        return ufeSg;
    }

    public void setUfeSg(LogFaixaUf ufeSg) {
        this.ufeSg = ufeSg;
    }

    @XmlTransient
    public Collection<LogBairro> getLogBairroCollection() {
        return logBairroCollection;
    }

    public void setLogBairroCollection(Collection<LogBairro> logBairroCollection) {
        this.logBairroCollection = logBairroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locNuSequencial != null ? locNuSequencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogLocalidade)) {
            return false;
        }
        LogLocalidade other = (LogLocalidade) object;
        if ((this.locNuSequencial == null && other.locNuSequencial != null) || (this.locNuSequencial != null && !this.locNuSequencial.equals(other.locNuSequencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.LogLocalidade[ locNuSequencial=" + locNuSequencial + " ]";
    }
    
}

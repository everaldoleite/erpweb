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
@Table(name = "PROCESSO_EMISSAONF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcessoEmissaonf.findAll", query = "SELECT p FROM ProcessoEmissaonf p"),
    @NamedQuery(name = "ProcessoEmissaonf.findByIdProcessoEmissaoNF", query = "SELECT p FROM ProcessoEmissaonf p WHERE p.idProcessoEmissaoNF = :idProcessoEmissaoNF"),
    @NamedQuery(name = "ProcessoEmissaonf.findByCodigoFisco", query = "SELECT p FROM ProcessoEmissaonf p WHERE p.codigoFisco = :codigoFisco"),
    @NamedQuery(name = "ProcessoEmissaonf.findByDescricaoProcessoEmissaoNF", query = "SELECT p FROM ProcessoEmissaonf p WHERE p.descricaoProcessoEmissaoNF = :descricaoProcessoEmissaoNF")})
public class ProcessoEmissaonf implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProcessoEmissaoNF")
    private Integer idProcessoEmissaoNF;
    @Column(name = "codigoFisco")
    private Integer codigoFisco;
    @Size(max = 45)
    @Column(name = "descricaoProcessoEmissaoNF")
    private String descricaoProcessoEmissaoNF;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pROCESSOEMISSAONFidProcessoEmissaoNF")
    private Collection<NotaFiscal> notaFiscalCollection;

    public ProcessoEmissaonf() {
    }

    public ProcessoEmissaonf(Integer idProcessoEmissaoNF) {
        this.idProcessoEmissaoNF = idProcessoEmissaoNF;
    }

    public Integer getIdProcessoEmissaoNF() {
        return idProcessoEmissaoNF;
    }

    public void setIdProcessoEmissaoNF(Integer idProcessoEmissaoNF) {
        this.idProcessoEmissaoNF = idProcessoEmissaoNF;
    }

    public Integer getCodigoFisco() {
        return codigoFisco;
    }

    public void setCodigoFisco(Integer codigoFisco) {
        this.codigoFisco = codigoFisco;
    }

    public String getDescricaoProcessoEmissaoNF() {
        return descricaoProcessoEmissaoNF;
    }

    public void setDescricaoProcessoEmissaoNF(String descricaoProcessoEmissaoNF) {
        this.descricaoProcessoEmissaoNF = descricaoProcessoEmissaoNF;
    }

    @XmlTransient
    public Collection<NotaFiscal> getNotaFiscalCollection() {
        return notaFiscalCollection;
    }

    public void setNotaFiscalCollection(Collection<NotaFiscal> notaFiscalCollection) {
        this.notaFiscalCollection = notaFiscalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProcessoEmissaoNF != null ? idProcessoEmissaoNF.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcessoEmissaonf)) {
            return false;
        }
        ProcessoEmissaonf other = (ProcessoEmissaonf) object;
        if ((this.idProcessoEmissaoNF == null && other.idProcessoEmissaoNF != null) || (this.idProcessoEmissaoNF != null && !this.idProcessoEmissaoNF.equals(other.idProcessoEmissaoNF))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.ProcessoEmissaonf[ idProcessoEmissaoNF=" + idProcessoEmissaoNF + " ]";
    }
    
}

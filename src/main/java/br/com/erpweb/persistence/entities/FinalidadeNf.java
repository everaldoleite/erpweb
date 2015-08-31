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
@Table(name = "FINALIDADE_NF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinalidadeNf.findAll", query = "SELECT f FROM FinalidadeNf f"),
    @NamedQuery(name = "FinalidadeNf.findByIdFinalidadeNF", query = "SELECT f FROM FinalidadeNf f WHERE f.idFinalidadeNF = :idFinalidadeNF"),
    @NamedQuery(name = "FinalidadeNf.findByCodigoFisco", query = "SELECT f FROM FinalidadeNf f WHERE f.codigoFisco = :codigoFisco"),
    @NamedQuery(name = "FinalidadeNf.findByDescricaoFinalidade", query = "SELECT f FROM FinalidadeNf f WHERE f.descricaoFinalidade = :descricaoFinalidade")})
public class FinalidadeNf implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idFinalidadeNF")
    private Integer idFinalidadeNF;
    @Column(name = "codigoFisco")
    private Integer codigoFisco;
    @Size(max = 45)
    @Column(name = "descricaoFinalidade")
    private String descricaoFinalidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFinalidadeNF")
    private Collection<NotaFiscal> notaFiscalCollection;

    public FinalidadeNf() {
    }

    public FinalidadeNf(Integer idFinalidadeNF) {
        this.idFinalidadeNF = idFinalidadeNF;
    }

    public Integer getIdFinalidadeNF() {
        return idFinalidadeNF;
    }

    public void setIdFinalidadeNF(Integer idFinalidadeNF) {
        this.idFinalidadeNF = idFinalidadeNF;
    }

    public Integer getCodigoFisco() {
        return codigoFisco;
    }

    public void setCodigoFisco(Integer codigoFisco) {
        this.codigoFisco = codigoFisco;
    }

    public String getDescricaoFinalidade() {
        return descricaoFinalidade;
    }

    public void setDescricaoFinalidade(String descricaoFinalidade) {
        this.descricaoFinalidade = descricaoFinalidade;
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
        hash += (idFinalidadeNF != null ? idFinalidadeNF.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinalidadeNf)) {
            return false;
        }
        FinalidadeNf other = (FinalidadeNf) object;
        if ((this.idFinalidadeNF == null && other.idFinalidadeNF != null) || (this.idFinalidadeNF != null && !this.idFinalidadeNF.equals(other.idFinalidadeNF))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.FinalidadeNf[ idFinalidadeNF=" + idFinalidadeNF + " ]";
    }
    
}

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
@Table(name = "STATUS_ORDEM_FATURAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatusOrdemFaturamento.findAll", query = "SELECT s FROM StatusOrdemFaturamento s"),
    @NamedQuery(name = "StatusOrdemFaturamento.findByIdStatusOF", query = "SELECT s FROM StatusOrdemFaturamento s WHERE s.idStatusOF = :idStatusOF"),
    @NamedQuery(name = "StatusOrdemFaturamento.findByDescricaoStatusOF", query = "SELECT s FROM StatusOrdemFaturamento s WHERE s.descricaoStatusOF = :descricaoStatusOF"),
    @NamedQuery(name = "StatusOrdemFaturamento.findBySituacao", query = "SELECT s FROM StatusOrdemFaturamento s WHERE s.situacao = :situacao")})
public class StatusOrdemFaturamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idStatusOF")
    private Integer idStatusOF;
    @Size(max = 45)
    @Column(name = "descricaoStatusOF")
    private String descricaoStatusOF;
    @Column(name = "situacao")
    private Character situacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStatusOF")
    private Collection<OrdemFaturamento> ordemFaturamentoCollection;

    public StatusOrdemFaturamento() {
    }

    public StatusOrdemFaturamento(Integer idStatusOF) {
        this.idStatusOF = idStatusOF;
    }

    public Integer getIdStatusOF() {
        return idStatusOF;
    }

    public void setIdStatusOF(Integer idStatusOF) {
        this.idStatusOF = idStatusOF;
    }

    public String getDescricaoStatusOF() {
        return descricaoStatusOF;
    }

    public void setDescricaoStatusOF(String descricaoStatusOF) {
        this.descricaoStatusOF = descricaoStatusOF;
    }

    public Character getSituacao() {
        return situacao;
    }

    public void setSituacao(Character situacao) {
        this.situacao = situacao;
    }

    @XmlTransient
    public Collection<OrdemFaturamento> getOrdemFaturamentoCollection() {
        return ordemFaturamentoCollection;
    }

    public void setOrdemFaturamentoCollection(Collection<OrdemFaturamento> ordemFaturamentoCollection) {
        this.ordemFaturamentoCollection = ordemFaturamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStatusOF != null ? idStatusOF.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StatusOrdemFaturamento)) {
            return false;
        }
        StatusOrdemFaturamento other = (StatusOrdemFaturamento) object;
        if ((this.idStatusOF == null && other.idStatusOF != null) || (this.idStatusOF != null && !this.idStatusOF.equals(other.idStatusOF))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.StatusOrdemFaturamento[ idStatusOF=" + idStatusOF + " ]";
    }
    
}

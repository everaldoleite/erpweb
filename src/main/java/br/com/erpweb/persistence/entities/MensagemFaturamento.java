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
@Table(name = "MENSAGEM_FATURAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MensagemFaturamento.findAll", query = "SELECT m FROM MensagemFaturamento m"),
    @NamedQuery(name = "MensagemFaturamento.findByIdMensagemFaturamento", query = "SELECT m FROM MensagemFaturamento m WHERE m.idMensagemFaturamento = :idMensagemFaturamento"),
    @NamedQuery(name = "MensagemFaturamento.findByDescricao", query = "SELECT m FROM MensagemFaturamento m WHERE m.descricao = :descricao")})
public class MensagemFaturamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMensagemFaturamento")
    private Integer idMensagemFaturamento;
    @Size(max = 50)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMensagemFaturamento")
    private Collection<NaturezaOperacao> naturezaOperacaoCollection;

    public MensagemFaturamento() {
    }

    public MensagemFaturamento(Integer idMensagemFaturamento) {
        this.idMensagemFaturamento = idMensagemFaturamento;
    }

    public Integer getIdMensagemFaturamento() {
        return idMensagemFaturamento;
    }

    public void setIdMensagemFaturamento(Integer idMensagemFaturamento) {
        this.idMensagemFaturamento = idMensagemFaturamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<NaturezaOperacao> getNaturezaOperacaoCollection() {
        return naturezaOperacaoCollection;
    }

    public void setNaturezaOperacaoCollection(Collection<NaturezaOperacao> naturezaOperacaoCollection) {
        this.naturezaOperacaoCollection = naturezaOperacaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMensagemFaturamento != null ? idMensagemFaturamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MensagemFaturamento)) {
            return false;
        }
        MensagemFaturamento other = (MensagemFaturamento) object;
        if ((this.idMensagemFaturamento == null && other.idMensagemFaturamento != null) || (this.idMensagemFaturamento != null && !this.idMensagemFaturamento.equals(other.idMensagemFaturamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.MensagemFaturamento[ idMensagemFaturamento=" + idMensagemFaturamento + " ]";
    }
    
}

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
@Table(name = "CONTA_RESULTADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContaResultado.findAll", query = "SELECT c FROM ContaResultado c"),
    @NamedQuery(name = "ContaResultado.findByIdPlanoConta", query = "SELECT c FROM ContaResultado c WHERE c.idPlanoConta = :idPlanoConta"),
    @NamedQuery(name = "ContaResultado.findByCodigoConta", query = "SELECT c FROM ContaResultado c WHERE c.codigoConta = :codigoConta"),
    @NamedQuery(name = "ContaResultado.findByDescricaoConta", query = "SELECT c FROM ContaResultado c WHERE c.descricaoConta = :descricaoConta"),
    @NamedQuery(name = "ContaResultado.findByTipoConta", query = "SELECT c FROM ContaResultado c WHERE c.tipoConta = :tipoConta")})
public class ContaResultado implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlanoConta")
    private Collection<TipoMovimentoEstoque> tipoMovimentoEstoqueCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPlanoConta")
    private Integer idPlanoConta;
    @Size(max = 45)
    @Column(name = "codigoConta")
    private String codigoConta;
    @Size(max = 45)
    @Column(name = "descricaoConta")
    private String descricaoConta;
    @Column(name = "tipoConta")
    private Character tipoConta;

    public ContaResultado() {
    }

    public ContaResultado(Integer idPlanoConta) {
        this.idPlanoConta = idPlanoConta;
    }

    public Integer getIdPlanoConta() {
        return idPlanoConta;
    }

    public void setIdPlanoConta(Integer idPlanoConta) {
        this.idPlanoConta = idPlanoConta;
    }

    public String getCodigoConta() {
        return codigoConta;
    }

    public void setCodigoConta(String codigoConta) {
        this.codigoConta = codigoConta;
    }

    public String getDescricaoConta() {
        return descricaoConta;
    }

    public void setDescricaoConta(String descricaoConta) {
        this.descricaoConta = descricaoConta;
    }

    public Character getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(Character tipoConta) {
        this.tipoConta = tipoConta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlanoConta != null ? idPlanoConta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContaResultado)) {
            return false;
        }
        ContaResultado other = (ContaResultado) object;
        if ((this.idPlanoConta == null && other.idPlanoConta != null) || (this.idPlanoConta != null && !this.idPlanoConta.equals(other.idPlanoConta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.ContaResultado[ idPlanoConta=" + idPlanoConta + " ]";
    }

    @XmlTransient
    public Collection<TipoMovimentoEstoque> getTipoMovimentoEstoqueCollection() {
        return tipoMovimentoEstoqueCollection;
    }

    public void setTipoMovimentoEstoqueCollection(Collection<TipoMovimentoEstoque> tipoMovimentoEstoqueCollection) {
        this.tipoMovimentoEstoqueCollection = tipoMovimentoEstoqueCollection;
    }

}

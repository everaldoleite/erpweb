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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author everaldo
 */
@Entity
@Table(name = "TIPO_PEDIDO_VENDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPedidoVenda.findAll", query = "SELECT t FROM TipoPedidoVenda t"),
    @NamedQuery(name = "TipoPedidoVenda.findByIdTipoPedidoVenda", query = "SELECT t FROM TipoPedidoVenda t WHERE t.idTipoPedidoVenda = :idTipoPedidoVenda"),
    @NamedQuery(name = "TipoPedidoVenda.findByDescricaoTipoPedidoVenda", query = "SELECT t FROM TipoPedidoVenda t WHERE t.descricaoTipoPedidoVenda = :descricaoTipoPedidoVenda"),
    @NamedQuery(name = "TipoPedidoVenda.findByBaixaEstoque", query = "SELECT t FROM TipoPedidoVenda t WHERE t.baixaEstoque = :baixaEstoque")})
public class TipoPedidoVenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoPedidoVenda")
    private Integer idTipoPedidoVenda;
    @Size(max = 45)
    @Column(name = "descricaoTipoPedidoVenda")
    private String descricaoTipoPedidoVenda;
    @Column(name = "baixaEstoque")
    private Boolean baixaEstoque;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoPedidoVenda")
    private Collection<PedidoVenda> pedidoVendaCollection;

    public TipoPedidoVenda() {
    }

    public TipoPedidoVenda(Integer idTipoPedidoVenda) {
        this.idTipoPedidoVenda = idTipoPedidoVenda;
    }

    public Integer getIdTipoPedidoVenda() {
        return idTipoPedidoVenda;
    }

    public void setIdTipoPedidoVenda(Integer idTipoPedidoVenda) {
        this.idTipoPedidoVenda = idTipoPedidoVenda;
    }

    public String getDescricaoTipoPedidoVenda() {
        return descricaoTipoPedidoVenda;
    }

    public void setDescricaoTipoPedidoVenda(String descricaoTipoPedidoVenda) {
        this.descricaoTipoPedidoVenda = descricaoTipoPedidoVenda;
    }

    @XmlTransient
    public Collection<PedidoVenda> getPedidoVendaCollection() {
        return pedidoVendaCollection;
    }

    public void setPedidoVendaCollection(Collection<PedidoVenda> pedidoVendaCollection) {
        this.pedidoVendaCollection = pedidoVendaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPedidoVenda != null ? idTipoPedidoVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPedidoVenda)) {
            return false;
        }
        TipoPedidoVenda other = (TipoPedidoVenda) object;
        if ((this.idTipoPedidoVenda == null && other.idTipoPedidoVenda != null) || (this.idTipoPedidoVenda != null && !this.idTipoPedidoVenda.equals(other.idTipoPedidoVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.exception.TipoPedidoVenda[ idTipoPedidoVenda=" + idTipoPedidoVenda + " ]";
    }

    /**
     * @return the baixaEstoque
     */
    public Boolean getBaixaEstoque() {
        return baixaEstoque;
    }

    /**
     * @param baixaEstoque the baixaEstoque to set
     */
    public void setBaixaEstoque(Boolean baixaEstoque) {
        this.baixaEstoque = baixaEstoque;
    }
    
}

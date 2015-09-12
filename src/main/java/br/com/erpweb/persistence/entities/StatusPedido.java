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
@Table(name = "STATUS_PEDIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatusPedido.findAll", query = "SELECT s FROM StatusPedido s"),
    @NamedQuery(name = "StatusPedido.findByIdStatusPedido", query = "SELECT s FROM StatusPedido s WHERE s.idStatusPedido = :idStatusPedido"),
    @NamedQuery(name = "StatusPedido.findByDescricaoStatusPedido", query = "SELECT s FROM StatusPedido s WHERE s.descricaoStatusPedido = :descricaoStatusPedido"),
    @NamedQuery(name = "StatusPedido.findBySituacaoStatusPedido", query = "SELECT s FROM StatusPedido s WHERE s.situacaoStatusPedido = :situacaoStatusPedido")})
public class StatusPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idStatusPedido")
    private Integer idStatusPedido;
    @Size(max = 45)
    @Column(name = "descricaoStatusPedido")
    private String descricaoStatusPedido;
    @Column(name = "situacaoStatusPedido")
    private Boolean situacaoStatusPedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStatusPedido")
    private Collection<PedidoVenda> pedidoVendaCollection;

    public StatusPedido() {
    }

    public StatusPedido(Integer idStatusPedido) {
        this.idStatusPedido = idStatusPedido;
    }

    public Integer getIdStatusPedido() {
        return idStatusPedido;
    }

    public void setIdStatusPedido(Integer idStatusPedido) {
        this.idStatusPedido = idStatusPedido;
    }

    public String getDescricaoStatusPedido() {
        return descricaoStatusPedido;
    }

    public void setDescricaoStatusPedido(String descricaoStatusPedido) {
        this.descricaoStatusPedido = descricaoStatusPedido;
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
        hash += (idStatusPedido != null ? idStatusPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StatusPedido)) {
            return false;
        }
        StatusPedido other = (StatusPedido) object;
        if ((this.idStatusPedido == null && other.idStatusPedido != null) || (this.idStatusPedido != null && !this.idStatusPedido.equals(other.idStatusPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.exception.StatusPedido[ idStatusPedido=" + idStatusPedido + " ]";
    }

    /**
     * @return the situacaoStatusPedido
     */
    public Boolean getSituacaoStatusPedido() {
        return situacaoStatusPedido;
    }

    /**
     * @param situacaoStatusPedido the situacaoStatusPedido to set
     */
    public void setSituacaoStatusPedido(Boolean situacaoStatusPedido) {
        this.situacaoStatusPedido = situacaoStatusPedido;
    }
    
}

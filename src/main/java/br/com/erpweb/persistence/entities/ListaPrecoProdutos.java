/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.persistence.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author everaldo
 */
@Entity
@Table(name = "LISTA_PRECO_PRODUTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListaPrecoProdutos.findAll", query = "SELECT l FROM ListaPrecoProdutos l"),
    @NamedQuery(name = "ListaPrecoProdutos.findByIdListaPrecosProdutos", query = "SELECT l FROM ListaPrecoProdutos l WHERE l.idListaPrecosProdutos = :idListaPrecosProdutos"),
    @NamedQuery(name = "ListaPrecoProdutos.findByDescricaoLista", query = "SELECT l FROM ListaPrecoProdutos l WHERE l.descricaoLista = :descricaoLista"),
    @NamedQuery(name = "ListaPrecoProdutos.findByStatusListaPrecos", query = "SELECT l FROM ListaPrecoProdutos l WHERE l.statusListaPrecos = :statusListaPrecos"),
    @NamedQuery(name = "ListaPrecoProdutos.findByCoeficiente1", query = "SELECT l FROM ListaPrecoProdutos l WHERE l.coeficiente1 = :coeficiente1"),
    @NamedQuery(name = "ListaPrecoProdutos.findByCoeficiente2", query = "SELECT l FROM ListaPrecoProdutos l WHERE l.coeficiente2 = :coeficiente2"),
    @NamedQuery(name = "ListaPrecoProdutos.findByCoeficiente3", query = "SELECT l FROM ListaPrecoProdutos l WHERE l.coeficiente3 = :coeficiente3"),
    @NamedQuery(name = "ListaPrecoProdutos.findByCoeficiente4", query = "SELECT l FROM ListaPrecoProdutos l WHERE l.coeficiente4 = :coeficiente4"),
    @NamedQuery(name = "ListaPrecoProdutos.findByCoeficiente5", query = "SELECT l FROM ListaPrecoProdutos l WHERE l.coeficiente5 = :coeficiente5"),
    @NamedQuery(name = "ListaPrecoProdutos.findByCoeficiente6", query = "SELECT l FROM ListaPrecoProdutos l WHERE l.coeficiente6 = :coeficiente6"),
    @NamedQuery(name = "ListaPrecoProdutos.findByComissao", query = "SELECT l FROM ListaPrecoProdutos l WHERE l.comissao = :comissao"),
    @NamedQuery(name = "ListaPrecoProdutos.findByObservacao", query = "SELECT l FROM ListaPrecoProdutos l WHERE l.observacao = :observacao"),
    @NamedQuery(name = "ListaPrecoProdutos.findByFator", query = "SELECT l FROM ListaPrecoProdutos l WHERE l.fator = :fator"),
    @NamedQuery(name = "ListaPrecoProdutos.findByLocalEstoque", query = "SELECT l FROM ListaPrecoProdutos l WHERE l.localEstoque = :localEstoque"),
    @NamedQuery(name = "ListaPrecoProdutos.findByDataValidade", query = "SELECT l FROM ListaPrecoProdutos l WHERE l.dataValidade = :dataValidade")})
public class ListaPrecoProdutos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idListaPrecosProdutos")
    private Integer idListaPrecosProdutos;
    @Size(max = 45)
    @Column(name = "descricaoLista")
    private String descricaoLista;
    @Column(name = "statusListaPrecos")
    private Character statusListaPrecos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "coeficiente1")
    private BigDecimal coeficiente1;
    @Column(name = "coeficiente2")
    private BigDecimal coeficiente2;
    @Column(name = "coeficiente3")
    private BigDecimal coeficiente3;
    @Column(name = "coeficiente4")
    private BigDecimal coeficiente4;
    @Column(name = "coeficiente5")
    private BigDecimal coeficiente5;
    @Column(name = "coeficiente6")
    private BigDecimal coeficiente6;
    @Column(name = "comissao")
    private BigDecimal comissao;
    @Size(max = 45)
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "fator")
    private BigDecimal fator;
    @Size(max = 45)
    @Column(name = "localEstoque")
    private String localEstoque;
    @Column(name = "dataValidade")
    @Temporal(TemporalType.DATE)
    private Date dataValidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idListaPrecosProdutos")
    private Collection<Cliente> clienteCollection;

    public ListaPrecoProdutos() {
    }

    public ListaPrecoProdutos(Integer idListaPrecosProdutos) {
        this.idListaPrecosProdutos = idListaPrecosProdutos;
    }

    public Integer getIdListaPrecosProdutos() {
        return idListaPrecosProdutos;
    }

    public void setIdListaPrecosProdutos(Integer idListaPrecosProdutos) {
        this.idListaPrecosProdutos = idListaPrecosProdutos;
    }

    public String getDescricaoLista() {
        return descricaoLista;
    }

    public void setDescricaoLista(String descricaoLista) {
        this.descricaoLista = descricaoLista;
    }

    public Character getStatusListaPrecos() {
        return statusListaPrecos;
    }

    public void setStatusListaPrecos(Character statusListaPrecos) {
        this.statusListaPrecos = statusListaPrecos;
    }

    public BigDecimal getCoeficiente1() {
        return coeficiente1;
    }

    public void setCoeficiente1(BigDecimal coeficiente1) {
        this.coeficiente1 = coeficiente1;
    }

    public BigDecimal getCoeficiente2() {
        return coeficiente2;
    }

    public void setCoeficiente2(BigDecimal coeficiente2) {
        this.coeficiente2 = coeficiente2;
    }

    public BigDecimal getCoeficiente3() {
        return coeficiente3;
    }

    public void setCoeficiente3(BigDecimal coeficiente3) {
        this.coeficiente3 = coeficiente3;
    }

    public BigDecimal getCoeficiente4() {
        return coeficiente4;
    }

    public void setCoeficiente4(BigDecimal coeficiente4) {
        this.coeficiente4 = coeficiente4;
    }

    public BigDecimal getCoeficiente5() {
        return coeficiente5;
    }

    public void setCoeficiente5(BigDecimal coeficiente5) {
        this.coeficiente5 = coeficiente5;
    }

    public BigDecimal getCoeficiente6() {
        return coeficiente6;
    }

    public void setCoeficiente6(BigDecimal coeficiente6) {
        this.coeficiente6 = coeficiente6;
    }

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public BigDecimal getFator() {
        return fator;
    }

    public void setFator(BigDecimal fator) {
        this.fator = fator;
    }

    public String getLocalEstoque() {
        return localEstoque;
    }

    public void setLocalEstoque(String localEstoque) {
        this.localEstoque = localEstoque;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idListaPrecosProdutos != null ? idListaPrecosProdutos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaPrecoProdutos)) {
            return false;
        }
        ListaPrecoProdutos other = (ListaPrecoProdutos) object;
        if ((this.idListaPrecosProdutos == null && other.idListaPrecosProdutos != null) || (this.idListaPrecosProdutos != null && !this.idListaPrecosProdutos.equals(other.idListaPrecosProdutos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.ListaPrecoProdutos[ idListaPrecosProdutos=" + idListaPrecosProdutos + " ]";
    }
    
}

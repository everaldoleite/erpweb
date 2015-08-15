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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author everaldo
 */
@Entity
@Table(name = "TIPO_MOVIMENTO_ESTOQUE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMovimentoEstoque.findAll", query = "SELECT t FROM TipoMovimentoEstoque t"),
    @NamedQuery(name = "TipoMovimentoEstoque.findByIdtipoMovimentoEstoque", query = "SELECT t FROM TipoMovimentoEstoque t WHERE t.idtipoMovimentoEstoque = :idtipoMovimentoEstoque"),
    @NamedQuery(name = "TipoMovimentoEstoque.findByDescricaoTipoMovimento", query = "SELECT t FROM TipoMovimentoEstoque t WHERE t.descricaoTipoMovimento = :descricaoTipoMovimento"),
    @NamedQuery(name = "TipoMovimentoEstoque.findByAceitaEstoqueNegativo", query = "SELECT t FROM TipoMovimentoEstoque t WHERE t.aceitaEstoqueNegativo = :aceitaEstoqueNegativo"),
    @NamedQuery(name = "TipoMovimentoEstoque.findByConsumoMensal", query = "SELECT t FROM TipoMovimentoEstoque t WHERE t.consumoMensal = :consumoMensal"),
    @NamedQuery(name = "TipoMovimentoEstoque.findByExigeAprovacao", query = "SELECT t FROM TipoMovimentoEstoque t WHERE t.exigeAprovacao = :exigeAprovacao"),
    @NamedQuery(name = "TipoMovimentoEstoque.findByExigeCentroResultado", query = "SELECT t FROM TipoMovimentoEstoque t WHERE t.exigeCentroResultado = :exigeCentroResultado"),
    @NamedQuery(name = "TipoMovimentoEstoque.findByOpcaoTransferencia", query = "SELECT t FROM TipoMovimentoEstoque t WHERE t.opcaoTransferencia = :opcaoTransferencia"),
    @NamedQuery(name = "TipoMovimentoEstoque.findByOperacao", query = "SELECT t FROM TipoMovimentoEstoque t WHERE t.operacao = :operacao"),
    @NamedQuery(name = "TipoMovimentoEstoque.findByAtualizaDadosCompra", query = "SELECT t FROM TipoMovimentoEstoque t WHERE t.atualizaDadosCompra = :atualizaDadosCompra"),
    @NamedQuery(name = "TipoMovimentoEstoque.findByContaResultado", query = "SELECT t FROM TipoMovimentoEstoque t WHERE t.contaResultado = :contaResultado")})
public class TipoMovimentoEstoque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipoMovimentoEstoque")
    private Integer idtipoMovimentoEstoque;
    @Column(name = "descricaoTipoMovimento")
    private Character descricaoTipoMovimento;
    @Column(name = "aceitaEstoqueNegativo")
    private Character aceitaEstoqueNegativo;
    @Column(name = "consumoMensal")
    private Character consumoMensal;
    @Column(name = "exigeAprovacao")
    private Character exigeAprovacao;
    @Column(name = "exigeCentroResultado")
    private Character exigeCentroResultado;
    @Column(name = "opcaoTransferencia")
    private Character opcaoTransferencia;
    @Column(name = "operacao")
    private Character operacao;
    @Column(name = "atualizaDadosCompra")
    private Character atualizaDadosCompra;
    @Column(name = "contaResultado")
    private Integer contaResultado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoMovimentoEstoque")
    private Collection<NaturezaOperacao> naturezaOperacaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoMovimentoEstoqueCancelamento")
    private Collection<NaturezaOperacao> naturezaOperacaoCollection1;
    @JoinColumn(name = "idPlanoConta", referencedColumnName = "idPlanoConta")
    @ManyToOne(optional = false)
    private PlanoContas idPlanoConta;

    public TipoMovimentoEstoque() {
    }

    public TipoMovimentoEstoque(Integer idtipoMovimentoEstoque) {
        this.idtipoMovimentoEstoque = idtipoMovimentoEstoque;
    }

    public Integer getIdtipoMovimentoEstoque() {
        return idtipoMovimentoEstoque;
    }

    public void setIdtipoMovimentoEstoque(Integer idtipoMovimentoEstoque) {
        this.idtipoMovimentoEstoque = idtipoMovimentoEstoque;
    }

    public Character getDescricaoTipoMovimento() {
        return descricaoTipoMovimento;
    }

    public void setDescricaoTipoMovimento(Character descricaoTipoMovimento) {
        this.descricaoTipoMovimento = descricaoTipoMovimento;
    }

    public Character getAceitaEstoqueNegativo() {
        return aceitaEstoqueNegativo;
    }

    public void setAceitaEstoqueNegativo(Character aceitaEstoqueNegativo) {
        this.aceitaEstoqueNegativo = aceitaEstoqueNegativo;
    }

    public Character getConsumoMensal() {
        return consumoMensal;
    }

    public void setConsumoMensal(Character consumoMensal) {
        this.consumoMensal = consumoMensal;
    }

    public Character getExigeAprovacao() {
        return exigeAprovacao;
    }

    public void setExigeAprovacao(Character exigeAprovacao) {
        this.exigeAprovacao = exigeAprovacao;
    }

    public Character getExigeCentroResultado() {
        return exigeCentroResultado;
    }

    public void setExigeCentroResultado(Character exigeCentroResultado) {
        this.exigeCentroResultado = exigeCentroResultado;
    }

    public Character getOpcaoTransferencia() {
        return opcaoTransferencia;
    }

    public void setOpcaoTransferencia(Character opcaoTransferencia) {
        this.opcaoTransferencia = opcaoTransferencia;
    }

    public Character getOperacao() {
        return operacao;
    }

    public void setOperacao(Character operacao) {
        this.operacao = operacao;
    }

    public Character getAtualizaDadosCompra() {
        return atualizaDadosCompra;
    }

    public void setAtualizaDadosCompra(Character atualizaDadosCompra) {
        this.atualizaDadosCompra = atualizaDadosCompra;
    }

    public Integer getContaResultado() {
        return contaResultado;
    }

    public void setContaResultado(Integer contaResultado) {
        this.contaResultado = contaResultado;
    }

    @XmlTransient
    public Collection<NaturezaOperacao> getNaturezaOperacaoCollection() {
        return naturezaOperacaoCollection;
    }

    public void setNaturezaOperacaoCollection(Collection<NaturezaOperacao> naturezaOperacaoCollection) {
        this.naturezaOperacaoCollection = naturezaOperacaoCollection;
    }

    @XmlTransient
    public Collection<NaturezaOperacao> getNaturezaOperacaoCollection1() {
        return naturezaOperacaoCollection1;
    }

    public void setNaturezaOperacaoCollection1(Collection<NaturezaOperacao> naturezaOperacaoCollection1) {
        this.naturezaOperacaoCollection1 = naturezaOperacaoCollection1;
    }

    public PlanoContas getIdPlanoConta() {
        return idPlanoConta;
    }

    public void setIdPlanoConta(PlanoContas idPlanoConta) {
        this.idPlanoConta = idPlanoConta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoMovimentoEstoque != null ? idtipoMovimentoEstoque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMovimentoEstoque)) {
            return false;
        }
        TipoMovimentoEstoque other = (TipoMovimentoEstoque) object;
        if ((this.idtipoMovimentoEstoque == null && other.idtipoMovimentoEstoque != null) || (this.idtipoMovimentoEstoque != null && !this.idtipoMovimentoEstoque.equals(other.idtipoMovimentoEstoque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.TipoMovimentoEstoque[ idtipoMovimentoEstoque=" + idtipoMovimentoEstoque + " ]";
    }
    
}

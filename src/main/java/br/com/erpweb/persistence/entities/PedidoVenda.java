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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author everaldo
 */
@Entity
@Table(name = "PEDIDO_VENDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidoVenda.findAll", query = "SELECT p FROM PedidoVenda p"),
    @NamedQuery(name = "PedidoVenda.findByIdPedidoVenda", query = "SELECT p FROM PedidoVenda p WHERE p.idPedidoVenda = :idPedidoVenda"),
    @NamedQuery(name = "PedidoVenda.findByDataAberturaPedido", query = "SELECT p FROM PedidoVenda p WHERE p.dataAberturaPedido = :dataAberturaPedido"),
    @NamedQuery(name = "PedidoVenda.findByNumeroExterno", query = "SELECT p FROM PedidoVenda p WHERE p.numeroExterno = :numeroExterno"),
    @NamedQuery(name = "PedidoVenda.findByOutros", query = "SELECT p FROM PedidoVenda p WHERE p.outros = :outros"),
    @NamedQuery(name = "PedidoVenda.findByFrete", query = "SELECT p FROM PedidoVenda p WHERE p.frete = :frete"),
    @NamedQuery(name = "PedidoVenda.findByValorFrete", query = "SELECT p FROM PedidoVenda p WHERE p.valorFrete = :valorFrete"),
    @NamedQuery(name = "PedidoVenda.findByAtendimentoParcial", query = "SELECT p FROM PedidoVenda p WHERE p.atendimentoParcial = :atendimentoParcial"),
    @NamedQuery(name = "PedidoVenda.findByStatusAprovacaoFinanceira", query = "SELECT p FROM PedidoVenda p WHERE p.statusAprovacaoFinanceira = :statusAprovacaoFinanceira"),
    @NamedQuery(name = "PedidoVenda.findByStatusAprovacaoComercial", query = "SELECT p FROM PedidoVenda p WHERE p.statusAprovacaoComercial = :statusAprovacaoComercial"),
    @NamedQuery(name = "PedidoVenda.findByComissaoPrincipal", query = "SELECT p FROM PedidoVenda p WHERE p.comissaoPrincipal = :comissaoPrincipal"),
    @NamedQuery(name = "PedidoVenda.findByComissaoSubstituto", query = "SELECT p FROM PedidoVenda p WHERE p.comissaoSubstituto = :comissaoSubstituto"),
    @NamedQuery(name = "PedidoVenda.findByValorTotalProdutos", query = "SELECT p FROM PedidoVenda p WHERE p.valorTotalProdutos = :valorTotalProdutos"),
    @NamedQuery(name = "PedidoVenda.findByValorTotalServicos", query = "SELECT p FROM PedidoVenda p WHERE p.valorTotalServicos = :valorTotalServicos"),
    @NamedQuery(name = "PedidoVenda.findByValorTotalPedido", query = "SELECT p FROM PedidoVenda p WHERE p.valorTotalPedido = :valorTotalPedido"),
    @NamedQuery(name = "PedidoVenda.findByDataAprovacaoFinanceira", query = "SELECT p FROM PedidoVenda p WHERE p.dataAprovacaoFinanceira = :dataAprovacaoFinanceira"),
    @NamedQuery(name = "PedidoVenda.findByObservacaoAprovacaoFinanceira", query = "SELECT p FROM PedidoVenda p WHERE p.observacaoAprovacaoFinanceira = :observacaoAprovacaoFinanceira"),
    @NamedQuery(name = "PedidoVenda.findByDataAprovacaoComercial", query = "SELECT p FROM PedidoVenda p WHERE p.dataAprovacaoComercial = :dataAprovacaoComercial"),
    @NamedQuery(name = "PedidoVenda.findByObservacaoAprovacaoComercial", query = "SELECT p FROM PedidoVenda p WHERE p.observacaoAprovacaoComercial = :observacaoAprovacaoComercial"),
    @NamedQuery(name = "PedidoVenda.findByDataEncerramento", query = "SELECT p FROM PedidoVenda p WHERE p.dataEncerramento = :dataEncerramento"),
    @NamedQuery(name = "PedidoVenda.findByTotalIPI", query = "SELECT p FROM PedidoVenda p WHERE p.totalIPI = :totalIPI"),
    @NamedQuery(name = "PedidoVenda.findByTotalICMS", query = "SELECT p FROM PedidoVenda p WHERE p.totalICMS = :totalICMS"),
    @NamedQuery(name = "PedidoVenda.findByDataAgendamento", query = "SELECT p FROM PedidoVenda p WHERE p.dataAgendamento = :dataAgendamento"),
    @NamedQuery(name = "PedidoVenda.findByObservacaoNota", query = "SELECT p FROM PedidoVenda p WHERE p.observacaoNota = :observacaoNota"),
    @NamedQuery(name = "PedidoVenda.findByScoreAprovacaoFinanceira", query = "SELECT p FROM PedidoVenda p WHERE p.scoreAprovacaoFinanceira = :scoreAprovacaoFinanceira"),
    @NamedQuery(name = "PedidoVenda.findByScoreAprovacaoComercial", query = "SELECT p FROM PedidoVenda p WHERE p.scoreAprovacaoComercial = :scoreAprovacaoComercial"),
    @NamedQuery(name = "PedidoVenda.findByOrigemPedido", query = "SELECT p FROM PedidoVenda p WHERE p.origemPedido = :origemPedido"),
    @NamedQuery(name = "PedidoVenda.findByObservacaoInterna", query = "SELECT p FROM PedidoVenda p WHERE p.observacaoInterna = :observacaoInterna"),
    @NamedQuery(name = "PedidoVenda.findByObservacaoCancelamento", query = "SELECT p FROM PedidoVenda p WHERE p.observacaoCancelamento = :observacaoCancelamento"),
    @NamedQuery(name = "PedidoVenda.findByCotacao", query = "SELECT p FROM PedidoVenda p WHERE p.cotacao = :cotacao"),
    @NamedQuery(name = "PedidoVenda.findByPrazoValidade", query = "SELECT p FROM PedidoVenda p WHERE p.prazoValidade = :prazoValidade")})
public class PedidoVenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPedidoVenda")
    private Integer idPedidoVenda;
    @Column(name = "dataAberturaPedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAberturaPedido = new Date();
    @Size(max = 45)
    @Column(name = "numeroExterno")
    private String numeroExterno;
    @Size(max = 45)
    @Column(name = "outros")
    private String outros;
    @Column(name = "frete")
    private Character frete;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorFrete")
    private BigDecimal valorFrete;
    @Column(name = "atendimentoParcial")
    private Boolean atendimentoParcial;
    @Column(name = "statusAprovacaoFinanceira")
    private Boolean statusAprovacaoFinanceira;
    @Column(name = "statusAprovacaoComercial")
    private Boolean statusAprovacaoComercial;
    @Column(name = "comissaoPrincipal")
    private BigDecimal comissaoPrincipal;
    @Column(name = "comissaoSubstituto")
    private BigDecimal comissaoSubstituto;
    @Column(name = "valorTotalProdutos")
    private BigDecimal valorTotalProdutos;
    @Column(name = "valorTotalServicos")
    private BigDecimal valorTotalServicos;
    @Column(name = "valorTotalPedido")
    private BigDecimal valorTotalPedido;
    @Column(name = "dataAprovacaoFinanceira")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAprovacaoFinanceira;
    @Size(max = 45)
    @Column(name = "observacaoAprovacaoFinanceira")
    private String observacaoAprovacaoFinanceira;
    @Column(name = "dataAprovacaoComercial")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAprovacaoComercial;
    @Size(max = 45)
    @Column(name = "observacaoAprovacaoComercial")
    private String observacaoAprovacaoComercial;
    @Column(name = "dataEncerramento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEncerramento;
    @Column(name = "totalIPI")
    private BigDecimal totalIPI;
    @Column(name = "totalICMS")
    private BigDecimal totalICMS;
    @Column(name = "dataAgendamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAgendamento;
    @Size(max = 45)
    @Column(name = "observacaoNota")
    private String observacaoNota;
    @Column(name = "scoreAprovacaoFinanceira")
    private Integer scoreAprovacaoFinanceira;
    @Column(name = "scoreAprovacaoComercial")
    private Integer scoreAprovacaoComercial;
    @Column(name = "origemPedido")
    private Character origemPedido;
    @Size(max = 45)
    @Column(name = "observacaoInterna")
    private String observacaoInterna;
    @Size(max = 45)
    @Column(name = "observacaoCancelamento")
    private String observacaoCancelamento;
    @Column(name = "cotacao")
    private Boolean cotacao;
    @Column(name = "prazoValidade")
    private Integer prazoValidade;
    @JoinColumn(name = "idTipoPedidoVenda", referencedColumnName = "idTipoPedidoVenda")
    @ManyToOne(optional = false)
    private TipoPedidoVenda idTipoPedidoVenda;
    @JoinColumn(name = "idStatusPedido", referencedColumnName = "idStatusPedido")
    @ManyToOne(optional = false)
    private StatusPedido idStatusPedido;
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "idVendedor", referencedColumnName = "idVendedor")
    @ManyToOne(optional = false)
    private Vendedor idVendedor;
    @JoinColumn(name = "idVendedorSubstituto", referencedColumnName = "idVendedor")
    @ManyToOne(optional = false)
    private Vendedor idVendedorSubstituto;
    @JoinColumn(name = "idCondicaoPagamento", referencedColumnName = "idCondicaoPagamento")
    @ManyToOne(optional = false)
    private CondicaoPagamento idCondicaoPagamento;
    @JoinColumn(name = "idUsuarioFinanceiro", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuarioFinanceiro;
    @JoinColumn(name = "idUsuarioComercial", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuarioComercial;
    @JoinColumn(name = "idContato", referencedColumnName = "idContato")
    @ManyToOne(optional = false)
    private Contato idContato;
    @JoinColumn(name = "idUsuarioEncerramento", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuarioEncerramento;
    @JoinColumn(name = "idRepresentante", referencedColumnName = "idRepresentante")
    @ManyToOne(optional = false)
    private Representantes idRepresentante;
    
    @Transient
    private String buscaProduto;
    
    public PedidoVenda() {
    }

    public PedidoVenda(Integer idPedidoVenda) {
        this.idPedidoVenda = idPedidoVenda;
    }

    public Integer getIdPedidoVenda() {
        return idPedidoVenda;
    }

    public void setIdPedidoVenda(Integer idPedidoVenda) {
        this.idPedidoVenda = idPedidoVenda;
    }

    public Date getDataAberturaPedido() {
        return dataAberturaPedido;
    }

    public void setDataAberturaPedido(Date dataAberturaPedido) {
        this.dataAberturaPedido = dataAberturaPedido;
    }

    public String getNumeroExterno() {
        return numeroExterno;
    }

    public void setNumeroExterno(String numeroExterno) {
        this.numeroExterno = numeroExterno;
    }

    public String getOutros() {
        return outros;
    }

    public void setOutros(String outros) {
        this.outros = outros;
    }

    public Character getFrete() {
        return frete;
    }

    public void setFrete(Character frete) {
        this.frete = frete;
    }

    public BigDecimal getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(BigDecimal valorFrete) {
        this.valorFrete = valorFrete;
    }

    public Boolean getAtendimentoParcial() {
        return atendimentoParcial;
    }

    public void setAtendimentoParcial(Boolean atendimentoParcial) {
        this.atendimentoParcial = atendimentoParcial;
    }

    public Boolean getStatusAprovacaoFinanceira() {
        return statusAprovacaoFinanceira;
    }

    public void setStatusAprovacaoFinanceira(Boolean statusAprovacaoFinanceira) {
        this.statusAprovacaoFinanceira = statusAprovacaoFinanceira;
    }

    public Boolean getStatusAprovacaoComercial() {
        return statusAprovacaoComercial;
    }

    public void setStatusAprovacaoComercial(Boolean statusAprovacaoComercial) {
        this.statusAprovacaoComercial = statusAprovacaoComercial;
    }

    public BigDecimal getComissaoPrincipal() {
        return comissaoPrincipal;
    }

    public void setComissaoPrincipal(BigDecimal comissaoPrincipal) {
        this.comissaoPrincipal = comissaoPrincipal;
    }

    public BigDecimal getComissaoSubstituto() {
        return comissaoSubstituto;
    }

    public void setComissaoSubstituto(BigDecimal comissaoSubstituto) {
        this.comissaoSubstituto = comissaoSubstituto;
    }

    public BigDecimal getValorTotalProdutos() {
        return valorTotalProdutos;
    }

    public void setValorTotalProdutos(BigDecimal valorTotalProdutos) {
        this.valorTotalProdutos = valorTotalProdutos;
    }

    public BigDecimal getValorTotalServicos() {
        return valorTotalServicos;
    }

    public void setValorTotalServicos(BigDecimal valorTotalServicos) {
        this.valorTotalServicos = valorTotalServicos;
    }

    public BigDecimal getValorTotalPedido() {
        return valorTotalPedido;
    }

    public void setValorTotalPedido(BigDecimal valorTotalPedido) {
        this.valorTotalPedido = valorTotalPedido;
    }

    public Date getDataAprovacaoFinanceira() {
        return dataAprovacaoFinanceira;
    }

    public void setDataAprovacaoFinanceira(Date dataAprovacaoFinanceira) {
        this.dataAprovacaoFinanceira = dataAprovacaoFinanceira;
    }

    public String getObservacaoAprovacaoFinanceira() {
        return observacaoAprovacaoFinanceira;
    }

    public void setObservacaoAprovacaoFinanceira(String observacaoAprovacaoFinanceira) {
        this.observacaoAprovacaoFinanceira = observacaoAprovacaoFinanceira;
    }

    public Date getDataAprovacaoComercial() {
        return dataAprovacaoComercial;
    }

    public void setDataAprovacaoComercial(Date dataAprovacaoComercial) {
        this.dataAprovacaoComercial = dataAprovacaoComercial;
    }

    public String getObservacaoAprovacaoComercial() {
        return observacaoAprovacaoComercial;
    }

    public void setObservacaoAprovacaoComercial(String observacaoAprovacaoComercial) {
        this.observacaoAprovacaoComercial = observacaoAprovacaoComercial;
    }

    public Date getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(Date dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public BigDecimal getTotalIPI() {
        return totalIPI;
    }

    public void setTotalIPI(BigDecimal totalIPI) {
        this.totalIPI = totalIPI;
    }

    public BigDecimal getTotalICMS() {
        return totalICMS;
    }

    public void setTotalICMS(BigDecimal totalICMS) {
        this.totalICMS = totalICMS;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getObservacaoNota() {
        return observacaoNota;
    }

    public void setObservacaoNota(String observacaoNota) {
        this.observacaoNota = observacaoNota;
    }

    public Integer getScoreAprovacaoFinanceira() {
        return scoreAprovacaoFinanceira;
    }

    public void setScoreAprovacaoFinanceira(Integer scoreAprovacaoFinanceira) {
        this.scoreAprovacaoFinanceira = scoreAprovacaoFinanceira;
    }

    public Integer getScoreAprovacaoComercial() {
        return scoreAprovacaoComercial;
    }

    public void setScoreAprovacaoComercial(Integer scoreAprovacaoComercial) {
        this.scoreAprovacaoComercial = scoreAprovacaoComercial;
    }

    public Character getOrigemPedido() {
        return origemPedido;
    }

    public void setOrigemPedido(Character origemPedido) {
        this.origemPedido = origemPedido;
    }

    public String getObservacaoInterna() {
        return observacaoInterna;
    }

    public void setObservacaoInterna(String observacaoInterna) {
        this.observacaoInterna = observacaoInterna;
    }

    public String getObservacaoCancelamento() {
        return observacaoCancelamento;
    }

    public void setObservacaoCancelamento(String observacaoCancelamento) {
        this.observacaoCancelamento = observacaoCancelamento;
    }

    public Boolean getCotacao() {
        return cotacao;
    }

    public void setCotacao(Boolean cotacao) {
        this.cotacao = cotacao;
    }

    public Integer getPrazoValidade() {
        return prazoValidade;
    }

    public void setPrazoValidade(Integer prazoValidade) {
        this.prazoValidade = prazoValidade;
    }

    public TipoPedidoVenda getIdTipoPedidoVenda() {
        return idTipoPedidoVenda;
    }

    public void setIdTipoPedidoVenda(TipoPedidoVenda idTipoPedidoVenda) {
        this.idTipoPedidoVenda = idTipoPedidoVenda;
    }

    public StatusPedido getIdStatusPedido() {
        return idStatusPedido;
    }

    public void setIdStatusPedido(StatusPedido idStatusPedido) {
        this.idStatusPedido = idStatusPedido;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Vendedor getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Vendedor idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Vendedor getIdVendedorSubstituto() {
        return idVendedorSubstituto;
    }

    public void setIdVendedorSubstituto(Vendedor idVendedorSubstituto) {
        this.idVendedorSubstituto = idVendedorSubstituto;
    }

    public CondicaoPagamento getIdCondicaoPagamento() {
        return idCondicaoPagamento;
    }

    public void setIdCondicaoPagamento(CondicaoPagamento idCondicaoPagamento) {
        this.idCondicaoPagamento = idCondicaoPagamento;
    }

    public Usuarios getIdUsuarioFinanceiro() {
        return idUsuarioFinanceiro;
    }

    public void setIdUsuarioFinanceiro(Usuarios idUsuarioFinanceiro) {
        this.idUsuarioFinanceiro = idUsuarioFinanceiro;
    }

    public Usuarios getIdUsuarioComercial() {
        return idUsuarioComercial;
    }

    public void setIdUsuarioComercial(Usuarios idUsuarioComercial) {
        this.idUsuarioComercial = idUsuarioComercial;
    }

    public Contato getIdContato() {
        return idContato;
    }

    public void setIdContato(Contato idContato) {
        this.idContato = idContato;
    }

    public Usuarios getIdUsuarioEncerramento() {
        return idUsuarioEncerramento;
    }

    public void setIdUsuarioEncerramento(Usuarios idUsuarioEncerramento) {
        this.idUsuarioEncerramento = idUsuarioEncerramento;
    }

    public Representantes getIdRepresentante() {
        return idRepresentante;
    }

    public void setIdRepresentante(Representantes idRepresentante) {
        this.idRepresentante = idRepresentante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedidoVenda != null ? idPedidoVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoVenda)) {
            return false;
        }
        PedidoVenda other = (PedidoVenda) object;
        if ((this.idPedidoVenda == null && other.idPedidoVenda != null) || (this.idPedidoVenda != null && !this.idPedidoVenda.equals(other.idPedidoVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.exception.PedidoVenda[ idPedidoVenda=" + idPedidoVenda + " ]";
    }

    public String getBuscaProduto() {
        return buscaProduto;
    }

    public void setBuscaProduto(String buscaProduto) {
        this.buscaProduto = buscaProduto;
    }
    
}

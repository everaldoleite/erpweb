/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.persistence.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author everaldo
 */
@Entity
@Table(name = "NATUREZA_OPERACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NaturezaOperacao.findAll", query = "SELECT n FROM NaturezaOperacao n"),
    @NamedQuery(name = "NaturezaOperacao.findByIdNaturezaOperacao", query = "SELECT n FROM NaturezaOperacao n WHERE n.idNaturezaOperacao = :idNaturezaOperacao"),
    @NamedQuery(name = "NaturezaOperacao.findByCodigoOperacao", query = "SELECT n FROM NaturezaOperacao n WHERE n.codigoOperacao = :codigoOperacao"),
    @NamedQuery(name = "NaturezaOperacao.findByDescricaoOperacao", query = "SELECT n FROM NaturezaOperacao n WHERE n.descricaoOperacao = :descricaoOperacao"),
    @NamedQuery(name = "NaturezaOperacao.findByDescricaoInterna", query = "SELECT n FROM NaturezaOperacao n WHERE n.descricaoInterna = :descricaoInterna"),
    @NamedQuery(name = "NaturezaOperacao.findByCfop", query = "SELECT n FROM NaturezaOperacao n WHERE n.cfop = :cfop"),
    @NamedQuery(name = "NaturezaOperacao.findByAliquotaICMS", query = "SELECT n FROM NaturezaOperacao n WHERE n.aliquotaICMS = :aliquotaICMS"),
    @NamedQuery(name = "NaturezaOperacao.findByBaseCalculoICMS", query = "SELECT n FROM NaturezaOperacao n WHERE n.baseCalculoICMS = :baseCalculoICMS"),
    @NamedQuery(name = "NaturezaOperacao.findByBaseCalculoICMSOutras", query = "SELECT n FROM NaturezaOperacao n WHERE n.baseCalculoICMSOutras = :baseCalculoICMSOutras"),
    @NamedQuery(name = "NaturezaOperacao.findByBaseCalculoICMSIsento", query = "SELECT n FROM NaturezaOperacao n WHERE n.baseCalculoICMSIsento = :baseCalculoICMSIsento"),
    @NamedQuery(name = "NaturezaOperacao.findByBaseCalculoIPI", query = "SELECT n FROM NaturezaOperacao n WHERE n.baseCalculoIPI = :baseCalculoIPI"),
    @NamedQuery(name = "NaturezaOperacao.findByBaseCalculoIPIOutras", query = "SELECT n FROM NaturezaOperacao n WHERE n.baseCalculoIPIOutras = :baseCalculoIPIOutras"),
    @NamedQuery(name = "NaturezaOperacao.findByBaseCalculoIPIIsento", query = "SELECT n FROM NaturezaOperacao n WHERE n.baseCalculoIPIIsento = :baseCalculoIPIIsento"),
    @NamedQuery(name = "NaturezaOperacao.findByOpcaoInclusaoIPIBaseICMS", query = "SELECT n FROM NaturezaOperacao n WHERE n.opcaoInclusaoIPIBaseICMS = :opcaoInclusaoIPIBaseICMS"),
    @NamedQuery(name = "NaturezaOperacao.findByAliquotaISS", query = "SELECT n FROM NaturezaOperacao n WHERE n.aliquotaISS = :aliquotaISS"),
    @NamedQuery(name = "NaturezaOperacao.findByAliquotaIR", query = "SELECT n FROM NaturezaOperacao n WHERE n.aliquotaIR = :aliquotaIR"),
    @NamedQuery(name = "NaturezaOperacao.findByAliquotaINSS", query = "SELECT n FROM NaturezaOperacao n WHERE n.aliquotaINSS = :aliquotaINSS"),
    @NamedQuery(name = "NaturezaOperacao.findByAliquotaPIS", query = "SELECT n FROM NaturezaOperacao n WHERE n.aliquotaPIS = :aliquotaPIS"),
    @NamedQuery(name = "NaturezaOperacao.findByAliquotaCOFINS", query = "SELECT n FROM NaturezaOperacao n WHERE n.aliquotaCOFINS = :aliquotaCOFINS"),
    @NamedQuery(name = "NaturezaOperacao.findByAliquotaCSLL", query = "SELECT n FROM NaturezaOperacao n WHERE n.aliquotaCSLL = :aliquotaCSLL"),
    @NamedQuery(name = "NaturezaOperacao.findByRetemISS", query = "SELECT n FROM NaturezaOperacao n WHERE n.retemISS = :retemISS"),
    @NamedQuery(name = "NaturezaOperacao.findByRetemINSS", query = "SELECT n FROM NaturezaOperacao n WHERE n.retemINSS = :retemINSS"),
    @NamedQuery(name = "NaturezaOperacao.findByRetemPIS", query = "SELECT n FROM NaturezaOperacao n WHERE n.retemPIS = :retemPIS"),
    @NamedQuery(name = "NaturezaOperacao.findByRetemCOFINS", query = "SELECT n FROM NaturezaOperacao n WHERE n.retemCOFINS = :retemCOFINS"),
    @NamedQuery(name = "NaturezaOperacao.findByRetemCSLL", query = "SELECT n FROM NaturezaOperacao n WHERE n.retemCSLL = :retemCSLL"),
    @NamedQuery(name = "NaturezaOperacao.findByOrigemST", query = "SELECT n FROM NaturezaOperacao n WHERE n.origemST = :origemST"),
    @NamedQuery(name = "NaturezaOperacao.findByTributacaoST", query = "SELECT n FROM NaturezaOperacao n WHERE n.tributacaoST = :tributacaoST"),
    @NamedQuery(name = "NaturezaOperacao.findByOpcaoContasReceber", query = "SELECT n FROM NaturezaOperacao n WHERE n.opcaoContasReceber = :opcaoContasReceber"),
    @NamedQuery(name = "NaturezaOperacao.findByOpcaoComissao", query = "SELECT n FROM NaturezaOperacao n WHERE n.opcaoComissao = :opcaoComissao"),
    @NamedQuery(name = "NaturezaOperacao.findByOpcaoPermiteAlteracao", query = "SELECT n FROM NaturezaOperacao n WHERE n.opcaoPermiteAlteracao = :opcaoPermiteAlteracao"),
    @NamedQuery(name = "NaturezaOperacao.findByOpcaoAtualizaEstoque", query = "SELECT n FROM NaturezaOperacao n WHERE n.opcaoAtualizaEstoque = :opcaoAtualizaEstoque"),
    @NamedQuery(name = "NaturezaOperacao.findByDispensaICMS", query = "SELECT n FROM NaturezaOperacao n WHERE n.dispensaICMS = :dispensaICMS"),
    @NamedQuery(name = "NaturezaOperacao.findByRetemIR", query = "SELECT n FROM NaturezaOperacao n WHERE n.retemIR = :retemIR"),
    @NamedQuery(name = "NaturezaOperacao.findByOpcaoNotaEletronicaServico", query = "SELECT n FROM NaturezaOperacao n WHERE n.opcaoNotaEletronicaServico = :opcaoNotaEletronicaServico"),
    @NamedQuery(name = "NaturezaOperacao.findByTipoNotaServico", query = "SELECT n FROM NaturezaOperacao n WHERE n.tipoNotaServico = :tipoNotaServico"),
    @NamedQuery(name = "NaturezaOperacao.findBySituacaoNotaEletronicaServico", query = "SELECT n FROM NaturezaOperacao n WHERE n.situacaoNotaEletronicaServico = :situacaoNotaEletronicaServico"),
    @NamedQuery(name = "NaturezaOperacao.findByCodigoServico", query = "SELECT n FROM NaturezaOperacao n WHERE n.codigoServico = :codigoServico"),
    @NamedQuery(name = "NaturezaOperacao.findByCodigoServicoFederal", query = "SELECT n FROM NaturezaOperacao n WHERE n.codigoServicoFederal = :codigoServicoFederal"),
    @NamedQuery(name = "NaturezaOperacao.findByDestino", query = "SELECT n FROM NaturezaOperacao n WHERE n.destino = :destino"),
    @NamedQuery(name = "NaturezaOperacao.findByLocalPrestacaoServico", query = "SELECT n FROM NaturezaOperacao n WHERE n.localPrestacaoServico = :localPrestacaoServico"),
    @NamedQuery(name = "NaturezaOperacao.findByOpcaoServicoPrestadoViaPublica", query = "SELECT n FROM NaturezaOperacao n WHERE n.opcaoServicoPrestadoViaPublica = :opcaoServicoPrestadoViaPublica"),
    @NamedQuery(name = "NaturezaOperacao.findByExibirTributos", query = "SELECT n FROM NaturezaOperacao n WHERE n.exibirTributos = :exibirTributos"),
    @NamedQuery(name = "NaturezaOperacao.findByStatus", query = "SELECT n FROM NaturezaOperacao n WHERE n.status = :status")})
public class NaturezaOperacao implements Serializable {
    @Column(name = "retemISS")
    private Character retemISS;
    @Column(name = "retemINSS")
    private Character retemINSS;
    @Column(name = "retemPIS")
    private Character retemPIS;
    @Column(name = "retemCOFINS")
    private Character retemCOFINS;
    @Column(name = "retemCSLL")
    private Character retemCSLL;
    @Column(name = "opcaoContasReceber")
    private Character opcaoContasReceber;
    @Column(name = "opcaoComissao")
    private Character opcaoComissao;
    @Column(name = "opcaoPermiteAlteracao")
    private Character opcaoPermiteAlteracao;
    @Column(name = "opcaoAtualizaEstoque")
    private Character opcaoAtualizaEstoque;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNaturezaOperacao")
    private Collection<NotaFiscal> notaFiscalCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNaturezaOperacao")
    private Integer idNaturezaOperacao;
    @Column(name = "codigoOperacao")
    private Integer codigoOperacao;
    @Size(max = 45)
    @Column(name = "descricaoOperacao")
    private String descricaoOperacao;
    @Size(max = 45)
    @Column(name = "descricaoInterna")
    private String descricaoInterna;
    @Size(max = 4)
    @Column(name = "cfop")
    private String cfop;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "aliquotaICMS")
    private BigDecimal aliquotaICMS;
    @Column(name = "baseCalculoICMS")
    private BigDecimal baseCalculoICMS;
    @Column(name = "baseCalculoICMSOutras")
    private BigDecimal baseCalculoICMSOutras;
    @Column(name = "baseCalculoICMSIsento")
    private BigDecimal baseCalculoICMSIsento;
    @Column(name = "baseCalculoIPI")
    private BigDecimal baseCalculoIPI;
    @Column(name = "baseCalculoIPIOutras")
    private BigDecimal baseCalculoIPIOutras;
    @Column(name = "baseCalculoIPIIsento")
    private BigDecimal baseCalculoIPIIsento;
    @Column(name = "opcaoInclusaoIPIBaseICMS")
    private Character opcaoInclusaoIPIBaseICMS;
    @Column(name = "aliquotaISS")
    private BigDecimal aliquotaISS;
    @Column(name = "aliquotaIR")
    private BigDecimal aliquotaIR;
    @Column(name = "aliquotaINSS")
    private BigDecimal aliquotaINSS;
    @Column(name = "aliquotaPIS")
    private BigDecimal aliquotaPIS;
    @Column(name = "aliquotaCOFINS")
    private BigDecimal aliquotaCOFINS;
    @Column(name = "aliquotaCSLL")
    private BigDecimal aliquotaCSLL;
    @Column(name = "origemST")
    private Integer origemST;
    @Column(name = "tributacaoST")
    private Integer tributacaoST;
    @Column(name = "dispensaICMS")
    private Character dispensaICMS;
    @Column(name = "retemIR")
    private Character retemIR;
    @Column(name = "opcaoNotaEletronicaServico")
    private Character opcaoNotaEletronicaServico;
    @Column(name = "tipoNotaServico")
    private Character tipoNotaServico;
    @Column(name = "situacaoNotaEletronicaServico")
    private Character situacaoNotaEletronicaServico;
    @Column(name = "codigoServico")
    private Integer codigoServico;
    @Size(max = 5)
    @Column(name = "codigoServicoFederal")
    private String codigoServicoFederal;
    @Column(name = "destino")
    private Character destino;
    @Column(name = "localPrestacaoServico")
    private Character localPrestacaoServico;
    @Column(name = "opcaoServicoPrestadoViaPublica")
    private Character opcaoServicoPrestadoViaPublica;
    @Column(name = "exibirTributos")
    private Character exibirTributos;
    @Size(max = 45)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "idMensagemFaturamento", referencedColumnName = "idMensagemFaturamento")
    @ManyToOne(optional = false)
    private MensagemFaturamento idMensagemFaturamento;
    @JoinColumn(name = "idTipoTitulo", referencedColumnName = "idTipoTitulo")
    @ManyToOne(optional = false)
    private TipoTitulo idTipoTitulo;
    @JoinColumn(name = "idtipoMovimentoEstoque", referencedColumnName = "idtipoMovimentoEstoque")
    @ManyToOne(optional = false)
    private TipoMovimentoEstoque idtipoMovimentoEstoque;
    @JoinColumn(name = "idtipoMovimentoEstoqueCancelamento", referencedColumnName = "idtipoMovimentoEstoque")
    @ManyToOne(optional = false)
    private TipoMovimentoEstoque idtipoMovimentoEstoqueCancelamento;
    @JoinColumn(name = "idsubstituicaoTributariaPIS", referencedColumnName = "idsubstituicaoTributariaPIS")
    @ManyToOne(optional = false)
    private SubstituicaoTributariaPisCofins idsubstituicaoTributariaPIS;
    @JoinColumn(name = "idsubstituicaoTributariaCOFINS", referencedColumnName = "idsubstituicaoTributariaPIS")
    @ManyToOne(optional = false)
    private SubstituicaoTributariaPisCofins idsubstituicaoTributariaCOFINS;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNaturezaOperacao")
    private Collection<Cliente> clienteCollection;

    public NaturezaOperacao() {
    }

    public NaturezaOperacao(Integer idNaturezaOperacao) {
        this.idNaturezaOperacao = idNaturezaOperacao;
    }

    public Integer getIdNaturezaOperacao() {
        return idNaturezaOperacao;
    }

    public void setIdNaturezaOperacao(Integer idNaturezaOperacao) {
        this.idNaturezaOperacao = idNaturezaOperacao;
    }

    public Integer getCodigoOperacao() {
        return codigoOperacao;
    }

    public void setCodigoOperacao(Integer codigoOperacao) {
        this.codigoOperacao = codigoOperacao;
    }

    public String getDescricaoOperacao() {
        return descricaoOperacao;
    }

    public void setDescricaoOperacao(String descricaoOperacao) {
        this.descricaoOperacao = descricaoOperacao;
    }

    public String getDescricaoInterna() {
        return descricaoInterna;
    }

    public void setDescricaoInterna(String descricaoInterna) {
        this.descricaoInterna = descricaoInterna;
    }

    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    public BigDecimal getAliquotaICMS() {
        return aliquotaICMS;
    }

    public void setAliquotaICMS(BigDecimal aliquotaICMS) {
        this.aliquotaICMS = aliquotaICMS;
    }

    public BigDecimal getBaseCalculoICMS() {
        return baseCalculoICMS;
    }

    public void setBaseCalculoICMS(BigDecimal baseCalculoICMS) {
        this.baseCalculoICMS = baseCalculoICMS;
    }

    public BigDecimal getBaseCalculoICMSOutras() {
        return baseCalculoICMSOutras;
    }

    public void setBaseCalculoICMSOutras(BigDecimal baseCalculoICMSOutras) {
        this.baseCalculoICMSOutras = baseCalculoICMSOutras;
    }

    public BigDecimal getBaseCalculoICMSIsento() {
        return baseCalculoICMSIsento;
    }

    public void setBaseCalculoICMSIsento(BigDecimal baseCalculoICMSIsento) {
        this.baseCalculoICMSIsento = baseCalculoICMSIsento;
    }

    public BigDecimal getBaseCalculoIPI() {
        return baseCalculoIPI;
    }

    public void setBaseCalculoIPI(BigDecimal baseCalculoIPI) {
        this.baseCalculoIPI = baseCalculoIPI;
    }

    public BigDecimal getBaseCalculoIPIOutras() {
        return baseCalculoIPIOutras;
    }

    public void setBaseCalculoIPIOutras(BigDecimal baseCalculoIPIOutras) {
        this.baseCalculoIPIOutras = baseCalculoIPIOutras;
    }

    public BigDecimal getBaseCalculoIPIIsento() {
        return baseCalculoIPIIsento;
    }

    public void setBaseCalculoIPIIsento(BigDecimal baseCalculoIPIIsento) {
        this.baseCalculoIPIIsento = baseCalculoIPIIsento;
    }

    public Character getOpcaoInclusaoIPIBaseICMS() {
        return opcaoInclusaoIPIBaseICMS;
    }

    public void setOpcaoInclusaoIPIBaseICMS(Character opcaoInclusaoIPIBaseICMS) {
        this.opcaoInclusaoIPIBaseICMS = opcaoInclusaoIPIBaseICMS;
    }

    public BigDecimal getAliquotaISS() {
        return aliquotaISS;
    }

    public void setAliquotaISS(BigDecimal aliquotaISS) {
        this.aliquotaISS = aliquotaISS;
    }

    public BigDecimal getAliquotaIR() {
        return aliquotaIR;
    }

    public void setAliquotaIR(BigDecimal aliquotaIR) {
        this.aliquotaIR = aliquotaIR;
    }

    public BigDecimal getAliquotaINSS() {
        return aliquotaINSS;
    }

    public void setAliquotaINSS(BigDecimal aliquotaINSS) {
        this.aliquotaINSS = aliquotaINSS;
    }

    public BigDecimal getAliquotaPIS() {
        return aliquotaPIS;
    }

    public void setAliquotaPIS(BigDecimal aliquotaPIS) {
        this.aliquotaPIS = aliquotaPIS;
    }

    public BigDecimal getAliquotaCOFINS() {
        return aliquotaCOFINS;
    }

    public void setAliquotaCOFINS(BigDecimal aliquotaCOFINS) {
        this.aliquotaCOFINS = aliquotaCOFINS;
    }

    public BigDecimal getAliquotaCSLL() {
        return aliquotaCSLL;
    }

    public void setAliquotaCSLL(BigDecimal aliquotaCSLL) {
        this.aliquotaCSLL = aliquotaCSLL;
    }

    public Integer getOrigemST() {
        return origemST;
    }

    public void setOrigemST(Integer origemST) {
        this.origemST = origemST;
    }

    public Integer getTributacaoST() {
        return tributacaoST;
    }

    public void setTributacaoST(Integer tributacaoST) {
        this.tributacaoST = tributacaoST;
    }

    public Character getDispensaICMS() {
        return dispensaICMS;
    }

    public void setDispensaICMS(Character dispensaICMS) {
        this.dispensaICMS = dispensaICMS;
    }

    public Character getRetemIR() {
        return retemIR;
    }

    public void setRetemIR(Character retemIR) {
        this.retemIR = retemIR;
    }

    public Character getOpcaoNotaEletronicaServico() {
        return opcaoNotaEletronicaServico;
    }

    public void setOpcaoNotaEletronicaServico(Character opcaoNotaEletronicaServico) {
        this.opcaoNotaEletronicaServico = opcaoNotaEletronicaServico;
    }

    public Character getTipoNotaServico() {
        return tipoNotaServico;
    }

    public void setTipoNotaServico(Character tipoNotaServico) {
        this.tipoNotaServico = tipoNotaServico;
    }

    public Character getSituacaoNotaEletronicaServico() {
        return situacaoNotaEletronicaServico;
    }

    public void setSituacaoNotaEletronicaServico(Character situacaoNotaEletronicaServico) {
        this.situacaoNotaEletronicaServico = situacaoNotaEletronicaServico;
    }

    public Integer getCodigoServico() {
        return codigoServico;
    }

    public void setCodigoServico(Integer codigoServico) {
        this.codigoServico = codigoServico;
    }

    public String getCodigoServicoFederal() {
        return codigoServicoFederal;
    }

    public void setCodigoServicoFederal(String codigoServicoFederal) {
        this.codigoServicoFederal = codigoServicoFederal;
    }

    public Character getDestino() {
        return destino;
    }

    public void setDestino(Character destino) {
        this.destino = destino;
    }

    public Character getLocalPrestacaoServico() {
        return localPrestacaoServico;
    }

    public void setLocalPrestacaoServico(Character localPrestacaoServico) {
        this.localPrestacaoServico = localPrestacaoServico;
    }

    public Character getOpcaoServicoPrestadoViaPublica() {
        return opcaoServicoPrestadoViaPublica;
    }

    public void setOpcaoServicoPrestadoViaPublica(Character opcaoServicoPrestadoViaPublica) {
        this.opcaoServicoPrestadoViaPublica = opcaoServicoPrestadoViaPublica;
    }

    public Character getExibirTributos() {
        return exibirTributos;
    }

    public void setExibirTributos(Character exibirTributos) {
        this.exibirTributos = exibirTributos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MensagemFaturamento getIdMensagemFaturamento() {
        return idMensagemFaturamento;
    }

    public void setIdMensagemFaturamento(MensagemFaturamento idMensagemFaturamento) {
        this.idMensagemFaturamento = idMensagemFaturamento;
    }

    public TipoTitulo getIdTipoTitulo() {
        return idTipoTitulo;
    }

    public void setIdTipoTitulo(TipoTitulo idTipoTitulo) {
        this.idTipoTitulo = idTipoTitulo;
    }

    public TipoMovimentoEstoque getIdtipoMovimentoEstoque() {
        return idtipoMovimentoEstoque;
    }

    public void setIdtipoMovimentoEstoque(TipoMovimentoEstoque idtipoMovimentoEstoque) {
        this.idtipoMovimentoEstoque = idtipoMovimentoEstoque;
    }

    public TipoMovimentoEstoque getIdtipoMovimentoEstoqueCancelamento() {
        return idtipoMovimentoEstoqueCancelamento;
    }

    public void setIdtipoMovimentoEstoqueCancelamento(TipoMovimentoEstoque idtipoMovimentoEstoqueCancelamento) {
        this.idtipoMovimentoEstoqueCancelamento = idtipoMovimentoEstoqueCancelamento;
    }

    public SubstituicaoTributariaPisCofins getIdsubstituicaoTributariaPIS() {
        return idsubstituicaoTributariaPIS;
    }

    public void setIdsubstituicaoTributariaPIS(SubstituicaoTributariaPisCofins idsubstituicaoTributariaPIS) {
        this.idsubstituicaoTributariaPIS = idsubstituicaoTributariaPIS;
    }

    public SubstituicaoTributariaPisCofins getIdsubstituicaoTributariaCOFINS() {
        return idsubstituicaoTributariaCOFINS;
    }

    public void setIdsubstituicaoTributariaCOFINS(SubstituicaoTributariaPisCofins idsubstituicaoTributariaCOFINS) {
        this.idsubstituicaoTributariaCOFINS = idsubstituicaoTributariaCOFINS;
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
        hash += (idNaturezaOperacao != null ? idNaturezaOperacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NaturezaOperacao)) {
            return false;
        }
        NaturezaOperacao other = (NaturezaOperacao) object;
        if ((this.idNaturezaOperacao == null && other.idNaturezaOperacao != null) || (this.idNaturezaOperacao != null && !this.idNaturezaOperacao.equals(other.idNaturezaOperacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.NaturezaOperacao[ idNaturezaOperacao=" + idNaturezaOperacao + " ]";
    }

    /**
     * @return the retemISS
     */
    public Character getRetemISS() {
        return retemISS;
    }

    /**
     * @param retemISS the retemISS to set
     */
    public void setRetemISS(Character retemISS) {
        this.retemISS = retemISS;
    }

    /**
     * @return the retemINSS
     */
    public Character getRetemINSS() {
        return retemINSS;
    }

    /**
     * @param retemINSS the retemINSS to set
     */
    public void setRetemINSS(Character retemINSS) {
        this.retemINSS = retemINSS;
    }

    /**
     * @return the retemPIS
     */
    public Character getRetemPIS() {
        return retemPIS;
    }

    /**
     * @param retemPIS the retemPIS to set
     */
    public void setRetemPIS(Character retemPIS) {
        this.retemPIS = retemPIS;
    }

    /**
     * @return the retemCOFINS
     */
    public Character getRetemCOFINS() {
        return retemCOFINS;
    }

    /**
     * @param retemCOFINS the retemCOFINS to set
     */
    public void setRetemCOFINS(Character retemCOFINS) {
        this.retemCOFINS = retemCOFINS;
    }

    /**
     * @return the retemCSLL
     */
    public Character getRetemCSLL() {
        return retemCSLL;
    }

    /**
     * @param retemCSLL the retemCSLL to set
     */
    public void setRetemCSLL(Character retemCSLL) {
        this.retemCSLL = retemCSLL;
    }

    /**
     * @return the opcaoContasReceber
     */
    public Character getOpcaoContasReceber() {
        return opcaoContasReceber;
    }

    /**
     * @param opcaoContasReceber the opcaoContasReceber to set
     */
    public void setOpcaoContasReceber(Character opcaoContasReceber) {
        this.opcaoContasReceber = opcaoContasReceber;
    }

    /**
     * @return the opcaoComissao
     */
    public Character getOpcaoComissao() {
        return opcaoComissao;
    }

    /**
     * @param opcaoComissao the opcaoComissao to set
     */
    public void setOpcaoComissao(Character opcaoComissao) {
        this.opcaoComissao = opcaoComissao;
    }

    /**
     * @return the opcaoPermiteAlteracao
     */
    public Character getOpcaoPermiteAlteracao() {
        return opcaoPermiteAlteracao;
    }

    /**
     * @param opcaoPermiteAlteracao the opcaoPermiteAlteracao to set
     */
    public void setOpcaoPermiteAlteracao(Character opcaoPermiteAlteracao) {
        this.opcaoPermiteAlteracao = opcaoPermiteAlteracao;
    }

    /**
     * @return the opcaoAtualizaEstoque
     */
    public Character getOpcaoAtualizaEstoque() {
        return opcaoAtualizaEstoque;
    }

    /**
     * @param opcaoAtualizaEstoque the opcaoAtualizaEstoque to set
     */
    public void setOpcaoAtualizaEstoque(Character opcaoAtualizaEstoque) {
        this.opcaoAtualizaEstoque = opcaoAtualizaEstoque;
    }

    @XmlTransient
    public Collection<NotaFiscal> getNotaFiscalCollection() {
        return notaFiscalCollection;
    }

    public void setNotaFiscalCollection(Collection<NotaFiscal> notaFiscalCollection) {
        this.notaFiscalCollection = notaFiscalCollection;
    }
    
}

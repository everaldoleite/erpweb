/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.persistence.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author everaldo
 */
@Entity
@Table(name = "NOTA_FISCAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotaFiscal.findAll", query = "SELECT n FROM NotaFiscal n"),
    @NamedQuery(name = "NotaFiscal.findByIdNotaFiscal", query = "SELECT n FROM NotaFiscal n WHERE n.idNotaFiscal = :idNotaFiscal"),
    @NamedQuery(name = "NotaFiscal.findByIdCliente", query = "SELECT n FROM NotaFiscal n WHERE n.idCliente = :idCliente AND n.geraCobranca = :geraCobranca AND n.boletoEmitido = :boletoEmitido"),
    @NamedQuery(name = "NotaFiscal.findByTipoNota", query = "SELECT n FROM NotaFiscal n WHERE n.tipoNota = :tipoNota"),
    @NamedQuery(name = "NotaFiscal.findBySerie", query = "SELECT n FROM NotaFiscal n WHERE n.serie = :serie"),
    @NamedQuery(name = "NotaFiscal.findByDataGeracao", query = "SELECT n FROM NotaFiscal n WHERE n.dataGeracao = :dataGeracao"),
    @NamedQuery(name = "NotaFiscal.findByNumeroNota", query = "SELECT n FROM NotaFiscal n WHERE n.numeroNota = :numeroNota"),
    @NamedQuery(name = "NotaFiscal.findByDataEmissaoNotaFiscal", query = "SELECT n FROM NotaFiscal n WHERE n.dataEmissaoNotaFiscal = :dataEmissaoNotaFiscal"),
    @NamedQuery(name = "NotaFiscal.findByDataBase", query = "SELECT n FROM NotaFiscal n WHERE n.dataBase = :dataBase"),
    @NamedQuery(name = "NotaFiscal.findByDataCancelamento", query = "SELECT n FROM NotaFiscal n WHERE n.dataCancelamento = :dataCancelamento"),
    @NamedQuery(name = "NotaFiscal.findByMotivoCancelamento", query = "SELECT n FROM NotaFiscal n WHERE n.motivoCancelamento = :motivoCancelamento"),
    @NamedQuery(name = "NotaFiscal.findByCentroResultado", query = "SELECT n FROM NotaFiscal n WHERE n.centroResultado = :centroResultado"),
    @NamedQuery(name = "NotaFiscal.findByContaResultado", query = "SELECT n FROM NotaFiscal n WHERE n.contaResultado = :contaResultado"),
    @NamedQuery(name = "NotaFiscal.findByOrigem", query = "SELECT n FROM NotaFiscal n WHERE n.origem = :origem"),
    @NamedQuery(name = "NotaFiscal.findByDocumentoOrigem", query = "SELECT n FROM NotaFiscal n WHERE n.documentoOrigem = :documentoOrigem"),
    @NamedQuery(name = "NotaFiscal.findByErroProcessamentoInterno", query = "SELECT n FROM NotaFiscal n WHERE n.erroProcessamentoInterno = :erroProcessamentoInterno"),
    @NamedQuery(name = "NotaFiscal.findByErroProcessamentoExterno", query = "SELECT n FROM NotaFiscal n WHERE n.erroProcessamentoExterno = :erroProcessamentoExterno"),
    @NamedQuery(name = "NotaFiscal.findByStatusNotaFiscal", query = "SELECT n FROM NotaFiscal n WHERE n.statusNotaFiscal = :statusNotaFiscal"),
    @NamedQuery(name = "NotaFiscal.findByAnoCompetencia", query = "SELECT n FROM NotaFiscal n WHERE n.anoCompetencia = :anoCompetencia"),
    @NamedQuery(name = "NotaFiscal.findByMesCompetencia", query = "SELECT n FROM NotaFiscal n WHERE n.mesCompetencia = :mesCompetencia"),
    @NamedQuery(name = "NotaFiscal.findByTotalICMS", query = "SELECT n FROM NotaFiscal n WHERE n.totalICMS = :totalICMS"),
    @NamedQuery(name = "NotaFiscal.findByTotalBaseICMS", query = "SELECT n FROM NotaFiscal n WHERE n.totalBaseICMS = :totalBaseICMS"),
    @NamedQuery(name = "NotaFiscal.findByTotalIsentoICMS", query = "SELECT n FROM NotaFiscal n WHERE n.totalIsentoICMS = :totalIsentoICMS"),
    @NamedQuery(name = "NotaFiscal.findByTotalOutrasICMS", query = "SELECT n FROM NotaFiscal n WHERE n.totalOutrasICMS = :totalOutrasICMS"),
    @NamedQuery(name = "NotaFiscal.findByTotalIPI", query = "SELECT n FROM NotaFiscal n WHERE n.totalIPI = :totalIPI"),
    @NamedQuery(name = "NotaFiscal.findByTotalBaseIPI", query = "SELECT n FROM NotaFiscal n WHERE n.totalBaseIPI = :totalBaseIPI"),
    @NamedQuery(name = "NotaFiscal.findByTotalIsentoIPI", query = "SELECT n FROM NotaFiscal n WHERE n.totalIsentoIPI = :totalIsentoIPI"),
    @NamedQuery(name = "NotaFiscal.findByTotalOutrasIPI", query = "SELECT n FROM NotaFiscal n WHERE n.totalOutrasIPI = :totalOutrasIPI"),
    @NamedQuery(name = "NotaFiscal.findByValorTotalProdutos", query = "SELECT n FROM NotaFiscal n WHERE n.valorTotalProdutos = :valorTotalProdutos"),
    @NamedQuery(name = "NotaFiscal.findByPercentualINSS", query = "SELECT n FROM NotaFiscal n WHERE n.percentualINSS = :percentualINSS"),
    @NamedQuery(name = "NotaFiscal.findByPercentualIR", query = "SELECT n FROM NotaFiscal n WHERE n.percentualIR = :percentualIR"),
    @NamedQuery(name = "NotaFiscal.findByPercentualPIS", query = "SELECT n FROM NotaFiscal n WHERE n.percentualPIS = :percentualPIS"),
    @NamedQuery(name = "NotaFiscal.findByPercentualCOFINS", query = "SELECT n FROM NotaFiscal n WHERE n.percentualCOFINS = :percentualCOFINS"),
    @NamedQuery(name = "NotaFiscal.findByPercentualCSLL", query = "SELECT n FROM NotaFiscal n WHERE n.percentualCSLL = :percentualCSLL"),
    @NamedQuery(name = "NotaFiscal.findByRetencaoINSS", query = "SELECT n FROM NotaFiscal n WHERE n.retencaoINSS = :retencaoINSS"),
    @NamedQuery(name = "NotaFiscal.findByRetencaoPIS", query = "SELECT n FROM NotaFiscal n WHERE n.retencaoPIS = :retencaoPIS"),
    @NamedQuery(name = "NotaFiscal.findByRetencaoCOFINS", query = "SELECT n FROM NotaFiscal n WHERE n.retencaoCOFINS = :retencaoCOFINS"),
    @NamedQuery(name = "NotaFiscal.findByRetencaoIR", query = "SELECT n FROM NotaFiscal n WHERE n.retencaoIR = :retencaoIR"),
    @NamedQuery(name = "NotaFiscal.findByRetencaoCSLL", query = "SELECT n FROM NotaFiscal n WHERE n.retencaoCSLL = :retencaoCSLL"),
    @NamedQuery(name = "NotaFiscal.findByValorINSS", query = "SELECT n FROM NotaFiscal n WHERE n.valorINSS = :valorINSS"),
    @NamedQuery(name = "NotaFiscal.findByValorIR", query = "SELECT n FROM NotaFiscal n WHERE n.valorIR = :valorIR"),
    @NamedQuery(name = "NotaFiscal.findByValorCOFINS", query = "SELECT n FROM NotaFiscal n WHERE n.valorCOFINS = :valorCOFINS"),
    @NamedQuery(name = "NotaFiscal.findByValorPIS", query = "SELECT n FROM NotaFiscal n WHERE n.valorPIS = :valorPIS"),
    @NamedQuery(name = "NotaFiscal.findByValorCSLL", query = "SELECT n FROM NotaFiscal n WHERE n.valorCSLL = :valorCSLL"),
    @NamedQuery(name = "NotaFiscal.findByTotalBruto", query = "SELECT n FROM NotaFiscal n WHERE n.totalBruto = :totalBruto"),
    @NamedQuery(name = "NotaFiscal.findByTotalLiquido", query = "SELECT n FROM NotaFiscal n WHERE n.totalLiquido = :totalLiquido"),
    @NamedQuery(name = "NotaFiscal.findByValorTotalRetencao", query = "SELECT n FROM NotaFiscal n WHERE n.valorTotalRetencao = :valorTotalRetencao"),
    @NamedQuery(name = "NotaFiscal.findByComplementoNotaFiscal", query = "SELECT n FROM NotaFiscal n WHERE n.complementoNotaFiscal = :complementoNotaFiscal"),
    @NamedQuery(name = "NotaFiscal.findByComplementoMensagem", query = "SELECT n FROM NotaFiscal n WHERE n.complementoMensagem = :complementoMensagem"),
    @NamedQuery(name = "NotaFiscal.findByObservacao", query = "SELECT n FROM NotaFiscal n WHERE n.observacao = :observacao"),
    @NamedQuery(name = "NotaFiscal.findByCfop", query = "SELECT n FROM NotaFiscal n WHERE n.cfop = :cfop"),
    @NamedQuery(name = "NotaFiscal.findByAliquotaICMS", query = "SELECT n FROM NotaFiscal n WHERE n.aliquotaICMS = :aliquotaICMS"),
    @NamedQuery(name = "NotaFiscal.findByAtualizacaoEstoque", query = "SELECT n FROM NotaFiscal n WHERE n.atualizacaoEstoque = :atualizacaoEstoque"),
    @NamedQuery(name = "NotaFiscal.findByFatorBaseICMS", query = "SELECT n FROM NotaFiscal n WHERE n.fatorBaseICMS = :fatorBaseICMS"),
    @NamedQuery(name = "NotaFiscal.findByFatorBaseIPI", query = "SELECT n FROM NotaFiscal n WHERE n.fatorBaseIPI = :fatorBaseIPI"),
    @NamedQuery(name = "NotaFiscal.findByGeraCobranca", query = "SELECT n FROM NotaFiscal n WHERE n.geraCobranca = :geraCobranca"),
    @NamedQuery(name = "NotaFiscal.findByGeraComissao", query = "SELECT n FROM NotaFiscal n WHERE n.geraComissao = :geraComissao"),
    @NamedQuery(name = "NotaFiscal.findByRetemIRF", query = "SELECT n FROM NotaFiscal n WHERE n.retemIRF = :retemIRF"),
    @NamedQuery(name = "NotaFiscal.findByNotaFiscalComplementar", query = "SELECT n FROM NotaFiscal n WHERE n.notaFiscalComplementar = :notaFiscalComplementar"),
    @NamedQuery(name = "NotaFiscal.findByRevendedor", query = "SELECT n FROM NotaFiscal n WHERE n.revendedor = :revendedor"),
    @NamedQuery(name = "NotaFiscal.findByDescricaoOficialNF", query = "SELECT n FROM NotaFiscal n WHERE n.descricaoOficialNF = :descricaoOficialNF"),
    @NamedQuery(name = "NotaFiscal.findByValorLiquidoTotalST", query = "SELECT n FROM NotaFiscal n WHERE n.valorLiquidoTotalST = :valorLiquidoTotalST"),
    @NamedQuery(name = "NotaFiscal.findByValorBrutoTotalST", query = "SELECT n FROM NotaFiscal n WHERE n.valorBrutoTotalST = :valorBrutoTotalST"),
    @NamedQuery(name = "NotaFiscal.findByMensagemErroNotaFiscal", query = "SELECT n FROM NotaFiscal n WHERE n.mensagemErroNotaFiscal = :mensagemErroNotaFiscal"),
    @NamedQuery(name = "NotaFiscal.findByChaveNotaFiscal", query = "SELECT n FROM NotaFiscal n WHERE n.chaveNotaFiscal = :chaveNotaFiscal"),
    @NamedQuery(name = "NotaFiscal.findByDigitoVerificadorNotaFiscal", query = "SELECT n FROM NotaFiscal n WHERE n.digitoVerificadorNotaFiscal = :digitoVerificadorNotaFiscal"),
    @NamedQuery(name = "NotaFiscal.findByProtocoloNotaFiscal", query = "SELECT n FROM NotaFiscal n WHERE n.protocoloNotaFiscal = :protocoloNotaFiscal"),
    @NamedQuery(name = "NotaFiscal.findByDataProtocolo", query = "SELECT n FROM NotaFiscal n WHERE n.dataProtocolo = :dataProtocolo"),
    @NamedQuery(name = "NotaFiscal.findByEspecieVolume", query = "SELECT n FROM NotaFiscal n WHERE n.especieVolume = :especieVolume"),
    @NamedQuery(name = "NotaFiscal.findByReferenciaNotaFiscal", query = "SELECT n FROM NotaFiscal n WHERE n.referenciaNotaFiscal = :referenciaNotaFiscal")})
public class NotaFiscal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNotaFiscal")
    private Integer idNotaFiscal;
    @Column(name = "tipoNota")
    private Character tipoNota;
    @Size(max = 45)
    @Column(name = "serie")
    private String serie;
    @Column(name = "dataGeracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataGeracao;
    @Size(max = 45)
    @Column(name = "numeroNota")
    private String numeroNota;
    @Column(name = "dataEmissaoNotaFiscal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEmissaoNotaFiscal;
    @Column(name = "dataBase")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataBase;
    @Column(name = "dataCancelamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCancelamento;
    @Size(max = 45)
    @Column(name = "motivoCancelamento")
    private String motivoCancelamento;
    @Size(max = 45)
    @Column(name = "centroResultado")
    private String centroResultado;
    @Size(max = 45)
    @Column(name = "contaResultado")
    private String contaResultado;
    @Column(name = "origem")
    private Character origem;
    @Column(name = "documentoOrigem")
    private Integer documentoOrigem;
    @Column(name = "erroProcessamentoInterno")
    private Character erroProcessamentoInterno;
    @Column(name = "erroProcessamentoExterno")
    private Character erroProcessamentoExterno;
    @Column(name = "statusNotaFiscal")
    private Character statusNotaFiscal;
    @Size(max = 4)
    @Column(name = "anoCompetencia")
    private String anoCompetencia;
    @Size(max = 2)
    @Column(name = "mesCompetencia")
    private String mesCompetencia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "totalICMS")
    private BigDecimal totalICMS;
    @Column(name = "totalBaseICMS")
    private BigDecimal totalBaseICMS;
    @Column(name = "totalIsentoICMS")
    private BigDecimal totalIsentoICMS;
    @Column(name = "totalOutrasICMS")
    private BigDecimal totalOutrasICMS;
    @Column(name = "totalIPI")
    private BigDecimal totalIPI;
    @Column(name = "totalBaseIPI")
    private BigDecimal totalBaseIPI;
    @Column(name = "totalIsentoIPI")
    private BigDecimal totalIsentoIPI;
    @Column(name = "totalOutrasIPI")
    private BigDecimal totalOutrasIPI;
    @Column(name = "valorTotalProdutos")
    private BigDecimal valorTotalProdutos;
    @Column(name = "percentualINSS")
    private BigDecimal percentualINSS;
    @Column(name = "percentualIR")
    private BigDecimal percentualIR;
    @Column(name = "percentualPIS")
    private BigDecimal percentualPIS;
    @Column(name = "percentualCOFINS")
    private BigDecimal percentualCOFINS;
    @Column(name = "percentualCSLL")
    private BigDecimal percentualCSLL;
    @Column(name = "retencaoINSS")
    private Character retencaoINSS;
    @Column(name = "retencaoPIS")
    private Character retencaoPIS;
    @Column(name = "retencaoCOFINS")
    private Character retencaoCOFINS;
    @Column(name = "retencaoIR")
    private Character retencaoIR;
    @Column(name = "retencaoCSLL")
    private Character retencaoCSLL;
    @Column(name = "valorINSS")
    private BigDecimal valorINSS;
    @Column(name = "valorIR")
    private BigDecimal valorIR;
    @Column(name = "valorCOFINS")
    private BigDecimal valorCOFINS;
    @Column(name = "valorPIS")
    private BigDecimal valorPIS;
    @Column(name = "valorCSLL")
    private BigDecimal valorCSLL;
    @Column(name = "totalBruto")
    private BigDecimal totalBruto;
    @Column(name = "totalLiquido")
    private BigDecimal totalLiquido;
    @Column(name = "valorTotalRetencao")
    private BigDecimal valorTotalRetencao;
    @Size(max = 45)
    @Column(name = "complementoNotaFiscal")
    private String complementoNotaFiscal;
    @Size(max = 45)
    @Column(name = "complementoMensagem")
    private String complementoMensagem;
    @Size(max = 45)
    @Column(name = "observacao")
    private String observacao;
    @Size(max = 45)
    @Column(name = "cfop")
    private String cfop;
    @Column(name = "aliquotaICMS")
    private Integer aliquotaICMS;
    @Column(name = "atualizacaoEstoque")
    private Character atualizacaoEstoque;
    @Column(name = "fatorBaseICMS")
    private BigDecimal fatorBaseICMS;
    @Column(name = "fatorBaseIPI")
    private BigDecimal fatorBaseIPI;
    @Column(name = "geraCobranca")
    private Character geraCobranca;
    @Column(name = "geraComissao")
    private Character geraComissao;
    @Column(name = "retemIRF")
    private Character retemIRF;
    @Column(name = "notaFiscalComplementar")
    private Character notaFiscalComplementar;
    @Column(name = "revendedor")
    private Character revendedor;
    @Size(max = 30)
    @Column(name = "descricaoOficialNF")
    private String descricaoOficialNF;
    @Column(name = "valorLiquidoTotalST")
    private BigDecimal valorLiquidoTotalST;
    @Column(name = "valorBrutoTotalST")
    private BigDecimal valorBrutoTotalST;
    @Size(max = 150)
    @Column(name = "mensagemErroNotaFiscal")
    private String mensagemErroNotaFiscal;
    @Size(max = 45)
    @Column(name = "chaveNotaFiscal")
    private String chaveNotaFiscal;
    @Size(max = 45)
    @Column(name = "digitoVerificadorNotaFiscal")
    private String digitoVerificadorNotaFiscal;
    @Size(max = 45)
    @Column(name = "protocoloNotaFiscal")
    private String protocoloNotaFiscal;
    @Column(name = "dataProtocolo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataProtocolo;
    @Size(max = 45)
    @Column(name = "especieVolume")
    private String especieVolume;
    @Size(max = 45)
    @Column(name = "referenciaNotaFiscal")
    private String referenciaNotaFiscal;
    @JoinColumn(name = "idCondicaoPagamento", referencedColumnName = "idCondicaoPagamento")
    @ManyToOne(optional = false)
    private CondicaoPagamento idCondicaoPagamento;
    @JoinColumn(name = "idEmpresaEmitente", referencedColumnName = "idEmpresaEmitente")
    @ManyToOne(optional = false)
    private EmpresaEmitente idEmpresaEmitente;
    @JoinColumn(name = "PROCESSO_EMISSAONF_idProcessoEmissaoNF", referencedColumnName = "idProcessoEmissaoNF")
    @ManyToOne(optional = false)
    private ProcessoEmissaonf pROCESSOEMISSAONFidProcessoEmissaoNF;
    @JoinColumn(name = "idFinalidadeNF", referencedColumnName = "idFinalidadeNF")
    @ManyToOne(optional = false)
    private FinalidadeNf idFinalidadeNF;
    @JoinColumn(name = "idFormatoImpressao", referencedColumnName = "idFormatoImpressao")
    @ManyToOne(optional = false)
    private FormatoImpressao idFormatoImpressao;
    @JoinColumn(name = "idLocalidadeEntrega", referencedColumnName = "idLocalidade")
    @ManyToOne(optional = false)
    private Localidade idLocalidadeEntrega;
    @JoinColumn(name = "idLocalidadePagamento", referencedColumnName = "idLocalidade")
    @ManyToOne(optional = false)
    private Localidade idLocalidadePagamento;
    @JoinColumn(name = "idTipoEmissao", referencedColumnName = "idTipoEmissao")
    @ManyToOne(optional = false)
    private TipoEmissao idTipoEmissao;
    @JoinColumn(name = "idMensagemFaturamento", referencedColumnName = "idMensagemFaturamento")
    @ManyToOne(optional = false)
    private MensagemFaturamento idMensagemFaturamento;
    @JoinColumn(name = "idMensagemFaturamentoPrincipal", referencedColumnName = "idMensagemFaturamento")
    @ManyToOne(optional = false)
    private MensagemFaturamento idMensagemFaturamentoPrincipal;
    @JoinColumn(name = "idMensagemFaturamentoSecundaria", referencedColumnName = "idMensagemFaturamento")
    @ManyToOne(optional = false)
    private MensagemFaturamento idMensagemFaturamentoSecundaria;
    @JoinColumn(name = "idVendedor", referencedColumnName = "idVendedor")
    @ManyToOne(optional = false)
    private Vendedor idVendedor;
    @JoinColumn(name = "idmotivoCancelamento", referencedColumnName = "idmotivoCancelamento")
    @ManyToOne
    private MotivoCancelamento idmotivoCancelamento;
    @JoinColumn(name = "idNaturezaOperacao", referencedColumnName = "idNaturezaOperacao")
    @ManyToOne(optional = false)
    private NaturezaOperacao idNaturezaOperacao;
    @JoinColumn(name = "idOrdemFaturamento", referencedColumnName = "idOrdemFaturamento")
    @ManyToOne(optional = false)
    private OrdemFaturamento idOrdemFaturamento;

    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;

    @Column(name = "boletoEmitido")
    private Boolean boletoEmitido;
       
    
    public NotaFiscal() {
    }

    public NotaFiscal(Integer idNotaFiscal) {
        this.idNotaFiscal = idNotaFiscal;
    }

    public Integer getIdNotaFiscal() {
        return idNotaFiscal;
    }

    public void setIdNotaFiscal(Integer idNotaFiscal) {
        this.idNotaFiscal = idNotaFiscal;
    }

    public Character getTipoNota() {
        return tipoNota;
    }

    public void setTipoNota(Character tipoNota) {
        this.tipoNota = tipoNota;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Date getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(Date dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public String getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(String numeroNota) {
        this.numeroNota = numeroNota;
    }

    public Date getDataEmissaoNotaFiscal() {
        return dataEmissaoNotaFiscal;
    }

    public void setDataEmissaoNotaFiscal(Date dataEmissaoNotaFiscal) {
        this.dataEmissaoNotaFiscal = dataEmissaoNotaFiscal;
    }

    public Date getDataBase() {
        return dataBase;
    }

    public void setDataBase(Date dataBase) {
        this.dataBase = dataBase;
    }

    public Date getDataCancelamento() {
        return dataCancelamento;
    }

    public void setDataCancelamento(Date dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }

    public void setMotivoCancelamento(String motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
    }

    public String getCentroResultado() {
        return centroResultado;
    }

    public void setCentroResultado(String centroResultado) {
        this.centroResultado = centroResultado;
    }

    public String getContaResultado() {
        return contaResultado;
    }

    public void setContaResultado(String contaResultado) {
        this.contaResultado = contaResultado;
    }

    public Character getOrigem() {
        return origem;
    }

    public void setOrigem(Character origem) {
        this.origem = origem;
    }

    public Integer getDocumentoOrigem() {
        return documentoOrigem;
    }

    public void setDocumentoOrigem(Integer documentoOrigem) {
        this.documentoOrigem = documentoOrigem;
    }

    public Character getErroProcessamentoInterno() {
        return erroProcessamentoInterno;
    }

    public void setErroProcessamentoInterno(Character erroProcessamentoInterno) {
        this.erroProcessamentoInterno = erroProcessamentoInterno;
    }

    public Character getErroProcessamentoExterno() {
        return erroProcessamentoExterno;
    }

    public void setErroProcessamentoExterno(Character erroProcessamentoExterno) {
        this.erroProcessamentoExterno = erroProcessamentoExterno;
    }

    public Character getStatusNotaFiscal() {
        return statusNotaFiscal;
    }

    public void setStatusNotaFiscal(Character statusNotaFiscal) {
        this.statusNotaFiscal = statusNotaFiscal;
    }

    public String getAnoCompetencia() {
        return anoCompetencia;
    }

    public void setAnoCompetencia(String anoCompetencia) {
        this.anoCompetencia = anoCompetencia;
    }

    public String getMesCompetencia() {
        return mesCompetencia;
    }

    public void setMesCompetencia(String mesCompetencia) {
        this.mesCompetencia = mesCompetencia;
    }

    public BigDecimal getTotalICMS() {
        return totalICMS;
    }

    public void setTotalICMS(BigDecimal totalICMS) {
        this.totalICMS = totalICMS;
    }

    public BigDecimal getTotalBaseICMS() {
        return totalBaseICMS;
    }

    public void setTotalBaseICMS(BigDecimal totalBaseICMS) {
        this.totalBaseICMS = totalBaseICMS;
    }

    public BigDecimal getTotalIsentoICMS() {
        return totalIsentoICMS;
    }

    public void setTotalIsentoICMS(BigDecimal totalIsentoICMS) {
        this.totalIsentoICMS = totalIsentoICMS;
    }

    public BigDecimal getTotalOutrasICMS() {
        return totalOutrasICMS;
    }

    public void setTotalOutrasICMS(BigDecimal totalOutrasICMS) {
        this.totalOutrasICMS = totalOutrasICMS;
    }

    public BigDecimal getTotalIPI() {
        return totalIPI;
    }

    public void setTotalIPI(BigDecimal totalIPI) {
        this.totalIPI = totalIPI;
    }

    public BigDecimal getTotalBaseIPI() {
        return totalBaseIPI;
    }

    public void setTotalBaseIPI(BigDecimal totalBaseIPI) {
        this.totalBaseIPI = totalBaseIPI;
    }

    public BigDecimal getTotalIsentoIPI() {
        return totalIsentoIPI;
    }

    public void setTotalIsentoIPI(BigDecimal totalIsentoIPI) {
        this.totalIsentoIPI = totalIsentoIPI;
    }

    public BigDecimal getTotalOutrasIPI() {
        return totalOutrasIPI;
    }

    public void setTotalOutrasIPI(BigDecimal totalOutrasIPI) {
        this.totalOutrasIPI = totalOutrasIPI;
    }

    public BigDecimal getValorTotalProdutos() {
        return valorTotalProdutos;
    }

    public void setValorTotalProdutos(BigDecimal valorTotalProdutos) {
        this.valorTotalProdutos = valorTotalProdutos;
    }

    public BigDecimal getPercentualINSS() {
        return percentualINSS;
    }

    public void setPercentualINSS(BigDecimal percentualINSS) {
        this.percentualINSS = percentualINSS;
    }

    public BigDecimal getPercentualIR() {
        return percentualIR;
    }

    public void setPercentualIR(BigDecimal percentualIR) {
        this.percentualIR = percentualIR;
    }

    public BigDecimal getPercentualPIS() {
        return percentualPIS;
    }

    public void setPercentualPIS(BigDecimal percentualPIS) {
        this.percentualPIS = percentualPIS;
    }

    public BigDecimal getPercentualCOFINS() {
        return percentualCOFINS;
    }

    public void setPercentualCOFINS(BigDecimal percentualCOFINS) {
        this.percentualCOFINS = percentualCOFINS;
    }

    public BigDecimal getPercentualCSLL() {
        return percentualCSLL;
    }

    public void setPercentualCSLL(BigDecimal percentualCSLL) {
        this.percentualCSLL = percentualCSLL;
    }

    public Character getRetencaoINSS() {
        return retencaoINSS;
    }

    public void setRetencaoINSS(Character retencaoINSS) {
        this.retencaoINSS = retencaoINSS;
    }

    public Character getRetencaoPIS() {
        return retencaoPIS;
    }

    public void setRetencaoPIS(Character retencaoPIS) {
        this.retencaoPIS = retencaoPIS;
    }

    public Character getRetencaoCOFINS() {
        return retencaoCOFINS;
    }

    public void setRetencaoCOFINS(Character retencaoCOFINS) {
        this.retencaoCOFINS = retencaoCOFINS;
    }

    public Character getRetencaoIR() {
        return retencaoIR;
    }

    public void setRetencaoIR(Character retencaoIR) {
        this.retencaoIR = retencaoIR;
    }

    public Character getRetencaoCSLL() {
        return retencaoCSLL;
    }

    public void setRetencaoCSLL(Character retencaoCSLL) {
        this.retencaoCSLL = retencaoCSLL;
    }

    public BigDecimal getValorINSS() {
        return valorINSS;
    }

    public void setValorINSS(BigDecimal valorINSS) {
        this.valorINSS = valorINSS;
    }

    public BigDecimal getValorIR() {
        return valorIR;
    }

    public void setValorIR(BigDecimal valorIR) {
        this.valorIR = valorIR;
    }

    public BigDecimal getValorCOFINS() {
        return valorCOFINS;
    }

    public void setValorCOFINS(BigDecimal valorCOFINS) {
        this.valorCOFINS = valorCOFINS;
    }

    public BigDecimal getValorPIS() {
        return valorPIS;
    }

    public void setValorPIS(BigDecimal valorPIS) {
        this.valorPIS = valorPIS;
    }

    public BigDecimal getValorCSLL() {
        return valorCSLL;
    }

    public void setValorCSLL(BigDecimal valorCSLL) {
        this.valorCSLL = valorCSLL;
    }

    public BigDecimal getTotalBruto() {
        return totalBruto;
    }

    public void setTotalBruto(BigDecimal totalBruto) {
        this.totalBruto = totalBruto;
    }

    public BigDecimal getTotalLiquido() {
        return totalLiquido;
    }

    public void setTotalLiquido(BigDecimal totalLiquido) {
        this.totalLiquido = totalLiquido;
    }

    public BigDecimal getValorTotalRetencao() {
        return valorTotalRetencao;
    }

    public void setValorTotalRetencao(BigDecimal valorTotalRetencao) {
        this.valorTotalRetencao = valorTotalRetencao;
    }

    public String getComplementoNotaFiscal() {
        return complementoNotaFiscal;
    }

    public void setComplementoNotaFiscal(String complementoNotaFiscal) {
        this.complementoNotaFiscal = complementoNotaFiscal;
    }

    public String getComplementoMensagem() {
        return complementoMensagem;
    }

    public void setComplementoMensagem(String complementoMensagem) {
        this.complementoMensagem = complementoMensagem;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    public Integer getAliquotaICMS() {
        return aliquotaICMS;
    }

    public void setAliquotaICMS(Integer aliquotaICMS) {
        this.aliquotaICMS = aliquotaICMS;
    }

    public Character getAtualizacaoEstoque() {
        return atualizacaoEstoque;
    }

    public void setAtualizacaoEstoque(Character atualizacaoEstoque) {
        this.atualizacaoEstoque = atualizacaoEstoque;
    }

    public BigDecimal getFatorBaseICMS() {
        return fatorBaseICMS;
    }

    public void setFatorBaseICMS(BigDecimal fatorBaseICMS) {
        this.fatorBaseICMS = fatorBaseICMS;
    }

    public BigDecimal getFatorBaseIPI() {
        return fatorBaseIPI;
    }

    public void setFatorBaseIPI(BigDecimal fatorBaseIPI) {
        this.fatorBaseIPI = fatorBaseIPI;
    }

    public Character getGeraCobranca() {
        return geraCobranca;
    }

    public void setGeraCobranca(Character geraCobranca) {
        this.geraCobranca = geraCobranca;
    }

    public Character getGeraComissao() {
        return geraComissao;
    }

    public void setGeraComissao(Character geraComissao) {
        this.geraComissao = geraComissao;
    }

    public Character getRetemIRF() {
        return retemIRF;
    }

    public void setRetemIRF(Character retemIRF) {
        this.retemIRF = retemIRF;
    }

    public Character getNotaFiscalComplementar() {
        return notaFiscalComplementar;
    }

    public void setNotaFiscalComplementar(Character notaFiscalComplementar) {
        this.notaFiscalComplementar = notaFiscalComplementar;
    }

    public Character getRevendedor() {
        return revendedor;
    }

    public void setRevendedor(Character revendedor) {
        this.revendedor = revendedor;
    }

    public String getDescricaoOficialNF() {
        return descricaoOficialNF;
    }

    public void setDescricaoOficialNF(String descricaoOficialNF) {
        this.descricaoOficialNF = descricaoOficialNF;
    }

    public BigDecimal getValorLiquidoTotalST() {
        return valorLiquidoTotalST;
    }

    public void setValorLiquidoTotalST(BigDecimal valorLiquidoTotalST) {
        this.valorLiquidoTotalST = valorLiquidoTotalST;
    }

    public BigDecimal getValorBrutoTotalST() {
        return valorBrutoTotalST;
    }

    public void setValorBrutoTotalST(BigDecimal valorBrutoTotalST) {
        this.valorBrutoTotalST = valorBrutoTotalST;
    }

    public String getMensagemErroNotaFiscal() {
        return mensagemErroNotaFiscal;
    }

    public void setMensagemErroNotaFiscal(String mensagemErroNotaFiscal) {
        this.mensagemErroNotaFiscal = mensagemErroNotaFiscal;
    }

    public String getChaveNotaFiscal() {
        return chaveNotaFiscal;
    }

    public void setChaveNotaFiscal(String chaveNotaFiscal) {
        this.chaveNotaFiscal = chaveNotaFiscal;
    }

    public String getDigitoVerificadorNotaFiscal() {
        return digitoVerificadorNotaFiscal;
    }

    public void setDigitoVerificadorNotaFiscal(String digitoVerificadorNotaFiscal) {
        this.digitoVerificadorNotaFiscal = digitoVerificadorNotaFiscal;
    }

    public String getProtocoloNotaFiscal() {
        return protocoloNotaFiscal;
    }

    public void setProtocoloNotaFiscal(String protocoloNotaFiscal) {
        this.protocoloNotaFiscal = protocoloNotaFiscal;
    }

    public Date getDataProtocolo() {
        return dataProtocolo;
    }

    public void setDataProtocolo(Date dataProtocolo) {
        this.dataProtocolo = dataProtocolo;
    }

    public String getEspecieVolume() {
        return especieVolume;
    }

    public void setEspecieVolume(String especieVolume) {
        this.especieVolume = especieVolume;
    }

    public String getReferenciaNotaFiscal() {
        return referenciaNotaFiscal;
    }

    public void setReferenciaNotaFiscal(String referenciaNotaFiscal) {
        this.referenciaNotaFiscal = referenciaNotaFiscal;
    }

    public CondicaoPagamento getIdCondicaoPagamento() {
        return idCondicaoPagamento;
    }

    public void setIdCondicaoPagamento(CondicaoPagamento idCondicaoPagamento) {
        this.idCondicaoPagamento = idCondicaoPagamento;
    }

    public EmpresaEmitente getIdEmpresaEmitente() {
        return idEmpresaEmitente;
    }

    public void setIdEmpresaEmitente(EmpresaEmitente idEmpresaEmitente) {
        this.idEmpresaEmitente = idEmpresaEmitente;
    }

    public ProcessoEmissaonf getPROCESSOEMISSAONFidProcessoEmissaoNF() {
        return pROCESSOEMISSAONFidProcessoEmissaoNF;
    }

    public void setPROCESSOEMISSAONFidProcessoEmissaoNF(ProcessoEmissaonf pROCESSOEMISSAONFidProcessoEmissaoNF) {
        this.pROCESSOEMISSAONFidProcessoEmissaoNF = pROCESSOEMISSAONFidProcessoEmissaoNF;
    }

    public FinalidadeNf getIdFinalidadeNF() {
        return idFinalidadeNF;
    }

    public void setIdFinalidadeNF(FinalidadeNf idFinalidadeNF) {
        this.idFinalidadeNF = idFinalidadeNF;
    }

    public FormatoImpressao getIdFormatoImpressao() {
        return idFormatoImpressao;
    }

    public void setIdFormatoImpressao(FormatoImpressao idFormatoImpressao) {
        this.idFormatoImpressao = idFormatoImpressao;
    }

    public Localidade getIdLocalidadeEntrega() {
        return idLocalidadeEntrega;
    }

    public void setIdLocalidadeEntrega(Localidade idLocalidadeEntrega) {
        this.idLocalidadeEntrega = idLocalidadeEntrega;
    }

    public Localidade getIdLocalidadePagamento() {
        return idLocalidadePagamento;
    }

    public void setIdLocalidadePagamento(Localidade idLocalidadePagamento) {
        this.idLocalidadePagamento = idLocalidadePagamento;
    }

    public TipoEmissao getIdTipoEmissao() {
        return idTipoEmissao;
    }

    public void setIdTipoEmissao(TipoEmissao idTipoEmissao) {
        this.idTipoEmissao = idTipoEmissao;
    }

    public MensagemFaturamento getIdMensagemFaturamento() {
        return idMensagemFaturamento;
    }

    public void setIdMensagemFaturamento(MensagemFaturamento idMensagemFaturamento) {
        this.idMensagemFaturamento = idMensagemFaturamento;
    }

    public MensagemFaturamento getIdMensagemFaturamentoPrincipal() {
        return idMensagemFaturamentoPrincipal;
    }

    public void setIdMensagemFaturamentoPrincipal(MensagemFaturamento idMensagemFaturamentoPrincipal) {
        this.idMensagemFaturamentoPrincipal = idMensagemFaturamentoPrincipal;
    }

    public MensagemFaturamento getIdMensagemFaturamentoSecundaria() {
        return idMensagemFaturamentoSecundaria;
    }

    public void setIdMensagemFaturamentoSecundaria(MensagemFaturamento idMensagemFaturamentoSecundaria) {
        this.idMensagemFaturamentoSecundaria = idMensagemFaturamentoSecundaria;
    }

    public Vendedor getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Vendedor idVendedor) {
        this.idVendedor = idVendedor;
    }

    public MotivoCancelamento getIdmotivoCancelamento() {
        return idmotivoCancelamento;
    }

    public void setIdmotivoCancelamento(MotivoCancelamento idmotivoCancelamento) {
        this.idmotivoCancelamento = idmotivoCancelamento;
    }

    public NaturezaOperacao getIdNaturezaOperacao() {
        return idNaturezaOperacao;
    }

    public void setIdNaturezaOperacao(NaturezaOperacao idNaturezaOperacao) {
        this.idNaturezaOperacao = idNaturezaOperacao;
    }

    public OrdemFaturamento getIdOrdemFaturamento() {
        return idOrdemFaturamento;
    }

    public void setIdOrdemFaturamento(OrdemFaturamento idOrdemFaturamento) {
        this.idOrdemFaturamento = idOrdemFaturamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotaFiscal != null ? idNotaFiscal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaFiscal)) {
            return false;
        }
        NotaFiscal other = (NotaFiscal) object;
        if ((this.idNotaFiscal == null && other.idNotaFiscal != null) || (this.idNotaFiscal != null && !this.idNotaFiscal.equals(other.idNotaFiscal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.NotaFiscal[ idNotaFiscal=" + idNotaFiscal + " ]";
    }

    /**
     * @return the idCliente
     */
    public Cliente getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the boletoEmitido
     */
    public Boolean getBoletoEmitido() {
        return boletoEmitido;
    }

    /**
     * @param boletoEmitido the boletoEmitido to set
     */
    public void setBoletoEmitido(Boolean boletoEmitido) {
        this.boletoEmitido = boletoEmitido;
    }
    
}

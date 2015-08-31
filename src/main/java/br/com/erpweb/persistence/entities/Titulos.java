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
@Table(name = "TITULOS")
@XmlRootElement
public class Titulos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTitulo")
    private Integer idTitulo;

    @JoinColumn(name = "idTipoTitulo", referencedColumnName = "idTipoTitulo")
    @ManyToOne(optional = false)
    private TipoTitulo idTipoTitulo;

    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;

    @Size(max = 60)
    @Column(name = "descricaoTitulo")
    private String descricaoTitulo;

    @Column(name = "localizacao")
    private Character localizacao;

    @Column(name = "situacao")
    private Character situacao;
    
    
    @Column(name = "numeroNF")
    private Integer numeroNF;

    @Column(name = "parcela")
    private Integer parcela;

    @Column(name = "dataEmissao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEmissao;

    @Column(name = "dataVencimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVencimento;

    @Column(name = "valorBruto", precision = 11, scale = 2)
    private BigDecimal valorBruto;

    @Column(name = "valorTotal", precision = 11, scale = 2)
    private BigDecimal valorTotal;

    @Column(name = "percentualIR", precision = 11, scale = 2)
    private BigDecimal percentualIR;

    @Column(name = "valorIR", precision = 11, scale = 2)
    private BigDecimal valorIR;

    @Column(name = "percentualISS", precision = 11, scale = 2)
    private BigDecimal percentualISS;

    @Column(name = "valorISS", precision = 11, scale = 2)
    private BigDecimal valorISS;

    @Size(max = 45)
    @Column(name = "motivoDesconto")
    private String motivoDesconto;

    @Column(name = "juros", precision = 11, scale = 2)
    private BigDecimal juros;

    @Column(name = "multa", precision = 11, scale = 2)
    private BigDecimal multa;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataRegistroMotivo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataImpressaoBoleto;

    @Size(max = 45)
    @Column(name = "observacao")
    private String observacao;

    @Size(max = 45)
    @Column(name = "numeroDocumento")
    private String numeroDocumento;

    @Column(name = "valorEmAberto", precision = 11, scale = 2)
    private BigDecimal valorEmAberto;

    @Column(name = "valorDesconto", precision = 11, scale = 2)
    private BigDecimal valorDesconto;

    @Column(name = "valorLiquidado", precision = 11, scale = 2)
    private BigDecimal valorLiquidado;

    @Column(name = "saldoEmAberto", precision = 11, scale = 2)
    private BigDecimal saldoEmAberto;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataBloqueio;

    @Column(name = "percentualINSS", precision = 11, scale = 2)
    private BigDecimal percentualINSS;

    @Column(name = "valorINSS", precision = 11, scale = 2)
    private BigDecimal valorINSS;

    private Boolean geracaoRemessa;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimoPagamento;

    @Size(max = 6)
    @Column(name = "competencia")
    private String competencia;

    @Column(name = "percentualCSLL", precision = 11, scale = 2)
    private BigDecimal percentualCSLL;

    @Column(name = "valorCSLL", precision = 11, scale = 2)
    private BigDecimal valorCSLL;

    @Column(name = "percentualCOFINS", precision = 11, scale = 2)
    private BigDecimal percentualCOFINS;

    @Column(name = "valorCOFINS", precision = 11, scale = 2)
    private BigDecimal valorCOFINS;

    @JoinColumn(name = "idVendedor", referencedColumnName = "idVendedor")
    @ManyToOne
    private Vendedor idVendedor;

    @JoinColumn(name = "idCentroResultado", referencedColumnName = "idCentroResultado")
    @ManyToOne(optional = false)
    private CentroResultado idCentroResultado;

    @JoinColumn(name = "idPlanoContas", referencedColumnName = "idPlanoContas")
    @ManyToOne(optional = false)
    private ContaResultado idPlanoContas;

    @JoinColumn(name = "idTipoCobranca", referencedColumnName = "idTipoCobranca")
    @ManyToOne(optional = false)
    private TipoCobranca idTipoCobranca;

    @JoinColumn(name = "idEmpresaEmitente", referencedColumnName = "idEmpresaEmitente")
    @ManyToOne(optional = false)
    private EmpresaEmitente idEmpresaEmitente;

    @JoinColumn(name = "idNotaFiscal", referencedColumnName = "idNotaFiscal")
    @ManyToOne
    private NotaFiscal idNotaFiscal;
    
    @Column(name = "percentualDesconto", precision = 11, scale = 2)
    private BigDecimal percentualDesconto;
    
    
    public Titulos() {
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getIdTitulo() != null ? getIdTitulo().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Titulos)) {
            return false;
        }
        Titulos other = (Titulos) object;
        if ((this.getIdTitulo() == null && other.getIdTitulo() != null) || (this.getIdTitulo() != null && !this.idTitulo.equals(other.idTitulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.Titulos[ idTitulo=" + getIdTitulo() + " ]";
    }

    /**
     * @return the idTitulo
     */
    public Integer getIdTitulo() {
        return idTitulo;
    }

    /**
     * @param idTitulo the idTitulo to set
     */
    public void setIdTitulo(Integer idTitulo) {
        this.idTitulo = idTitulo;
    }

    /**
     * @return the idTipoTitulo
     */
    public TipoTitulo getIdTipoTitulo() {
        return idTipoTitulo;
    }

    /**
     * @param idTipoTitulo the idTipoTitulo to set
     */
    public void setIdTipoTitulo(TipoTitulo idTipoTitulo) {
        this.idTipoTitulo = idTipoTitulo;
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
     * @return the descricaoTitulo
     */
    public String getDescricaoTitulo() {
        return descricaoTitulo;
    }

    /**
     * @param descricaoTitulo the descricaoTitulo to set
     */
    public void setDescricaoTitulo(String descricaoTitulo) {
        this.descricaoTitulo = descricaoTitulo;
    }

    /**
     * @return the localizacao
     */
    public Character getLocalizacao() {
        return localizacao;
    }

    /**
     * @param localizacao the localizacao to set
     */
    public void setLocalizacao(Character localizacao) {
        this.localizacao = localizacao;
    }

    /**
     * @return the numeroNF
     */
    public Integer getNumeroNF() {
        return numeroNF;
    }

    /**
     * @param numeroNF the numeroNF to set
     */
    public void setNumeroNF(Integer numeroNF) {
        this.numeroNF = numeroNF;
    }

    /**
     * @return the parcela
     */
    public Integer getParcela() {
        return parcela;
    }

    /**
     * @param parcela the parcela to set
     */
    public void setParcela(Integer parcela) {
        this.parcela = parcela;
    }

    /**
     * @return the dataEmissao
     */
    public Date getDataEmissao() {
        return dataEmissao;
    }

    /**
     * @param dataEmissao the dataEmissao to set
     */
    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    /**
     * @return the dataVencimento
     */
    public Date getDataVencimento() {
        return dataVencimento;
    }

    /**
     * @param dataVencimento the dataVencimento to set
     */
    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    /**
     * @return the valorBruto
     */
    public BigDecimal getValorBruto() {
        return valorBruto;
    }

    /**
     * @param valorBruto the valorBruto to set
     */
    public void setValorBruto(BigDecimal valorBruto) {
        this.valorBruto = valorBruto;
    }

    /**
     * @return the valorTotal
     */
    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the percentualIR
     */
    public BigDecimal getPercentualIR() {
        return percentualIR;
    }

    /**
     * @param percentualIR the percentualIR to set
     */
    public void setPercentualIR(BigDecimal percentualIR) {
        this.percentualIR = percentualIR;
    }

    /**
     * @return the valorIR
     */
    public BigDecimal getValorIR() {
        return valorIR;
    }

    /**
     * @param valorIR the valorIR to set
     */
    public void setValorIR(BigDecimal valorIR) {
        this.valorIR = valorIR;
    }

    /**
     * @return the percentualISS
     */
    public BigDecimal getPercentualISS() {
        return percentualISS;
    }

    /**
     * @param percentualISS the percentualISS to set
     */
    public void setPercentualISS(BigDecimal percentualISS) {
        this.percentualISS = percentualISS;
    }

    /**
     * @return the valorISS
     */
    public BigDecimal getValorISS() {
        return valorISS;
    }

    /**
     * @param valorISS the valorISS to set
     */
    public void setValorISS(BigDecimal valorISS) {
        this.valorISS = valorISS;
    }

    /**
     * @return the motivoDesconto
     */
    public String getMotivoDesconto() {
        return motivoDesconto;
    }

    /**
     * @param motivoDesconto the motivoDesconto to set
     */
    public void setMotivoDesconto(String motivoDesconto) {
        this.motivoDesconto = motivoDesconto;
    }

    /**
     * @return the juros
     */
    public BigDecimal getJuros() {
        return juros;
    }

    /**
     * @param juros the juros to set
     */
    public void setJuros(BigDecimal juros) {
        this.juros = juros;
    }

    /**
     * @return the multa
     */
    public BigDecimal getMulta() {
        return multa;
    }

    /**
     * @param multa the multa to set
     */
    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }

    /**
     * @return the dataRegistroMotivo
     */
    public Date getDataRegistroMotivo() {
        return dataRegistroMotivo;
    }

    /**
     * @param dataRegistroMotivo the dataRegistroMotivo to set
     */
    public void setDataRegistroMotivo(Date dataRegistroMotivo) {
        this.dataRegistroMotivo = dataRegistroMotivo;
    }

    /**
     * @return the dataImpressaoBoleto
     */
    public Date getDataImpressaoBoleto() {
        return dataImpressaoBoleto;
    }

    /**
     * @param dataImpressaoBoleto the dataImpressaoBoleto to set
     */
    public void setDataImpressaoBoleto(Date dataImpressaoBoleto) {
        this.dataImpressaoBoleto = dataImpressaoBoleto;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * @return the numeroDocumento
     */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * @param numeroDocumento the numeroDocumento to set
     */
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    /**
     * @return the valorEmAberto
     */
    public BigDecimal getValorEmAberto() {
        return valorEmAberto;
    }

    /**
     * @param valorEmAberto the valorEmAberto to set
     */
    public void setValorEmAberto(BigDecimal valorEmAberto) {
        this.valorEmAberto = valorEmAberto;
    }

    /**
     * @return the valorDesconto
     */
    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    /**
     * @param valorDesconto the valorDesconto to set
     */
    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    /**
     * @return the valorLiquidado
     */
    public BigDecimal getValorLiquidado() {
        return valorLiquidado;
    }

    /**
     * @param valorLiquidado the valorLiquidado to set
     */
    public void setValorLiquidado(BigDecimal valorLiquidado) {
        this.valorLiquidado = valorLiquidado;
    }

    /**
     * @return the saldoEmAberto
     */
    public BigDecimal getSaldoEmAberto() {
        return saldoEmAberto;
    }

    /**
     * @param saldoEmAberto the saldoEmAberto to set
     */
    public void setSaldoEmAberto(BigDecimal saldoEmAberto) {
        this.saldoEmAberto = saldoEmAberto;
    }

    /**
     * @return the dataBloqueio
     */
    public Date getDataBloqueio() {
        return dataBloqueio;
    }

    /**
     * @param dataBloqueio the dataBloqueio to set
     */
    public void setDataBloqueio(Date dataBloqueio) {
        this.dataBloqueio = dataBloqueio;
    }

    /**
     * @return the percentualINSS
     */
    public BigDecimal getPercentualINSS() {
        return percentualINSS;
    }

    /**
     * @param percentualINSS the percentualINSS to set
     */
    public void setPercentualINSS(BigDecimal percentualINSS) {
        this.percentualINSS = percentualINSS;
    }

    /**
     * @return the valorINSS
     */
    public BigDecimal getValorINSS() {
        return valorINSS;
    }

    /**
     * @param valorINSS the valorINSS to set
     */
    public void setValorINSS(BigDecimal valorINSS) {
        this.valorINSS = valorINSS;
    }

    /**
     * @return the geracaoRemessa
     */
    public Boolean getGeracaoRemessa() {
        return geracaoRemessa;
    }

    /**
     * @param geracaoRemessa the geracaoRemessa to set
     */
    public void setGeracaoRemessa(Boolean geracaoRemessa) {
        this.geracaoRemessa = geracaoRemessa;
    }

    /**
     * @return the dataUltimoPagamento
     */
    public Date getDataUltimoPagamento() {
        return dataUltimoPagamento;
    }

    /**
     * @param dataUltimoPagamento the dataUltimoPagamento to set
     */
    public void setDataUltimoPagamento(Date dataUltimoPagamento) {
        this.dataUltimoPagamento = dataUltimoPagamento;
    }

    /**
     * @return the competencia
     */
    public String getCompetencia() {
        return competencia;
    }

    /**
     * @param competencia the competencia to set
     */
    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    /**
     * @return the percentualCSLL
     */
    public BigDecimal getPercentualCSLL() {
        return percentualCSLL;
    }

    /**
     * @param percentualCSLL the percentualCSLL to set
     */
    public void setPercentualCSLL(BigDecimal percentualCSLL) {
        this.percentualCSLL = percentualCSLL;
    }

    /**
     * @return the valorCSLL
     */
    public BigDecimal getValorCSLL() {
        return valorCSLL;
    }

    /**
     * @param valorCSLL the valorCSLL to set
     */
    public void setValorCSLL(BigDecimal valorCSLL) {
        this.valorCSLL = valorCSLL;
    }

    /**
     * @return the percentualCOFINS
     */
    public BigDecimal getPercentualCOFINS() {
        return percentualCOFINS;
    }

    /**
     * @param percentualCOFINS the percentualCOFINS to set
     */
    public void setPercentualCOFINS(BigDecimal percentualCOFINS) {
        this.percentualCOFINS = percentualCOFINS;
    }

    /**
     * @return the valorCOFINS
     */
    public BigDecimal getValorCOFINS() {
        return valorCOFINS;
    }

    /**
     * @param valorCOFINS the valorCOFINS to set
     */
    public void setValorCOFINS(BigDecimal valorCOFINS) {
        this.valorCOFINS = valorCOFINS;
    }

    /**
     * @return the idVendedor
     */
    public Vendedor getIdVendedor() {
        return idVendedor;
    }

    /**
     * @param idVendedor the idVendedor to set
     */
    public void setIdVendedor(Vendedor idVendedor) {
        this.idVendedor = idVendedor;
    }

    /**
     * @return the idCentroResultado
     */
    public CentroResultado getIdCentroResultado() {
        return idCentroResultado;
    }

    /**
     * @param idCentroResultado the idCentroResultado to set
     */
    public void setIdCentroResultado(CentroResultado idCentroResultado) {
        this.idCentroResultado = idCentroResultado;
    }

    /**
     * @return the idTipoCobranca
     */
    public TipoCobranca getIdTipoCobranca() {
        return idTipoCobranca;
    }

    /**
     * @param idTipoCobranca the idTipoCobranca to set
     */
    public void setIdTipoCobranca(TipoCobranca idTipoCobranca) {
        this.idTipoCobranca = idTipoCobranca;
    }

    /**
     * @return the idEmpresaEmitente
     */
    public EmpresaEmitente getIdEmpresaEmitente() {
        return idEmpresaEmitente;
    }

    /**
     * @param idEmpresaEmitente the idEmpresaEmitente to set
     */
    public void setIdEmpresaEmitente(EmpresaEmitente idEmpresaEmitente) {
        this.idEmpresaEmitente = idEmpresaEmitente;
    }

    /**
     * @return the idNotaFiscal
     */
    public NotaFiscal getIdNotaFiscal() {
        return idNotaFiscal;
    }

    /**
     * @param idNotaFiscal the idNotaFiscal to set
     */
    public void setIdNotaFiscal(NotaFiscal idNotaFiscal) {
        this.idNotaFiscal = idNotaFiscal;
    }

    /**
     * @return the situacao
     */
    public Character getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(Character situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the percentualDesconto
     */
    public BigDecimal getPercentualDesconto() {
        return percentualDesconto;
    }

    /**
     * @param percentualDesconto the percentualDesconto to set
     */
    public void setPercentualDesconto(BigDecimal percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    /**
     * @param idPlanoContas the idPlanoContas to set
     */
    public void setIdPlanoContas(ContaResultado idPlanoContas) {
        this.idPlanoContas = idPlanoContas;
    }

    /**
     * @return the idPlanoContas
     */
    public ContaResultado getIdPlanoContas() {
        return idPlanoContas;
    }

}

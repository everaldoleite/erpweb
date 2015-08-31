/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.persistence.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author everaldo
 */
@Entity
@Table(name = "TIPO_COBRANCA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCobranca.findAll", query = "SELECT t FROM TipoCobranca t"),
    @NamedQuery(name = "TipoCobranca.findByIdtipoCobranca", query = "SELECT t FROM TipoCobranca t WHERE t.idtipoCobranca = :idtipoCobranca"),
    @NamedQuery(name = "TipoCobranca.findByCodigoCarteira", query = "SELECT t FROM TipoCobranca t WHERE t.codigoCarteira = :codigoCarteira"),
    @NamedQuery(name = "TipoCobranca.findByDescricaoTipoCobranca", query = "SELECT t FROM TipoCobranca t WHERE t.descricaoTipoCobranca = :descricaoTipoCobranca"),
    @NamedQuery(name = "TipoCobranca.findByRegistraFluxoCaixa", query = "SELECT t FROM TipoCobranca t WHERE t.registraFluxoCaixa = :registraFluxoCaixa"),
    @NamedQuery(name = "TipoCobranca.findByDiasCredito", query = "SELECT t FROM TipoCobranca t WHERE t.diasCredito = :diasCredito"),
    @NamedQuery(name = "TipoCobranca.findByInstrucao", query = "SELECT t FROM TipoCobranca t WHERE t.instrucao = :instrucao"),
    @NamedQuery(name = "TipoCobranca.findByPercentualJuros", query = "SELECT t FROM TipoCobranca t WHERE t.percentualJuros = :percentualJuros"),
    @NamedQuery(name = "TipoCobranca.findByPercentualMulta", query = "SELECT t FROM TipoCobranca t WHERE t.percentualMulta = :percentualMulta"),
    @NamedQuery(name = "TipoCobranca.findByDiasProtesto", query = "SELECT t FROM TipoCobranca t WHERE t.diasProtesto = :diasProtesto"),
    @NamedQuery(name = "TipoCobranca.findByCodigoCedente", query = "SELECT t FROM TipoCobranca t WHERE t.codigoCedente = :codigoCedente"),
    @NamedQuery(name = "TipoCobranca.findByCodigoAgenciaCedente", query = "SELECT t FROM TipoCobranca t WHERE t.codigoAgenciaCedente = :codigoAgenciaCedente"),
    @NamedQuery(name = "TipoCobranca.findByCodigoContaMovimentoCedente", query = "SELECT t FROM TipoCobranca t WHERE t.codigoContaMovimentoCedente = :codigoContaMovimentoCedente"),
    @NamedQuery(name = "TipoCobranca.findByCodigoContaCobrancaCedente", query = "SELECT t FROM TipoCobranca t WHERE t.codigoContaCobrancaCedente = :codigoContaCobrancaCedente"),
    @NamedQuery(name = "TipoCobranca.findByNossoNumeroInicio", query = "SELECT t FROM TipoCobranca t WHERE t.nossoNumeroInicio = :nossoNumeroInicio"),
    @NamedQuery(name = "TipoCobranca.findByNossoNumeroFim", query = "SELECT t FROM TipoCobranca t WHERE t.nossoNumeroFim = :nossoNumeroFim"),
    @NamedQuery(name = "TipoCobranca.findByNossoNumeroUltimo", query = "SELECT t FROM TipoCobranca t WHERE t.nossoNumeroUltimo = :nossoNumeroUltimo"),
    @NamedQuery(name = "TipoCobranca.findByIndicadorFluxoCaixa", query = "SELECT t FROM TipoCobranca t WHERE t.indicadorFluxoCaixa = :indicadorFluxoCaixa"),
    @NamedQuery(name = "TipoCobranca.findByTipoGeracaoBoleto", query = "SELECT t FROM TipoCobranca t WHERE t.tipoGeracaoBoleto = :tipoGeracaoBoleto")})
public class TipoCobranca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipoCobranca")
    private Integer idtipoCobranca;
    @Size(max = 7)
    @Column(name = "codigoCarteira")
    private String codigoCarteira;
    @Size(max = 45)
    @Column(name = "descricaoTipoCobranca")
    private String descricaoTipoCobranca;
    @Column(name = "registraFluxoCaixa")
    private Boolean registraFluxoCaixa;
    @Column(name = "diasCredito")
    private Integer diasCredito;
    @Size(max = 160)
    @Column(name = "instrucao")
    private String instrucao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "percentualJuros")
    private BigDecimal percentualJuros;
    @Column(name = "percentualMulta")
    private BigDecimal percentualMulta;
    @Column(name = "diasProtesto")
    private Integer diasProtesto;
    @Size(max = 20)
    @Column(name = "codigoCedente")
    private String codigoCedente;
    @Size(max = 4)
    @Column(name = "codigoAgenciaCedente")
    private String codigoAgenciaCedente;
    @Size(max = 8)
    @Column(name = "codigoContaMovimentoCedente")
    private String codigoContaMovimentoCedente;
    @Size(max = 8)
    @Column(name = "codigoContaCobrancaCedente")
    private String codigoContaCobrancaCedente;
    @Column(name = "nossoNumeroInicio")
    private Integer nossoNumeroInicio;
    @Column(name = "nossoNumeroFim")
    private Integer nossoNumeroFim;
    @Column(name = "nossoNumeroUltimo")
    private Integer nossoNumeroUltimo;
    @Size(max = 45)
    @Column(name = "indicadorFluxoCaixa")
    private String indicadorFluxoCaixa;
    @Column(name = "tipoGeracaoBoleto")
    private Character tipoGeracaoBoleto;
    @JoinColumn(name = "idContaCorrente", referencedColumnName = "idContaCorrente")
    @ManyToOne(optional = false)
    private ContaCorrente idContaCorrente;
    @JoinColumn(name = "idEspecieDocumento", referencedColumnName = "idEspecieDocumento")
    @ManyToOne(optional = false)
    private EspecieDocumento idEspecieDocumento;

    public TipoCobranca() {
    }

    public TipoCobranca(Integer idtipoCobranca) {
        this.idtipoCobranca = idtipoCobranca;
    }

    public Integer getIdtipoCobranca() {
        return idtipoCobranca;
    }

    public void setIdtipoCobranca(Integer idtipoCobranca) {
        this.idtipoCobranca = idtipoCobranca;
    }

    public String getCodigoCarteira() {
        return codigoCarteira;
    }

    public void setCodigoCarteira(String codigoCarteira) {
        this.codigoCarteira = codigoCarteira;
    }

    public String getDescricaoTipoCobranca() {
        return descricaoTipoCobranca;
    }

    public void setDescricaoTipoCobranca(String descricaoTipoCobranca) {
        this.descricaoTipoCobranca = descricaoTipoCobranca;
    }

    public Boolean getRegistraFluxoCaixa() {
        return registraFluxoCaixa;
    }

    public void setRegistraFluxoCaixa(Boolean registraFluxoCaixa) {
        this.registraFluxoCaixa = registraFluxoCaixa;
    }

    public Integer getDiasCredito() {
        return diasCredito;
    }

    public void setDiasCredito(Integer diasCredito) {
        this.diasCredito = diasCredito;
    }

    public String getInstrucao() {
        return instrucao;
    }

    public void setInstrucao(String instrucao) {
        this.instrucao = instrucao;
    }

    public BigDecimal getPercentualJuros() {
        return percentualJuros;
    }

    public void setPercentualJuros(BigDecimal percentualJuros) {
        this.percentualJuros = percentualJuros;
    }

    public BigDecimal getPercentualMulta() {
        return percentualMulta;
    }

    public void setPercentualMulta(BigDecimal percentualMulta) {
        this.percentualMulta = percentualMulta;
    }

    public Integer getDiasProtesto() {
        return diasProtesto;
    }

    public void setDiasProtesto(Integer diasProtesto) {
        this.diasProtesto = diasProtesto;
    }

    public String getCodigoCedente() {
        return codigoCedente;
    }

    public void setCodigoCedente(String codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public String getCodigoAgenciaCedente() {
        return codigoAgenciaCedente;
    }

    public void setCodigoAgenciaCedente(String codigoAgenciaCedente) {
        this.codigoAgenciaCedente = codigoAgenciaCedente;
    }

    public String getCodigoContaMovimentoCedente() {
        return codigoContaMovimentoCedente;
    }

    public void setCodigoContaMovimentoCedente(String codigoContaMovimentoCedente) {
        this.codigoContaMovimentoCedente = codigoContaMovimentoCedente;
    }

    public String getCodigoContaCobrancaCedente() {
        return codigoContaCobrancaCedente;
    }

    public void setCodigoContaCobrancaCedente(String codigoContaCobrancaCedente) {
        this.codigoContaCobrancaCedente = codigoContaCobrancaCedente;
    }

    public Integer getNossoNumeroInicio() {
        return nossoNumeroInicio;
    }

    public void setNossoNumeroInicio(Integer nossoNumeroInicio) {
        this.nossoNumeroInicio = nossoNumeroInicio;
    }

    public Integer getNossoNumeroFim() {
        return nossoNumeroFim;
    }

    public void setNossoNumeroFim(Integer nossoNumeroFim) {
        this.nossoNumeroFim = nossoNumeroFim;
    }

    public Integer getNossoNumeroUltimo() {
        return nossoNumeroUltimo;
    }

    public void setNossoNumeroUltimo(Integer nossoNumeroUltimo) {
        this.nossoNumeroUltimo = nossoNumeroUltimo;
    }

    public String getIndicadorFluxoCaixa() {
        return indicadorFluxoCaixa;
    }

    public void setIndicadorFluxoCaixa(String indicadorFluxoCaixa) {
        this.indicadorFluxoCaixa = indicadorFluxoCaixa;
    }

    public Character getTipoGeracaoBoleto() {
        return tipoGeracaoBoleto;
    }

    public void setTipoGeracaoBoleto(Character tipoGeracaoBoleto) {
        this.tipoGeracaoBoleto = tipoGeracaoBoleto;
    }

    public ContaCorrente getIdContaCorrente() {
        return idContaCorrente;
    }

    public void setIdContaCorrente(ContaCorrente idContaCorrente) {
        this.idContaCorrente = idContaCorrente;
    }

    public EspecieDocumento getIdEspecieDocumento() {
        return idEspecieDocumento;
    }

    public void setIdEspecieDocumento(EspecieDocumento idEspecieDocumento) {
        this.idEspecieDocumento = idEspecieDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoCobranca != null ? idtipoCobranca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCobranca)) {
            return false;
        }
        TipoCobranca other = (TipoCobranca) object;
        if ((this.idtipoCobranca == null && other.idtipoCobranca != null) || (this.idtipoCobranca != null && !this.idtipoCobranca.equals(other.idtipoCobranca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.exception.TipoCobranca[ idtipoCobranca=" + idtipoCobranca + " ]";
    }
    
}

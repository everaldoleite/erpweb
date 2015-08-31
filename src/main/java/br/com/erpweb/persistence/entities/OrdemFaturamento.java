/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.persistence.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author everaldo
 */
@Entity
@Table(name = "ORDEM_FATURAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdemFaturamento.findAll", query = "SELECT o FROM OrdemFaturamento o"),
    @NamedQuery(name = "OrdemFaturamento.findByIdOrdemFaturamento", query = "SELECT o FROM OrdemFaturamento o WHERE o.idOrdemFaturamento = :idOrdemFaturamento"),
    @NamedQuery(name = "OrdemFaturamento.findByIdPedidoVenda", query = "SELECT o FROM OrdemFaturamento o WHERE o.idPedidoVenda = :idPedidoVenda"),
    @NamedQuery(name = "OrdemFaturamento.findByDataAberturaOrdemFaturamento", query = "SELECT o FROM OrdemFaturamento o WHERE o.dataAberturaOrdemFaturamento = :dataAberturaOrdemFaturamento"),
    @NamedQuery(name = "OrdemFaturamento.findByPesoBrutoTotal", query = "SELECT o FROM OrdemFaturamento o WHERE o.pesoBrutoTotal = :pesoBrutoTotal"),
    @NamedQuery(name = "OrdemFaturamento.findByPesoLiquidoTotal", query = "SELECT o FROM OrdemFaturamento o WHERE o.pesoLiquidoTotal = :pesoLiquidoTotal"),
    @NamedQuery(name = "OrdemFaturamento.findByDataExpedicao", query = "SELECT o FROM OrdemFaturamento o WHERE o.dataExpedicao = :dataExpedicao"),
    @NamedQuery(name = "OrdemFaturamento.findByCodigoRastreio", query = "SELECT o FROM OrdemFaturamento o WHERE o.codigoRastreio = :codigoRastreio"),
    @NamedQuery(name = "OrdemFaturamento.findByObservacaoSeparador", query = "SELECT o FROM OrdemFaturamento o WHERE o.observacaoSeparador = :observacaoSeparador"),
    @NamedQuery(name = "OrdemFaturamento.findByCentroResultado", query = "SELECT o FROM OrdemFaturamento o WHERE o.centroResultado = :centroResultado"),
    @NamedQuery(name = "OrdemFaturamento.findByContaResultado", query = "SELECT o FROM OrdemFaturamento o WHERE o.contaResultado = :contaResultado"),
    @NamedQuery(name = "OrdemFaturamento.findByVolumeTotal", query = "SELECT o FROM OrdemFaturamento o WHERE o.volumeTotal = :volumeTotal"),
    @NamedQuery(name = "OrdemFaturamento.findByGeracaoNotaFiscal", query = "SELECT o FROM OrdemFaturamento o WHERE o.geracaoNotaFiscal = :geracaoNotaFiscal"),
    @NamedQuery(name = "OrdemFaturamento.findByNumeroNota", query = "SELECT o FROM OrdemFaturamento o WHERE o.numeroNota = :numeroNota"),
    @NamedQuery(name = "OrdemFaturamento.findByDataEmissaoNotaFiscal", query = "SELECT o FROM OrdemFaturamento o WHERE o.dataEmissaoNotaFiscal = :dataEmissaoNotaFiscal")})
public class OrdemFaturamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idOrdemFaturamento")
    private Integer idOrdemFaturamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPedidoVenda")
    private int idPedidoVenda;
    @Column(name = "dataAberturaOrdemFaturamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAberturaOrdemFaturamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pesoBrutoTotal")
    private Double pesoBrutoTotal;
    @Column(name = "pesoLiquidoTotal")
    private Double pesoLiquidoTotal;
    @Column(name = "dataExpedicao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataExpedicao;
    @Size(max = 45)
    @Column(name = "codigoRastreio")
    private String codigoRastreio;
    @Size(max = 45)
    @Column(name = "observacaoSeparador")
    private String observacaoSeparador;
    @Size(max = 45)
    @Column(name = "centroResultado")
    private String centroResultado;
    @Size(max = 45)
    @Column(name = "contaResultado")
    private String contaResultado;
    @Column(name = "volumeTotal")
    private Integer volumeTotal;
    @Column(name = "geracaoNotaFiscal")
    private Character geracaoNotaFiscal;
    @Size(max = 45)
    @Column(name = "numeroNota")
    private String numeroNota;
    @Column(name = "dataEmissaoNotaFiscal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEmissaoNotaFiscal;
    @JoinColumn(name = "idEmpresaEmitente", referencedColumnName = "idEmpresaEmitente")
    @ManyToOne(optional = false)
    private EmpresaEmitente idEmpresaEmitente;
    @JoinColumn(name = "idStatusOF", referencedColumnName = "idStatusOF")
    @ManyToOne(optional = false)
    private StatusOrdemFaturamento idStatusOF;
    @JoinColumn(name = "idUsuarioAbertura", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuarioAbertura;
    @JoinColumn(name = "idUsuarioExpedicao", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuarioExpedicao;
    @JoinColumn(name = "idUsuarioSeparador", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuarioSeparador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrdemFaturamento")
    private Collection<NotaFiscal> notaFiscalCollection;

    public OrdemFaturamento() {
    }

    public OrdemFaturamento(Integer idOrdemFaturamento) {
        this.idOrdemFaturamento = idOrdemFaturamento;
    }

    public OrdemFaturamento(Integer idOrdemFaturamento, int idPedidoVenda) {
        this.idOrdemFaturamento = idOrdemFaturamento;
        this.idPedidoVenda = idPedidoVenda;
    }

    public Integer getIdOrdemFaturamento() {
        return idOrdemFaturamento;
    }

    public void setIdOrdemFaturamento(Integer idOrdemFaturamento) {
        this.idOrdemFaturamento = idOrdemFaturamento;
    }

    public int getIdPedidoVenda() {
        return idPedidoVenda;
    }

    public void setIdPedidoVenda(int idPedidoVenda) {
        this.idPedidoVenda = idPedidoVenda;
    }

    public Date getDataAberturaOrdemFaturamento() {
        return dataAberturaOrdemFaturamento;
    }

    public void setDataAberturaOrdemFaturamento(Date dataAberturaOrdemFaturamento) {
        this.dataAberturaOrdemFaturamento = dataAberturaOrdemFaturamento;
    }

    public Double getPesoBrutoTotal() {
        return pesoBrutoTotal;
    }

    public void setPesoBrutoTotal(Double pesoBrutoTotal) {
        this.pesoBrutoTotal = pesoBrutoTotal;
    }

    public Double getPesoLiquidoTotal() {
        return pesoLiquidoTotal;
    }

    public void setPesoLiquidoTotal(Double pesoLiquidoTotal) {
        this.pesoLiquidoTotal = pesoLiquidoTotal;
    }

    public Date getDataExpedicao() {
        return dataExpedicao;
    }

    public void setDataExpedicao(Date dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }

    public String getCodigoRastreio() {
        return codigoRastreio;
    }

    public void setCodigoRastreio(String codigoRastreio) {
        this.codigoRastreio = codigoRastreio;
    }

    public String getObservacaoSeparador() {
        return observacaoSeparador;
    }

    public void setObservacaoSeparador(String observacaoSeparador) {
        this.observacaoSeparador = observacaoSeparador;
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

    public Integer getVolumeTotal() {
        return volumeTotal;
    }

    public void setVolumeTotal(Integer volumeTotal) {
        this.volumeTotal = volumeTotal;
    }

    public Character getGeracaoNotaFiscal() {
        return geracaoNotaFiscal;
    }

    public void setGeracaoNotaFiscal(Character geracaoNotaFiscal) {
        this.geracaoNotaFiscal = geracaoNotaFiscal;
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

    public EmpresaEmitente getIdEmpresaEmitente() {
        return idEmpresaEmitente;
    }

    public void setIdEmpresaEmitente(EmpresaEmitente idEmpresaEmitente) {
        this.idEmpresaEmitente = idEmpresaEmitente;
    }

    public StatusOrdemFaturamento getIdStatusOF() {
        return idStatusOF;
    }

    public void setIdStatusOF(StatusOrdemFaturamento idStatusOF) {
        this.idStatusOF = idStatusOF;
    }

    public Usuarios getIdUsuarioAbertura() {
        return idUsuarioAbertura;
    }

    public void setIdUsuarioAbertura(Usuarios idUsuarioAbertura) {
        this.idUsuarioAbertura = idUsuarioAbertura;
    }

    public Usuarios getIdUsuarioExpedicao() {
        return idUsuarioExpedicao;
    }

    public void setIdUsuarioExpedicao(Usuarios idUsuarioExpedicao) {
        this.idUsuarioExpedicao = idUsuarioExpedicao;
    }

    public Usuarios getIdUsuarioSeparador() {
        return idUsuarioSeparador;
    }

    public void setIdUsuarioSeparador(Usuarios idUsuarioSeparador) {
        this.idUsuarioSeparador = idUsuarioSeparador;
    }

    @XmlTransient
    public Collection<NotaFiscal> getNotaFiscalCollection() {
        return notaFiscalCollection;
    }

    public void setNotaFiscalCollection(Collection<NotaFiscal> notaFiscalCollection) {
        this.notaFiscalCollection = notaFiscalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdemFaturamento != null ? idOrdemFaturamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdemFaturamento)) {
            return false;
        }
        OrdemFaturamento other = (OrdemFaturamento) object;
        if ((this.idOrdemFaturamento == null && other.idOrdemFaturamento != null) || (this.idOrdemFaturamento != null && !this.idOrdemFaturamento.equals(other.idOrdemFaturamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.OrdemFaturamento[ idOrdemFaturamento=" + idOrdemFaturamento + " ]";
    }
    
}

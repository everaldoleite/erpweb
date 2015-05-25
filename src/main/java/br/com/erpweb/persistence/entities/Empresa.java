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
@Table(name = "EMPRESA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByCodigo", query = "SELECT e FROM Empresa e WHERE e.codigo = :codigo"),
    @NamedQuery(name = "Empresa.findByRazaoSocial", query = "SELECT e FROM Empresa e WHERE e.razaoSocial = :razaoSocial"),
    @NamedQuery(name = "Empresa.findByNomeFantasia", query = "SELECT e FROM Empresa e WHERE e.nomeFantasia = :nomeFantasia"),
    @NamedQuery(name = "Empresa.findByTipoLogradouro", query = "SELECT e FROM Empresa e WHERE e.tipoLogradouro = :tipoLogradouro"),
    @NamedQuery(name = "Empresa.findByLogradouro", query = "SELECT e FROM Empresa e WHERE e.logradouro = :logradouro"),
    @NamedQuery(name = "Empresa.findByNumero", query = "SELECT e FROM Empresa e WHERE e.numero = :numero"),
    @NamedQuery(name = "Empresa.findByBairro", query = "SELECT e FROM Empresa e WHERE e.bairro = :bairro"),
    @NamedQuery(name = "Empresa.findByCep", query = "SELECT e FROM Empresa e WHERE e.cep = :cep"),
    @NamedQuery(name = "Empresa.findByUf", query = "SELECT e FROM Empresa e WHERE e.uf = :uf"),
    @NamedQuery(name = "Empresa.findByCidade", query = "SELECT e FROM Empresa e WHERE e.cidade = :cidade"),
    @NamedQuery(name = "Empresa.findByDdd", query = "SELECT e FROM Empresa e WHERE e.ddd = :ddd"),
    @NamedQuery(name = "Empresa.findByTelefone", query = "SELECT e FROM Empresa e WHERE e.telefone = :telefone"),
    @NamedQuery(name = "Empresa.findByTipoPessoa", query = "SELECT e FROM Empresa e WHERE e.tipoPessoa = :tipoPessoa"),
    @NamedQuery(name = "Empresa.findByCnpjEmpresa", query = "SELECT e FROM Empresa e WHERE e.cnpjEmpresa = :cnpjEmpresa"),
    @NamedQuery(name = "Empresa.findByCpfEmpresa", query = "SELECT e FROM Empresa e WHERE e.cpfEmpresa = :cpfEmpresa"),
    @NamedQuery(name = "Empresa.findByInscricaoEstadual", query = "SELECT e FROM Empresa e WHERE e.inscricaoEstadual = :inscricaoEstadual"),
    @NamedQuery(name = "Empresa.findByNomeRepresentanteLegal", query = "SELECT e FROM Empresa e WHERE e.nomeRepresentanteLegal = :nomeRepresentanteLegal"),
    @NamedQuery(name = "Empresa.findByDocumentoRepresentanteCPF", query = "SELECT e FROM Empresa e WHERE e.documentoRepresentanteCPF = :documentoRepresentanteCPF"),
    @NamedQuery(name = "Empresa.findByDocumentoRepresentanteRG", query = "SELECT e FROM Empresa e WHERE e.documentoRepresentanteRG = :documentoRepresentanteRG"),
    @NamedQuery(name = "Empresa.findByDataInclusao", query = "SELECT e FROM Empresa e WHERE e.dataInclusao = :dataInclusao"),
    @NamedQuery(name = "Empresa.findByDataAlteracao", query = "SELECT e FROM Empresa e WHERE e.dataAlteracao = :dataAlteracao"),
    @NamedQuery(name = "Empresa.findByCepPagamento", query = "SELECT e FROM Empresa e WHERE e.cepPagamento = :cepPagamento"),
    @NamedQuery(name = "Empresa.findByEstadoPagamento", query = "SELECT e FROM Empresa e WHERE e.estadoPagamento = :estadoPagamento"),
    @NamedQuery(name = "Empresa.findByTipoLogradouroPagamento", query = "SELECT e FROM Empresa e WHERE e.tipoLogradouroPagamento = :tipoLogradouroPagamento"),
    @NamedQuery(name = "Empresa.findByLogradouroPagamento", query = "SELECT e FROM Empresa e WHERE e.logradouroPagamento = :logradouroPagamento"),
    @NamedQuery(name = "Empresa.findByNumeroPagamento", query = "SELECT e FROM Empresa e WHERE e.numeroPagamento = :numeroPagamento"),
    @NamedQuery(name = "Empresa.findByCidadePagamento", query = "SELECT e FROM Empresa e WHERE e.cidadePagamento = :cidadePagamento"),
    @NamedQuery(name = "Empresa.findByCepEntrega", query = "SELECT e FROM Empresa e WHERE e.cepEntrega = :cepEntrega"),
    @NamedQuery(name = "Empresa.findByRazaoSocialEntrega", query = "SELECT e FROM Empresa e WHERE e.razaoSocialEntrega = :razaoSocialEntrega"),
    @NamedQuery(name = "Empresa.findByInscricaoEstadualEntrega", query = "SELECT e FROM Empresa e WHERE e.inscricaoEstadualEntrega = :inscricaoEstadualEntrega"),
    @NamedQuery(name = "Empresa.findByEstadoEntrega", query = "SELECT e FROM Empresa e WHERE e.estadoEntrega = :estadoEntrega"),
    @NamedQuery(name = "Empresa.findByCidadeEntrega", query = "SELECT e FROM Empresa e WHERE e.cidadeEntrega = :cidadeEntrega"),
    @NamedQuery(name = "Empresa.findByDocumentoEntrega", query = "SELECT e FROM Empresa e WHERE e.documentoEntrega = :documentoEntrega"),
    @NamedQuery(name = "Empresa.findByDataFollowUp", query = "SELECT e FROM Empresa e WHERE e.dataFollowUp = :dataFollowUp"),
    @NamedQuery(name = "Empresa.findByCapitalSocial", query = "SELECT e FROM Empresa e WHERE e.capitalSocial = :capitalSocial"),
    @NamedQuery(name = "Empresa.findByNumeroEmpregados", query = "SELECT e FROM Empresa e WHERE e.numeroEmpregados = :numeroEmpregados"),
    @NamedQuery(name = "Empresa.findByHomepage", query = "SELECT e FROM Empresa e WHERE e.homepage = :homepage"),
    @NamedQuery(name = "Empresa.findByEmailComercial", query = "SELECT e FROM Empresa e WHERE e.emailComercial = :emailComercial"),
    @NamedQuery(name = "Empresa.findByEmailAtendimento", query = "SELECT e FROM Empresa e WHERE e.emailAtendimento = :emailAtendimento"),
    @NamedQuery(name = "Empresa.findByInscricaoMunicipal", query = "SELECT e FROM Empresa e WHERE e.inscricaoMunicipal = :inscricaoMunicipal"),
    @NamedQuery(name = "Empresa.findByNaturezaOperacao", query = "SELECT e FROM Empresa e WHERE e.naturezaOperacao = :naturezaOperacao"),
    @NamedQuery(name = "Empresa.findByBloqueioEmpresa", query = "SELECT e FROM Empresa e WHERE e.bloqueioEmpresa = :bloqueioEmpresa"),
    @NamedQuery(name = "Empresa.findByMotivoBloqueio", query = "SELECT e FROM Empresa e WHERE e.motivoBloqueio = :motivoBloqueio"),
    @NamedQuery(name = "Empresa.findByUsuarioBloqueio", query = "SELECT e FROM Empresa e WHERE e.usuarioBloqueio = :usuarioBloqueio"),
    @NamedQuery(name = "Empresa.findByDataBloqueio", query = "SELECT e FROM Empresa e WHERE e.dataBloqueio = :dataBloqueio"),
    @NamedQuery(name = "Empresa.findByBloqueioAtendimento", query = "SELECT e FROM Empresa e WHERE e.bloqueioAtendimento = :bloqueioAtendimento"),
    @NamedQuery(name = "Empresa.findByBloqueioVendas", query = "SELECT e FROM Empresa e WHERE e.bloqueioVendas = :bloqueioVendas"),
    @NamedQuery(name = "Empresa.findByBloqueioFaturamento", query = "SELECT e FROM Empresa e WHERE e.bloqueioFaturamento = :bloqueioFaturamento"),
    @NamedQuery(name = "Empresa.findByBloqueioComercial", query = "SELECT e FROM Empresa e WHERE e.bloqueioComercial = :bloqueioComercial"),
    @NamedQuery(name = "Empresa.findByBloqueioTotal", query = "SELECT e FROM Empresa e WHERE e.bloqueioTotal = :bloqueioTotal"),
    @NamedQuery(name = "Empresa.findByBanco", query = "SELECT e FROM Empresa e WHERE e.banco = :banco"),
    @NamedQuery(name = "Empresa.findByAgencia", query = "SELECT e FROM Empresa e WHERE e.agencia = :agencia"),
    @NamedQuery(name = "Empresa.findByContaCorrente", query = "SELECT e FROM Empresa e WHERE e.contaCorrente = :contaCorrente"),
    @NamedQuery(name = "Empresa.findByTransportePreferencial", query = "SELECT e FROM Empresa e WHERE e.transportePreferencial = :transportePreferencial"),
    @NamedQuery(name = "Empresa.findByStatusEmpresa", query = "SELECT e FROM Empresa e WHERE e.statusEmpresa = :statusEmpresa"),
    @NamedQuery(name = "Empresa.findByRevendedor", query = "SELECT e FROM Empresa e WHERE e.revendedor = :revendedor"),
    @NamedQuery(name = "Empresa.findByDataReserva", query = "SELECT e FROM Empresa e WHERE e.dataReserva = :dataReserva"),
    @NamedQuery(name = "Empresa.findByCodigoVendedorFidelidade", query = "SELECT e FROM Empresa e WHERE e.codigoVendedorFidelidade = :codigoVendedorFidelidade"),
    @NamedQuery(name = "Empresa.findByLimiteCredito", query = "SELECT e FROM Empresa e WHERE e.limiteCredito = :limiteCredito"),
    @NamedQuery(name = "Empresa.findByCodigoPagamento", query = "SELECT e FROM Empresa e WHERE e.codigoPagamento = :codigoPagamento"),
    @NamedQuery(name = "Empresa.findByDataInicialLimiteCredito", query = "SELECT e FROM Empresa e WHERE e.dataInicialLimiteCredito = :dataInicialLimiteCredito"),
    @NamedQuery(name = "Empresa.findByDataFinalLimiteCredito", query = "SELECT e FROM Empresa e WHERE e.dataFinalLimiteCredito = :dataFinalLimiteCredito"),
    @NamedQuery(name = "Empresa.findByDataAvaliacaoLimiteCredito", query = "SELECT e FROM Empresa e WHERE e.dataAvaliacaoLimiteCredito = :dataAvaliacaoLimiteCredito"),
    @NamedQuery(name = "Empresa.findByResponsavelLimiteCredito", query = "SELECT e FROM Empresa e WHERE e.responsavelLimiteCredito = :responsavelLimiteCredito"),
    @NamedQuery(name = "Empresa.findByObservacaoLimiteCredito", query = "SELECT e FROM Empresa e WHERE e.observacaoLimiteCredito = :observacaoLimiteCredito"),
    @NamedQuery(name = "Empresa.findByTipoLimiteCredito", query = "SELECT e FROM Empresa e WHERE e.tipoLimiteCredito = :tipoLimiteCredito"),
    @NamedQuery(name = "Empresa.findByAceitaCobranca", query = "SELECT e FROM Empresa e WHERE e.aceitaCobranca = :aceitaCobranca"),
    @NamedQuery(name = "Empresa.findByTipoEmpresaSubstituto", query = "SELECT e FROM Empresa e WHERE e.tipoEmpresaSubstituto = :tipoEmpresaSubstituto"),
    @NamedQuery(name = "Empresa.findByBairroEntrega", query = "SELECT e FROM Empresa e WHERE e.bairroEntrega = :bairroEntrega"),
    @NamedQuery(name = "Empresa.findByEmailNotaMunicipal", query = "SELECT e FROM Empresa e WHERE e.emailNotaMunicipal = :emailNotaMunicipal"),
    @NamedQuery(name = "Empresa.findByEmailNotaFederal", query = "SELECT e FROM Empresa e WHERE e.emailNotaFederal = :emailNotaFederal"),
    @NamedQuery(name = "Empresa.findByUltimoFaturamento", query = "SELECT e FROM Empresa e WHERE e.ultimoFaturamento = :ultimoFaturamento"),
    @NamedQuery(name = "Empresa.findByDataUltimoFaturamento", query = "SELECT e FROM Empresa e WHERE e.dataUltimoFaturamento = :dataUltimoFaturamento"),
    @NamedQuery(name = "Empresa.findByPasta", query = "SELECT e FROM Empresa e WHERE e.pasta = :pasta"),
    @NamedQuery(name = "Empresa.findByCodigoInterno", query = "SELECT e FROM Empresa e WHERE e.codigoInterno = :codigoInterno"),
    @NamedQuery(name = "Empresa.findByPerfil", query = "SELECT e FROM Empresa e WHERE e.perfil = :perfil"),
    @NamedQuery(name = "Empresa.findByAtuacao", query = "SELECT e FROM Empresa e WHERE e.atuacao = :atuacao")})
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Size(max = 60)
    @Column(name = "razaoSocial")
    private String razaoSocial;
    @Size(max = 60)
    @Column(name = "nomeFantasia")
    private String nomeFantasia;
    @Size(max = 5)
    @Column(name = "tipoLogradouro")
    private String tipoLogradouro;
    @Size(max = 60)
    @Column(name = "logradouro")
    private String logradouro;
    @Size(max = 5)
    @Column(name = "numero")
    private String numero;
    @Size(max = 30)
    @Column(name = "bairro")
    private String bairro;
    @Size(max = 8)
    @Column(name = "cep")
    private String cep;
    @Size(max = 2)
    @Column(name = "uf")
    private String uf;
    @Size(max = 30)
    @Column(name = "cidade")
    private String cidade;
    @Size(max = 4)
    @Column(name = "ddd")
    private String ddd;
    @Size(max = 20)
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "tipoPessoa")
    private Character tipoPessoa;
    @Size(max = 18)
    @Column(name = "cnpjEmpresa")
    private String cnpjEmpresa;
    @Size(max = 11)
    @Column(name = "cpfEmpresa")
    private String cpfEmpresa;
    @Size(max = 18)
    @Column(name = "inscricaoEstadual")
    private String inscricaoEstadual;
    @Size(max = 45)
    @Column(name = "nomeRepresentanteLegal")
    private String nomeRepresentanteLegal;
    @Size(max = 12)
    @Column(name = "documentoRepresentanteCPF")
    private String documentoRepresentanteCPF;
    @Size(max = 14)
    @Column(name = "documentoRepresentanteRG")
    private String documentoRepresentanteRG;
    @Column(name = "dataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @Column(name = "dataAlteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAlteracao;
    @Size(max = 9)
    @Column(name = "cepPagamento")
    private String cepPagamento;
    @Size(max = 2)
    @Column(name = "estadoPagamento")
    private String estadoPagamento;
    @Size(max = 5)
    @Column(name = "tipoLogradouroPagamento")
    private String tipoLogradouroPagamento;
    @Size(max = 60)
    @Column(name = "logradouroPagamento")
    private String logradouroPagamento;
    @Size(max = 3)
    @Column(name = "numeroPagamento")
    private String numeroPagamento;
    @Size(max = 30)
    @Column(name = "cidadePagamento")
    private String cidadePagamento;
    @Size(max = 9)
    @Column(name = "cepEntrega")
    private String cepEntrega;
    @Size(max = 60)
    @Column(name = "razaoSocialEntrega")
    private String razaoSocialEntrega;
    @Size(max = 18)
    @Column(name = "inscricaoEstadualEntrega")
    private String inscricaoEstadualEntrega;
    @Size(max = 2)
    @Column(name = "estadoEntrega")
    private String estadoEntrega;
    @Size(max = 30)
    @Column(name = "cidadeEntrega")
    private String cidadeEntrega;
    @Size(max = 18)
    @Column(name = "documentoEntrega")
    private String documentoEntrega;
    @Column(name = "dataFollowUp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFollowUp;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "capitalSocial")
    private BigDecimal capitalSocial;
    @Column(name = "numeroEmpregados")
    private Integer numeroEmpregados;
    @Size(max = 45)
    @Column(name = "homepage")
    private String homepage;
    @Size(max = 45)
    @Column(name = "emailComercial")
    private String emailComercial;
    @Size(max = 45)
    @Column(name = "emailAtendimento")
    private String emailAtendimento;
    @Size(max = 45)
    @Column(name = "inscricaoMunicipal")
    private String inscricaoMunicipal;
    @Size(max = 45)
    @Column(name = "naturezaOperacao")
    private String naturezaOperacao;
    @Column(name = "bloqueioEmpresa")
    private Character bloqueioEmpresa;
    @Size(max = 45)
    @Column(name = "motivoBloqueio")
    private String motivoBloqueio;
    @Size(max = 45)
    @Column(name = "usuarioBloqueio")
    private String usuarioBloqueio;
    @Column(name = "dataBloqueio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataBloqueio;
    @Column(name = "bloqueioAtendimento")
    private Character bloqueioAtendimento;
    @Column(name = "bloqueioVendas")
    private Character bloqueioVendas;
    @Column(name = "bloqueioFaturamento")
    private Character bloqueioFaturamento;
    @Column(name = "bloqueioComercial")
    private Character bloqueioComercial;
    @Column(name = "bloqueioTotal")
    private Character bloqueioTotal;
    @Size(max = 3)
    @Column(name = "banco")
    private String banco;
    @Size(max = 4)
    @Column(name = "agencia")
    private String agencia;
    @Size(max = 5)
    @Column(name = "contaCorrente")
    private String contaCorrente;
    @Column(name = "transportePreferencial")
    private Character transportePreferencial;
    @Column(name = "statusEmpresa")
    private Character statusEmpresa;
    @Column(name = "revendedor")
    private Character revendedor;
    @Column(name = "dataReserva")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataReserva;
    @Size(max = 4)
    @Column(name = "codigoVendedorFidelidade")
    private String codigoVendedorFidelidade;
    @Column(name = "limiteCredito")
    private BigDecimal limiteCredito;
    @Size(max = 3)
    @Column(name = "codigoPagamento")
    private String codigoPagamento;
    @Column(name = "dataInicialLimiteCredito")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicialLimiteCredito;
    @Column(name = "dataFinalLimiteCredito")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFinalLimiteCredito;
    @Column(name = "dataAvaliacaoLimiteCredito")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAvaliacaoLimiteCredito;
    @Size(max = 3)
    @Column(name = "responsavelLimiteCredito")
    private String responsavelLimiteCredito;
    @Size(max = 45)
    @Column(name = "observacaoLimiteCredito")
    private String observacaoLimiteCredito;
    @Size(max = 3)
    @Column(name = "tipoLimiteCredito")
    private String tipoLimiteCredito;
    @Column(name = "aceitaCobranca")
    private Character aceitaCobranca;
    @Size(max = 5)
    @Column(name = "tipoEmpresaSubstituto")
    private String tipoEmpresaSubstituto;
    @Size(max = 45)
    @Column(name = "bairroEntrega")
    private String bairroEntrega;
    @Size(max = 45)
    @Column(name = "emailNotaMunicipal")
    private String emailNotaMunicipal;
    @Size(max = 45)
    @Column(name = "emailNotaFederal")
    private String emailNotaFederal;
    @Column(name = "ultimoFaturamento")
    private BigDecimal ultimoFaturamento;
    @Column(name = "dataUltimoFaturamento")
    private BigDecimal dataUltimoFaturamento;
    @Size(max = 45)
    @Column(name = "pasta")
    private String pasta;
    @Size(max = 45)
    @Column(name = "codigoInterno")
    private String codigoInterno;
    @Size(max = 45)
    @Column(name = "perfil")
    private String perfil;
    @Size(max = 45)
    @Column(name = "atuacao")
    private String atuacao;
    @JoinColumn(name = "idTRANSPORTADOR", referencedColumnName = "idTRANSPORTADOR")
    @ManyToOne(optional = false)
    private Transportador idTRANSPORTADOR;
    @JoinColumn(name = "idSEGMENTO", referencedColumnName = "idSEGMENTO")
    @ManyToOne(optional = false)
    private Segmento idSEGMENTO;

    public Empresa() {
    }

    public Empresa(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Character getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(Character tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getCnpjEmpresa() {
        return cnpjEmpresa;
    }

    public void setCnpjEmpresa(String cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
    }

    public String getCpfEmpresa() {
        return cpfEmpresa;
    }

    public void setCpfEmpresa(String cpfEmpresa) {
        this.cpfEmpresa = cpfEmpresa;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getNomeRepresentanteLegal() {
        return nomeRepresentanteLegal;
    }

    public void setNomeRepresentanteLegal(String nomeRepresentanteLegal) {
        this.nomeRepresentanteLegal = nomeRepresentanteLegal;
    }

    public String getDocumentoRepresentanteCPF() {
        return documentoRepresentanteCPF;
    }

    public void setDocumentoRepresentanteCPF(String documentoRepresentanteCPF) {
        this.documentoRepresentanteCPF = documentoRepresentanteCPF;
    }

    public String getDocumentoRepresentanteRG() {
        return documentoRepresentanteRG;
    }

    public void setDocumentoRepresentanteRG(String documentoRepresentanteRG) {
        this.documentoRepresentanteRG = documentoRepresentanteRG;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public String getCepPagamento() {
        return cepPagamento;
    }

    public void setCepPagamento(String cepPagamento) {
        this.cepPagamento = cepPagamento;
    }

    public String getEstadoPagamento() {
        return estadoPagamento;
    }

    public void setEstadoPagamento(String estadoPagamento) {
        this.estadoPagamento = estadoPagamento;
    }

    public String getTipoLogradouroPagamento() {
        return tipoLogradouroPagamento;
    }

    public void setTipoLogradouroPagamento(String tipoLogradouroPagamento) {
        this.tipoLogradouroPagamento = tipoLogradouroPagamento;
    }

    public String getLogradouroPagamento() {
        return logradouroPagamento;
    }

    public void setLogradouroPagamento(String logradouroPagamento) {
        this.logradouroPagamento = logradouroPagamento;
    }

    public String getNumeroPagamento() {
        return numeroPagamento;
    }

    public void setNumeroPagamento(String numeroPagamento) {
        this.numeroPagamento = numeroPagamento;
    }

    public String getCidadePagamento() {
        return cidadePagamento;
    }

    public void setCidadePagamento(String cidadePagamento) {
        this.cidadePagamento = cidadePagamento;
    }

    public String getCepEntrega() {
        return cepEntrega;
    }

    public void setCepEntrega(String cepEntrega) {
        this.cepEntrega = cepEntrega;
    }

    public String getRazaoSocialEntrega() {
        return razaoSocialEntrega;
    }

    public void setRazaoSocialEntrega(String razaoSocialEntrega) {
        this.razaoSocialEntrega = razaoSocialEntrega;
    }

    public String getInscricaoEstadualEntrega() {
        return inscricaoEstadualEntrega;
    }

    public void setInscricaoEstadualEntrega(String inscricaoEstadualEntrega) {
        this.inscricaoEstadualEntrega = inscricaoEstadualEntrega;
    }

    public String getEstadoEntrega() {
        return estadoEntrega;
    }

    public void setEstadoEntrega(String estadoEntrega) {
        this.estadoEntrega = estadoEntrega;
    }

    public String getCidadeEntrega() {
        return cidadeEntrega;
    }

    public void setCidadeEntrega(String cidadeEntrega) {
        this.cidadeEntrega = cidadeEntrega;
    }

    public String getDocumentoEntrega() {
        return documentoEntrega;
    }

    public void setDocumentoEntrega(String documentoEntrega) {
        this.documentoEntrega = documentoEntrega;
    }

    public Date getDataFollowUp() {
        return dataFollowUp;
    }

    public void setDataFollowUp(Date dataFollowUp) {
        this.dataFollowUp = dataFollowUp;
    }

    public BigDecimal getCapitalSocial() {
        return capitalSocial;
    }

    public void setCapitalSocial(BigDecimal capitalSocial) {
        this.capitalSocial = capitalSocial;
    }

    public Integer getNumeroEmpregados() {
        return numeroEmpregados;
    }

    public void setNumeroEmpregados(Integer numeroEmpregados) {
        this.numeroEmpregados = numeroEmpregados;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getEmailComercial() {
        return emailComercial;
    }

    public void setEmailComercial(String emailComercial) {
        this.emailComercial = emailComercial;
    }

    public String getEmailAtendimento() {
        return emailAtendimento;
    }

    public void setEmailAtendimento(String emailAtendimento) {
        this.emailAtendimento = emailAtendimento;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public String getNaturezaOperacao() {
        return naturezaOperacao;
    }

    public void setNaturezaOperacao(String naturezaOperacao) {
        this.naturezaOperacao = naturezaOperacao;
    }

    public Character getBloqueioEmpresa() {
        return bloqueioEmpresa;
    }

    public void setBloqueioEmpresa(Character bloqueioEmpresa) {
        this.bloqueioEmpresa = bloqueioEmpresa;
    }

    public String getMotivoBloqueio() {
        return motivoBloqueio;
    }

    public void setMotivoBloqueio(String motivoBloqueio) {
        this.motivoBloqueio = motivoBloqueio;
    }

    public String getUsuarioBloqueio() {
        return usuarioBloqueio;
    }

    public void setUsuarioBloqueio(String usuarioBloqueio) {
        this.usuarioBloqueio = usuarioBloqueio;
    }

    public Date getDataBloqueio() {
        return dataBloqueio;
    }

    public void setDataBloqueio(Date dataBloqueio) {
        this.dataBloqueio = dataBloqueio;
    }

    public Character getBloqueioAtendimento() {
        return bloqueioAtendimento;
    }

    public void setBloqueioAtendimento(Character bloqueioAtendimento) {
        this.bloqueioAtendimento = bloqueioAtendimento;
    }

    public Character getBloqueioVendas() {
        return bloqueioVendas;
    }

    public void setBloqueioVendas(Character bloqueioVendas) {
        this.bloqueioVendas = bloqueioVendas;
    }

    public Character getBloqueioFaturamento() {
        return bloqueioFaturamento;
    }

    public void setBloqueioFaturamento(Character bloqueioFaturamento) {
        this.bloqueioFaturamento = bloqueioFaturamento;
    }

    public Character getBloqueioComercial() {
        return bloqueioComercial;
    }

    public void setBloqueioComercial(Character bloqueioComercial) {
        this.bloqueioComercial = bloqueioComercial;
    }

    public Character getBloqueioTotal() {
        return bloqueioTotal;
    }

    public void setBloqueioTotal(Character bloqueioTotal) {
        this.bloqueioTotal = bloqueioTotal;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(String contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public Character getTransportePreferencial() {
        return transportePreferencial;
    }

    public void setTransportePreferencial(Character transportePreferencial) {
        this.transportePreferencial = transportePreferencial;
    }

    public Character getStatusEmpresa() {
        return statusEmpresa;
    }

    public void setStatusEmpresa(Character statusEmpresa) {
        this.statusEmpresa = statusEmpresa;
    }

    public Character getRevendedor() {
        return revendedor;
    }

    public void setRevendedor(Character revendedor) {
        this.revendedor = revendedor;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public String getCodigoVendedorFidelidade() {
        return codigoVendedorFidelidade;
    }

    public void setCodigoVendedorFidelidade(String codigoVendedorFidelidade) {
        this.codigoVendedorFidelidade = codigoVendedorFidelidade;
    }

    public BigDecimal getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(BigDecimal limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public String getCodigoPagamento() {
        return codigoPagamento;
    }

    public void setCodigoPagamento(String codigoPagamento) {
        this.codigoPagamento = codigoPagamento;
    }

    public Date getDataInicialLimiteCredito() {
        return dataInicialLimiteCredito;
    }

    public void setDataInicialLimiteCredito(Date dataInicialLimiteCredito) {
        this.dataInicialLimiteCredito = dataInicialLimiteCredito;
    }

    public Date getDataFinalLimiteCredito() {
        return dataFinalLimiteCredito;
    }

    public void setDataFinalLimiteCredito(Date dataFinalLimiteCredito) {
        this.dataFinalLimiteCredito = dataFinalLimiteCredito;
    }

    public Date getDataAvaliacaoLimiteCredito() {
        return dataAvaliacaoLimiteCredito;
    }

    public void setDataAvaliacaoLimiteCredito(Date dataAvaliacaoLimiteCredito) {
        this.dataAvaliacaoLimiteCredito = dataAvaliacaoLimiteCredito;
    }

    public String getResponsavelLimiteCredito() {
        return responsavelLimiteCredito;
    }

    public void setResponsavelLimiteCredito(String responsavelLimiteCredito) {
        this.responsavelLimiteCredito = responsavelLimiteCredito;
    }

    public String getObservacaoLimiteCredito() {
        return observacaoLimiteCredito;
    }

    public void setObservacaoLimiteCredito(String observacaoLimiteCredito) {
        this.observacaoLimiteCredito = observacaoLimiteCredito;
    }

    public String getTipoLimiteCredito() {
        return tipoLimiteCredito;
    }

    public void setTipoLimiteCredito(String tipoLimiteCredito) {
        this.tipoLimiteCredito = tipoLimiteCredito;
    }

    public Character getAceitaCobranca() {
        return aceitaCobranca;
    }

    public void setAceitaCobranca(Character aceitaCobranca) {
        this.aceitaCobranca = aceitaCobranca;
    }

    public String getTipoEmpresaSubstituto() {
        return tipoEmpresaSubstituto;
    }

    public void setTipoEmpresaSubstituto(String tipoEmpresaSubstituto) {
        this.tipoEmpresaSubstituto = tipoEmpresaSubstituto;
    }

    public String getBairroEntrega() {
        return bairroEntrega;
    }

    public void setBairroEntrega(String bairroEntrega) {
        this.bairroEntrega = bairroEntrega;
    }

    public String getEmailNotaMunicipal() {
        return emailNotaMunicipal;
    }

    public void setEmailNotaMunicipal(String emailNotaMunicipal) {
        this.emailNotaMunicipal = emailNotaMunicipal;
    }

    public String getEmailNotaFederal() {
        return emailNotaFederal;
    }

    public void setEmailNotaFederal(String emailNotaFederal) {
        this.emailNotaFederal = emailNotaFederal;
    }

    public BigDecimal getUltimoFaturamento() {
        return ultimoFaturamento;
    }

    public void setUltimoFaturamento(BigDecimal ultimoFaturamento) {
        this.ultimoFaturamento = ultimoFaturamento;
    }

    public BigDecimal getDataUltimoFaturamento() {
        return dataUltimoFaturamento;
    }

    public void setDataUltimoFaturamento(BigDecimal dataUltimoFaturamento) {
        this.dataUltimoFaturamento = dataUltimoFaturamento;
    }

    public String getPasta() {
        return pasta;
    }

    public void setPasta(String pasta) {
        this.pasta = pasta;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getAtuacao() {
        return atuacao;
    }

    public void setAtuacao(String atuacao) {
        this.atuacao = atuacao;
    }

    public Transportador getIdTRANSPORTADOR() {
        return idTRANSPORTADOR;
    }

    public void setIdTRANSPORTADOR(Transportador idTRANSPORTADOR) {
        this.idTRANSPORTADOR = idTRANSPORTADOR;
    }

    public Segmento getIdSEGMENTO() {
        return idSEGMENTO;
    }

    public void setIdSEGMENTO(Segmento idSEGMENTO) {
        this.idSEGMENTO = idSEGMENTO;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.Empresa[ codigo=" + codigo + " ]";
    }
    
}

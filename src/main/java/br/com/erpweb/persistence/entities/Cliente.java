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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author everaldo
 */
@Entity
@Table(name = "CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Cliente.findByRazaoSocial", query = "SELECT c FROM Cliente c WHERE c.razaoSocial LIKE :razaoSocial"),
    @NamedQuery(name = "Cliente.findByNomeFantasia", query = "SELECT c FROM Cliente c WHERE c.nomeFantasia = :nomeFantasia"),
    @NamedQuery(name = "Cliente.findByDdd", query = "SELECT c FROM Cliente c WHERE c.ddd = :ddd"),
    @NamedQuery(name = "Cliente.findByTelefone", query = "SELECT c FROM Cliente c WHERE c.telefone = :telefone"),
    @NamedQuery(name = "Cliente.findByTipoPessoa", query = "SELECT c FROM Cliente c WHERE c.tipoPessoa = :tipoPessoa"),
    @NamedQuery(name = "Cliente.findByCnpjEmpresa", query = "SELECT c FROM Cliente c WHERE c.cnpjEmpresa = :cnpjEmpresa"),
    @NamedQuery(name = "Cliente.findByCpfEmpresa", query = "SELECT c FROM Cliente c WHERE c.cpfEmpresa = :cpfEmpresa"),
    @NamedQuery(name = "Cliente.findByInscricaoEstadual", query = "SELECT c FROM Cliente c WHERE c.inscricaoEstadual = :inscricaoEstadual"),
    @NamedQuery(name = "Cliente.findByNomeRepresentanteLegal", query = "SELECT c FROM Cliente c WHERE c.nomeRepresentanteLegal = :nomeRepresentanteLegal"),
    @NamedQuery(name = "Cliente.findByDocumentoRepresentanteCPF", query = "SELECT c FROM Cliente c WHERE c.documentoRepresentanteCPF = :documentoRepresentanteCPF"),
    @NamedQuery(name = "Cliente.findByDocumentoRepresentanteRG", query = "SELECT c FROM Cliente c WHERE c.documentoRepresentanteRG = :documentoRepresentanteRG"),
    @NamedQuery(name = "Cliente.findByDataInclusao", query = "SELECT c FROM Cliente c WHERE c.dataInclusao = :dataInclusao"),
    @NamedQuery(name = "Cliente.findByNomeRazaoSocialEntrega", query = "SELECT c FROM Cliente c WHERE c.nomeRazaoSocialEntrega = :nomeRazaoSocialEntrega"),
    @NamedQuery(name = "Cliente.findByInscricaoEstadualEntrega", query = "SELECT c FROM Cliente c WHERE c.inscricaoEstadualEntrega = :inscricaoEstadualEntrega"),
    @NamedQuery(name = "Cliente.findByDocumentoEntregaCNPJ", query = "SELECT c FROM Cliente c WHERE c.documentoEntregaCNPJ = :documentoEntregaCNPJ"),
    @NamedQuery(name = "Cliente.findByDocumentoEntregaCPF", query = "SELECT c FROM Cliente c WHERE c.documentoEntregaCPF = :documentoEntregaCPF"),
    @NamedQuery(name = "Cliente.findByDataFollowUp", query = "SELECT c FROM Cliente c WHERE c.dataFollowUp = :dataFollowUp"),
    @NamedQuery(name = "Cliente.findByCapitalSocial", query = "SELECT c FROM Cliente c WHERE c.capitalSocial = :capitalSocial"),
    @NamedQuery(name = "Cliente.findByNumeroEmpregados", query = "SELECT c FROM Cliente c WHERE c.numeroEmpregados = :numeroEmpregados"),
    @NamedQuery(name = "Cliente.findByHomepage", query = "SELECT c FROM Cliente c WHERE c.homepage = :homepage"),
    @NamedQuery(name = "Cliente.findByEmailComercial", query = "SELECT c FROM Cliente c WHERE c.emailComercial = :emailComercial"),
    @NamedQuery(name = "Cliente.findByEmailAtendimento", query = "SELECT c FROM Cliente c WHERE c.emailAtendimento = :emailAtendimento"),
    @NamedQuery(name = "Cliente.findByInscricaoMunicipal", query = "SELECT c FROM Cliente c WHERE c.inscricaoMunicipal = :inscricaoMunicipal"),
    @NamedQuery(name = "Cliente.findByMotivoBloqueio", query = "SELECT c FROM Cliente c WHERE c.motivoBloqueio = :motivoBloqueio"),
    @NamedQuery(name = "Cliente.findByUsuarioBloqueio", query = "SELECT c FROM Cliente c WHERE c.usuarioBloqueio = :usuarioBloqueio"),
    @NamedQuery(name = "Cliente.findByDataBloqueio", query = "SELECT c FROM Cliente c WHERE c.dataBloqueio = :dataBloqueio"),
    @NamedQuery(name = "Cliente.findByBloqueioAtendimento", query = "SELECT c FROM Cliente c WHERE c.bloqueioAtendimento = :bloqueioAtendimento"),
    @NamedQuery(name = "Cliente.findByBloqueioVendas", query = "SELECT c FROM Cliente c WHERE c.bloqueioVendas = :bloqueioVendas"),
    @NamedQuery(name = "Cliente.findByBloqueioFaturamento", query = "SELECT c FROM Cliente c WHERE c.bloqueioFaturamento = :bloqueioFaturamento"),
    @NamedQuery(name = "Cliente.findByBloqueioComercial", query = "SELECT c FROM Cliente c WHERE c.bloqueioComercial = :bloqueioComercial"),
    @NamedQuery(name = "Cliente.findByStatusEmpresa", query = "SELECT c FROM Cliente c WHERE c.statusEmpresa = :statusEmpresa"),
    @NamedQuery(name = "Cliente.findByRevendedor", query = "SELECT c FROM Cliente c WHERE c.revendedor = :revendedor"),
    @NamedQuery(name = "Cliente.findByLimiteCredito", query = "SELECT c FROM Cliente c WHERE c.limiteCredito = :limiteCredito"),
    @NamedQuery(name = "Cliente.findByDataAvaliacaoLimiteCredito", query = "SELECT c FROM Cliente c WHERE c.dataAvaliacaoLimiteCredito = :dataAvaliacaoLimiteCredito"),
    @NamedQuery(name = "Cliente.findByResponsavelLimiteCredito", query = "SELECT c FROM Cliente c WHERE c.responsavelLimiteCredito = :responsavelLimiteCredito"),
    @NamedQuery(name = "Cliente.findByObservacaoLimiteCredito", query = "SELECT c FROM Cliente c WHERE c.observacaoLimiteCredito = :observacaoLimiteCredito"),
    @NamedQuery(name = "Cliente.findByTipoLimiteCredito", query = "SELECT c FROM Cliente c WHERE c.tipoLimiteCredito = :tipoLimiteCredito"),
    @NamedQuery(name = "Cliente.findByGeraBoleto", query = "SELECT c FROM Cliente c WHERE c.geraBoleto = :geraBoleto"),
    @NamedQuery(name = "Cliente.findByTipoEstabelecimento", query = "SELECT c FROM Cliente c WHERE c.tipoEstabelecimento = :tipoEstabelecimento"),
    @NamedQuery(name = "Cliente.findByEmailNotaMunicipal", query = "SELECT c FROM Cliente c WHERE c.emailNotaMunicipal = :emailNotaMunicipal"),
    @NamedQuery(name = "Cliente.findByEmailNotaFederal", query = "SELECT c FROM Cliente c WHERE c.emailNotaFederal = :emailNotaFederal"),
    @NamedQuery(name = "Cliente.findByPasta", query = "SELECT c FROM Cliente c WHERE c.pasta = :pasta"),
    @NamedQuery(name = "Cliente.findByCodigoInterno", query = "SELECT c FROM Cliente c WHERE c.codigoInterno = :codigoInterno"),
    @NamedQuery(name = "Cliente.findByPerfil", query = "SELECT c FROM Cliente c WHERE c.perfil = :perfil"),
    @NamedQuery(name = "Cliente.findByAtuacao", query = "SELECT c FROM Cliente c WHERE c.atuacao = :atuacao"),
    @NamedQuery(name = "Cliente.findByFatorVenda", query = "SELECT c FROM Cliente c WHERE c.fatorVenda = :fatorVenda"),
    @NamedQuery(name = "Cliente.findByOptanteSimples", query = "SELECT c FROM Cliente c WHERE c.optanteSimples = :optanteSimples"),
    @NamedQuery(name = "Cliente.findByInscricaoSuframa", query = "SELECT c FROM Cliente c WHERE c.inscricaoSuframa = :inscricaoSuframa"),
    @NamedQuery(name = "Cliente.findByRankingScore", query = "SELECT c FROM Cliente c WHERE c.rankingScore = :rankingScore"),
    @NamedQuery(name = "Cliente.findByOpcaoSimplesDANFE", query = "SELECT c FROM Cliente c WHERE c.opcaoSimplesDANFE = :opcaoSimplesDANFE"),
    @NamedQuery(name = "Cliente.findByAcessoItensPromocionais", query = "SELECT c FROM Cliente c WHERE c.acessoItensPromocionais = :acessoItensPromocionais"),
    @NamedQuery(name = "Cliente.findByIndicadorProspect", query = "SELECT c FROM Cliente c WHERE c.indicadorProspect = :indicadorProspect")})
public class Cliente implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<PedidoVenda> pedidoVendaCollection;
    @Column(name = "bloqueioAtendimento")
    private Boolean bloqueioAtendimento;
    @Column(name = "bloqueioVendas")
    private Boolean bloqueioVendas;
    @Column(name = "bloqueioFaturamento")
    private Boolean bloqueioFaturamento;
    @Column(name = "bloqueioComercial")
    private Boolean bloqueioComercial;
    @Column(name = "acessoItensPromocionais")
    private Boolean acessoItensPromocionais;
    @Size(max = 1)
    @Column(name = "enderecoCobranca")
    private String enderecoCobranca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<Localidade> localidadeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<Contato> contatoCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCliente")
    private Integer idCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "razaoSocial")
    private String razaoSocial;
    @Size(max = 60)
    @Column(name = "nomeFantasia")
    private String nomeFantasia;
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
    @Size(max = 11)
    @Column(name = "documentoRepresentanteCPF")
    private String documentoRepresentanteCPF;
    @Size(max = 14)
    @Column(name = "documentoRepresentanteRG")
    private String documentoRepresentanteRG;
    @Column(name = "dataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @Size(max = 60)
    @Column(name = "nomeRazaoSocialEntrega")
    private String nomeRazaoSocialEntrega;
    @Size(max = 18)
    @Column(name = "inscricaoEstadualEntrega")
    private String inscricaoEstadualEntrega;
    @Size(max = 18)
    @Column(name = "documentoEntregaCNPJ")
    private String documentoEntregaCNPJ;
    @Size(max = 11)
    @Column(name = "documentoEntregaCPF")
    private String documentoEntregaCPF;
    @Column(name = "dataFollowUp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFollowUp;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "capitalSocial", precision = 11, scale = 2)
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
    @Size(max = 15)
    @Column(name = "inscricaoMunicipal")
    private String inscricaoMunicipal;
    @Size(max = 45)
    @Column(name = "motivoBloqueio")
    private String motivoBloqueio;
    @Size(max = 45)
    @Column(name = "usuarioBloqueio")
    private String usuarioBloqueio;
    @Column(name = "dataBloqueio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataBloqueio;
    @Column(name = "statusEmpresa")
    private Character statusEmpresa;
    @Column(name = "revendedor")
    private Character revendedor;
    @Column(name = "limiteCredito")
    private BigDecimal limiteCredito;
    @Column(name = "dataAvaliacaoLimiteCredito")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAvaliacaoLimiteCredito;
    @Size(max = 30)
    @Column(name = "responsavelLimiteCredito")
    private String responsavelLimiteCredito;
    @Size(max = 45)
    @Column(name = "observacaoLimiteCredito")
    private String observacaoLimiteCredito;
    @Size(max = 3)
    @Column(name = "tipoLimiteCredito")
    private String tipoLimiteCredito;
    @Column(name = "geraBoleto")
    private Character geraBoleto;
    @Column(name = "tipoEstabelecimento")
    private Character tipoEstabelecimento;
    @Size(max = 45)
    @Column(name = "emailNotaMunicipal")
    private String emailNotaMunicipal;
    @Size(max = 45)
    @Column(name = "emailNotaFederal")
    private String emailNotaFederal;
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
    @Column(name = "fatorVenda")
    private BigDecimal fatorVenda;
    @Column(name = "optanteSimples")
    private Character optanteSimples;
    @Column(name = "inscricaoSuframa")
    private Character inscricaoSuframa;
    @Column(name = "rankingScore")
    private Integer rankingScore;
    @Column(name = "opcaoSimplesDANFE")
    private Character opcaoSimplesDANFE;
    @Column(name = "indicadorProspect")
    private Character indicadorProspect;
    @JoinColumn(name = "idBanco", referencedColumnName = "idBanco")
    @ManyToOne(optional = false)
    private Banco idBanco;
    @JoinColumn(name = "idCarteira", referencedColumnName = "idCarteira")
    @ManyToOne(optional = false)
    private Carteira idCarteira;
    @JoinColumn(name = "idCondicaoPagamento", referencedColumnName = "idCondicaoPagamento")
    @ManyToOne(optional = false)
    private CondicaoPagamento idCondicaoPagamento;
    @JoinColumn(name = "idListaPrecosProdutos", referencedColumnName = "idListaPrecosProdutos")
    @ManyToOne(optional = false)
    private ListaPrecoProdutos idListaPrecosProdutos;
    @JoinColumn(name = "idListaPrecosServicos", referencedColumnName = "idListaPrecosServicos")
    @ManyToOne(optional = false)
    private ListaPrecoServicos idListaPrecosServicos;
    @JoinColumn(name = "idNaturezaOperacao", referencedColumnName = "idNaturezaOperacao")
    @ManyToOne
    private NaturezaOperacao idNaturezaOperacao;
    @JoinColumn(name = "idCodigoSegmento", referencedColumnName = "idCodigoSegmento")
    @ManyToOne(optional = false)
    private Segmento idCodigoSegmento;
    @JoinColumn(name = "idVendedorFidelidade", referencedColumnName = "idVendedor")
    @ManyToOne
    private Vendedor idVendedorFidelidade;
    @JoinColumn(name = "idTipoTransporte", referencedColumnName = "idTipoTransporte")
    @ManyToOne(optional = false)
    private TipoTransporte idTipoTransporte;
    @JoinColumn(name = "idCodigoTransportador", referencedColumnName = "idCodigoTransportador")
    @ManyToOne(optional = false)
    private Transportador idCodigoTransportador;

    @Size(max = 8)
    @Column(name = "cep")
    private String cep;
    @Size(max = 20)
    @Column(name = "tipoLogradouro")
    private String tipoLogradouro;
    @Size(max = 45)
    @Column(name = "logradouro")
    private String logradouro;
    @Size(max = 5)
    @Column(name = "numero")
    private String numero;
    @Size(max = 30)
    @Column(name = "bairro")
    private String bairro;
    @Size(max = 30)
    @Column(name = "cidade")
    private String cidade;
    @Size(max = 2)
    @Column(name = "uf")
    private String uf;
    @Size(max = 1)
    @Column(name = "status")
    private String status;
    @Size(max = 45)
    @Column(name = "complemento")
    private String complemento;
    @Size(max = 10)
    @Column(name = "codigoIBGE")
    private String codigoIBGE;
    
    @Column(name = "ufInscricaoEstadual")
    private String ufInscricaoEstadual;

    
    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(Integer idCliente, String razaoSocial) {
        this.idCliente = idCliente;
        this.razaoSocial = razaoSocial;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
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

    public String getNomeRazaoSocialEntrega() {
        return nomeRazaoSocialEntrega;
    }

    public void setNomeRazaoSocialEntrega(String nomeRazaoSocialEntrega) {
        this.nomeRazaoSocialEntrega = nomeRazaoSocialEntrega;
    }

    public String getInscricaoEstadualEntrega() {
        return inscricaoEstadualEntrega;
    }

    public void setInscricaoEstadualEntrega(String inscricaoEstadualEntrega) {
        this.inscricaoEstadualEntrega = inscricaoEstadualEntrega;
    }

    public String getDocumentoEntregaCNPJ() {
        return documentoEntregaCNPJ;
    }

    public void setDocumentoEntregaCNPJ(String documentoEntregaCNPJ) {
        this.documentoEntregaCNPJ = documentoEntregaCNPJ;
    }

    public String getDocumentoEntregaCPF() {
        return documentoEntregaCPF;
    }

    public void setDocumentoEntregaCPF(String documentoEntregaCPF) {
        this.documentoEntregaCPF = documentoEntregaCPF;
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

    public BigDecimal getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(BigDecimal limiteCredito) {
        this.limiteCredito = limiteCredito;
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

    public Character getGeraBoleto() {
        return geraBoleto;
    }

    public void setGeraBoleto(Character geraBoleto) {
        this.geraBoleto = geraBoleto;
    }

    public Character getTipoEstabelecimento() {
        return tipoEstabelecimento;
    }

    public void setTipoEstabelecimento(Character tipoEstabelecimento) {
        this.tipoEstabelecimento = tipoEstabelecimento;
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

    public BigDecimal getFatorVenda() {
        return fatorVenda;
    }

    public void setFatorVenda(BigDecimal fatorVenda) {
        this.fatorVenda = fatorVenda;
    }

    public Character getOptanteSimples() {
        return optanteSimples;
    }

    public void setOptanteSimples(Character optanteSimples) {
        this.optanteSimples = optanteSimples;
    }

    public Character getInscricaoSuframa() {
        return inscricaoSuframa;
    }

    public void setInscricaoSuframa(Character inscricaoSuframa) {
        this.inscricaoSuframa = inscricaoSuframa;
    }

    public Integer getRankingScore() {
        return rankingScore;
    }

    public void setRankingScore(Integer rankingScore) {
        this.rankingScore = rankingScore;
    }

    public Character getOpcaoSimplesDANFE() {
        return opcaoSimplesDANFE;
    }

    public void setOpcaoSimplesDANFE(Character opcaoSimplesDANFE) {
        this.opcaoSimplesDANFE = opcaoSimplesDANFE;
    }

    public Character getIndicadorProspect() {
        return indicadorProspect;
    }

    public void setIndicadorProspect(Character indicadorProspect) {
        this.indicadorProspect = indicadorProspect;
    }

    public Banco getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Banco idBanco) {
        this.idBanco = idBanco;
    }

    public Carteira getIdCarteira() {
        return idCarteira;
    }

    public void setIdCarteira(Carteira idCarteira) {
        this.idCarteira = idCarteira;
    }

    public CondicaoPagamento getIdCondicaoPagamento() {
        return idCondicaoPagamento;
    }

    public void setIdCondicaoPagamento(CondicaoPagamento idCondicaoPagamento) {
        this.idCondicaoPagamento = idCondicaoPagamento;
    }

    public ListaPrecoProdutos getIdListaPrecosProdutos() {
        return idListaPrecosProdutos;
    }

    public void setIdListaPrecosProdutos(ListaPrecoProdutos idListaPrecosProdutos) {
        this.idListaPrecosProdutos = idListaPrecosProdutos;
    }

    public ListaPrecoServicos getIdListaPrecosServicos() {
        return idListaPrecosServicos;
    }

    public void setIdListaPrecosServicos(ListaPrecoServicos idListaPrecosServicos) {
        this.idListaPrecosServicos = idListaPrecosServicos;
    }

    public NaturezaOperacao getIdNaturezaOperacao() {
        return idNaturezaOperacao;
    }

    public void setIdNaturezaOperacao(NaturezaOperacao idNaturezaOperacao) {
        this.idNaturezaOperacao = idNaturezaOperacao;
    }

    public Segmento getIdCodigoSegmento() {
        return idCodigoSegmento;
    }

    public void setIdCodigoSegmento(Segmento idCodigoSegmento) {
        this.idCodigoSegmento = idCodigoSegmento;
    }

    public Vendedor getIdVendedorFidelidade() {
        return idVendedorFidelidade;
    }

    public void setIdVendedorFidelidade(Vendedor idVendedorFidelidade) {
        this.idVendedorFidelidade = idVendedorFidelidade;
    }

    public TipoTransporte getIdTipoTransporte() {
        return idTipoTransporte;
    }

    public void setIdTipoTransporte(TipoTransporte idTipoTransporte) {
        this.idTipoTransporte = idTipoTransporte;
    }

    public Transportador getIdCodigoTransportador() {
        return idCodigoTransportador;
    }

    public void setIdCodigoTransportador(Transportador idCodigoTransportador) {
        this.idCodigoTransportador = idCodigoTransportador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.Cliente[ idCliente=" + idCliente + " ]";
    }

    @XmlTransient
    public Collection<Contato> getContatoCollection() {
        return contatoCollection;
    }

    public void setContatoCollection(Collection<Contato> contatoCollection) {
        this.contatoCollection = contatoCollection;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the tipoLogradouro
     */
    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    /**
     * @param tipoLogradouro the tipoLogradouro to set
     */
    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    /**
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the codigoIBGE
     */
    public String getCodigoIBGE() {
        return codigoIBGE;
    }

    /**
     * @param codigoIBGE the codigoIBGE to set
     */
    public void setCodigoIBGE(String codigoIBGE) {
        this.codigoIBGE = codigoIBGE;
    }
    public String getUfInscricaoEstadual() {
        return ufInscricaoEstadual;
    }
    public void setUfInscricaoEstadual(String ufInscricaoEstadual) {
        this.ufInscricaoEstadual = ufInscricaoEstadual;
    }

    /**
     * @return the bloqueioAtendimento
     */
    public Boolean getBloqueioAtendimento() {
        return bloqueioAtendimento;
    }

    /**
     * @param bloqueioAtendimento the bloqueioAtendimento to set
     */
    public void setBloqueioAtendimento(Boolean bloqueioAtendimento) {
        this.bloqueioAtendimento = bloqueioAtendimento;
    }

    /**
     * @return the bloqueioVendas
     */
    public Boolean getBloqueioVendas() {
        return bloqueioVendas;
    }

    /**
     * @param bloqueioVendas the bloqueioVendas to set
     */
    public void setBloqueioVendas(Boolean bloqueioVendas) {
        this.bloqueioVendas = bloqueioVendas;
    }

    /**
     * @return the bloqueioFaturamento
     */
    public Boolean getBloqueioFaturamento() {
        return bloqueioFaturamento;
    }

    /**
     * @param bloqueioFaturamento the bloqueioFaturamento to set
     */
    public void setBloqueioFaturamento(Boolean bloqueioFaturamento) {
        this.bloqueioFaturamento = bloqueioFaturamento;
    }

    /**
     * @return the bloqueioComercial
     */
    public Boolean getBloqueioComercial() {
        return bloqueioComercial;
    }

    /**
     * @param bloqueioComercial the bloqueioComercial to set
     */
    public void setBloqueioComercial(Boolean bloqueioComercial) {
        this.bloqueioComercial = bloqueioComercial;
    }

    /**
     * @return the acessoItensPromocionais
     */
    public Boolean getAcessoItensPromocionais() {
        return acessoItensPromocionais;
    }

    /**
     * @param acessoItensPromocionais the acessoItensPromocionais to set
     */
    public void setAcessoItensPromocionais(Boolean acessoItensPromocionais) {
        this.acessoItensPromocionais = acessoItensPromocionais;
    }

    /**
     * @return the ufInscricaoEstadual
     */
    public String getEnderecoCobranca() {
        return enderecoCobranca;
    }

    /**
     * @param ufInscricaoEstadual the ufInscricaoEstadual to set
     */
    public void setEnderecoCobranca(String enderecoCobranca) {
        this.enderecoCobranca = enderecoCobranca;
    }

    @XmlTransient
    public Collection<Localidade> getLocalidadeCollection() {
        return localidadeCollection;
    }

    public void setLocalidadeCollection(Collection<Localidade> localidadeCollection) {
        this.localidadeCollection = localidadeCollection;
    }

    @XmlTransient
    public Collection<PedidoVenda> getPedidoVendaCollection() {
        return pedidoVendaCollection;
    }

    public void setPedidoVendaCollection(Collection<PedidoVenda> pedidoVendaCollection) {
        this.pedidoVendaCollection = pedidoVendaCollection;
    }

}

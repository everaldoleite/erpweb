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
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author everaldo
 */
@Entity
@Table(name = "PRODUTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByIdProduto", query = "SELECT p FROM Produto p WHERE p.idProduto = :idProduto"),
    @NamedQuery(name = "Produto.findByPartNumber", query = "SELECT p FROM Produto p WHERE p.partNumber = :partNumber"),
    @NamedQuery(name = "Produto.findByDescricaoProduto", query = "SELECT p FROM Produto p WHERE p.descricaoProduto = :descricaoProduto"),
    @NamedQuery(name = "Produto.findByMarca", query = "SELECT p FROM Produto p WHERE p.marca = :marca"),
    @NamedQuery(name = "Produto.findBySituacao", query = "SELECT p FROM Produto p WHERE p.situacao = :situacao"),
    @NamedQuery(name = "Produto.findByUnidadeEstoque", query = "SELECT p FROM Produto p WHERE p.unidadeEstoque = :unidadeEstoque"),
    @NamedQuery(name = "Produto.findByUnidadeEntrada", query = "SELECT p FROM Produto p WHERE p.unidadeEntrada = :unidadeEntrada"),
    @NamedQuery(name = "Produto.findByPesoBruto", query = "SELECT p FROM Produto p WHERE p.pesoBruto = :pesoBruto"),
    @NamedQuery(name = "Produto.findByPesoLiquido", query = "SELECT p FROM Produto p WHERE p.pesoLiquido = :pesoLiquido"),
    @NamedQuery(name = "Produto.findByDimensao", query = "SELECT p FROM Produto p WHERE p.dimensao = :dimensao"),
    @NamedQuery(name = "Produto.findByCalculoPrecoCusto", query = "SELECT p FROM Produto p WHERE p.calculoPrecoCusto = :calculoPrecoCusto"),
    @NamedQuery(name = "Produto.findByPedidoAutomatico", query = "SELECT p FROM Produto p WHERE p.pedidoAutomatico = :pedidoAutomatico"),
    @NamedQuery(name = "Produto.findByTipoMoeda", query = "SELECT p FROM Produto p WHERE p.tipoMoeda = :tipoMoeda"),
    @NamedQuery(name = "Produto.findByDataManutencao", query = "SELECT p FROM Produto p WHERE p.dataManutencao = :dataManutencao"),
    @NamedQuery(name = "Produto.findByRendimento", query = "SELECT p FROM Produto p WHERE p.rendimento = :rendimento"),
    @NamedQuery(name = "Produto.findByTipoOrigemProduto", query = "SELECT p FROM Produto p WHERE p.tipoOrigemProduto = :tipoOrigemProduto"),
    @NamedQuery(name = "Produto.findByTipoTributacao", query = "SELECT p FROM Produto p WHERE p.tipoTributacao = :tipoTributacao"),
    @NamedQuery(name = "Produto.findByTipoProduto", query = "SELECT p FROM Produto p WHERE p.tipoProduto = :tipoProduto"),
    @NamedQuery(name = "Produto.findByMpBem", query = "SELECT p FROM Produto p WHERE p.mpBem = :mpBem"),
    @NamedQuery(name = "Produto.findByDataUltimaVenda", query = "SELECT p FROM Produto p WHERE p.dataUltimaVenda = :dataUltimaVenda"),
    @NamedQuery(name = "Produto.findByEspecificacaoProduto", query = "SELECT p FROM Produto p WHERE p.especificacaoProduto = :especificacaoProduto"),
    @NamedQuery(name = "Produto.findByIndicadorEstoque", query = "SELECT p FROM Produto p WHERE p.indicadorEstoque = :indicadorEstoque")})
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProduto")
    private Integer idProduto;
    @Size(max = 15)
    @Column(name = "partNumber")
    private String partNumber;
    @Size(max = 80)
    @Column(name = "descricaoProduto")
    private String descricaoProduto;
    @Size(max = 40)
    @Column(name = "descricaoResumidaProduto")
    private String descricaoResumidaProduto;
    @Size(max = 45)
    @Column(name = "marca")
    private String marca;
    @Size(max = 20)
    @Column(name = "cor")
    private String cor;
    @Column(name = "ativo")
    private boolean ativo;
    @Column(name = "fabricacaoPropria")
    private boolean fabricacaoPropria;
    @Column(name = "situacao")
    private Character situacao;
    @Size(max = 3)
    @Column(name = "unidadeEstoque")
    private String unidadeEstoque;
    @Size(max = 3)
    @Column(name = "unidadeEntrada")
    private String unidadeEntrada;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pesoBruto")
    private Double pesoBruto;
    @Column(name = "pesoLiquido")
    private Double pesoLiquido;
    @Size(max = 20)
    @Column(name = "dimensao")
    private String dimensao;
    @Size(max = 20)
    @Column(name = "unidade")
    private String unidade;
    @Column(name = "calculoPrecoCusto")
    private Character calculoPrecoCusto;
    @Column(name = "pedidoAutomatico")
    private Character pedidoAutomatico;
    @Column(name = "tipoMoeda")
    private Character tipoMoeda;
    @Column(name = "dataManutencao")
    @Temporal(TemporalType.DATE)
    private Date dataManutencao;
    @Size(max = 45)
    @Column(name = "rendimento")
    private String rendimento;
    @Column(name = "tipoOrigemProduto")
    private Character tipoOrigemProduto;
    @Column(name = "tipoTributacao")
    private Character tipoTributacao;
    @Column(name = "tipoProduto")
    private Character tipoProduto;
    @Column(name = "mpBem")
    private Character mpBem;
    @Column(name = "dataUltimaVenda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaVenda;
    @Size(max = 45)
    @Column(name = "especificacaoProduto")
    private String especificacaoProduto;
    @Column(name = "indicadorEstoque")
    private Character indicadorEstoque;
    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria")
    @ManyToOne(optional = false)
    private Categoria idCategoria;
    @JoinColumn(name = "idGrupo", referencedColumnName = "idGrupo")
    @ManyToOne(optional = false)
    private Grupo idGrupo;
    @JoinColumn(name = "IdNcm", referencedColumnName = "idNcm")
    @ManyToOne(optional = false)
    private Ncm idNcm;
    @JoinColumn(name = "idSubGrupo", referencedColumnName = "idSubGrupo")
    @ManyToOne(optional = false)
    private SubGrupo idSubGrupo;
    @JoinColumn(name = "idFabricante", referencedColumnName = "idFabricante")
    @ManyToOne(optional = false)
    private Fabricante idFabricante;
    @Size(max = 20)
    @Column(name = "modelo")
    private String modelo;
    
    @Digits(integer = 11, fraction = 2)
    @Column(name = "precoCusto")
    private BigDecimal precoCusto;

    public Produto() {
    }

    public Produto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getUnidadeEstoque() {
        return unidadeEstoque;
    }

    public void setUnidadeEstoque(String unidadeEstoque) {
        this.unidadeEstoque = unidadeEstoque;
    }

    public String getUnidadeEntrada() {
        return unidadeEntrada;
    }

    public void setUnidadeEntrada(String unidadeEntrada) {
        this.unidadeEntrada = unidadeEntrada;
    }

    public Double getPesoBruto() {
        return pesoBruto;
    }

    public void setPesoBruto(Double pesoBruto) {
        this.pesoBruto = pesoBruto;
    }

    public Double getPesoLiquido() {
        return pesoLiquido;
    }

    public void setPesoLiquido(Double pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }

    public String getDimensao() {
        return dimensao;
    }

    public void setDimensao(String dimensao) {
        this.dimensao = dimensao;
    }

    public Character getCalculoPrecoCusto() {
        return calculoPrecoCusto;
    }

    public void setCalculoPrecoCusto(Character calculoPrecoCusto) {
        this.calculoPrecoCusto = calculoPrecoCusto;
    }

    public Character getPedidoAutomatico() {
        return pedidoAutomatico;
    }

    public void setPedidoAutomatico(Character pedidoAutomatico) {
        this.pedidoAutomatico = pedidoAutomatico;
    }

    public Character getTipoMoeda() {
        return tipoMoeda;
    }

    public void setTipoMoeda(Character tipoMoeda) {
        this.tipoMoeda = tipoMoeda;
    }

    public Date getDataManutencao() {
        return dataManutencao;
    }

    public void setDataManutencao(Date dataManutencao) {
        this.dataManutencao = dataManutencao;
    }

    public String getRendimento() {
        return rendimento;
    }

    public void setRendimento(String rendimento) {
        this.rendimento = rendimento;
    }

    public Character getTipoOrigemProduto() {
        return tipoOrigemProduto;
    }

    public void setTipoOrigemProduto(Character tipoOrigemProduto) {
        this.tipoOrigemProduto = tipoOrigemProduto;
    }

    public Character getTipoTributacao() {
        return tipoTributacao;
    }

    public void setTipoTributacao(Character tipoTributacao) {
        this.tipoTributacao = tipoTributacao;
    }

    public Character getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(Character tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public Character getMpBem() {
        return mpBem;
    }

    public void setMpBem(Character mpBem) {
        this.mpBem = mpBem;
    }

    public Date getDataUltimaVenda() {
        return dataUltimaVenda;
    }

    public void setDataUltimaVenda(Date dataUltimaVenda) {
        this.dataUltimaVenda = dataUltimaVenda;
    }

    public String getEspecificacaoProduto() {
        return especificacaoProduto;
    }

    public void setEspecificacaoProduto(String especificacaoProduto) {
        this.especificacaoProduto = especificacaoProduto;
    }

    public Character getIndicadorEstoque() {
        return indicadorEstoque;
    }

    public void setIndicadorEstoque(Character indicadorEstoque) {
        this.indicadorEstoque = indicadorEstoque;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Grupo getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Grupo idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Ncm getIdNcm() {
        return idNcm;
    }

    public void setIdNcm(Ncm idNcm) {
        this.idNcm = idNcm;
    }

    public SubGrupo getIdSubGrupo() {
        return idSubGrupo;
    }

    public void setIdSubGrupo(SubGrupo idSubGrupo) {
        this.idSubGrupo = idSubGrupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.Produto[ idProduto=" + idProduto + " ]";
    }

    /**
     * @return the descricaoResumidaProduto
     */
    public String getDescricaoResumidaProduto() {
        return descricaoResumidaProduto;
    }

    /**
     * @param descricaoResumidaProduto the descricaoResumidaProduto to set
     */
    public void setDescricaoResumidaProduto(String descricaoResumidaProduto) {
        this.descricaoResumidaProduto = descricaoResumidaProduto;
    }

    /**
     * @return the ativo
     */
    public boolean isAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
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
     * @return the fabricacaoPropria
     */
    public boolean isFabricacaoPropria() {
        return fabricacaoPropria;
    }

    /**
     * @param fabricacaoPropria the fabricacaoPropria to set
     */
    public void setFabricacaoPropria(boolean fabricacaoPropria) {
        this.fabricacaoPropria = fabricacaoPropria;
    }

    /**
     * @return the cor
     */
    public String getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * @return the idFabricante
     */
    public Fabricante getIdFabricante() {
        return idFabricante;
    }

    /**
     * @param idFabricante the idFabricante to set
     */
    public void setIdFabricante(Fabricante idFabricante) {
        this.idFabricante = idFabricante;
    }

    /**
     * @return the unidade
     */
    public String getUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the precoCusto
     */
    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    /**
     * @param precoCusto the precoCusto to set
     */
    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }
    
}

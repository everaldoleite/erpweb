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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "PRODUTOS_PEDIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProdutosPedido.findAll", query = "SELECT p FROM ProdutosPedido p"),
    @NamedQuery(name = "ProdutosPedido.findByIdProdutoPedido", query = "SELECT p FROM ProdutosPedido p WHERE p.idProdutoPedido = :idProdutoPedido"),
    @NamedQuery(name = "ProdutosPedido.findByIdArmazem", query = "SELECT p FROM ProdutosPedido p WHERE p.idArmazem = :idArmazem"),
    @NamedQuery(name = "ProdutosPedido.findByCoeficiente", query = "SELECT p FROM ProdutosPedido p WHERE p.coeficiente = :coeficiente"),
    @NamedQuery(name = "ProdutosPedido.findByPrecoLista", query = "SELECT p FROM ProdutosPedido p WHERE p.precoLista = :precoLista"),
    @NamedQuery(name = "ProdutosPedido.findByPrecoVenda", query = "SELECT p FROM ProdutosPedido p WHERE p.precoVenda = :precoVenda"),
    @NamedQuery(name = "ProdutosPedido.findByQuantidadeSolicitada", query = "SELECT p FROM ProdutosPedido p WHERE p.quantidadeSolicitada = :quantidadeSolicitada"),
    @NamedQuery(name = "ProdutosPedido.findByQuantidadeFaturada", query = "SELECT p FROM ProdutosPedido p WHERE p.quantidadeFaturada = :quantidadeFaturada"),
    @NamedQuery(name = "ProdutosPedido.findByMargem", query = "SELECT p FROM ProdutosPedido p WHERE p.margem = :margem"),
    @NamedQuery(name = "ProdutosPedido.findByPercentualICMSUtilizado", query = "SELECT p FROM ProdutosPedido p WHERE p.percentualICMSUtilizado = :percentualICMSUtilizado"),
    @NamedQuery(name = "ProdutosPedido.findByBaseCalculoIPI", query = "SELECT p FROM ProdutosPedido p WHERE p.baseCalculoIPI = :baseCalculoIPI"),
    @NamedQuery(name = "ProdutosPedido.findByBaseCalculoIPIIsento", query = "SELECT p FROM ProdutosPedido p WHERE p.baseCalculoIPIIsento = :baseCalculoIPIIsento"),
    @NamedQuery(name = "ProdutosPedido.findByBaseCalculoIPIOutras", query = "SELECT p FROM ProdutosPedido p WHERE p.baseCalculoIPIOutras = :baseCalculoIPIOutras"),
    @NamedQuery(name = "ProdutosPedido.findByBaseCalculoICMS", query = "SELECT p FROM ProdutosPedido p WHERE p.baseCalculoICMS = :baseCalculoICMS"),
    @NamedQuery(name = "ProdutosPedido.findByBaseCalculoICMSIsento", query = "SELECT p FROM ProdutosPedido p WHERE p.baseCalculoICMSIsento = :baseCalculoICMSIsento"),
    @NamedQuery(name = "ProdutosPedido.findByBaseCalculoICMSOutras", query = "SELECT p FROM ProdutosPedido p WHERE p.baseCalculoICMSOutras = :baseCalculoICMSOutras"),
    @NamedQuery(name = "ProdutosPedido.findByNumeroPedidoCliente", query = "SELECT p FROM ProdutosPedido p WHERE p.numeroPedidoCliente = :numeroPedidoCliente"),
    @NamedQuery(name = "ProdutosPedido.findByPosicaoPedidoCliente", query = "SELECT p FROM ProdutosPedido p WHERE p.posicaoPedidoCliente = :posicaoPedidoCliente")})
public class ProdutosPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProdutoPedido")
    private Integer idProdutoPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idArmazem")
    private int idArmazem;
    @Column(name = "coeficiente")
    private Character coeficiente;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precoLista")
    private BigDecimal precoLista;
    @Column(name = "precoVenda")
    private BigDecimal precoVenda;
    @Column(name = "quantidadeSolicitada")
    private Double quantidadeSolicitada;
    @Column(name = "quantidadeFaturada")
    private Double quantidadeFaturada;
    @Column(name = "margem")
    private Double margem;
    @Column(name = "percentualICMSUtilizado")
    private BigDecimal percentualICMSUtilizado;
    @Column(name = "baseCalculoIPI")
    private BigDecimal baseCalculoIPI;
    @Column(name = "baseCalculoIPIIsento")
    private BigDecimal baseCalculoIPIIsento;
    @Column(name = "baseCalculoIPIOutras")
    private BigDecimal baseCalculoIPIOutras;
    @Column(name = "baseCalculoICMS")
    private BigDecimal baseCalculoICMS;
    @Column(name = "baseCalculoICMSIsento")
    private BigDecimal baseCalculoICMSIsento;
    @Column(name = "baseCalculoICMSOutras")
    private BigDecimal baseCalculoICMSOutras;
    @Size(max = 45)
    @Column(name = "numeroPedidoCliente")
    private String numeroPedidoCliente;
    @Size(max = 45)
    @Column(name = "posicaoPedidoCliente")
    private String posicaoPedidoCliente;
    
    public ProdutosPedido() {
    }

    public ProdutosPedido(Integer idProdutoPedido) {
        this.idProdutoPedido = idProdutoPedido;
    }

    public ProdutosPedido(Integer idProdutoPedido, int idArmazem) {
        this.idProdutoPedido = idProdutoPedido;
        this.idArmazem = idArmazem;
    }

    public Integer getIdProdutoPedido() {
        return idProdutoPedido;
    }

    public void setIdProdutoPedido(Integer idProdutoPedido) {
        this.idProdutoPedido = idProdutoPedido;
    }

    public int getIdArmazem() {
        return idArmazem;
    }

    public void setIdArmazem(int idArmazem) {
        this.idArmazem = idArmazem;
    }

    public Character getCoeficiente() {
        return coeficiente;
    }

    public void setCoeficiente(Character coeficiente) {
        this.coeficiente = coeficiente;
    }

    public BigDecimal getPrecoLista() {
        return precoLista;
    }

    public void setPrecoLista(BigDecimal precoLista) {
        this.precoLista = precoLista;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Double getQuantidadeSolicitada() {
        return quantidadeSolicitada;
    }

    public void setQuantidadeSolicitada(Double quantidadeSolicitada) {
        this.quantidadeSolicitada = quantidadeSolicitada;
    }

    public Double getQuantidadeFaturada() {
        return quantidadeFaturada;
    }

    public void setQuantidadeFaturada(Double quantidadeFaturada) {
        this.quantidadeFaturada = quantidadeFaturada;
    }

    public Double getMargem() {
        return margem;
    }

    public void setMargem(Double margem) {
        this.margem = margem;
    }

    public BigDecimal getPercentualICMSUtilizado() {
        return percentualICMSUtilizado;
    }

    public void setPercentualICMSUtilizado(BigDecimal percentualICMSUtilizado) {
        this.percentualICMSUtilizado = percentualICMSUtilizado;
    }

    public BigDecimal getBaseCalculoIPI() {
        return baseCalculoIPI;
    }

    public void setBaseCalculoIPI(BigDecimal baseCalculoIPI) {
        this.baseCalculoIPI = baseCalculoIPI;
    }

    public BigDecimal getBaseCalculoIPIIsento() {
        return baseCalculoIPIIsento;
    }

    public void setBaseCalculoIPIIsento(BigDecimal baseCalculoIPIIsento) {
        this.baseCalculoIPIIsento = baseCalculoIPIIsento;
    }

    public BigDecimal getBaseCalculoIPIOutras() {
        return baseCalculoIPIOutras;
    }

    public void setBaseCalculoIPIOutras(BigDecimal baseCalculoIPIOutras) {
        this.baseCalculoIPIOutras = baseCalculoIPIOutras;
    }

    public BigDecimal getBaseCalculoICMS() {
        return baseCalculoICMS;
    }

    public void setBaseCalculoICMS(BigDecimal baseCalculoICMS) {
        this.baseCalculoICMS = baseCalculoICMS;
    }

    public BigDecimal getBaseCalculoICMSIsento() {
        return baseCalculoICMSIsento;
    }

    public void setBaseCalculoICMSIsento(BigDecimal baseCalculoICMSIsento) {
        this.baseCalculoICMSIsento = baseCalculoICMSIsento;
    }

    public BigDecimal getBaseCalculoICMSOutras() {
        return baseCalculoICMSOutras;
    }

    public void setBaseCalculoICMSOutras(BigDecimal baseCalculoICMSOutras) {
        this.baseCalculoICMSOutras = baseCalculoICMSOutras;
    }

    public String getNumeroPedidoCliente() {
        return numeroPedidoCliente;
    }

    public void setNumeroPedidoCliente(String numeroPedidoCliente) {
        this.numeroPedidoCliente = numeroPedidoCliente;
    }

    public String getPosicaoPedidoCliente() {
        return posicaoPedidoCliente;
    }

    public void setPosicaoPedidoCliente(String posicaoPedidoCliente) {
        this.posicaoPedidoCliente = posicaoPedidoCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProdutoPedido != null ? idProdutoPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdutosPedido)) {
            return false;
        }
        ProdutosPedido other = (ProdutosPedido) object;
        if ((this.idProdutoPedido == null && other.idProdutoPedido != null) || (this.idProdutoPedido != null && !this.idProdutoPedido.equals(other.idProdutoPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.ProdutosPedido[ idProdutoPedido=" + idProdutoPedido + " ]";
    }
    
}

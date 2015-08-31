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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author everaldo
 */
@Entity
@Table(name = "CONDICAO_PAGAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CondicaoPagamento.findAll", query = "SELECT c FROM CondicaoPagamento c"),
    @NamedQuery(name = "CondicaoPagamento.findByIdCondicaoPagamento", query = "SELECT c FROM CondicaoPagamento c WHERE c.idCondicaoPagamento = :idCondicaoPagamento"),
    @NamedQuery(name = "CondicaoPagamento.findByDescricaoCondicaoPagamento", query = "SELECT c FROM CondicaoPagamento c WHERE c.descricaoCondicaoPagamento = :descricaoCondicaoPagamento"),
    @NamedQuery(name = "CondicaoPagamento.findByTaxaFinanceira", query = "SELECT c FROM CondicaoPagamento c WHERE c.taxaFinanceira = :taxaFinanceira")})
public class CondicaoPagamento implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCondicaoPagamento")
    private Collection<NotaFiscal> notaFiscalCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCondicaoPagamento")
    private Integer idCondicaoPagamento;
    @Size(max = 45)
    @Column(name = "descricaoCondicaoPagamento")
    private String descricaoCondicaoPagamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "taxaFinanceira")
    private BigDecimal taxaFinanceira;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCondicaoPagamento")
    private Collection<Cliente> clienteCollection;
    @Min(value = 1, message = "Quantidade Minima é 1")
    @Column(name = "quantidadeParcelas")
    private Integer quantidadeParcelas;
    @Min(value = 1, message = "Quantidade Minima é 1")
    @Max(value = 30, message = "Quandidade Máxima permitida = 30")
    @Column(name = "quantidadeDiasParcelas")
    private Integer quantidadeDiasParcelas;

    public CondicaoPagamento() {
    }

    public CondicaoPagamento(Integer idCondicaoPagamento) {
        this.idCondicaoPagamento = idCondicaoPagamento;
    }

    public Integer getIdCondicaoPagamento() {
        return idCondicaoPagamento;
    }

    public void setIdCondicaoPagamento(Integer idCondicaoPagamento) {
        this.idCondicaoPagamento = idCondicaoPagamento;
    }

    public String getDescricaoCondicaoPagamento() {
        return descricaoCondicaoPagamento;
    }

    public void setDescricaoCondicaoPagamento(String descricaoCondicaoPagamento) {
        this.descricaoCondicaoPagamento = descricaoCondicaoPagamento;
    }

    public BigDecimal getTaxaFinanceira() {
        return taxaFinanceira;
    }

    public void setTaxaFinanceira(BigDecimal taxaFinanceira) {
        this.taxaFinanceira = taxaFinanceira;
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
        hash += (idCondicaoPagamento != null ? idCondicaoPagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CondicaoPagamento)) {
            return false;
        }
        CondicaoPagamento other = (CondicaoPagamento) object;
        if ((this.idCondicaoPagamento == null && other.idCondicaoPagamento != null) || (this.idCondicaoPagamento != null && !this.idCondicaoPagamento.equals(other.idCondicaoPagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.CondicaoPagamento[ idCondicaoPagamento=" + idCondicaoPagamento + " ]";
    }

    /**
     * @return the quantidadeParcelas
     */
    public Integer getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    /**
     * @param quantidadeParcelas the quantidadeParcelas to set
     */
    public void setQuantidadeParcelas(Integer quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    /**
     * @return the quantidadeDiasParcelas
     */
    public Integer getQuantidadeDiasParcelas() {
        return quantidadeDiasParcelas;
    }

    /**
     * @param quantidadeDiasParcelas the quantidadeDiasParcelas to set
     */
    public void setQuantidadeDiasParcelas(Integer quantidadeDiasParcelas) {
        this.quantidadeDiasParcelas = quantidadeDiasParcelas;
    }

    @XmlTransient
    public Collection<NotaFiscal> getNotaFiscalCollection() {
        return notaFiscalCollection;
    }

    public void setNotaFiscalCollection(Collection<NotaFiscal> notaFiscalCollection) {
        this.notaFiscalCollection = notaFiscalCollection;
    }
    
}

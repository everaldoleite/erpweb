/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.persistence.entities;

import br.com.erpweb.persistence.entities.Banco;
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
@Table(name = "CONTA_CORRENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContaCorrente.findAll", query = "SELECT c FROM ContaCorrente c"),
    @NamedQuery(name = "ContaCorrente.findByIdContaCorrente", query = "SELECT c FROM ContaCorrente c WHERE c.idContaCorrente = :idContaCorrente"),
    @NamedQuery(name = "ContaCorrente.findByAgencia", query = "SELECT c FROM ContaCorrente c WHERE c.agencia = :agencia"),
    @NamedQuery(name = "ContaCorrente.findByLimiteCredito", query = "SELECT c FROM ContaCorrente c WHERE c.limiteCredito = :limiteCredito"),
    @NamedQuery(name = "ContaCorrente.findByNumeroConta", query = "SELECT c FROM ContaCorrente c WHERE c.numeroConta = :numeroConta"),
    @NamedQuery(name = "ContaCorrente.findBySaldoInicial", query = "SELECT c FROM ContaCorrente c WHERE c.saldoInicial = :saldoInicial"),
    @NamedQuery(name = "ContaCorrente.findBySaldoAtual", query = "SELECT c FROM ContaCorrente c WHERE c.saldoAtual = :saldoAtual")})
public class ContaCorrente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idContaCorrente")
    private Integer idContaCorrente;
    @Size(max = 10)
    @Column(name = "agencia")
    private String agencia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "limiteCredito")
    private BigDecimal limiteCredito;
    @Size(max = 10)
    @Column(name = "numeroConta")
    private String numeroConta;
    @Column(name = "saldoInicial")
    private BigDecimal saldoInicial;
    @Column(name = "saldoAtual")
    private BigDecimal saldoAtual;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContaCorrente")
    private Collection<TipoCobranca> tipoCobrancaCollection;
    @JoinColumn(name = "idBanco", referencedColumnName = "idBanco")
    @ManyToOne(optional = false)
    private Banco idBanco;
    @JoinColumn(name = "idEmpresaEmitente", referencedColumnName = "idEmpresaEmitente")
    @ManyToOne(optional = false)
    private EmpresaEmitente idEmpresaEmitente;

    public ContaCorrente() {
    }

    public ContaCorrente(Integer idContaCorrente) {
        this.idContaCorrente = idContaCorrente;
    }

    public Integer getIdContaCorrente() {
        return idContaCorrente;
    }

    public void setIdContaCorrente(Integer idContaCorrente) {
        this.idContaCorrente = idContaCorrente;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public BigDecimal getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(BigDecimal limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public BigDecimal getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(BigDecimal saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    @XmlTransient
    public Collection<TipoCobranca> getTipoCobrancaCollection() {
        return tipoCobrancaCollection;
    }

    public void setTipoCobrancaCollection(Collection<TipoCobranca> tipoCobrancaCollection) {
        this.tipoCobrancaCollection = tipoCobrancaCollection;
    }

    public Banco getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Banco idBanco) {
        this.idBanco = idBanco;
    }

    public EmpresaEmitente getIdEmpresaEmitente() {
        return idEmpresaEmitente;
    }

    public void setIdEmpresaEmitente(EmpresaEmitente idEmpresaEmitente) {
        this.idEmpresaEmitente = idEmpresaEmitente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContaCorrente != null ? idContaCorrente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContaCorrente)) {
            return false;
        }
        ContaCorrente other = (ContaCorrente) object;
        if ((this.idContaCorrente == null && other.idContaCorrente != null) || (this.idContaCorrente != null && !this.idContaCorrente.equals(other.idContaCorrente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.exception.ContaCorrente[ idContaCorrente=" + idContaCorrente + " ]";
    }
    
}

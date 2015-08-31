/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.persistence.entities;

import br.com.erpweb.persistence.entities.Empresa;
import br.com.erpweb.persistence.entities.NotaFiscal;
import br.com.erpweb.persistence.entities.OrdemFaturamento;
import java.io.Serializable;
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
@Table(name = "EMPRESA_EMITENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpresaEmitente.findAll", query = "SELECT e FROM EmpresaEmitente e"),
    @NamedQuery(name = "EmpresaEmitente.findByIdEmpresaEmitente", query = "SELECT e FROM EmpresaEmitente e WHERE e.idEmpresaEmitente = :idEmpresaEmitente"),
    @NamedQuery(name = "EmpresaEmitente.findByNumeroNotaFiscal", query = "SELECT e FROM EmpresaEmitente e WHERE e.numeroNotaFiscal = :numeroNotaFiscal")})
public class EmpresaEmitente implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresaEmitente")
    private Collection<OrdemFaturamento> ordemFaturamentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresaEmitente")
    private Collection<NotaFiscal> notaFiscalCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEmpresaEmitente")
    private Integer idEmpresaEmitente;
    @Size(max = 5)
    @Column(name = "numeroNotaFiscal")
    private String numeroNotaFiscal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresaEmitente")
    private Collection<ContaCorrente> contaCorrenteCollection;
    @JoinColumn(name = "idAmbienteSEFAZ", referencedColumnName = "idAmbienteSEFAZ")
    @ManyToOne(optional = false)
    private AmbienteSefaz idAmbienteSEFAZ;
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEMPRESA")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;

    public EmpresaEmitente() {
    }

    public EmpresaEmitente(Integer idEmpresaEmitente) {
        this.idEmpresaEmitente = idEmpresaEmitente;
    }

    public Integer getIdEmpresaEmitente() {
        return idEmpresaEmitente;
    }

    public void setIdEmpresaEmitente(Integer idEmpresaEmitente) {
        this.idEmpresaEmitente = idEmpresaEmitente;
    }

    public String getNumeroNotaFiscal() {
        return numeroNotaFiscal;
    }

    public void setNumeroNotaFiscal(String numeroNotaFiscal) {
        this.numeroNotaFiscal = numeroNotaFiscal;
    }

    @XmlTransient
    public Collection<ContaCorrente> getContaCorrenteCollection() {
        return contaCorrenteCollection;
    }

    public void setContaCorrenteCollection(Collection<ContaCorrente> contaCorrenteCollection) {
        this.contaCorrenteCollection = contaCorrenteCollection;
    }

    public AmbienteSefaz getIdAmbienteSEFAZ() {
        return idAmbienteSEFAZ;
    }

    public void setIdAmbienteSEFAZ(AmbienteSefaz idAmbienteSEFAZ) {
        this.idAmbienteSEFAZ = idAmbienteSEFAZ;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresaEmitente != null ? idEmpresaEmitente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpresaEmitente)) {
            return false;
        }
        EmpresaEmitente other = (EmpresaEmitente) object;
        if ((this.idEmpresaEmitente == null && other.idEmpresaEmitente != null) || (this.idEmpresaEmitente != null && !this.idEmpresaEmitente.equals(other.idEmpresaEmitente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.exception.EmpresaEmitente[ idEmpresaEmitente=" + idEmpresaEmitente + " ]";
    }

    @XmlTransient
    public Collection<OrdemFaturamento> getOrdemFaturamentoCollection() {
        return ordemFaturamentoCollection;
    }

    public void setOrdemFaturamentoCollection(Collection<OrdemFaturamento> ordemFaturamentoCollection) {
        this.ordemFaturamentoCollection = ordemFaturamentoCollection;
    }

    @XmlTransient
    public Collection<NotaFiscal> getNotaFiscalCollection() {
        return notaFiscalCollection;
    }

    public void setNotaFiscalCollection(Collection<NotaFiscal> notaFiscalCollection) {
        this.notaFiscalCollection = notaFiscalCollection;
    }
    
}

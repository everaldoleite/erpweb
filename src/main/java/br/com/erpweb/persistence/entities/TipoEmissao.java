/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.persistence.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author everaldo
 */
@Entity
@Table(name = "TIPO_EMISSAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEmissao.findAll", query = "SELECT t FROM TipoEmissao t"),
    @NamedQuery(name = "TipoEmissao.findByIdTipoEmissao", query = "SELECT t FROM TipoEmissao t WHERE t.idTipoEmissao = :idTipoEmissao"),
    @NamedQuery(name = "TipoEmissao.findByCodigoFisco", query = "SELECT t FROM TipoEmissao t WHERE t.codigoFisco = :codigoFisco"),
    @NamedQuery(name = "TipoEmissao.findByDescricaoTipoEmissao", query = "SELECT t FROM TipoEmissao t WHERE t.descricaoTipoEmissao = :descricaoTipoEmissao")})
public class TipoEmissao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTipoEmissao")
    private Integer idTipoEmissao;
    @Column(name = "codigoFisco")
    private Integer codigoFisco;
    @Size(max = 45)
    @Column(name = "descricaoTipoEmissao")
    private String descricaoTipoEmissao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoEmissao")
    private Collection<NotaFiscal> notaFiscalCollection;

    public TipoEmissao() {
    }

    public TipoEmissao(Integer idTipoEmissao) {
        this.idTipoEmissao = idTipoEmissao;
    }

    public Integer getIdTipoEmissao() {
        return idTipoEmissao;
    }

    public void setIdTipoEmissao(Integer idTipoEmissao) {
        this.idTipoEmissao = idTipoEmissao;
    }

    public Integer getCodigoFisco() {
        return codigoFisco;
    }

    public void setCodigoFisco(Integer codigoFisco) {
        this.codigoFisco = codigoFisco;
    }

    public String getDescricaoTipoEmissao() {
        return descricaoTipoEmissao;
    }

    public void setDescricaoTipoEmissao(String descricaoTipoEmissao) {
        this.descricaoTipoEmissao = descricaoTipoEmissao;
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
        hash += (idTipoEmissao != null ? idTipoEmissao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEmissao)) {
            return false;
        }
        TipoEmissao other = (TipoEmissao) object;
        if ((this.idTipoEmissao == null && other.idTipoEmissao != null) || (this.idTipoEmissao != null && !this.idTipoEmissao.equals(other.idTipoEmissao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.TipoEmissao[ idTipoEmissao=" + idTipoEmissao + " ]";
    }
    
}

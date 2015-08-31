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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "FORMATO_IMPRESSAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormatoImpressao.findAll", query = "SELECT f FROM FormatoImpressao f"),
    @NamedQuery(name = "FormatoImpressao.findByIdFormatoImpressao", query = "SELECT f FROM FormatoImpressao f WHERE f.idFormatoImpressao = :idFormatoImpressao"),
    @NamedQuery(name = "FormatoImpressao.findByDescricaoFormatoImpressao", query = "SELECT f FROM FormatoImpressao f WHERE f.descricaoFormatoImpressao = :descricaoFormatoImpressao"),
    @NamedQuery(name = "FormatoImpressao.findByCodigoFisco", query = "SELECT f FROM FormatoImpressao f WHERE f.codigoFisco = :codigoFisco")})
public class FormatoImpressao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFormatoImpressao")
    private Integer idFormatoImpressao;
    @Size(max = 45)
    @Column(name = "descricaoFormatoImpressao")
    private String descricaoFormatoImpressao;
    @Column(name = "codigoFisco")
    private Integer codigoFisco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFormatoImpressao")
    private Collection<NotaFiscal> notaFiscalCollection;

    public FormatoImpressao() {
    }

    public FormatoImpressao(Integer idFormatoImpressao) {
        this.idFormatoImpressao = idFormatoImpressao;
    }

    public Integer getIdFormatoImpressao() {
        return idFormatoImpressao;
    }

    public void setIdFormatoImpressao(Integer idFormatoImpressao) {
        this.idFormatoImpressao = idFormatoImpressao;
    }

    public String getDescricaoFormatoImpressao() {
        return descricaoFormatoImpressao;
    }

    public void setDescricaoFormatoImpressao(String descricaoFormatoImpressao) {
        this.descricaoFormatoImpressao = descricaoFormatoImpressao;
    }

    public Integer getCodigoFisco() {
        return codigoFisco;
    }

    public void setCodigoFisco(Integer codigoFisco) {
        this.codigoFisco = codigoFisco;
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
        hash += (idFormatoImpressao != null ? idFormatoImpressao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormatoImpressao)) {
            return false;
        }
        FormatoImpressao other = (FormatoImpressao) object;
        if ((this.idFormatoImpressao == null && other.idFormatoImpressao != null) || (this.idFormatoImpressao != null && !this.idFormatoImpressao.equals(other.idFormatoImpressao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.FormatoImpressao[ idFormatoImpressao=" + idFormatoImpressao + " ]";
    }
    
}

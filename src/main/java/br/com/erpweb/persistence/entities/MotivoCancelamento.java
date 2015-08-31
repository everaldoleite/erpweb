/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.persistence.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "MOTIVO_CANCELAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MotivoCancelamento.findAll", query = "SELECT m FROM MotivoCancelamento m"),
    @NamedQuery(name = "MotivoCancelamento.findByIdmotivoCancelamento", query = "SELECT m FROM MotivoCancelamento m WHERE m.idmotivoCancelamento = :idmotivoCancelamento"),
    @NamedQuery(name = "MotivoCancelamento.findByDescricaoCancelamento", query = "SELECT m FROM MotivoCancelamento m WHERE m.descricaoCancelamento = :descricaoCancelamento")})
public class MotivoCancelamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmotivoCancelamento")
    private Integer idmotivoCancelamento;
    @Size(max = 45)
    @Column(name = "descricaoCancelamento")
    private String descricaoCancelamento;
    @OneToMany(mappedBy = "idmotivoCancelamento")
    private Collection<NotaFiscal> notaFiscalCollection;

    public MotivoCancelamento() {
    }

    public MotivoCancelamento(Integer idmotivoCancelamento) {
        this.idmotivoCancelamento = idmotivoCancelamento;
    }

    public Integer getIdmotivoCancelamento() {
        return idmotivoCancelamento;
    }

    public void setIdmotivoCancelamento(Integer idmotivoCancelamento) {
        this.idmotivoCancelamento = idmotivoCancelamento;
    }

    public String getDescricaoCancelamento() {
        return descricaoCancelamento;
    }

    public void setDescricaoCancelamento(String descricaoCancelamento) {
        this.descricaoCancelamento = descricaoCancelamento;
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
        hash += (idmotivoCancelamento != null ? idmotivoCancelamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MotivoCancelamento)) {
            return false;
        }
        MotivoCancelamento other = (MotivoCancelamento) object;
        if ((this.idmotivoCancelamento == null && other.idmotivoCancelamento != null) || (this.idmotivoCancelamento != null && !this.idmotivoCancelamento.equals(other.idmotivoCancelamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.MotivoCancelamento[ idmotivoCancelamento=" + idmotivoCancelamento + " ]";
    }
    
}

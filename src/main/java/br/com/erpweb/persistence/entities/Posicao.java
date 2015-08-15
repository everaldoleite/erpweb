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
@Table(name = "POSICAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Posicao.findAll", query = "SELECT p FROM Posicao p"),
    @NamedQuery(name = "Posicao.findByIdPosicao", query = "SELECT p FROM Posicao p WHERE p.idPosicao = :idPosicao"),
    @NamedQuery(name = "Posicao.findByDescricaoPosicao", query = "SELECT p FROM Posicao p WHERE p.descricaoPosicao = :descricaoPosicao")})
public class Posicao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPosicao")
    private Integer idPosicao;
    @Size(max = 45)
    @Column(name = "descricaoPosicao")
    private String descricaoPosicao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPosicao")
    private Collection<Contato> contatoCollection;

    public Posicao() {
    }

    public Posicao(Integer idPosicao) {
        this.idPosicao = idPosicao;
    }

    public Integer getIdPosicao() {
        return idPosicao;
    }

    public void setIdPosicao(Integer idPosicao) {
        this.idPosicao = idPosicao;
    }

    public String getDescricaoPosicao() {
        return descricaoPosicao;
    }

    public void setDescricaoPosicao(String descricaoPosicao) {
        this.descricaoPosicao = descricaoPosicao;
    }

    @XmlTransient
    public Collection<Contato> getContatoCollection() {
        return contatoCollection;
    }

    public void setContatoCollection(Collection<Contato> contatoCollection) {
        this.contatoCollection = contatoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPosicao != null ? idPosicao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Posicao)) {
            return false;
        }
        Posicao other = (Posicao) object;
        if ((this.idPosicao == null && other.idPosicao != null) || (this.idPosicao != null && !this.idPosicao.equals(other.idPosicao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.Posicao[ idPosicao=" + idPosicao + " ]";
    }
    
}

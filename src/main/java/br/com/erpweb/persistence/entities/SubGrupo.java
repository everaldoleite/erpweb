/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.persistence.entities;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author everaldo
 */
@Entity
@Table(name = "SUB_GRUPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubGrupo.findAll", query = "SELECT s FROM SubGrupo s"),
    @NamedQuery(name = "SubGrupo.findByIdSubGrupo", query = "SELECT s FROM SubGrupo s WHERE s.idSubGrupo = :idSubGrupo"),
    @NamedQuery(name = "SubGrupo.findByDescricaoSubGrupo", query = "SELECT s FROM SubGrupo s WHERE s.descricaoSubGrupo = :descricaoSubGrupo")})
public class SubGrupo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSubGrupo")
    private Integer idSubGrupo;
    @Size(max = 45)
    @Column(name = "descricaoSubGrupo")
    private String descricaoSubGrupo;
    @JoinColumn(name = "idGrupo", referencedColumnName = "idGrupo")
    @ManyToOne(optional = false)
    private Grupo idGrupo;

    public SubGrupo() {
    }

    public SubGrupo(Integer idSubGrupo) {
        this.idSubGrupo = idSubGrupo;
    }

    public Integer getIdSubGrupo() {
        return idSubGrupo;
    }

    public void setIdSubGrupo(Integer idSubGrupo) {
        this.idSubGrupo = idSubGrupo;
    }

    public String getDescricaoSubGrupo() {
        return descricaoSubGrupo;
    }

    public void setDescricaoSubGrupo(String descricaoSubGrupo) {
        this.descricaoSubGrupo = descricaoSubGrupo;
    }

    public Grupo getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Grupo idGrupo) {
        this.idGrupo = idGrupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubGrupo != null ? idSubGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubGrupo)) {
            return false;
        }
        SubGrupo other = (SubGrupo) object;
        if ((this.idSubGrupo == null && other.idSubGrupo != null) || (this.idSubGrupo != null && !this.idSubGrupo.equals(other.idSubGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.SubGrupo[ idSubGrupo=" + idSubGrupo + " ]";
    }
    
}

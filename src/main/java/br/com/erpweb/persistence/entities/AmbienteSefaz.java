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
@Table(name = "AMBIENTE_SEFAZ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbienteSefaz.findAll", query = "SELECT a FROM AmbienteSefaz a"),
    @NamedQuery(name = "AmbienteSefaz.findByIdAmbienteSEFAZ", query = "SELECT a FROM AmbienteSefaz a WHERE a.idAmbienteSEFAZ = :idAmbienteSEFAZ"),
    @NamedQuery(name = "AmbienteSefaz.findByTipoAmbiente", query = "SELECT a FROM AmbienteSefaz a WHERE a.tipoAmbiente = :tipoAmbiente"),
    @NamedQuery(name = "AmbienteSefaz.findByUrlAutorizacaoNFE", query = "SELECT a FROM AmbienteSefaz a WHERE a.urlAutorizacaoNFE = :urlAutorizacaoNFE"),
    @NamedQuery(name = "AmbienteSefaz.findByUrlRetornoAutorizacaoNFE", query = "SELECT a FROM AmbienteSefaz a WHERE a.urlRetornoAutorizacaoNFE = :urlRetornoAutorizacaoNFE"),
    @NamedQuery(name = "AmbienteSefaz.findByUrlCancelamento", query = "SELECT a FROM AmbienteSefaz a WHERE a.urlCancelamento = :urlCancelamento"),
    @NamedQuery(name = "AmbienteSefaz.findByUrlInutilizacao", query = "SELECT a FROM AmbienteSefaz a WHERE a.urlInutilizacao = :urlInutilizacao"),
    @NamedQuery(name = "AmbienteSefaz.findByUrlConsultaCadastro", query = "SELECT a FROM AmbienteSefaz a WHERE a.urlConsultaCadastro = :urlConsultaCadastro"),
    @NamedQuery(name = "AmbienteSefaz.findByUrlRecepcaoEvento", query = "SELECT a FROM AmbienteSefaz a WHERE a.urlRecepcaoEvento = :urlRecepcaoEvento"),
    @NamedQuery(name = "AmbienteSefaz.findByUrlStatusServico", query = "SELECT a FROM AmbienteSefaz a WHERE a.urlStatusServico = :urlStatusServico")})
public class AmbienteSefaz implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAmbienteSEFAZ")
    private Integer idAmbienteSEFAZ;
    @Column(name = "tipoAmbiente")
    private Character tipoAmbiente;
    @Size(max = 100)
    @Column(name = "urlAutorizacaoNFE")
    private String urlAutorizacaoNFE;
    @Size(max = 100)
    @Column(name = "urlRetornoAutorizacaoNFE")
    private String urlRetornoAutorizacaoNFE;
    @Size(max = 100)
    @Column(name = "urlCancelamento")
    private String urlCancelamento;
    @Size(max = 100)
    @Column(name = "urlInutilizacao")
    private String urlInutilizacao;
    @Size(max = 100)
    @Column(name = "urlConsultaCadastro")
    private String urlConsultaCadastro;
    @Size(max = 100)
    @Column(name = "urlRecepcaoEvento")
    private String urlRecepcaoEvento;
    @Size(max = 100)
    @Column(name = "urlStatusServico")
    private String urlStatusServico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAmbienteSEFAZ")
    private Collection<EmpresaEmitente> empresaEmitenteCollection;

    public AmbienteSefaz() {
    }

    public AmbienteSefaz(Integer idAmbienteSEFAZ) {
        this.idAmbienteSEFAZ = idAmbienteSEFAZ;
    }

    public Integer getIdAmbienteSEFAZ() {
        return idAmbienteSEFAZ;
    }

    public void setIdAmbienteSEFAZ(Integer idAmbienteSEFAZ) {
        this.idAmbienteSEFAZ = idAmbienteSEFAZ;
    }

    public Character getTipoAmbiente() {
        return tipoAmbiente;
    }

    public void setTipoAmbiente(Character tipoAmbiente) {
        this.tipoAmbiente = tipoAmbiente;
    }

    public String getUrlAutorizacaoNFE() {
        return urlAutorizacaoNFE;
    }

    public void setUrlAutorizacaoNFE(String urlAutorizacaoNFE) {
        this.urlAutorizacaoNFE = urlAutorizacaoNFE;
    }

    public String getUrlRetornoAutorizacaoNFE() {
        return urlRetornoAutorizacaoNFE;
    }

    public void setUrlRetornoAutorizacaoNFE(String urlRetornoAutorizacaoNFE) {
        this.urlRetornoAutorizacaoNFE = urlRetornoAutorizacaoNFE;
    }

    public String getUrlCancelamento() {
        return urlCancelamento;
    }

    public void setUrlCancelamento(String urlCancelamento) {
        this.urlCancelamento = urlCancelamento;
    }

    public String getUrlInutilizacao() {
        return urlInutilizacao;
    }

    public void setUrlInutilizacao(String urlInutilizacao) {
        this.urlInutilizacao = urlInutilizacao;
    }

    public String getUrlConsultaCadastro() {
        return urlConsultaCadastro;
    }

    public void setUrlConsultaCadastro(String urlConsultaCadastro) {
        this.urlConsultaCadastro = urlConsultaCadastro;
    }

    public String getUrlRecepcaoEvento() {
        return urlRecepcaoEvento;
    }

    public void setUrlRecepcaoEvento(String urlRecepcaoEvento) {
        this.urlRecepcaoEvento = urlRecepcaoEvento;
    }

    public String getUrlStatusServico() {
        return urlStatusServico;
    }

    public void setUrlStatusServico(String urlStatusServico) {
        this.urlStatusServico = urlStatusServico;
    }

    @XmlTransient
    public Collection<EmpresaEmitente> getEmpresaEmitenteCollection() {
        return empresaEmitenteCollection;
    }

    public void setEmpresaEmitenteCollection(Collection<EmpresaEmitente> empresaEmitenteCollection) {
        this.empresaEmitenteCollection = empresaEmitenteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAmbienteSEFAZ != null ? idAmbienteSEFAZ.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbienteSefaz)) {
            return false;
        }
        AmbienteSefaz other = (AmbienteSefaz) object;
        if ((this.idAmbienteSEFAZ == null && other.idAmbienteSEFAZ != null) || (this.idAmbienteSEFAZ != null && !this.idAmbienteSEFAZ.equals(other.idAmbienteSEFAZ))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.exception.AmbienteSefaz[ idAmbienteSEFAZ=" + idAmbienteSEFAZ + " ]";
    }
    
}

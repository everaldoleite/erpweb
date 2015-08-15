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
@Table(name = "EMPRESA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByIdEMPRESA", query = "SELECT e FROM Empresa e WHERE e.idEMPRESA = :idEMPRESA"),
    @NamedQuery(name = "Empresa.findByNomeRazaoSocial", query = "SELECT e FROM Empresa e WHERE e.nomeRazaoSocial = :nomeRazaoSocial"),
    @NamedQuery(name = "Empresa.findByDocumentoEmpresa", query = "SELECT e FROM Empresa e WHERE e.documentoEmpresa = :documentoEmpresa"),
    @NamedQuery(name = "Empresa.findByNomeFantasia", query = "SELECT e FROM Empresa e WHERE e.nomeFantasia = :nomeFantasia"),
    @NamedQuery(name = "Empresa.findByInscricaoEstadual", query = "SELECT e FROM Empresa e WHERE e.inscricaoEstadual = :inscricaoEstadual"),
    @NamedQuery(name = "Empresa.findByCnaeFiscal", query = "SELECT e FROM Empresa e WHERE e.cnaeFiscal = :cnaeFiscal"),
    @NamedQuery(name = "Empresa.findByRegimeTributario", query = "SELECT e FROM Empresa e WHERE e.regimeTributario = :regimeTributario"),
    @NamedQuery(name = "Empresa.findByLogradouroEmpresa", query = "SELECT e FROM Empresa e WHERE e.logradouroEmpresa = :logradouroEmpresa"),
    @NamedQuery(name = "Empresa.findByComplementoEmpresa", query = "SELECT e FROM Empresa e WHERE e.complementoEmpresa = :complementoEmpresa"),
    @NamedQuery(name = "Empresa.findByNumeroLogradouroEmpresa", query = "SELECT e FROM Empresa e WHERE e.numeroLogradouroEmpresa = :numeroLogradouroEmpresa"),
    @NamedQuery(name = "Empresa.findByPaisEmpresa", query = "SELECT e FROM Empresa e WHERE e.paisEmpresa = :paisEmpresa"),
    @NamedQuery(name = "Empresa.findByUfEmpresa", query = "SELECT e FROM Empresa e WHERE e.ufEmpresa = :ufEmpresa"),
    @NamedQuery(name = "Empresa.findByBairroEmpresa", query = "SELECT e FROM Empresa e WHERE e.bairroEmpresa = :bairroEmpresa"),
    @NamedQuery(name = "Empresa.findByCepEmpresa", query = "SELECT e FROM Empresa e WHERE e.cepEmpresa = :cepEmpresa"),
    @NamedQuery(name = "Empresa.findByTelefoneEmpresa", query = "SELECT e FROM Empresa e WHERE e.telefoneEmpresa = :telefoneEmpresa")})
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEMPRESA")
    private Integer idEMPRESA;
    @Size(max = 60)
    @Column(name = "nomeRazaoSocial")
    private String nomeRazaoSocial;
    @Size(max = 20)
    @Column(name = "documentoEmpresa")
    private String documentoEmpresa;
    @Size(max = 60)
    @Column(name = "nomeFantasia")
    private String nomeFantasia;
    @Size(max = 15)
    @Column(name = "inscricaoEstadual")
    private String inscricaoEstadual;
    @Size(max = 7)
    @Column(name = "cnaeFiscal")
    private String cnaeFiscal;
    @Column(name = "regimeTributario")
    private Character regimeTributario;
    @Size(max = 60)
    @Column(name = "logradouroEmpresa")
    private String logradouroEmpresa;
    @Size(max = 45)
    @Column(name = "complementoEmpresa")
    private String complementoEmpresa;
    @Size(max = 45)
    @Column(name = "numeroLogradouroEmpresa")
    private String numeroLogradouroEmpresa;
    @Size(max = 45)
    @Column(name = "paisEmpresa")
    private String paisEmpresa = "BRASIL";
    @Size(max = 45)
    @Column(name = "ufEmpresa")
    private String ufEmpresa;
    @Size(max = 45)
    @Column(name = "bairroEmpresa")
    private String bairroEmpresa;
    @Size(max = 45)
    @Column(name = "cepEmpresa")
    private String cepEmpresa;
    @Size(max = 45)
    @Column(name = "telefoneEmpresa")
    private String telefoneEmpresa;
    @JoinColumn(name = "idParametrosGerais", referencedColumnName = "idParametros")
    @ManyToOne(optional = true)
    private ParametrosGerais idParametrosGerais;
    @Column(name = "tipoPessoa")
    private Character tipoPessoa;
    @Size(max = 20)
    @Column(name = "inscricaoMunicipal")
    private String inscricaoMunicipal;
    @Size(max = 15)
    @Column(name = "inscricaoEstadualST")
    private String inscricaoEstadualST;
    @Size(max = 15)
    @Column(name = "tipoLogradouro")
    private String tipoLogradouro;
    @Size(max = 45)
    @Column(name = "municipioEmpresa")
    private String municipioEmpresa;
    
    @Size(max = 15)
    @Column(name = "cpfEmpresa")
    private String cpfEmpresa;
    
    @Size(max = 15)
    @Column(name = "rgEmpresa")
    private String rgEmpresa;

    @Size(max = 10)
    @Column(name = "codigoMunicipioIBGE")
    private String codigoMunicipioIBGE;

    private Character opcaoSimplesDANFE;
    
    @Column(name = "ufInscricaoEstadual")
    private String ufInscricaoEstadual;
    
    public Empresa() {
    }

    public Empresa(Integer idEMPRESA) {
        this.idEMPRESA = idEMPRESA;
    }

    public Integer getIdEMPRESA() {
        return idEMPRESA;
    }

    public void setIdEMPRESA(Integer idEMPRESA) {
        this.idEMPRESA = idEMPRESA;
    }

    public String getNomeRazaoSocial() {
        return nomeRazaoSocial;
    }

    public void setNomeRazaoSocial(String nomeRazaoSocial) {
        this.nomeRazaoSocial = nomeRazaoSocial;
    }

    public String getDocumentoEmpresa() {
        return documentoEmpresa;
    }

    public void setDocumentoEmpresa(String documentoEmpresa) {
        this.documentoEmpresa = documentoEmpresa;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getCnaeFiscal() {
        return cnaeFiscal;
    }

    public void setCnaeFiscal(String cnaeFiscal) {
        this.cnaeFiscal = cnaeFiscal;
    }

    public Character getRegimeTributario() {
        return regimeTributario;
    }

    public void setRegimeTributario(Character regimeTributario) {
        this.regimeTributario = regimeTributario;
    }

    public String getLogradouroEmpresa() {
        return logradouroEmpresa;
    }

    public void setLogradouroEmpresa(String logradouroEmpresa) {
        this.logradouroEmpresa = logradouroEmpresa;
    }

    public String getComplementoEmpresa() {
        return complementoEmpresa;
    }

    public void setComplementoEmpresa(String complementoEmpresa) {
        this.complementoEmpresa = complementoEmpresa;
    }

    public String getNumeroLogradouroEmpresa() {
        return numeroLogradouroEmpresa;
    }

    public void setNumeroLogradouroEmpresa(String numeroLogradouroEmpresa) {
        this.numeroLogradouroEmpresa = numeroLogradouroEmpresa;
    }

    public String getPaisEmpresa() {
        return paisEmpresa;
    }

    public void setPaisEmpresa(String paisEmpresa) {
        this.paisEmpresa = paisEmpresa;
    }

    public String getUfEmpresa() {
        return ufEmpresa;
    }

    public void setUfEmpresa(String ufEmpresa) {
        this.ufEmpresa = ufEmpresa;
    }

    public String getBairroEmpresa() {
        return bairroEmpresa;
    }

    public void setBairroEmpresa(String bairroEmpresa) {
        this.bairroEmpresa = bairroEmpresa;
    }

    public String getCepEmpresa() {
        return cepEmpresa;
    }

    public void setCepEmpresa(String cepEmpresa) {
        this.cepEmpresa = cepEmpresa;
    }

    public String getTelefoneEmpresa() {
        return telefoneEmpresa;
    }

    public void setTelefoneEmpresa(String telefoneEmpresa) {
        this.telefoneEmpresa = telefoneEmpresa;
    }

    public ParametrosGerais getIdParametrosGerais() {
        return idParametrosGerais;
    }

    public void setIdParametrosGerais(ParametrosGerais idParametrosGerais) {
        this.idParametrosGerais = idParametrosGerais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEMPRESA != null ? idEMPRESA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idEMPRESA == null && other.idEMPRESA != null) || (this.idEMPRESA != null && !this.idEMPRESA.equals(other.idEMPRESA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.Empresa[ idEMPRESA=" + idEMPRESA + " ]";
    }

    /**
     * @return the tipoPessoa
     */
    public Character getTipoPessoa() {
        return tipoPessoa;
    }

    /**
     * @param tipoPessoa the tipoPessoa to set
     */
    public void setTipoPessoa(Character tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    /**
     * @return the inscricaoMunicipal
     */
    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    /**
     * @param inscricaoMunicipal the inscricaoMunicipal to set
     */
    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    /**
     * @return the inscricaoEstadualST
     */
    public String getInscricaoEstadualST() {
        return inscricaoEstadualST;
    }

    /**
     * @param inscricaoEstadualST the inscricaoEstadualST to set
     */
    public void setInscricaoEstadualST(String inscricaoEstadualST) {
        this.inscricaoEstadualST = inscricaoEstadualST;
    }

    /**
     * @return the tipoLogradouro
     */
    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    /**
     * @param tipoLogradouro the tipoLogradouro to set
     */
    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    /**
     * @return the municipioEmpresa
     */
    public String getMunicipioEmpresa() {
        return municipioEmpresa;
    }

    /**
     * @param municipioEmpresa the municipioEmpresa to set
     */
    public void setMunicipioEmpresa(String municipioEmpresa) {
        this.municipioEmpresa = municipioEmpresa;
    }

    /**
     * @return the cpfEmpresa
     */
    public String getCpfEmpresa() {
        return cpfEmpresa;
    }

    /**
     * @param cpfEmpresa the cpfEmpresa to set
     */
    public void setCpfEmpresa(String cpfEmpresa) {
        this.cpfEmpresa = cpfEmpresa;
    }

    /**
     * @return the rgEmpresa
     */
    public String getRgEmpresa() {
        return rgEmpresa;
    }

    /**
     * @param rgEmpresa the rgEmpresa to set
     */
    public void setRgEmpresa(String rgEmpresa) {
        this.rgEmpresa = rgEmpresa;
    }

    /**
     * @return the codigoMunicipioIBGE
     */
    public String getCodigoMunicipioIBGE() {
        return codigoMunicipioIBGE;
    }

    /**
     * @param codigoMunicipioIBGE the codigoMunicipioIBGE to set
     */
    public void setCodigoMunicipioIBGE(String codigoMunicipioIBGE) {
        this.codigoMunicipioIBGE = codigoMunicipioIBGE;
    }

    /**
     * @return the opcaoSimplesDANFE
     */
    public Character getOpcaoSimplesDANFE() {
        return opcaoSimplesDANFE;
    }

    /**
     * @param opcaoSimplesDANFE the opcaoSimplesDANFE to set
     */
    public void setOpcaoSimplesDANFE(Character opcaoSimplesDANFE) {
        this.opcaoSimplesDANFE = opcaoSimplesDANFE;
    }

    /**
     * @return the ufInscricaoEstadual
     */
    public String getUfInscricaoEstadual() {
        return ufInscricaoEstadual;
    }

    /**
     * @param ufInscricaoEstadual the ufInscricaoEstadual to set
     */
    public void setUfInscricaoEstadual(String ufInscricaoEstadual) {
        this.ufInscricaoEstadual = ufInscricaoEstadual;
    }
    
}

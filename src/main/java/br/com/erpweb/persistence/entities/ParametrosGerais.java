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
@Table(name = "PARAMETROS_GERAIS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParametrosGerais.findAll", query = "SELECT p FROM ParametrosGerais p"),
    @NamedQuery(name = "ParametrosGerais.findByIdParametros", query = "SELECT p FROM ParametrosGerais p WHERE p.idParametros = :idParametros"),
    @NamedQuery(name = "ParametrosGerais.findByPrazoClienteNovo", query = "SELECT p FROM ParametrosGerais p WHERE p.prazoClienteNovo = :prazoClienteNovo"),
    @NamedQuery(name = "ParametrosGerais.findByPercentualComissao", query = "SELECT p FROM ParametrosGerais p WHERE p.percentualComissao = :percentualComissao"),
    @NamedQuery(name = "ParametrosGerais.findByCaminhoCertificadoCliente", query = "SELECT p FROM ParametrosGerais p WHERE p.caminhoCertificadoCliente = :caminhoCertificadoCliente"),
    @NamedQuery(name = "ParametrosGerais.findBySenhaCertificadoCliente", query = "SELECT p FROM ParametrosGerais p WHERE p.senhaCertificadoCliente = :senhaCertificadoCliente"),
    @NamedQuery(name = "ParametrosGerais.findByArquivoCertificados", query = "SELECT p FROM ParametrosGerais p WHERE p.arquivoCertificados = :arquivoCertificados"),
    @NamedQuery(name = "ParametrosGerais.findByVersaoDados", query = "SELECT p FROM ParametrosGerais p WHERE p.versaoDados = :versaoDados"),
    @NamedQuery(name = "ParametrosGerais.findByUnidadeFederativaSEFAZ", query = "SELECT p FROM ParametrosGerais p WHERE p.unidadeFederativaSEFAZ = :unidadeFederativaSEFAZ"),
    @NamedQuery(name = "ParametrosGerais.findByCodigoAdministrativoCORREIOS", query = "SELECT p FROM ParametrosGerais p WHERE p.codigoAdministrativoCORREIOS = :codigoAdministrativoCORREIOS"),
    @NamedQuery(name = "ParametrosGerais.findBySenhaServicoCORREIOS", query = "SELECT p FROM ParametrosGerais p WHERE p.senhaServicoCORREIOS = :senhaServicoCORREIOS"),
    @NamedQuery(name = "ParametrosGerais.findByCaminhoNotaFiscal", query = "SELECT p FROM ParametrosGerais p WHERE p.caminhoNotaFiscal = :caminhoNotaFiscal"),
    @NamedQuery(name = "ParametrosGerais.findByModeloNotaFiscal", query = "SELECT p FROM ParametrosGerais p WHERE p.modeloNotaFiscal = :modeloNotaFiscal"),
    @NamedQuery(name = "ParametrosGerais.findByAmbienteEmissaoNF", query = "SELECT p FROM ParametrosGerais p WHERE p.ambienteEmissaoNF = :ambienteEmissaoNF"),
    @NamedQuery(name = "ParametrosGerais.findBySaldoInicial", query = "SELECT p FROM ParametrosGerais p WHERE p.saldoInicial = :saldoInicial"),
    @NamedQuery(name = "ParametrosGerais.findBySla", query = "SELECT p FROM ParametrosGerais p WHERE p.sla = :sla")})
public class ParametrosGerais implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idParametros")
    private Integer idParametros;
    
    @Column(name = "prazoClienteNovo")
    private Short prazoClienteNovo;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "percentualComissao")
    private BigDecimal percentualComissao;
    
    @Size(max = 100)
    @Column(name = "caminhoCertificadoCliente")
    private String caminhoCertificadoCliente;
    
    @Size(max = 100)
    @Column(name = "senhaCertificadoCliente")
    private String senhaCertificadoCliente;
    
    @Size(max = 100)
    @Column(name = "arquivoCertificados")
    private String arquivoCertificados;
    
    @Size(max = 100)
    @Column(name = "versaoDados")
    private String versaoDados;
    @Size(max = 2)
    @Column(name = "unidadeFederativaSEFAZ")
    private String unidadeFederativaSEFAZ;
    @Size(max = 45)
    @Column(name = "codigoAdministrativoCORREIOS")
    private String codigoAdministrativoCORREIOS;
    @Size(max = 45)
    @Column(name = "senhaServicoCORREIOS")
    private String senhaServicoCORREIOS;
    @Size(max = 100)
    @Column(name = "caminhoNotaFiscal")
    private String caminhoNotaFiscal;
    @Size(max = 2)
    @Column(name = "modeloNotaFiscal")
    private String modeloNotaFiscal;
    @Column(name = "ambienteEmissaoNF")
    private Integer ambienteEmissaoNF;
    @Column(name = "saldoInicial")
    private BigDecimal saldoInicial;
    @Column(name = "sla")
    private Character sla;

    public ParametrosGerais() {
    }

    public ParametrosGerais(Integer idParametros) {
        this.idParametros = idParametros;
    }

    public Integer getIdParametros() {
        return idParametros;
    }

    public void setIdParametros(Integer idParametros) {
        this.idParametros = idParametros;
    }

    public Short getPrazoClienteNovo() {
        return prazoClienteNovo;
    }

    public void setPrazoClienteNovo(Short prazoClienteNovo) {
        this.prazoClienteNovo = prazoClienteNovo;
    }

    public BigDecimal getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(BigDecimal percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    public String getCaminhoCertificadoCliente() {
        return caminhoCertificadoCliente;
    }

    public void setCaminhoCertificadoCliente(String caminhoCertificadoCliente) {
        this.caminhoCertificadoCliente = caminhoCertificadoCliente;
    }

    public String getSenhaCertificadoCliente() {
        return senhaCertificadoCliente;
    }

    public void setSenhaCertificadoCliente(String senhaCertificadoCliente) {
        this.senhaCertificadoCliente = senhaCertificadoCliente;
    }

    public String getArquivoCertificados() {
        return arquivoCertificados;
    }

    public void setArquivoCertificados(String arquivoCertificados) {
        this.arquivoCertificados = arquivoCertificados;
    }

    public String getVersaoDados() {
        return versaoDados;
    }

    public void setVersaoDados(String versaoDados) {
        this.versaoDados = versaoDados;
    }

    public String getUnidadeFederativaSEFAZ() {
        return unidadeFederativaSEFAZ;
    }

    public void setUnidadeFederativaSEFAZ(String unidadeFederativaSEFAZ) {
        this.unidadeFederativaSEFAZ = unidadeFederativaSEFAZ;
    }

    public String getCodigoAdministrativoCORREIOS() {
        return codigoAdministrativoCORREIOS;
    }

    public void setCodigoAdministrativoCORREIOS(String codigoAdministrativoCORREIOS) {
        this.codigoAdministrativoCORREIOS = codigoAdministrativoCORREIOS;
    }

    public String getSenhaServicoCORREIOS() {
        return senhaServicoCORREIOS;
    }

    public void setSenhaServicoCORREIOS(String senhaServicoCORREIOS) {
        this.senhaServicoCORREIOS = senhaServicoCORREIOS;
    }

    public String getCaminhoNotaFiscal() {
        return caminhoNotaFiscal;
    }

    public void setCaminhoNotaFiscal(String caminhoNotaFiscal) {
        this.caminhoNotaFiscal = caminhoNotaFiscal;
    }

    public String getModeloNotaFiscal() {
        return modeloNotaFiscal;
    }

    public void setModeloNotaFiscal(String modeloNotaFiscal) {
        this.modeloNotaFiscal = modeloNotaFiscal;
    }

    public Integer getAmbienteEmissaoNF() {
        return ambienteEmissaoNF;
    }

    public void setAmbienteEmissaoNF(Integer ambienteEmissaoNF) {
        this.ambienteEmissaoNF = ambienteEmissaoNF;
    }

    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Character getSla() {
        return sla;
    }

    public void setSla(Character sla) {
        this.sla = sla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParametros != null ? idParametros.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParametrosGerais)) {
            return false;
        }
        ParametrosGerais other = (ParametrosGerais) object;
        if ((this.idParametros == null && other.idParametros != null) || (this.idParametros != null && !this.idParametros.equals(other.idParametros))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.ParametrosGerais[ idParametros=" + idParametros + " ]";
    }
    
}

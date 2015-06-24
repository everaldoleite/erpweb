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
@Table(name = "LOCALIDADE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localidade.findAll", query = "SELECT l FROM Localidade l"),
    @NamedQuery(name = "Localidade.findByIdLocalidade", query = "SELECT l FROM Localidade l WHERE l.idLocalidade = :idLocalidade"),
    @NamedQuery(name = "Localidade.findByCep", query = "SELECT l FROM Localidade l WHERE l.cep = :cep"),
    @NamedQuery(name = "Localidade.findByTipoLogradouro", query = "SELECT l FROM Localidade l WHERE l.tipoLogradouro = :tipoLogradouro"),
    @NamedQuery(name = "Localidade.findByLogradouro", query = "SELECT l FROM Localidade l WHERE l.logradouro = :logradouro"),
    @NamedQuery(name = "Localidade.findByNumero", query = "SELECT l FROM Localidade l WHERE l.numero = :numero"),
    @NamedQuery(name = "Localidade.findByBairro", query = "SELECT l FROM Localidade l WHERE l.bairro = :bairro"),
    @NamedQuery(name = "Localidade.findByCidade", query = "SELECT l FROM Localidade l WHERE l.cidade = :cidade"),
    @NamedQuery(name = "Localidade.findByUf", query = "SELECT l FROM Localidade l WHERE l.uf = :uf")})
public class Localidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLocalidade")
    private Integer idLocalidade;
    @Size(max = 8)
    @Column(name = "cep")
    private String cep;
    @Size(max = 20)
    @Column(name = "tipoLogradouro")
    private String tipoLogradouro;
    @Size(max = 45)
    @Column(name = "logradouro")
    private String logradouro;
    @Size(max = 5)
    @Column(name = "numero")
    private String numero;
    @Size(max = 30)
    @Column(name = "bairro")
    private String bairro;
    @Size(max = 30)
    @Column(name = "cidade")
    private String cidade;
    @Size(max = 2)
    @Column(name = "uf")
    private String uf;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEnderecoEntrega")
    private Collection<Cliente> clienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEnderecoCobranca")
    private Collection<Cliente> clienteCollection1;

    public Localidade() {
    }

    public Localidade(Integer idLocalidade) {
        this.idLocalidade = idLocalidade;
    }

    public Integer getIdLocalidade() {
        return idLocalidade;
    }

    public void setIdLocalidade(Integer idLocalidade) {
        this.idLocalidade = idLocalidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection1() {
        return clienteCollection1;
    }

    public void setClienteCollection1(Collection<Cliente> clienteCollection1) {
        this.clienteCollection1 = clienteCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocalidade != null ? idLocalidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localidade)) {
            return false;
        }
        Localidade other = (Localidade) object;
        if ((this.idLocalidade == null && other.idLocalidade != null) || (this.idLocalidade != null && !this.idLocalidade.equals(other.idLocalidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.Localidade[ idLocalidade=" + idLocalidade + " ]";
    }
    
}

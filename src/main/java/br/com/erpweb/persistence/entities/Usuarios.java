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
@Table(name = "USUARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByIdUsuario", query = "SELECT u FROM Usuarios u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuarios.findByEmail", query = "SELECT u FROM Usuarios u WHERE u.email = :email"),
    @NamedQuery(name = "Usuarios.findByFirstName", query = "SELECT u FROM Usuarios u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "Usuarios.findByLastName", query = "SELECT u FROM Usuarios u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "Usuarios.findByPassword", query = "SELECT u FROM Usuarios u WHERE u.password = :password"),
    @NamedQuery(name = "Usuarios.findByUsername", query = "SELECT u FROM Usuarios u WHERE u.username = :username"),
    @NamedQuery(name = "Usuarios.findByEtapa", query = "SELECT u FROM Usuarios u WHERE u.etapa = :etapa")})
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuario")
    private Integer idUsuario;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "firstName")
    private String firstName;
    @Size(max = 45)
    @Column(name = "lastName")
    private String lastName;
    @Size(max = 64)
    @Column(name = "password")
    private String password;
    @Size(max = 45)
    @Column(name = "username")
    private String username;
    @Size(max = 45)
    @Column(name = "etapa")
    private String etapa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioAbertura")
    private Collection<OrdemFaturamento> ordemFaturamentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioExpedicao")
    private Collection<OrdemFaturamento> ordemFaturamentoCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioSeparador")
    private Collection<OrdemFaturamento> ordemFaturamentoCollection2;
    @JoinColumn(name = "idLocalidade", referencedColumnName = "idLocalidade")
    @ManyToOne(optional = false)
    private Localidade idLocalidade;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    @XmlTransient
    public Collection<OrdemFaturamento> getOrdemFaturamentoCollection() {
        return ordemFaturamentoCollection;
    }

    public void setOrdemFaturamentoCollection(Collection<OrdemFaturamento> ordemFaturamentoCollection) {
        this.ordemFaturamentoCollection = ordemFaturamentoCollection;
    }

    @XmlTransient
    public Collection<OrdemFaturamento> getOrdemFaturamentoCollection1() {
        return ordemFaturamentoCollection1;
    }

    public void setOrdemFaturamentoCollection1(Collection<OrdemFaturamento> ordemFaturamentoCollection1) {
        this.ordemFaturamentoCollection1 = ordemFaturamentoCollection1;
    }

    @XmlTransient
    public Collection<OrdemFaturamento> getOrdemFaturamentoCollection2() {
        return ordemFaturamentoCollection2;
    }

    public void setOrdemFaturamentoCollection2(Collection<OrdemFaturamento> ordemFaturamentoCollection2) {
        this.ordemFaturamentoCollection2 = ordemFaturamentoCollection2;
    }

    public Localidade getIdLocalidade() {
        return idLocalidade;
    }

    public void setIdLocalidade(Localidade idLocalidade) {
        this.idLocalidade = idLocalidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.Usuarios[ idUsuario=" + idUsuario + " ]";
    }
    
}

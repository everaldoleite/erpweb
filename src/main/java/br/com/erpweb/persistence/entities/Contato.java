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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author everaldo
 */
@Entity
@Table(name = "CONTATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contato.findAll", query = "SELECT c FROM Contato c"),
    @NamedQuery(name = "Contato.findByIdCONTATO", query = "SELECT c FROM Contato c WHERE c.idContato = :idContato"),
    @NamedQuery(name = "Contato.findByCodigoCliente", query = "SELECT c FROM Contato c WHERE c.codigoCliente = :codigoCliente"),
    @NamedQuery(name = "Contato.findByEmail", query = "SELECT c FROM Contato c WHERE c.email = :email"),
    @NamedQuery(name = "Contato.findByCelular", query = "SELECT c FROM Contato c WHERE c.celular = :celular"),
    @NamedQuery(name = "Contato.findByNome", query = "SELECT c FROM Contato c WHERE c.nome = :nome"),
    @NamedQuery(name = "Contato.findByRamal", query = "SELECT c FROM Contato c WHERE c.ramal = :ramal"),
    @NamedQuery(name = "Contato.findByDepartamento", query = "SELECT c FROM Contato c WHERE c.departamento = :departamento"),
    @NamedQuery(name = "Contato.findByTipoTratamento", query = "SELECT c FROM Contato c WHERE c.tipoTratamento = :tipoTratamento"),
    @NamedQuery(name = "Contato.findByDiaAniversario", query = "SELECT c FROM Contato c WHERE c.diaAniversario = :diaAniversario"),
    @NamedQuery(name = "Contato.findByTelefone", query = "SELECT c FROM Contato c WHERE c.telefone = :telefone"),
    @NamedQuery(name = "Contato.findByMesAniversario", query = "SELECT c FROM Contato c WHERE c.mesAniversario = :mesAniversario"),
    @NamedQuery(name = "Contato.findByCpf", query = "SELECT c FROM Contato c WHERE c.cpf = :cpf"),
    @NamedQuery(name = "Contato.findByPosicao", query = "SELECT c FROM Contato c WHERE c.posicao = :posicao"),
    @NamedQuery(name = "Contato.findByArea", query = "SELECT c FROM Contato c WHERE c.area = :area"),
    @NamedQuery(name = "Contato.findByOpcaoRecepcaoEmail", query = "SELECT c FROM Contato c WHERE c.opcaoRecepcaoEmail = :opcaoRecepcaoEmail")})
public class Contato implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContato")
    private Collection<PedidoVenda> pedidoVendaCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idContato")
    private Integer idContato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoCliente")
    private int codigoCliente;
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 20)
    @Column(name = "celular")
    private String celular;
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
    @Size(max = 6)
    @Column(name = "ramal")
    private String ramal;
    @Size(max = 45)
    @Column(name = "departamento")
    private String departamento;
    @Size(max = 5)
    @Column(name = "tipoTratamento")
    private String tipoTratamento;
    @Column(name = "diaAniversario")
    private Integer diaAniversario;
    @Size(max = 20)
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "mesAniversario")
    private Integer mesAniversario;
    @Size(max = 11)
    @Column(name = "cpf")
    private String cpf;
    @Size(max = 45)
    @Column(name = "posicao")
    private String posicao;
    @Size(max = 45)
    @Column(name = "area")
    private String area;
    @Column(name = "opcaoRecepcaoEmail")
    private Character opcaoRecepcaoEmail;
    @JoinColumn(name = "idArea", referencedColumnName = "idArea")
    @ManyToOne(optional = false)
    private Area idArea;
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "idPosicao", referencedColumnName = "idPosicao")
    @ManyToOne(optional = false)
    private Posicao idPosicao;

    public Contato() {
    }

    public Contato(Integer idContato) {
        this.idContato = idContato;
    }

    public Contato(Integer idContato, int codigoCliente) {
        this.idContato = idContato;
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTipoTratamento() {
        return tipoTratamento;
    }

    public void setTipoTratamento(String tipoTratamento) {
        this.tipoTratamento = tipoTratamento;
    }

    public Integer getDiaAniversario() {
        return diaAniversario;
    }

    public void setDiaAniversario(Integer diaAniversario) {
        this.diaAniversario = diaAniversario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getMesAniversario() {
        return mesAniversario;
    }

    public void setMesAniversario(Integer mesAniversario) {
        this.mesAniversario = mesAniversario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Character getOpcaoRecepcaoEmail() {
        return opcaoRecepcaoEmail;
    }

    public void setOpcaoRecepcaoEmail(Character opcaoRecepcaoEmail) {
        this.opcaoRecepcaoEmail = opcaoRecepcaoEmail;
    }

    public Area getIdArea() {
        return idArea;
    }

    public void setIdArea(Area idArea) {
        this.idArea = idArea;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Posicao getIdPosicao() {
        return idPosicao;
    }

    public void setIdPosicao(Posicao idPosicao) {
        this.idPosicao = idPosicao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContato != null ? idContato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contato)) {
            return false;
        }
        Contato other = (Contato) object;
        if ((this.idContato == null && other.idContato != null) || (this.idContato != null && !this.idContato.equals(other.idContato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.erpweb.persistence.entities.Contato[ idCONTATO=" + idContato + " ]";
    }

    @XmlTransient
    public Collection<PedidoVenda> getPedidoVendaCollection() {
        return pedidoVendaCollection;
    }

    public void setPedidoVendaCollection(Collection<PedidoVenda> pedidoVendaCollection) {
        this.pedidoVendaCollection = pedidoVendaCollection;
    }

    /**
     * @return the idContato
     */
    public Integer getIdContato() {
        return idContato;
    }

    /**
     * @param idContato the idContato to set
     */
    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }
    
}

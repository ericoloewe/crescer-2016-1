/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Érico de Souza Loewe
 */
@Entity
@Table(name = "PEDIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findByIdpedido", query = "SELECT p FROM Pedido p WHERE p.idpedido = :idpedido"),
    @NamedQuery(name = "Pedido.findByDatapedido", query = "SELECT p FROM Pedido p WHERE p.datapedido = :datapedido"),
    @NamedQuery(name = "Pedido.findByDataentrega", query = "SELECT p FROM Pedido p WHERE p.dataentrega = :dataentrega"),
    @NamedQuery(name = "Pedido.findByValorpedido", query = "SELECT p FROM Pedido p WHERE p.valorpedido = :valorpedido"),
    @NamedQuery(name = "Pedido.findBySituacao", query = "SELECT p FROM Pedido p WHERE p.situacao = :situacao")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDPEDIDO")
    private BigDecimal idpedido;
    @Basic(optional = false)
    @Column(name = "DATAPEDIDO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datapedido;
    @Column(name = "DATAENTREGA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataentrega;
    @Basic(optional = false)
    @Column(name = "VALORPEDIDO")
    private BigDecimal valorpedido;
    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private Character situacao;
    @JoinColumn(name = "IDCLIENTE", referencedColumnName = "IDCLIENTE")
    @ManyToOne(optional = false)
    private Cliente idcliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpedido")
    private List<Pedidoitem> pedidoitemList;

    public Pedido() {
    }

    public Pedido(BigDecimal idpedido) {
        this.idpedido = idpedido;
    }

    public Pedido(BigDecimal idpedido, Date datapedido, BigDecimal valorpedido, Character situacao) {
        this.idpedido = idpedido;
        this.datapedido = datapedido;
        this.valorpedido = valorpedido;
        this.situacao = situacao;
    }

    public BigDecimal getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(BigDecimal idpedido) {
        this.idpedido = idpedido;
    }

    public Date getDatapedido() {
        return datapedido;
    }

    public void setDatapedido(Date datapedido) {
        this.datapedido = datapedido;
    }

    public Date getDataentrega() {
        return dataentrega;
    }

    public void setDataentrega(Date dataentrega) {
        this.dataentrega = dataentrega;
    }

    public BigDecimal getValorpedido() {
        return valorpedido;
    }

    public void setValorpedido(BigDecimal valorpedido) {
        this.valorpedido = valorpedido;
    }

    public Character getSituacao() {
        return situacao;
    }

    public void setSituacao(Character situacao) {
        this.situacao = situacao;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    @XmlTransient
    public List<Pedidoitem> getPedidoitemList() {
        return pedidoitemList;
    }

    public void setPedidoitemList(List<Pedidoitem> pedidoitemList) {
        this.pedidoitemList = pedidoitemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpedido != null ? idpedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idpedido == null && other.idpedido != null) || (this.idpedido != null && !this.idpedido.equals(other.idpedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.cwi.crescer.entity.Pedido[ idpedido=" + idpedido + " ]";
    }
    
}

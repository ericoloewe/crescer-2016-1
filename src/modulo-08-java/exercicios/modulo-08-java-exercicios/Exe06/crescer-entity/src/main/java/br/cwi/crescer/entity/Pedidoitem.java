/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Érico de Souza Loewe
 */
@Entity
@Table(name = "PEDIDOITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedidoitem.findAll", query = "SELECT p FROM Pedidoitem p"),
    @NamedQuery(name = "Pedidoitem.findByIdpedidoitem", query = "SELECT p FROM Pedidoitem p WHERE p.idpedidoitem = :idpedidoitem"),
    @NamedQuery(name = "Pedidoitem.findByQuantidade", query = "SELECT p FROM Pedidoitem p WHERE p.quantidade = :quantidade"),
    @NamedQuery(name = "Pedidoitem.findByPrecounitario", query = "SELECT p FROM Pedidoitem p WHERE p.precounitario = :precounitario"),
    @NamedQuery(name = "Pedidoitem.findBySituacao", query = "SELECT p FROM Pedidoitem p WHERE p.situacao = :situacao")})
public class Pedidoitem implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDPEDIDOITEM")
    private BigDecimal idpedidoitem;
    @Basic(optional = false)
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Basic(optional = false)
    @Column(name = "PRECOUNITARIO")
    private BigDecimal precounitario;
    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private Character situacao;
    @JoinColumn(name = "IDPEDIDO", referencedColumnName = "IDPEDIDO")
    @ManyToOne(optional = false)
    private Pedido idpedido;
    @JoinColumn(name = "IDPRODUTO", referencedColumnName = "IDPRODUTO")
    @ManyToOne
    private Produto idproduto;

    public Pedidoitem() {
    }

    public Pedidoitem(BigDecimal idpedidoitem) {
        this.idpedidoitem = idpedidoitem;
    }

    public Pedidoitem(BigDecimal idpedidoitem, BigDecimal quantidade, BigDecimal precounitario, Character situacao) {
        this.idpedidoitem = idpedidoitem;
        this.quantidade = quantidade;
        this.precounitario = precounitario;
        this.situacao = situacao;
    }

    public BigDecimal getIdpedidoitem() {
        return idpedidoitem;
    }

    public void setIdpedidoitem(BigDecimal idpedidoitem) {
        this.idpedidoitem = idpedidoitem;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecounitario() {
        return precounitario;
    }

    public void setPrecounitario(BigDecimal precounitario) {
        this.precounitario = precounitario;
    }

    public Character getSituacao() {
        return situacao;
    }

    public void setSituacao(Character situacao) {
        this.situacao = situacao;
    }

    public Pedido getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Pedido idpedido) {
        this.idpedido = idpedido;
    }

    public Produto getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(Produto idproduto) {
        this.idproduto = idproduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpedidoitem != null ? idpedidoitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidoitem)) {
            return false;
        }
        Pedidoitem other = (Pedidoitem) object;
        if ((this.idpedidoitem == null && other.idpedidoitem != null) || (this.idpedidoitem != null && !this.idpedidoitem.equals(other.idpedidoitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.cwi.crescer.entity.Pedidoitem[ idpedidoitem=" + idpedidoitem + " ]";
    }
    
}

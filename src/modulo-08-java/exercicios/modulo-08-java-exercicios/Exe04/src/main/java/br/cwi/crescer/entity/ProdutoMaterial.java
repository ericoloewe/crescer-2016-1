/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Érico de Souza Loewe
 */
@Entity
@Table(name = "PRODUTOMATERIAL")
public class ProdutoMaterial implements Serializable {
    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_PRODUTOMATERIAL")
    @SequenceGenerator(name = "SEQ_PRODUTOMATERIAL", sequenceName = "SEQ_PRODUTOMATERIAL", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDPRODUTOMATERIAL")
    private Long id;
    
    @ManyToOne
    @Basic(optional = false)
    @JoinColumn(name = "IDPRODUTO")
    private Produto produto;
    
    @ManyToOne
    @Basic(optional = false)
    @JoinColumn(name = "IDMATERIAL")
    private Material material;
    
    @Basic(optional = false)
    @Column(name = "QUANTIDADE")
    private Integer quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}

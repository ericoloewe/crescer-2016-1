/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.entity;

import java.util.Date;
import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

/**
 *
 * @author erico.loewe
 */
@Entity
@Table(name = "PUBLICACAO")
public class Publicacao {
    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_PUBLICACAO")
    @SequenceGenerator(name = "SEQ_PUBLICACAO", sequenceName = "SEQ_PUBLICACAO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "CONTEUDO")
    private String conteudo;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_HORA")
    private Date dataHora;
    
    @ManyToOne
    @JoinColumn(name = "ID")
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

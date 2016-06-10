/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.entity;

import java.util.Date;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.*;

/**
 *
 * @author erico.loewe
 */
@Entity
@Table(name = "AMIGO_USUARIO")
public class Amigo {
    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_AMIGO_USUARIO")
    @SequenceGenerator(name = "SEQ_AMIGO_USUARIO", sequenceName = "SEQ_AMIGO_USUARIO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "ID_AMIGO")
    private Usuario amigo;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "INICIO_AMIZADE")
    private Date inicioAmizade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getAmigo() {
        return amigo;
    }

    public void setAmigo(Usuario amigo) {
        this.amigo = amigo;
    }

    public Date getInicioAmizade() {
        return inicioAmizade;
    }

    public void setInicioAmizade(Date inicioAmizade) {
        this.inicioAmizade = inicioAmizade;
    }
}
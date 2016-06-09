/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.model;

/**
 *
 * @author erico.loewe
 */
public class Pessoa {    
    public Long Id;
    public String Nome;
    
    public Pessoa(Long Id, String Nome) {
        this.Id = Id;
        this.Nome = Nome;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer;

import br.cwi.crescer.model.Pessoa;
import br.cwi.crescer.repositorio.PessoaRepositorio;
import br.cwi.crescer.util.ConnectionUtils;
import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author erico.loewe
 */
public class Run {
    private static final Logger LOGGER = Logger.getLogger(Run.class);
    
    public static void main(String[] args) {        
        PessoaRepositorio _repositorio = new PessoaRepositorio();
        _repositorio.delete(new Pessoa(1l, "Érico de Souza Loewe"));
        System.out.println("Deletou");
        _repositorio.insert(new Pessoa(1l, "Érico"));
        System.out.println("Inseriu");
        _repositorio.update(new Pessoa(1l, "Érico de Souza Loewe"));
        System.out.println("Atualizou");
        _repositorio.findNome("Érico de Souza Loewe").forEach(p -> {System.out.println(p.getNome());});
        System.out.println("Buscou por nome");
        _repositorio.listAll().forEach(p -> {System.out.println(p.getNome());});
        System.out.println("Buscou tudo");
    }
}

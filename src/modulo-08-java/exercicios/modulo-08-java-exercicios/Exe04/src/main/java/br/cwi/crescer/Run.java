/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer;

import br.cwi.crescer.entity.Pessoa;
import br.cwi.crescer.repositorio.*;

/**
 *
 * @author Érico de Souza Loewe
 */
public class Run {
    public static void main(String[] args) {
        PessoaRepositorio repo = new PessoaRepositorio();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Teste");
//        repo.adicionar(pessoa);
        repo.exportarDadosCsv(Pessoa.class, "teste.csv");
    }
}

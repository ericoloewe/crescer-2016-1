/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.repositorio;

import br.cwi.crescer.entity.Pessoa;
import java.util.List;

/**
 *
 * @author Érico de Souza Loewe
 */
public class PessoaRepositorio extends RepositorioBase<Pessoa> implements Repositorio<Pessoa> {

    public void adicionar(Pessoa pessoa) {
        super.adicionar(pessoa);
    }

    public void atualizar(Pessoa pessoa) {
        super.atualizar(pessoa);
    }

    public void deletar(Long pessoa) {
        super.deletar(pessoa);
    }

    public List<Pessoa> listar() {       
        return super.listar("Pessoa");
    }
}

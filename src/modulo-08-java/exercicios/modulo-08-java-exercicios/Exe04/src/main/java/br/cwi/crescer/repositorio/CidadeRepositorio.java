/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.repositorio;

import br.cwi.crescer.entity.Cidade;
import java.util.List;

/**
 *
 * @author Érico de Souza Loewe
 */
public class CidadeRepositorio extends RepositorioBase<Cidade> implements Repositorio<Cidade> {
    
    public void adicionar(Cidade cidade) {
        super.adicionar(cidade);
    }

    public void atualizar(Cidade cidade) {
        super.atualizar(cidade);
    }

    public void deletar(Long cidadeId) {
        super.deletar(cidadeId);
    }

    public List<Cidade> listar() {
        return super.listar("Cidade");
    }
}
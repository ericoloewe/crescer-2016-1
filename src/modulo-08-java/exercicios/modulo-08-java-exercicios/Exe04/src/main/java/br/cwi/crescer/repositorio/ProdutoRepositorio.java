/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.repositorio;

import br.cwi.crescer.entity.Produto;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Érico de Souza Loewe
 */
public class ProdutoRepositorio extends RepositorioBase<Produto> implements Repositorio<Produto> {

    public void adicionar(Produto produto) {
        super.adicionar(produto);
    }

    public void atualizar(Produto produto) {
        super.atualizar(produto);
    }

    public void deletar(Long idProduto) {
        super.deletar(idProduto);
    }

    public List<Produto> listar() {
        return super.listar("Produto");
    }
}

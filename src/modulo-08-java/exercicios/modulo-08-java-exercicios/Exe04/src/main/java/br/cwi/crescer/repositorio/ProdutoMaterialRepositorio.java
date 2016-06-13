/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.repositorio;

import br.cwi.crescer.entity.ProdutoMaterial;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Érico de Souza Loewe
 */
public class ProdutoMaterialRepositorio extends RepositorioBase<ProdutoMaterial> implements Repositorio<ProdutoMaterial> {

    public void adicionar(ProdutoMaterial produtoMaterial) {
        super.adicionar(produtoMaterial);
    }

    public void atualizar(ProdutoMaterial produtoMaterial) {
        super.atualizar(produtoMaterial);
    }

    public void deletar(Long idProdutoMaterial) {
        super.deletar(idProdutoMaterial);
    }

    public List<ProdutoMaterial> listar() {
        return super.listar("ProdutoMaterial");
    }
}

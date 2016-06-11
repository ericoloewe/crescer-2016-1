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
public class ProdutoMaterialRepositorio implements Repositorio<ProdutoMaterial> {

    @Override
    public Long adicionar(ProdutoMaterial produtoMaterial) {
        DbConnection.conectar();
        Session session = DbConnection.getEntityManager().unwrap(Session.class);
        session.save(produtoMaterial);
        DbConnection.desconectar();
        return produtoMaterial.getId();
    }

    @Override
    public void atualizar(ProdutoMaterial obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Long obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProdutoMaterial> listar() {
        List<ProdutoMaterial> produtoMateriais;
        DbConnection.conectar();
        Session session = DbConnection.getEntityManager().unwrap(Session.class);
        Query query = session.createQuery("select p from ProdutoMaterial p");
        produtoMateriais = query.list();
        DbConnection.desconectar();
        
        return produtoMateriais;
    }
}

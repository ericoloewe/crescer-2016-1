/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.repositorio;

import br.cwi.crescer.entity.Material;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Érico de Souza Loewe
 */
public class MaterialRepositorio implements Repositorio<Material> {

    @Override
    public Long adicionar(Material material) {
        DbConnection.conectar();
        Session session = DbConnection.getEntityManager().unwrap(Session.class);
        session.save(material);
        DbConnection.desconectar();
        return material.getId();
    }

    @Override
    public void atualizar(Material obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Long obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Material> listar() {
        List<Material> materiais;
        DbConnection.conectar();
        Session session = DbConnection.getEntityManager().unwrap(Session.class);
        Query query = session.createQuery("select m from Material m");
        materiais = query.list();
        DbConnection.desconectar();
        
        return materiais;
    }
}

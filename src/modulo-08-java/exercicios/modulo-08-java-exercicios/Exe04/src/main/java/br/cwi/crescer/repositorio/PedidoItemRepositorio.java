/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.repositorio;

import br.cwi.crescer.entity.PedidoItem;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Érico de Souza Loewe
 */
public class PedidoItemRepositorio implements Repositorio<PedidoItem> {

    @Override
    public Long adicionar(PedidoItem pedidoItem) {
        DbConnection.conectar();
        Session session = DbConnection.getEntityManager().unwrap(Session.class);
        session.save(pedidoItem);
        DbConnection.desconectar();
        return pedidoItem.getId();
    }

    @Override
    public void atualizar(PedidoItem obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Long obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PedidoItem> listar() {
        List<PedidoItem> pedidoItems;
        DbConnection.conectar();
        Session session = DbConnection.getEntityManager().unwrap(Session.class);
        Query query = session.createQuery("select p from PedidoItem p");
        pedidoItems = query.list();
        DbConnection.desconectar();
        
        return pedidoItems;
    }
}

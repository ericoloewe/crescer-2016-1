/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.repositorio;

import br.cwi.crescer.entity.Pedido;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Érico de Souza Loewe
 */
public class PedidoRepositorio implements Repositorio<Pedido> {

    @Override
    public Long adicionar(Pedido pedido) {
        DbConnection.conectar();
        Session session = DbConnection.getEntityManager().unwrap(Session.class);
        session.save(pedido);
        DbConnection.desconectar();
        return pedido.getId();
    }

    @Override
    public void atualizar(Pedido obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Long obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pedido> listar() {
        List<Pedido> pedidos;
        DbConnection.conectar();
        Session session = DbConnection.getEntityManager().unwrap(Session.class);
        Query query = session.createQuery("select p from Pedido p");
        pedidos = query.list();
        DbConnection.desconectar();
        
        return pedidos;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.repositorio;

import br.cwi.crescer.entity.Cliente;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Érico de Souza Loewe
 */
public class ClienteRepositorio implements Repositorio<Cliente> {

    @Override
    public Long adicionar(Cliente cliente) {
        DbConnection.conectar();
        Session session = DbConnection.getEntityManager().unwrap(Session.class);
        session.save(cliente);
        DbConnection.desconectar();
        return cliente.getId();
    }

    @Override
    public void atualizar(Cliente obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Long obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> clientes;
        DbConnection.conectar();
        Session session = DbConnection.getEntityManager().unwrap(Session.class);
        Query query = session.createQuery("select c from Cliente c");
        clientes = query.list();
        DbConnection.desconectar();
        
        return clientes;
    }
    
}

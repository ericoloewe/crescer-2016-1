/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.repositorio;

import br.cwi.crescer.entity.Pessoa;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Érico de Souza Loewe
 */
public class PessoaRepositorio implements Repositorio<Pessoa> {

    @Override
    public Long adicionar(Pessoa pessoa) {
        DbConnection.conectar();
        Session session = DbConnection.getEntityManager().unwrap(Session.class);
        session.save(pessoa);
        DbConnection.desconectar();
        return pessoa.getId();
    }

    @Override
    public void atualizar(Pessoa obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Long obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pessoa> listar() {
        List<Pessoa> pessoas;
        DbConnection.conectar();
        Session session = DbConnection.getEntityManager().unwrap(Session.class);
        Query query = session.createQuery("select p from Pessoa p");
        pessoas = query.list();
        DbConnection.desconectar();
        
        return pessoas;
    }
}

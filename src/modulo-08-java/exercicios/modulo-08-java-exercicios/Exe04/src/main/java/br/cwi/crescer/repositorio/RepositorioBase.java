/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.repositorio;

import br.cwi.crescer.util.MeuSQLUtils;
import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author erico.loewe
 */
public class RepositorioBase <T extends Object> {
    
    protected void adicionar(T obj) {
        DbConnection.getEntityManager().persist(obj);
    }

    protected void atualizar(T obj) {
        DbConnection.getEntityManager().merge(obj);
    }

    protected void deletar(Long id) {
        DbConnection.getEntityManager().remove(id);
    }

    protected List<T> listar(String tabela) {
        List<T> pessoas;
        DbConnection.conectar();
        Session session = DbConnection.getEntityManager().unwrap(Session.class);
        Query query = session.createQuery(String.format("select t from %s t", tabela));
        pessoas = query.list();
        DbConnection.desconectar();
        return pessoas;
    }
    
    public void exportarDadosCsv(Class<T> base, String caminhoArquivo) {
        MeuSQLUtils sqlUtils = new MeuSQLUtils();
        StringBuilder atributos = new StringBuilder();
        
        for(Field atr : base.getDeclaredFields()) {
            Column column = atr.getAnnotation(Column.class);
            if (column != null) {
                atributos.append(column.name());
                atributos.append(";");
            }            
        }
        atributos.deleteCharAt(atributos.length() - 1);
        
        sqlUtils.exportarParaArquivo(caminhoArquivo, base.getSimpleName().toUpperCase(), atributos.toString());
    }
}

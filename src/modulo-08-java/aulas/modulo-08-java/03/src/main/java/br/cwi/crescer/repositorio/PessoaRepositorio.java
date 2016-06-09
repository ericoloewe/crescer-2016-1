/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.repositorio;

import br.cwi.crescer.Run;
import br.cwi.crescer.model.Pessoa;
import br.cwi.crescer.util.ConnectionUtils;
import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author erico.loewe
 */
public class PessoaRepositorio implements IPessoa {
    private static final Logger LOGGER = Logger.getLogger(Run.class);
    
    public void insert(Pessoa pessoa) {
        final String query = "insert into PESSOA (ID_PESSOA, NM_PESSOA) values (?, ?)";
                
        try (final Connection connection = ConnectionUtils.getConnection();
             final PreparedStatement ps = connection.prepareStatement(query)) 
        {
            ps.setLong(1, pessoa.getId());
            ps.setString(2, pessoa.getNome());
            ps.execute();
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        }
    }
    
    public void update(Pessoa pessoa) {
        final String query = "update PESSOA set NM_PESSOA = ? where ID_PESSOA = ?";
                
        try (final Connection connection = ConnectionUtils.getConnection();
             final PreparedStatement ps = connection.prepareStatement(query)) 
        {
            ps.setString(1, pessoa.getNome());
            ps.setLong(2, pessoa.getId());
            ps.execute();
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        }
    }
    
    public void delete(Pessoa pessoa) {
        final String query = "delete from PESSOA where ID_PESSOA = ?";
                
        try (final Connection connection = ConnectionUtils.getConnection();
             final PreparedStatement ps = connection.prepareStatement(query)) 
        {
            ps.setLong(1, pessoa.getId());
            ps.execute();
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        }
    }

    public List<Pessoa> listAll() {
        final String query = "select * from PESSOA";
        final List<Pessoa> pessoas = new ArrayList<Pessoa>();
        
        try (final Connection connection = ConnectionUtils.getConnection();
             final PreparedStatement ps = connection.prepareStatement(query);
             final ResultSet rs = ps.executeQuery()) 
        {
            while(rs.next()) {
                pessoas.add(new Pessoa(rs.getLong("ID_PESSOA"), rs.getString("NM_PESSOA")));
            }
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        }
        
        return pessoas;
    }

    public List<Pessoa> findNome(String nome) {
        final String query = "select * from PESSOA where NM_PESSOA = ?";
        final List<Pessoa> pessoas = new ArrayList<Pessoa>();
                
        try (final Connection connection = ConnectionUtils.getConnection();
             final PreparedStatement ps = connection.prepareStatement(query)) 
        {
            ps.setString(1, nome);
            try(final ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    pessoas.add(new Pessoa(rs.getLong("ID_PESSOA"), rs.getString("NM_PESSOA")));
                }
            } catch (SQLException e) {
                LOGGER.severe(e.getMessage());
            }
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        }
        
        return pessoas;
    }    
}

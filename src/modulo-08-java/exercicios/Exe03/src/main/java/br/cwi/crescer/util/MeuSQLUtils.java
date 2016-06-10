/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.util;

import br.cwi.crescer.repositorio.File;
import com.sun.istack.internal.logging.Logger;
import java.security.InvalidParameterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Érico de Souza Loewe
 */
public class MeuSQLUtils {
    private static final Logger LOGGER = Logger.getLogger(MeuSQLUtils.class);
    
    private void executarInstrucaoSql(String instrucao) {
        try (final Connection connection = ConnectionUtils.getConnection();
             final PreparedStatement ps = connection.prepareStatement(instrucao)) 
        {
            System.out.println(instrucao);
            ps.execute();
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        }
    }
    
    public ArrayList<HashMap<String, String>> executarQuerySql(String query) {
        ArrayList<HashMap<String, String>> tabela = new ArrayList<>();
                
        try (final Connection connection = ConnectionUtils.getConnection();
             final PreparedStatement ps = connection.prepareStatement(query);
             final ResultSet rs = ps.executeQuery()) 
        {
            ResultSetMetaData meta = rs.getMetaData();
            while(rs.next()) {
                HashMap<String, String> coluna = new HashMap<>();
                for(Integer i = 1; i <= meta.getColumnCount(); i++) {
                    coluna.put(meta.getColumnName(i), rs.getString(i));
                }
                tabela.add(coluna);
            }
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        }
        
        return tabela;
    }
    
    public void executarArquivoSql(String caminhoDoArquivo) {
        if(!File.tipo(caminhoDoArquivo).equalsIgnoreCase(".sql"))
            throw new InvalidParameterException("Este metodo somente executa arquivos .sql");
        String comando = "";
        
        for(String linha : File.lerTodo(caminhoDoArquivo)) {
            comando += linha;
            if(linha.trim().contains(";")) {
                executarInstrucaoSql(comando.replaceAll(";", ""));
                comando = "";
            }
        }
    }
    
    public void importarDeArquivo(String caminhoDoArquivo, String nomeTabela, String formatoDoArquivo) {
        String[] campos = formatoDoArquivo.split(";");        
        
        for(String linha : File.lerTodo(caminhoDoArquivo)) {
            StringBuilder comandoInsert = new StringBuilder();
            comandoInsert.append(String.format("insert into %s (", nomeTabela));
            
            for(String campo : campos) {
                comandoInsert.append(String.format("%s,", campo));
            }
            
            comandoInsert.deleteCharAt(comandoInsert.length() - 1);
            comandoInsert.append(") values (");
            
            for(String campo : linha.split(";")) {
                comandoInsert.append(String.format("'%s',", campo));
            }
            
            comandoInsert.deleteCharAt(comandoInsert.length() - 1);
            comandoInsert.append(")");
            
            executarInstrucaoSql(comandoInsert.toString());
        }
    }
    
    public void exportarParaArquivo(String caminhoDoArquivo, String nomeTabela, String formatoDoArquivo) {
        String[] campos = formatoDoArquivo.split(";");
        StringBuilder csv = new StringBuilder();
        ArrayList<HashMap<String, String>> tabela = this.executarQuerySql(String.format("select * from %s", nomeTabela));
        
        for(HashMap<String, String> coluna : tabela) {
            for(String campo : campos) {
                csv.append(String.format("%s;", coluna.get(campo)));
            }
            csv.deleteCharAt(csv.length() - 1);
            csv.append("\n");
        }
        
        File.reescreverTodo(caminhoDoArquivo, csv.toString());
    }
}
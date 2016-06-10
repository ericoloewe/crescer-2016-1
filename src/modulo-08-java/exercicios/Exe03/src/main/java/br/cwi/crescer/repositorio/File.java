/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.repositorio;

import com.sun.istack.internal.logging.Logger;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 *
 * @author Érico de Souza Loewe
 */
public class File {
    private static final Logger LOGGER = Logger.getLogger(File.class);
    
    public static void criar(String caminhoDoArquivo) {
        try {
            new java.io.File(caminhoDoArquivo).createNewFile();
        } catch (IOException ex) {
            LOGGER.severe(ex.getMessage());
        }
    }    

    public static void deletar(String caminhoDoArquivo) {
        java.io.File arquivo = new java.io.File(caminhoDoArquivo);
        
        if(!arquivo.isFile())
            throw new InvalidParameterException("Este metodo somente deleta arquivos");

        arquivo.delete();            
    }

    public static void renomear(String caminhoDoArquivo, String novoNomeArquivo) {
        java.io.File arquivo = new java.io.File(caminhoDoArquivo);
        
        if(!arquivo.isFile())
            throw new InvalidParameterException("Este metodo somente renomeia arquivos");
        
        arquivo.renameTo(new java.io.File(novoNomeArquivo));        
    }

    public static ArrayList<String> lerTodo(String caminhoDoArquivo) {
        if(!existe(caminhoDoArquivo))
            throw new InvalidParameterException("Este metodo somente le arquivos");
        
        Reader reader = null;
        BufferedReader bufferReader = null;
        ArrayList<String> linhasArquivo = new ArrayList<>();
        try {
            reader = new FileReader(caminhoDoArquivo);
            bufferReader = new BufferedReader(reader);
            String linha;
            
            while((linha = bufferReader.readLine()) != null) {
                linhasArquivo.add(linha);
            }
        } catch (FileNotFoundException ex) {
            LOGGER.severe(ex.getMessage());
        } catch (IOException ex) {
            LOGGER.severe(ex.getMessage());
        } finally {
            try {
                if(reader != null)
                    reader.close();
                if(bufferReader != null)
                    bufferReader.close();
            } catch (IOException ex) {
                LOGGER.severe(ex.getMessage());
            }            
        }
        
        return linhasArquivo;
    }
    
    public static String lerLinha(String caminhoDoArquivo, int numLinha) {
        return lerTodo(caminhoDoArquivo).get(numLinha);
    }
    
    public static String tipo(String caminhoDoArquivo) {
        return caminhoDoArquivo.substring(caminhoDoArquivo.lastIndexOf("."), caminhoDoArquivo.length());
    }

    public static void reescreverTodo(String caminhoDoArquivo, String conteudo) {
        if(!existe(caminhoDoArquivo))
            throw new InvalidParameterException("Este metodo somente escreve em arquivos");
        
        Writer writer = null;
        BufferedWriter bufferWriter = null;
        try {
            writer = new FileWriter(caminhoDoArquivo);
            bufferWriter = new BufferedWriter(writer);                    
            bufferWriter.write(conteudo);
            bufferWriter.flush();
            writer.flush();
        } catch (FileNotFoundException ex) {
            LOGGER.severe(ex.getMessage());
        } catch (IOException ex) {
            LOGGER.severe(ex.getMessage());
        } finally {
            try {
                if(writer != null)
                    writer.close();
                if(bufferWriter != null)
                    bufferWriter.close();
            } catch (IOException ex) {
                LOGGER.severe(ex.getMessage());
            }            
        }
    }
    
    public static void acrescentarLinha(String caminhoDoArquivo, String linha) {
        if(!existe(caminhoDoArquivo))
            throw new InvalidParameterException("Este metodo somente escreve em arquivos");
        
        Writer writer = null;
        BufferedWriter bufferWriter = null;
        try {
            writer = new FileWriter(caminhoDoArquivo, true);
            bufferWriter = new BufferedWriter(writer);                    
            bufferWriter.append(linha);
            bufferWriter.flush();
            writer.flush();
        } catch (FileNotFoundException ex) {
            LOGGER.severe(ex.getMessage());
        } catch (IOException ex) {
            LOGGER.severe(ex.getMessage());
        } finally {
            try {
                if(writer != null)
                    writer.close();
                if(bufferWriter != null)
                    bufferWriter.close();
            } catch (IOException ex) {
                LOGGER.severe(ex.getMessage());
            }            
        }
    }
    
    public static boolean existe(String caminhoDoArquivo) {
        return new java.io.File(caminhoDoArquivo).exists();
    }
}
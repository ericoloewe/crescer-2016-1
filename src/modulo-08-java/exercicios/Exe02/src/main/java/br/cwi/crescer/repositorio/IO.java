/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.repositorio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
public class IO {
    public static void criar(String arquivoOuDiretorio) {
        try {
            new File(arquivoOuDiretorio).createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }    

    public static void deletarArquivo(String caminhoDoArquivo) {
        File arquivo = new File(caminhoDoArquivo);
        
        if(!arquivo.isFile()) {
            throw new InvalidParameterException("Este metodo somente deleta arquivos");
        }
        arquivo.delete();
            
    }

    public static String[] listar(String caminhoDoArquivoOuDiretorio) {
        String[] listagem = null;
        File arquivoOuDiretorio = new File(caminhoDoArquivoOuDiretorio);
        
        if(arquivoOuDiretorio.isDirectory()) {
            listagem = arquivoOuDiretorio.list();
        } else if(arquivoOuDiretorio.isFile()) {
            listagem = new String[]{ arquivoOuDiretorio.getAbsolutePath() };
        }
        
        return listagem;
    }

    public static void renomearArquivo(String caminhoDoArquivo, String novoNomeArquivo) {
        File arquivo = new File(caminhoDoArquivo);
        
        if(!arquivo.isFile())
            throw new InvalidParameterException("Este metodo somente renomeia arquivos");
        
        arquivo.renameTo(new File(novoNomeArquivo));        
    }

    public static ArrayList<String> lerTodoArquivo(String arquivo) {
        if(!existe(arquivo))
            throw new InvalidParameterException("Este metodo somente le arquivos");
        
        Reader reader = null;
        BufferedReader bufferReader = null;
        ArrayList<String> linhasArquivo = new ArrayList<String>();
        try {
            reader = new FileReader(arquivo);
            bufferReader = new BufferedReader(reader);
            String linha = null;            
            
            while((linha = bufferReader.readLine()) != null) {
                linhasArquivo.add(linha);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(reader != null)
                    reader.close();
                if(bufferReader != null)
                    bufferReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }            
        }
        
        return linhasArquivo;
    }
    
    public static String tipoArquivo(String arquivo) {
        return arquivo.substring(arquivo.lastIndexOf("."), arquivo.length());
    }

    public static void escreverTodoArquivo(String arquivo, String conteudo) {
        if(!existe(arquivo))
            throw new InvalidParameterException("Este metodo somente escreve em arquivos");
        
        Writer writer = null;
        BufferedWriter bufferWriter = null;
        try {
            writer = new FileWriter(arquivo);
            bufferWriter = new BufferedWriter(writer);                    
            bufferWriter.write(conteudo);
            bufferWriter.flush();
            writer.flush();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(writer != null)
                    writer.close();
                if(bufferWriter != null)
                    bufferWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }            
        }
    }
    
    public static boolean existe(String arquivo) {
        return new File(arquivo).exists();
    }
}

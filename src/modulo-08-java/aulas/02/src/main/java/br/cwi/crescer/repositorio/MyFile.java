/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.repositorio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 *
 * @author erico.loewe
 */
public class MyFile implements Closeable {
    private Writer writer = null;
    private BufferedWriter bufferWriter = null;
    private Reader reader = null;
    private BufferedReader bufferReader = null;
    
    private MyFile(String arquivo) {
        try {
            new File(arquivo).createNewFile();
            reader = new FileReader(arquivo);
            writer = new FileWriter(arquivo, true);            
            bufferReader = new BufferedReader(reader);
            bufferWriter = new BufferedWriter(writer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static MyFile abrirArquivo(String arquivo) {
        return new MyFile(arquivo);
    }

    @Override
    public void close() {
        try {
            if(writer != null) {
                writer.close();
            }
            if(reader != null) {
                reader.close();
            }
            if(bufferWriter != null) {
                bufferWriter.close();
            }
            if(bufferReader != null) {
                bufferReader.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String proximaLinha() {
        try {
            return bufferReader.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public void escreverProximaLinha(String proximaLinha) {
        try {
            bufferWriter.flush();
            writer.flush();
            bufferWriter.append(proximaLinha);
            bufferWriter.newLine();  
            bufferWriter.flush();
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

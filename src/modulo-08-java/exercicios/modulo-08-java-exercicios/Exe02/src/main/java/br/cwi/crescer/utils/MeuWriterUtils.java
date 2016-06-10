/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.utils;

import br.cwi.crescer.repositorio.IO;

/**
 *
 * @author Érico de Souza Loewe
 */
public class MeuWriterUtils {
    public boolean rodar(String comando) {  
        String[] partes = comando.split("\\$\\{|\\}");
        
        switch(partes[0].trim().toLowerCase()) {
            case "escrever": {
                escrever(partes[1], partes[3]);
                break;
            }
            default: {
                return false;
            }            
        }
        return true;
    }

    private void escrever(String arquivo, String conteudo) {
        if(IO.tipoArquivo(arquivo).equalsIgnoreCase(".txt")) {
            IO.escreverTodoArquivo(arquivo, conteudo);   
        } else {
            System.out.println("Extensão não suportada.");            
        }
    }
}

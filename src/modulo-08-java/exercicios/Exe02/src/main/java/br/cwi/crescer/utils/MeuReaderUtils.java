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
public class MeuReaderUtils {
    public boolean rodar(String comando) {  
        String[] partes = comando.split(" ");
        
        switch(partes[0].trim().toLowerCase()) {
            case "ler": {
                ler(partes[1]);
                break;
            }
            default: {
                return false;
            }            
        }
        return true;
    }

    private void ler(String arquivo) {
        for(String linha : IO.lerTodoArquivo(arquivo)) {
            System.out.println(linha);
        }        
    }
}

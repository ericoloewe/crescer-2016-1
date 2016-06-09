/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.utils;

import br.cwi.crescer.repositorio.IO;
import java.security.InvalidParameterException;

/**
 *
 * @author Érico de Souza Loewe
 */
public class MeuFileUtils {
    public boolean rodar(String comando) {  
        String[] partes = comando.split("\\$\\{|\\}");
        
        switch(partes[0].trim().toLowerCase()) {
            case "mk": {
                mk(partes[1]);
                break;
            }
            case "rm": {
                rm(partes[1]);
                break;
            }
            case "ls": {
                ls(partes[1]);
                break;
            }
            case "mv": {
                mv(partes[1], partes[3]);
                break;
            }
            default: {
                return false;
            }
        }
        return true;
    }

    private void mk(String arquivoOuDiretorio) {
        IO.criar(arquivoOuDiretorio);
        System.out.println("Arquivo/Diretorio criado com sucesso");
    }

    private void rm(String arquivo) {
        try {
            IO.deletarArquivo(arquivo);
            System.out.println("Arquivo deletado com sucesso");
        } catch (InvalidParameterException ex) {
            System.out.println(ex.getMessage());
        }        
    }

    private void ls(String arquivoOuDiretorio) {
        for(String arquivo : IO.listar(arquivoOuDiretorio)) {
            System.out.println(arquivo);
        }
    }

    private void mv(String arquivo, String novoNomeArquivo) {
        IO.renomearArquivo(arquivo, novoNomeArquivo);
        System.out.println("Arquivo renomeado com sucesso");
    }
    
    
}

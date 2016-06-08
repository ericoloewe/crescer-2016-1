/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.aula;

import br.cwi.crescer.repositorio.MyFile;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erico.loewe
 */
public class Chat {
    private static final String NOME_ARQUIVO = "//10.0.100.102/cwitmp/carloshenrique/crescer.txt";
    private static MyFile arquivo = null;
    private boolean rodando = false;
    private Scanner leitor = null;
    private String nomeUsuario = null;
    
    public static Chat abrir(String nomeUsuario) {
        Chat own = new Chat();
        own.rodando = true;
        arquivo = MyFile.abrirArquivo(NOME_ARQUIVO);
        own.leitor = new Scanner(System.in);
        own.nomeUsuario = nomeUsuario;
        own.escrita();
        own.leitura();
        
        return own;
    }
    
    public void fechar() {
        rodando = false;
        arquivo.close();
        leitor.close();
    }

    private void leitura() {
        String proximaLinha = null;
        while(rodando) {
            proximaLinha = leitor.nextLine();
            
            if(proximaLinha.equals(":exit")) {
                fechar();
                break;
            }

            arquivo.escreverProximaLinha(prepararTextoProArquivo(proximaLinha));
        }
    }

    private void escrita() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String proximaLinha = null;
                    while(rodando) {
                        proximaLinha = arquivo.proximaLinha();
                        
                        if(proximaLinha != null) {
                            System.out.println(proximaLinha);
                        }

                        Thread.sleep(1000l);
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }            
        }).start();
    }

    private String prepararTextoProArquivo(String proximaLinha) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");        
        return String.format("%s;%s;%s", dateFormat.format(new Date()),nomeUsuario,proximaLinha);
    }

    private String prepararTextoPraTela(String proximaLinha) {
        String[] texto = proximaLinha.split(";|-");
        
        return String.format("%s em %s digitou: %s", texto[1], texto[0], texto[2]);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer;

import br.cwi.crescer.utils.*;
import java.util.Scanner;

/**
 *
 * @author Érico de Souza Loewe
 */
public class Run {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String comando = "";
        MeuFileUtils meuFile = new MeuFileUtils();
        MeuReaderUtils meuReader = new MeuReaderUtils();
        MeuWriterUtils meuWriter = new MeuWriterUtils();
        
        while(!comando.equalsIgnoreCase(":exit")) {
            System.out.print("Digite um comando: ");
            comando = scanner.nextLine();        
            if(!comando.equalsIgnoreCase(":exit") && !(meuFile.rodar(comando) || meuReader.rodar(comando) || meuWriter.rodar(comando))) {
                System.out.println("Comando invalido!");
            }
        }
    }
}

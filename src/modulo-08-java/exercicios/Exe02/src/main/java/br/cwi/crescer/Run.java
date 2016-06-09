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
        MeuFileUtils meuFile = new MeuFileUtils();
        MeuReaderUtils meuReader = new MeuReaderUtils();
        
        System.out.print("Digite um comando: ");
        String comando = scanner.nextLine();        
        if(!(meuFile.rodar(comando) || meuReader.rodar(comando))) {
            System.out.println("Comando invalido!");
        }
    }
}

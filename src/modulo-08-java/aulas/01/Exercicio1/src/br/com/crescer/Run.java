/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import java.util.Scanner;

/**
 *
 * @author erico.loewe
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            System.out.print("Informe um numero: ");
            
            if(scanner.nextInt()%2 == 0)
                System.out.println("Seu numero é par");
            else
                System.out.println("Seu numero é impar");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

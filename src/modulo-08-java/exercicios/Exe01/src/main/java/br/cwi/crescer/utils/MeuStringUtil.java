/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.utils;

/**
 *
 * @author Érico de Souza Loewe
 */
public class MeuStringUtil {
    public static boolean estaVazia(String str) {
        return str  == null || str.isEmpty();
    }
    
    public static int numeroDeVogais(String str) {
        return str.length() - str.toLowerCase().replaceAll("a|e|i|o|u", "").length();
    }
    
    public static String inverter(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    public static boolean ehPalindromo(String str) {
        return MeuStringUtil.inverter(str).equals(str);
    }
}

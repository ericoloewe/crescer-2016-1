/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author erico.loewe
 */
public class StringUtils {    
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        
        ArrayList<Estados> estadosOrdenados = new ArrayList<>();
        Collections.addAll(estadosOrdenados, Estados.values());
        
        estadosOrdenados.sort(
            (Estados estado1, Estados estado2) 
                -> estado1.getNome().compareTo(estado2.getNome())
        );
        
        for(Estados estado : estadosOrdenados) {            
            str.append(estado.getNome());
            str.append(",");
        }
        
        str.deleteCharAt(str.length() - 1);
        System.out.println(str);
    }
}

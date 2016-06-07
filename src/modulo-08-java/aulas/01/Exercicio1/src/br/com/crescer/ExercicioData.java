/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import java.util.Calendar;

/**
 *
 * @author erico.loewe
 */
public class ExercicioData {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        calendar.set(1996, 8, 16);
        System.out.println(pesquisarDiaSemana(calendar.get(Calendar.DAY_OF_WEEK)));
    }

    public static String pesquisarDiaSemana(int numerodiaSemana) {
        String diaSemana = null;

        switch (numerodiaSemana) {
            case 1: {
                diaSemana = "Domingo";
                break;
            }
            case 2: {
                diaSemana = "Segunda";
                break;
            }
            case 3: {
                diaSemana = "Terça";
                break;
            }
            case 4: {
                diaSemana = "Quarta";
                break;
            }
            case 5: {
                diaSemana = "Quinta";
                break;
            }
            case 6: {
                diaSemana = "Sexta";
                break;
            }
            case 7: {
                diaSemana = "Sábado";
                break;
            }

        }
        return diaSemana;

    }
}

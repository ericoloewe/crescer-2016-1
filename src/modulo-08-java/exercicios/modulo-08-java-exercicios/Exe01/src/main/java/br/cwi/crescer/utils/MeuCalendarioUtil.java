/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.utils;
 
import java.util.Calendar;

/**
 *
 * @author Érico de Souza Loewe
 */
public class MeuCalendarioUtil {
    public static String tempoDecorridoDesde(Calendar data) {
        int dias, meses, anos;
        
        Calendar today = Calendar.getInstance();
        dias = today.get(Calendar.DAY_OF_MONTH) - data.get(Calendar.DAY_OF_MONTH);
        meses = today.get(Calendar.MONTH) - data.get(Calendar.MONTH);
        anos = today.get(Calendar.YEAR) - data.get(Calendar.YEAR);
        
        return tempoPercorridoToString(dias, meses, anos);
    }
    
    private static String tempoPercorridoToString(int dias, int meses, int anos) {
        StringBuilder str = new StringBuilder();
        //30 ano(s), 3 mes(es) e 12 dia(s)
        str.append(anos);
        str.append(" ano(s), ");
        str.append(meses);
        str.append(" mes(es) e ");
        str.append(dias);
        str.append(" dia(s)");
        
        return str.toString();
    }
    
    public static String meuDiaDaSemana(Calendar dataAniversario) {
        return diaDaSemana(dataAniversario.get(Calendar.DAY_OF_WEEK));
    }

    private static String diaDaSemana(int numeroDiaSemana) {
        String diaSemana = null;

        switch (numeroDiaSemana) {
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

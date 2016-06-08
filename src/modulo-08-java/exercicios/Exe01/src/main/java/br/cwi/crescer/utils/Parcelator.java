/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Érico de Souza Loewe
 */
public class Parcelator {
    public ArrayList<String> parcelar(float valor, int juros, int quantidadeParcelas, Calendar data) {
        ArrayList<String> parcelas = new ArrayList<>();
        float valorComJuros = valor + (valor * ((float) juros / 100));
        float valorParcela = valorComJuros / quantidadeParcelas;
        
        for(int i = 0; i < quantidadeParcelas; i++) {
            Date dataAux = data.getTime();
            
            dataAux.setMonth(data.get(Calendar.MONTH) + i);
            SimpleDateFormat dataParcelaFormatada = new SimpleDateFormat("dd/MM/yyyy");
            
            parcelas.add(String.format("%s - R$ %.2f", dataParcelaFormatada.format(dataAux), valorParcela));            
        }
        
        return parcelas;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Érico de Souza Loewe
 */
public class ParcelatorTest {
    
    public ParcelatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of parcelar method, of class Parcelator.
     * @throws java.text.ParseException
     */
    @Test
    public void testParcelar() throws ParseException {
        // Arrange
        Parcelator instance = new Parcelator();
        ArrayList<String> esperado = null;
        float valor = 1000;
        int juros = 10;
        int quantidadeParcelas = 10;
        Calendar data = Calendar.getInstance();
        data.setTime(new SimpleDateFormat("dd/MM/yyyy").parse("30/06/2016"));
        
        //Act
        ArrayList<String> obtido = instance.parcelar(valor, juros, quantidadeParcelas, data);
        
        // Assert
        assertNotNull(obtido);
    }
    
}

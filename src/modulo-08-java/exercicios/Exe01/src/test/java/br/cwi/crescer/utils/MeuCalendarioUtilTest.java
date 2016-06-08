/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.utils;

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
public class MeuCalendarioUtilTest {
    
    public MeuCalendarioUtilTest() {
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
     * Test of tempoDecorridoDesde method, of class MeuCalendarioUtil.
     */
    @Test
    public void testTempoDecorridoDesde() {
        String esperado = "2 ano(s), 2 mes(es) e 2 dia(s)";
        Calendar data = Calendar.getInstance();
        data.set(data.get(Calendar.YEAR) - 2, data.get(Calendar.MONTH) - 2, data.get(Calendar.DAY_OF_MONTH) - 2);
        
        String obtido = MeuCalendarioUtil.tempoDecorridoDesde(data);
        assertEquals(esperado, obtido);
    }

    /**
     * Test of meuDiaDaSemana method, of class MeuCalendarioUtil.
     */
    @Test
    public void testMeuDiaDaSemana() {
        // Arrange
        String esperado = "Segunda";
        Calendar calendar = Calendar.getInstance();
        calendar.set(1996, 8, 16);
        
        // Act
        String obtido = MeuCalendarioUtil.meuDiaDaSemana(calendar);
        
        // Assert
        assertEquals(esperado, obtido);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.utils;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Érico de Souza Loewe
 */
public class MeuStringUtilTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    /**
     * Test of estaVazia method, of class MeuStringUtil.
     */
    @org.junit.Test
    public void testEstaVazia() {
        // Arrange
        boolean esperado = true;
        
        // Act
        boolean obtido = MeuStringUtil.estaVazia("");
        
        // Assert
        assertEquals(esperado, obtido);
    }

    /**
     * Test of numeroDeVogais method, of class MeuStringUtil.
     */
    @org.junit.Test
    public void testNumeroDeVogais() {
        // Arrange
        int esperado = 9;
        
        // Act
        int obtido = MeuStringUtil.numeroDeVogais("Ericooookkeee");
        
        // Assert
        assertEquals(esperado, obtido);
    }

    /**
     * Test of inverter method, of class MeuStringUtil.
     */
    @Test
    public void testInverter() {
        // Arrange
        String esperado = "ocire";
        
        // Act
        String obtido = MeuStringUtil.inverter("erico");
        
        // Assert
        assertEquals(esperado, obtido);
    }

    /**
     * Test of ehPalindromo method, of class MeuStringUtil.
     */
    @Test
    public void testEhPalindromoDeveRetornarTrueParaRenner() {
        // Arrange
        boolean esperado = true;
        
        // Act
        boolean obtido = MeuStringUtil.ehPalindromo("renner");
        
        // Assert
        assertEquals(esperado, obtido);
    }
    
    /**
     * Test of ehPalindromo method, of class MeuStringUtil.
     */
    @Test
    public void testEhPalindromoDeveRetornarFalseParaCafe() {
        // Arrange
        boolean esperado = false;
        
        // Act
        boolean obtido = MeuStringUtil.ehPalindromo("cafe");
        
        // Assert
        assertEquals(esperado, obtido);
    }
    
}

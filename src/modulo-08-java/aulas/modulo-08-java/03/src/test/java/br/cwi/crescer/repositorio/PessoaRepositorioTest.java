/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.repositorio;

import br.cwi.crescer.model.Pessoa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author erico.loewe
 */
public class PessoaRepositorioTest {
    private final PessoaRepositorio _repositorio = new PessoaRepositorio();
    
    public PessoaRepositorioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        _repositorio.insert(new Pessoa(99999999l, "PessoaFake3000"));
    }
    
    @After
    public void tearDown() {
        _repositorio.delete(new Pessoa(99999999l, "PessoaFake3000"));
    }

    /**
     * Test of insert method, of class PessoaRepositorio.
     */
    @Test
    public void testInsert() {
        Pessoa pessoa = new Pessoa(99999991l, "PessoaFake3000I");
        
        _repositorio.insert(pessoa);
        
        assertEquals(1, _repositorio.findNome("PessoaFake3000I").size());
        _repositorio.delete(pessoa);
    }

    /**
     * Test of update method, of class PessoaRepositorio.
     */
    @Test
    public void testUpdate() {
        Pessoa pessoa = new Pessoa(99999999l, "PessoaFake30001");
        
        _repositorio.update(pessoa);
        
        assertEquals(1, _repositorio.findNome("PessoaFake30001").size());
    }

    /**
     * Test of delete method, of class PessoaRepositorio.
     */
    @Test
    public void testDelete() {
        Pessoa pessoa = new Pessoa(99999999l, "PessoaFake3000");
        
        _repositorio.delete(pessoa);
        
        assertEquals(0, _repositorio.findNome("PessoaFake3000").size());
    }

    /**
     * Test of listAll method, of class PessoaRepositorio.
     */
    @Test
    public void testListAll() {        
        List<Pessoa> obtido = _repositorio.listAll();
        
        assertNotNull(obtido);
    }

    /**
     * Test of findNome method, of class PessoaRepositorio.
     */
    @Test
    public void testFindNome() {
        String nome = "PessoaFake3000";

        List<Pessoa> obtido = _repositorio.findNome(nome);
        
        assertEquals(nome, obtido.get(0).getNome());
    }
    
}

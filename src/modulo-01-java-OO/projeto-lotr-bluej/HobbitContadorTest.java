import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HobbitContadorTest
{
    @Test
    public void obterMaiorMultiploDeTresAte10()
    {
        HobbitContador contador = new HobbitContador();
        int esperado = 9;
        
        int obtido = contador.obterMaiorMultiploDeTresAte(10);
        
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void obterMultiplosDeTresAte10()
    {
        HobbitContador contador = new HobbitContador();
        ArrayList<Integer> esperado = new ArrayList<Integer>(Arrays.asList(0, 3, 6, 9));
        
        ArrayList<Integer> obtido = contador.obterMultiplosDeTresAte(10);
        
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void calculaDiferencaDeveFuncionarComNull()
    {
        HobbitContador contador = new HobbitContador();
                
        assertNull(contador.calcularDiferenca(null));
    }
    
    @Test
    public void calculaDiferencaDeveFuncionarSemElementos()
    {
        Integer esperado = 0, obtido;
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        HobbitContador contador = new HobbitContador();             
                
        obtido = contador.calcularDiferenca(arrayDePares);
                
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void calcularDiferencaDeveRetornar0()
    {
        Integer esperado = 0, obtido;
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        HobbitContador contador = new HobbitContador();        
        arrayDePares.add(new ArrayList<>(Arrays.asList(0, 0)));    
                
        obtido = contador.calcularDiferenca(arrayDePares);
                
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void calcularDiferencaDeveRetornar180()
    {
        Integer esperado = 180, obtido;
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        HobbitContador contador = new HobbitContador();        
        arrayDePares.add(new ArrayList<>(Arrays.asList(15, 18)));    
                
        obtido = contador.calcularDiferenca(arrayDePares);
                
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void calcularDiferencaDeveRetornar840()
    {
        Integer esperado = 840, obtido;
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        HobbitContador contador = new HobbitContador();        
        arrayDePares.add(new ArrayList<>(Arrays.asList(15, 18)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(12, 60)));        
                
        obtido = contador.calcularDiferenca(arrayDePares);
                
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void calcularDiferencaDeveRetornar84()
    {
        Integer esperado = 84, obtido;
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        HobbitContador contador = new HobbitContador();        
        arrayDePares.add(new ArrayList<>(Arrays.asList(42, 4)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(20, 17)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(13, 29)));

        obtido = contador.calcularDiferenca(arrayDePares);
                
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void calcularDiferencaDeveRetornar348()
    {
        Integer esperado = 348, obtido;
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        HobbitContador contador = new HobbitContador();        
        arrayDePares.add(new ArrayList<>(Arrays.asList(10, 20)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(14, 24)));

        obtido = contador.calcularDiferenca(arrayDePares);
                
        assertEquals(esperado, obtido);
    }
}
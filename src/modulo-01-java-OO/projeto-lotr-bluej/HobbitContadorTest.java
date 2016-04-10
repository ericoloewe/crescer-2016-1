import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HobbitContadorTest
{
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
}
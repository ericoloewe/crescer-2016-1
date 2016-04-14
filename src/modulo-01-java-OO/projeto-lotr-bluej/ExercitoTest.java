import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class ExercitoTest
{
    @After
    public void tearDown()
    {
        System.gc();
    }
    
    @Test
    public void addElfoAoExercito()
    {
        Exercito exe = new Exercito();
        
        assertFalse(exe.alistarElfo(new Elfo("Auriel")));
    }
    
    @Test
    public void addElfoVerdeAoExercito()
    {
        Exercito exe = new Exercito();
        
        assertTrue(exe.alistarElfo(new ElfoVerde("Auriel")));
    }
    
    @Test
    public void addElfoNoturnoAoExercito()
    {
        Exercito exe = new Exercito();
        
        assertTrue(exe.alistarElfo(new ElfoNoturno("Auriel")));
    }
    
    @Test
    public void elfoEhAgrupadoPorStatus()
    {
        int tamanhoEsperado = 1;
        int tamanhoArrayEsperado = 3;
        Exercito exe = new Exercito();
        
        exe.alistarElfo(new ElfoNoturno("Auriel"));
        exe.alistarElfo(new ElfoVerde("Elfo2"));
        exe.alistarElfo(new ElfoNoturno("Elfo3"));
        
        exe.agruparPorStatus();
        
        assertEquals(tamanhoArrayEsperado, exe.getExercitoAgrupadoPorStatus().get(Status.VIVO).size());
        assertEquals(tamanhoEsperado, exe.getExercitoAgrupadoPorStatus().size());
        assertTrue(exe.getExercitoAgrupadoPorStatus() != null);
    }
    
    @Test
    public void elfoEhAgrupadoPorStatusVazia()
    {
        int tamanhoEsperado = 0;
        Exercito exe = new Exercito();
        
        exe.agruparPorStatus();
        
        assertEquals(tamanhoEsperado, exe.getExercitoAgrupadoPorStatus().size());
    }
    
    @Test
    public void buscarElfosVivos()
    {
        int tamanhoEsperado = 3;
        Exercito exe = new Exercito();
        
        exe.alistarElfo(new ElfoNoturno("Auriel"));
        exe.alistarElfo(new ElfoVerde("Elfo2"));
        exe.alistarElfo(new ElfoNoturno("Elfo3"));
        
        ArrayList<Elfo> elfos = exe.buscar(Status.VIVO);
        
        assertEquals(tamanhoEsperado, elfos.size());
        assertTrue(elfos != null);
    }
    
    @Test
    public void buscarElfosMortos()
    {
        Exercito exe = new Exercito();
        
        exe.alistarElfo(new ElfoNoturno("Auriel"));
        
        ArrayList<Elfo> elfos = exe.buscar(Status.MORTO);
        
        assertTrue(elfos == null);
    }
}

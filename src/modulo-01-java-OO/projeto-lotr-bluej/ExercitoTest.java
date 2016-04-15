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
        int tamanhoArrayEsperado = 20;
        Exercito exe = this.criarExercito();
        
        exe.agruparPorStatus();
        
        assertEquals(tamanhoArrayEsperado, exe.getExercitoAgrupadoPorStatus().get(Status.VIVO).size());
        assertEquals(tamanhoEsperado, exe.getExercitoAgrupadoPorStatus().size());
        assertTrue(exe.getExercitoAgrupadoPorStatus() != null);
    }
    
    @Test
    public void elfoEhAgrupadoPorStatus2Vzs()
    {
        int tamanhoEsperado = 1;
        int tamanhoArrayEsperado = 20;
        Exercito exe = this.criarExercito();
        
        exe.agruparPorStatus();
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
        int tamanhoEsperado = 20;
        Exercito exe = this.criarExercito();
        
        ArrayList<Elfo> elfos = exe.buscar(Status.VIVO);
        
        assertEquals(tamanhoEsperado, elfos.size());
        assertTrue(elfos != null);
    }
    
    @Test
    public void buscarElfosMortos()
    {
        int tamanhoEsperado = 1;
        Exercito exe = this.criarExercito();
        
        exe.alistarElfo(this.criarElfoMorto("Auriel"));
        
        ArrayList<Elfo> elfos = exe.buscar(Status.MORTO);
        
        assertEquals(tamanhoEsperado, elfos.size());
        assertTrue(elfos != null);
    }
    
    @Test
    public void buscarElfosMortosSemMortos()
    {
        Exercito exe = new Exercito();
        
        exe.alistarElfo(new ElfoNoturno("Auriel"));
        
        ArrayList<Elfo> elfos = exe.buscar(Status.MORTO);
        
        assertEquals(null, elfos);
    }
    
    private ArrayList<Dwarf> criarExercitoDeDwarfs()
    {
        ArrayList<Dwarf> exe = new ArrayList<>();
        
        for(int i = 0; i < 10; i++)
        {
            exe.add(new Dwarf("Dwarf" + i));
        }
        
        return exe;
    }
    
    private Exercito criarExercito()
    {
        Exercito exe = new Exercito();
        
        for(int i = 0; i < 10; i++)
        {
            exe.alistarElfo(new ElfoVerde("ElfoVerde" + i));
            exe.alistarElfo(new ElfoNoturno("ElfoNoturno" + i));
        }
        
        return exe;
    }
    
    private ElfoNoturno criarElfoMorto(String nome)
    {
        ElfoNoturno elfo = new ElfoNoturno(nome, 10000);
        
        while(elfo.getVidaElfoNoturno() != 0) 
            elfo.atirarFlechas();
        
        return elfo;
    }
}

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
    
    @Test(expected=NaoPodeAlistarException.class)
    public void addElfoAoExercito() throws NaoPodeAlistarException
    {
        Exercito exe = new Exercito();
        exe.alistarElfo(new Elfo("Auriel"));
        assertEquals(exe.getExercito().size(), 0);
    }
    
    @Test
    public void addElfoVerdeAoExercito() throws NaoPodeAlistarException
    {
        Exercito exe = new Exercito();
        exe.alistarElfo(new ElfoVerde("Auriel"));
        assertEquals(exe.getExercito().size(), 1);
    }
    
    @Test
    public void addElfoNoturnoAoExercito() throws NaoPodeAlistarException
    {
        Exercito exe = new Exercito();
        exe.alistarElfo(new ElfoNoturno("Auriel"));
        assertEquals(exe.getExercito().size(), 1);
    }
    
    @Test
    public void elfoEhAgrupadoPorStatus() throws NaoPodeAlistarException
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
    public void elfoEhAgrupadoPorStatus2Vzs() throws NaoPodeAlistarException
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
    public void buscarElfosVivos() throws NaoPodeAlistarException
    {
        int tamanhoEsperado = 20;
        Exercito exe = this.criarExercito();
        
        ArrayList<Elfo> elfos = exe.buscar(Status.VIVO);
        
        assertEquals(tamanhoEsperado, elfos.size());
        assertTrue(elfos != null);
    }
    
    @Test
    public void buscarElfosMortos() throws NaoPodeAlistarException
    {
        int tamanhoEsperado = 1;
        Exercito exe = this.criarExercito();
        
        exe.alistarElfo(this.criarElfoMorto("Auriel"));
        
        ArrayList<Elfo> elfos = exe.buscar(Status.MORTO);
        
        assertEquals(tamanhoEsperado, elfos.size());
        assertTrue(elfos != null);
    }
    
    @Test
    public void buscarElfosMortosSemMortos() throws NaoPodeAlistarException
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
    
    private Exercito criarExercito() throws NaoPodeAlistarException
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
            elfo.atirarFlecha();
        
        return elfo;
    }
}

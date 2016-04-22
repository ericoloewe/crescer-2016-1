import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class NoturnosPorUltimoTest
{
    @Test
    public void atacarDwarfs()
    {
        Exercito exe = this.criarExercitoComEstrategiaNoturnosPorUltimo();
        ArrayList<Dwarf> exeDwarfs = criarExercitoDeDwarfs(10);
        boolean elfosEstaoEmOrdem = true, acabouElfosVerdes = false;
        
        exe.atacar(exeDwarfs);
        
        for(Dwarf dwarf : exeDwarfs)
        {
            assertTrue(dwarf.getVida() < 110);
        }
        
        for(Elfo elfo : exe.getOrdemDoUltimoAtaque())
        {
            if(elfo instanceof ElfoNoturno && !acabouElfosVerdes)
            {
                acabouElfosVerdes = true;
            }
            if(elfo instanceof ElfoVerde && acabouElfosVerdes)
            {
                elfosEstaoEmOrdem = false;
                break;
            }
        }
        
        assertTrue(elfosEstaoEmOrdem);
    }
    
    @Test
    public void atacarDwarfsSemExercito()
    {
        Exercito exe = new Exercito();
        exe.mudarEstrategia(new NoturnosPorUltimo());
        ArrayList<Dwarf> exeDwarfs = criarExercitoDeDwarfs(10);
        
        exe.atacar(exeDwarfs);
        
        for(Dwarf dwarf : exeDwarfs)
        {
            assertEquals(dwarf.getVida(), 110);
        }
        assertEquals(new ArrayList<Elfo>(), exe.getOrdemDoUltimoAtaque());
    }
    
    @Test
    public void atacarDwarfsComNull()
    {
        Exercito exe = new Exercito();
        exe.mudarEstrategia(null);
        ArrayList<Dwarf> exeDwarfs = criarExercitoDeDwarfs(10);
        
        exe.atacar(exeDwarfs);
        
        for(Dwarf dwarf : exeDwarfs)
        {
            assertEquals(dwarf.getVida(), 110);
        }
    }
    
    private ArrayList<Dwarf> criarExercitoDeElfos(int n)
    {
        ArrayList<Dwarf> exe = new ArrayList<>();
        
        for(int i = 0; i < n; i++)
        {
            exe.add(new Dwarf("Dwarf" + i));
        }
        
        return exe;
    }
    
    private ArrayList<Dwarf> criarExercitoDeDwarfs(int n)
    {
        ArrayList<Dwarf> exe = new ArrayList<>();
        
        for(int i = 0; i < n; i++)
        {
            exe.add(new Dwarf("Dwarf" + i));
        }
        
        return exe;
    }
    
    private Exercito criarExercitoComEstrategiaNoturnosPorUltimo()
    {
        Exercito exe = new Exercito();
        
        for(int i = 0; i < 10; i++)
        {
            exe.alistarElfo(new ElfoVerde("ElfoVerde" + i));
            exe.alistarElfo(new ElfoNoturno("ElfoNoturno" + i));
        }
        exe.mudarEstrategia(new NoturnosPorUltimo());
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

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class AtaqueIntercaladoTest
{
    @Test
    public void atacarDwarfs()
    {
        Exercito exe = this.criarExercitoComEstrategiaAtaqueIntercalado();
        ArrayList<Dwarf> exeDwarfs = criarExercitoDeDwarfs(10);
        
        exe.atacar(exeDwarfs);
        
        for(Dwarf dwarf : exeDwarfs)
        {
            assertTrue(dwarf.getVida() < 110);
        }
    }
    
    @Test
    public void atacarDwarfsComExercitoNaoIntercaladoComMaisElfosNoturnos()
    {
        // Arrange
        Exercito exe = this.criarExercitoComEstrategiaAtaqueNaoIntercaladoComMaisNoturnos();
        ArrayList<Dwarf> exeDwarfs = criarExercitoDeDwarfs(10);
        boolean elfoVerdeAtacou = false, elfoNoturnoAtacou = false, elfosIntercalados = true;
        
        // Act
        exe.atacar(exeDwarfs);
        
        // Assert
        for(Dwarf dwarf : exeDwarfs)
        {
            assertTrue(dwarf.getVida() < 110);
        }
        
        for(Elfo elfo : exe.getOrdemDoUltimoAtaque())
        {
            if(elfo instanceof ElfoVerde && !elfoVerdeAtacou)
            {
                elfoVerdeAtacou = true;
                elfoNoturnoAtacou = false;
            } else if(elfo instanceof ElfoNoturno && !elfoNoturnoAtacou) {
                elfoNoturnoAtacou = true;
                elfoVerdeAtacou = false;
            } else if((elfo instanceof ElfoVerde && elfoVerdeAtacou) || (elfo instanceof ElfoNoturno && !elfoNoturnoAtacou)) {
                elfosIntercalados = false;
                break;
            }
        }        
        assertTrue(elfosIntercalados);
    }
    
    @Test
    public void atacarDwarfsComExercitoNaoIntercaladoComMaisElfosVerdes()
    {
        // Arrange
        Exercito exe = this.criarExercitoComEstrategiaAtaqueNaoIntercaladoComMaisVerdes();
        ArrayList<Dwarf> exeDwarfs = criarExercitoDeDwarfs(10);
        boolean elfoVerdeAtacou = false, elfoNoturnoAtacou = false, elfosIntercalados = true;
        
        // Act
        exe.atacar(exeDwarfs);
        
        // Assert
        for(Dwarf dwarf : exeDwarfs)
        {
            assertTrue(dwarf.getVida() < 110);
        }
        
        for(Elfo elfo : exe.getOrdemDoUltimoAtaque())
        {
            if(elfo instanceof ElfoVerde && !elfoVerdeAtacou)
            {
                elfoVerdeAtacou = true;
                elfoNoturnoAtacou = false;
            } else if(elfo instanceof ElfoNoturno && !elfoNoturnoAtacou) {
                elfoNoturnoAtacou = true;
                elfoVerdeAtacou = false;
            } else if((elfo instanceof ElfoVerde && elfoVerdeAtacou) || (elfo instanceof ElfoNoturno && !elfoNoturnoAtacou)) {
                elfosIntercalados = false;
                break;
            }
        }        
        assertTrue(elfosIntercalados);
    }
    
    @Test
    public void atacarDwarfsSemExercito()
    {
        Exercito exe = new Exercito();
        exe.mudarEstrategia(new AtaqueIntercalado());
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
    
    private ArrayList<Dwarf> criarExercitoDeDwarfs(int n)
    {
        ArrayList<Dwarf> exe = new ArrayList<>();
        
        for(int i = 0; i < n; i++)
        {
            exe.add(new Dwarf("Dwarf" + i));
        }
        
        return exe;
    }
    
    private Exercito criarExercitoComEstrategiaAtaqueNaoIntercaladoComMaisVerdes()
    {
        Exercito exe = new Exercito();
        
        for(int i = 0; i < 10; i++)
        {            
            exe.alistarElfo(new ElfoVerde("ElfoVerde" + i));
            exe.alistarElfo(new ElfoNoturno("ElfoNoturno" + i));
            exe.alistarElfo(new ElfoVerde("ElfoVerde" + i));
        }
        
        exe.mudarEstrategia(new AtaqueIntercalado());
        
        return exe;
    }
    
    private Exercito criarExercitoComEstrategiaAtaqueNaoIntercaladoComMaisNoturnos()
    {
        Exercito exe = new Exercito();
        
        for(int i = 0; i < 10; i++)
        {            
            exe.alistarElfo(new ElfoNoturno("ElfoNoturno" + i));
            exe.alistarElfo(new ElfoVerde("ElfoVerde" + i));
            exe.alistarElfo(new ElfoNoturno("ElfoNoturno" + i));
        }
        
        exe.mudarEstrategia(new AtaqueIntercalado());
        
        return exe;
    }
    
    private Exercito criarExercitoComEstrategiaAtaqueIntercalado()
    {
        Exercito exe = new Exercito();
        
        for(int i = 0; i < 10; i++)
        {            
            exe.alistarElfo(new ElfoNoturno("ElfoNoturno" + i));
            exe.alistarElfo(new ElfoVerde("ElfoVerde" + i));
        }
        
        exe.mudarEstrategia(new AtaqueIntercalado());
        
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

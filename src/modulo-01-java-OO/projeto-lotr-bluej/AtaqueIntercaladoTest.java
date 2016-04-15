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
        AtaqueIntercalado exe = this.criarExercitoComEstrategiaAtaqueIntercalado();
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
        AtaqueIntercalado exe = this.criarExercitoComEstrategiaAtaqueNaoIntercaladoComMaisNoturnos();
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
        AtaqueIntercalado exe = this.criarExercitoComEstrategiaAtaqueNaoIntercaladoComMaisVerdes();
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
    
    private ArrayList<Dwarf> criarExercitoDeDwarfs(int n)
    {
        ArrayList<Dwarf> exe = new ArrayList<>();
        
        for(int i = 0; i < n; i++)
        {
            exe.add(new Dwarf("Dwarf" + i));
        }
        
        return exe;
    }
    
    private AtaqueIntercalado criarExercitoComEstrategiaAtaqueNaoIntercaladoComMaisVerdes()
    {
        Exercito exe = new Exercito();
        
        for(int i = 0; i < 10; i++)
        {            
            exe.alistarElfo(new ElfoVerde("ElfoVerde" + i));
            exe.alistarElfo(new ElfoNoturno("ElfoNoturno" + i));
            exe.alistarElfo(new ElfoVerde("ElfoVerde" + i));
        }
        
        return new AtaqueIntercalado(exe);
    }
    
    private AtaqueIntercalado criarExercitoComEstrategiaAtaqueNaoIntercaladoComMaisNoturnos()
    {
        Exercito exe = new Exercito();
        
        for(int i = 0; i < 10; i++)
        {            
            exe.alistarElfo(new ElfoNoturno("ElfoNoturno" + i));
            exe.alistarElfo(new ElfoVerde("ElfoVerde" + i));
            exe.alistarElfo(new ElfoNoturno("ElfoNoturno" + i));
        }
        
        return new AtaqueIntercalado(exe);
    }
    
    private AtaqueIntercalado criarExercitoComEstrategiaAtaqueIntercalado()
    {
        Exercito exe = new Exercito();
        
        for(int i = 0; i < 10; i++)
        {            
            exe.alistarElfo(new ElfoNoturno("ElfoNoturno" + i));
            exe.alistarElfo(new ElfoVerde("ElfoVerde" + i));
        }
        
        return new AtaqueIntercalado(exe);
    }
    
    private ElfoNoturno criarElfoMorto(String nome)
    {
        ElfoNoturno elfo = new ElfoNoturno(nome, 10000);
        
        while(elfo.getVidaElfoNoturno() != 0) 
            elfo.atirarFlechas();
        
        return elfo;
    }
}

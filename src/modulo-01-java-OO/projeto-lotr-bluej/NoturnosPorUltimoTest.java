import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class NoturnosPorUltimoTest
{
    @Test
    public void exercitoEmbaralhadoPriorizaAtaqueComElfosVerdes() throws NaoPodeAtacarException, NaoPodeAlistarException 
    {
        // Arrange
        Exercito exercito = new Exercito();
        exercito.mudarEstrategia(new NoturnosPorUltimo());
        Elfo en1 = new ElfoNoturno("Night 1");
        Elfo en2 = new ElfoNoturno("Night 2");
        Elfo ev1 = new ElfoVerde("Green 1");
        Elfo en3 = new ElfoNoturno("Night 3");
        Elfo ev2 = new ElfoVerde("Green 2");
        exercito.alistarElfo(en1);
        exercito.alistarElfo(en2);
        exercito.alistarElfo(ev1);
        exercito.alistarElfo(en3);
        exercito.alistarElfo(ev2);
        ArrayList<Elfo> esperado = new ArrayList<>(Arrays.asList(ev2, ev1, en3, en2, en1));
        // Act
        exercito.atacar(new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"), new Dwarf("D3"))));
        // Assert
        assertEquals(esperado, exercito.getOrdemDoUltimoAtaque());
    }

    @Test
    public void exercitoSóDeVerdes() throws NaoPodeAtacarException, NaoPodeAlistarException 
    {
        // Arrange
        Exercito exercito = new Exercito();
        exercito.mudarEstrategia(new NoturnosPorUltimo());
        Elfo ev1 = new ElfoVerde("Green 1");
        Elfo ev2 = new ElfoVerde("Green 2");
        exercito.alistarElfo(ev1);
        exercito.alistarElfo(ev2);
        ArrayList<Elfo> esperado = new ArrayList<>(Arrays.asList(ev2, ev1));
        // Act
        exercito.atacar(new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"), new Dwarf("D3"))));
        // Assert
        assertEquals(esperado, exercito.getOrdemDoUltimoAtaque());
    }

    @Test
    public void exercitoSóDeNoturnos() throws NaoPodeAtacarException, NaoPodeAlistarException 
    {
        // Arrange
        Exercito exercito = new Exercito();
        exercito.mudarEstrategia(new NoturnosPorUltimo());
        Elfo en1 = new ElfoNoturno("EN1");
        Elfo en2 = new ElfoNoturno("EN2");
        exercito.alistarElfo(en1);
        exercito.alistarElfo(en2);
        ArrayList<Elfo> esperado = new ArrayList<>(Arrays.asList(en2, en1));
        // Act
        exercito.atacar(new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"), new Dwarf("D3"))));
        // Assert
        assertEquals(esperado, exercito.getOrdemDoUltimoAtaque());
    }

    @Test
    public void ataqueComExercitoVazio() throws NaoPodeAtacarException, NaoPodeAlistarException 
    {
        Exercito exercito = new Exercito();
        exercito.mudarEstrategia(new NoturnosPorUltimo());
        exercito.atacar(new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"))));
        List<Elfo> ordemAtaque = exercito.getOrdemDoUltimoAtaque();
        assertTrue(ordemAtaque.isEmpty());
    }

    @Test
    public void ataqueComVerdesENoturnoMorto() throws NaoPodeAtacarException, NaoPodeAlistarException 
    {
        // Arrange
        Exercito exercito = new Exercito();
        exercito.mudarEstrategia(new NoturnosPorUltimo());
        Elfo en1 = new ElfoNoturno("Night 1");
        Elfo en2 = new ElfoNoturno("Night 2");
        Elfo ev1 = new ElfoVerde("Green 1");
        Elfo en3 = new ElfoNoturno("Night 3");
        Elfo ev2 = new ElfoVerde("Green 2");
        for (int i = 0; i < 90; i++) en1.atirarFlecha(new Dwarf("D1"));
        exercito.alistarElfo(en1);
        exercito.alistarElfo(en2);
        exercito.alistarElfo(ev1);
        exercito.alistarElfo(en3);
        exercito.alistarElfo(ev2);
        ArrayList<Elfo> esperado = new ArrayList<>(Arrays.asList(ev2, ev1, en3, en2));
        // Act
        exercito.atacar(new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"), new Dwarf("D3"))));
        // Assert
        assertEquals(esperado, exercito.getOrdemDoUltimoAtaque());
    }
    
    @Test
    public void atacarDwarfs() throws NaoPodeAtacarException, NaoPodeAlistarException 
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
    public void atacarDwarfsSemExercito() throws NaoPodeAtacarException, NaoPodeAlistarException 
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
    public void atacarDwarfsComNull() throws NaoPodeAtacarException, NaoPodeAlistarException 
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
    
    private ArrayList<Dwarf> criarExercito(int n)
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
    
    private Exercito criarExercitoComEstrategiaNoturnosPorUltimo() throws NaoPodeAlistarException 
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
            elfo.atirarFlecha();
        
        return elfo;
    }
}

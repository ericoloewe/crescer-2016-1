import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class ArteDaGuerraTest
{
    @Test
    public void atacarDwarfsComElfosNoturnos()
    {
        ArrayList<Dwarf> exeDwarfs = criarExercitoDeDwarfs(2);
        Exercito exe = new Exercito();
        exe.alistarElfo(new ElfoVerde("EV1"));
        exe.alistarElfo(new ElfoNoturno("EN1"));
        exe.alistarElfo(new ElfoNoturno("EN2"));
        exe.alistarElfo(new ElfoNoturno("EN3"));
        ArteDaGuerra adg = new ArteDaGuerra(exe);
        
        adg.atacar(exeDwarfs);
        
        for(Dwarf dwarf : exeDwarfs)
        {
            assertTrue(dwarf.getVida() < 110);
        }
        
        assertTrue(100 ==((ElfoNoturno) exe.buscarElfo("EN3")).getVidaElfoNoturno());
    }
    
    @Test
    public void atacarDwarfs()
    {
        ArteDaGuerra exe = this.criarExercitoComEstrategiaArteDaGuerra();
        ArrayList<Dwarf> exeDwarfs = criarExercitoDeDwarfs(10);
        exe.getExercito().alistarElfo(criarElfoMorto("Elfo00"));
        
        exe.atacar(exeDwarfs);
        
        for(Dwarf dwarf : exeDwarfs)
        {
            assertTrue(dwarf.getVida() < 110);
        }
    }
    
    @Test
    public void atacarDwarfsSemExercito()
    {
        Estrategia exe = new ArteDaGuerra(new Exercito());
        ArrayList<Dwarf> exeDwarfs = criarExercitoDeDwarfs(10);
        
        exe.atacar(exeDwarfs);
        
        for(Dwarf dwarf : exeDwarfs)
        {
            assertEquals(dwarf.getVida(), 110);
        }
    }
    
    @Test
    public void atacarDwarfsComNull()
    {
        Estrategia exe = new ArteDaGuerra(null);
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
    
    private ArteDaGuerra criarExercitoComEstrategiaArteDaGuerra()
    {
        Exercito exe = new Exercito();
        
        for(int i = 0; i < 10; i++)
        {
            exe.alistarElfo(new ElfoVerde("ElfoVerde" + i));
            exe.alistarElfo(new ElfoNoturno("ElfoNoturno" + i));
        }
        
        return new ArteDaGuerra(exe);
    }
    
    private ElfoNoturno criarElfoMorto(String nome)
    {
        ElfoNoturno elfo = new ElfoNoturno(nome, 10000);
        
        while(elfo.getVidaElfoNoturno() != 0) 
            elfo.atirarFlechas();
        
        return elfo;
    }
}

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class ArteDaGuerraTest
{
    @Test
    public void ataqueCom3Noturnos1Verde2Dwarves() throws NaoPodeAlistarException, NaoPodeAtacarException {
        Exercito exercito = new Exercito();
        Elfo elfoNoturno1 = new ElfoNoturno("EN1");
        Elfo elfoNoturno2 = new ElfoNoturno("EN2");
        Elfo elfoNoturno3 = new ElfoNoturno("EN3");
        Elfo elfoVerde1 = new ElfoVerde("EV1");
        exercito.alistarElfo(elfoNoturno1);
        exercito.alistarElfo(elfoNoturno2);
        exercito.alistarElfo(elfoNoturno3);
        exercito.alistarElfo(elfoVerde1);
        ArrayList<Dwarf> dwarves = new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2")));
        exercito.atacar(dwarves);
        List<Elfo> ordemAtaque = exercito.getOrdemDoUltimoAtaque();
        assertEquals(elfoVerde1, ordemAtaque.get(0));
        // para o hashmap deste exército, EN2 virá antes, depois EN1 e EN3.
        assertEquals(elfoNoturno2, ordemAtaque.get(1));
        assertEquals(4, ordemAtaque.size());
    }

    @Test
    public void ataqueCom3Noturnos4Dwarves() throws NaoPodeAlistarException, NaoPodeAtacarException {
        Exercito exercito = new Exercito();
        Elfo elfoNoturno1 = new ElfoNoturno("EN1");
        Elfo elfoNoturno2 = new ElfoNoturno("EN2");
        Elfo elfoNoturno3 = new ElfoNoturno("EN3");
        exercito.alistarElfo(elfoNoturno1);
        exercito.alistarElfo(elfoNoturno2);
        exercito.alistarElfo(elfoNoturno3);
        ArrayList<Dwarf> dwarves = new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"), new Dwarf("D3"), new Dwarf("D4")));
        exercito.atacar(dwarves);
        List<Elfo> ordemAtaque = exercito.getOrdemDoUltimoAtaque();
        // para o hashmap deste exército, EN2 virá antes, depois EN1 e EN3.
        assertEquals(elfoNoturno2, ordemAtaque.get(0));
        assertEquals(3, ordemAtaque.size());
    }

    @Test
    public void ataqueCom3VerdesApenas() throws NaoPodeAlistarException, NaoPodeAtacarException {
        Exercito exercito = new Exercito();
        Elfo elfoVerde1 = new ElfoVerde("EV1");
        Elfo elfoVerde2 = new ElfoVerde("EV2");
        Elfo elfoVerde3 = new ElfoVerde("EV3");
        exercito.alistarElfo(elfoVerde1);
        exercito.alistarElfo(elfoVerde2);
        exercito.alistarElfo(elfoVerde3);
        ArrayList<Dwarf> dwarves = new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2")));
        exercito.atacar(dwarves);
        List<Elfo> ordemAtaque = exercito.getOrdemDoUltimoAtaque();
        // para o hashmap deste exército, EV2 virá antes, depois EV1 e EV3.
        assertEquals(elfoVerde2, ordemAtaque.get(0));
        assertEquals(elfoVerde1, ordemAtaque.get(1));
        assertEquals(elfoVerde3, ordemAtaque.get(2));
        assertEquals(3, ordemAtaque.size());
    }

    @Test
    public void ataqueComExercitoVazio() throws NaoPodeAlistarException, NaoPodeAtacarException {
        Exercito exercito = new Exercito();
        ArrayList<Dwarf> dwarves = new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2")));
        exercito.atacar(dwarves);
        List<Elfo> ordemAtaque = exercito.getOrdemDoUltimoAtaque();
        assertTrue(ordemAtaque.isEmpty());
    }

    @Test
    public void ataque1VerdeOutroMorto() throws NaoPodeAlistarException, NaoPodeAtacarException {
        Exercito exercito = new Exercito();
        Elfo elfoVerde1 = new ElfoVerde("EV1");
        Elfo en1 = new ElfoNoturno("EN1");
        for (int i = 0; i < 90; i++) en1.atirarFlecha(new Dwarf("D1"));
        exercito.alistarElfo(elfoVerde1);
        exercito.alistarElfo(en1);
        ArrayList<Dwarf> dwarves = new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2")));
        exercito.atacar(dwarves);
        List<Elfo> ordemAtaque = exercito.getOrdemDoUltimoAtaque();
        assertEquals(elfoVerde1, ordemAtaque.get(0));
        assertEquals(1, ordemAtaque.size());
    }
    
    @Test
    public void atacarDwarfsComElfosNoturnos() throws NaoPodeAlistarException, NaoPodeAtacarException
    {
        ArrayList<Dwarf> exeDwarfs = criarExercitoDeDwarfs(2);
        Exercito exe = new Exercito();
        exe.mudarEstrategia(new ArteDaGuerra());
        exe.alistarElfo(new ElfoVerde("EV1"));
        exe.alistarElfo(new ElfoNoturno("EN1"));
        exe.alistarElfo(new ElfoNoturno("EN2"));
        exe.alistarElfo(new ElfoNoturno("EN3"));
        
        exe.atacar(exeDwarfs);
        
        for(Dwarf dwarf : exeDwarfs)
        {
            assertTrue(dwarf.getVida() < 110);
        }
        
        assertTrue(100 ==((ElfoNoturno) exe.buscarElfo("EN3")).getVidaElfoNoturno());
    }
    
    @Test
    public void atacarDwarfs() throws NaoPodeAlistarException, NaoPodeAtacarException
    {
        Exercito exe = this.criarExercitoComEstrategiaArteDaGuerra();
        ArrayList<Dwarf> exeDwarfs = criarExercitoDeDwarfs(10);
        exe.alistarElfo(criarElfoMorto("Elfo00"));
        
        exe.atacar(exeDwarfs);
        
        for(Dwarf dwarf : exeDwarfs)
        {
            assertTrue(dwarf.getVida() < 110);
        }
    }
    
    @Test
    public void atacarDwarfsSemExercito() throws NaoPodeAlistarException, NaoPodeAtacarException
    {
        Exercito exe = new Exercito();
        exe.mudarEstrategia(new ArteDaGuerra());
        ArrayList<Dwarf> exeDwarfs = criarExercitoDeDwarfs(10);
        
        exe.atacar(exeDwarfs);
        
        for(Dwarf dwarf : exeDwarfs)
        {
            assertEquals(dwarf.getVida(), 110);
        }
        assertEquals(new ArrayList<Elfo>(), exe.getOrdemDoUltimoAtaque());
    }
    
    @Test
    public void atacarDwarfsComNull() throws NaoPodeAlistarException, NaoPodeAtacarException
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
    
    private Exercito criarExercitoComEstrategiaArteDaGuerra() throws NaoPodeAlistarException
    {
        Exercito exe = new Exercito();
        
        for(int i = 0; i < 10; i++)
        {
            exe.alistarElfo(new ElfoVerde("ElfoVerde" + i));
            exe.alistarElfo(new ElfoNoturno("ElfoNoturno" + i));
        }
        
        exe.mudarEstrategia(new ArteDaGuerra());
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

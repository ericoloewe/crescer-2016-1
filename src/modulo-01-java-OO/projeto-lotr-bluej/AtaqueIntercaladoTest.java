import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class AtaqueIntercaladoTest
{
    @Test
    public void exercitoIntercaladoComeçandoComElfoNoturno() throws NaoPodeAtacarException, NaoPodeAlistarException {
        // Arrange
        Exercito exercito = new Exercito();
        exercito.mudarEstrategia(new AtaqueIntercalado());
        Elfo night1 = new ElfoNoturno("Night 1");
        Elfo night2 = new ElfoNoturno("Night 2");
        Elfo green1 = new ElfoVerde("Green 1");
        Elfo night3 = new ElfoNoturno("Night 3");
        Elfo green2 = new ElfoVerde("Green 2");
        Elfo green3 = new ElfoVerde("Green 3");
        exercito.alistarElfo(night1);
        exercito.alistarElfo(night2);
        exercito.alistarElfo(green1);
        exercito.alistarElfo(night3);
        exercito.alistarElfo(green2);
        exercito.alistarElfo(green3);
        List<Elfo> esperado = new ArrayList<>(Arrays.asList(green2, night3, green1, night2, green3, night1));
        // Act
        exercito.atacar(new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"), new Dwarf("D3"))));
        // Assert
        ArrayList<Elfo> resultado = exercito.getOrdemDoUltimoAtaque();
        assertEquals(esperado, resultado);
    }

    @Test
    public void exercitoIntercaladoComeçandoComElfoVerde() throws NaoPodeAtacarException, NaoPodeAlistarException {
        // Arrange
        Exercito exercito = new Exercito();
        exercito.mudarEstrategia(new AtaqueIntercalado());
        Elfo night1 = new ElfoNoturno("EN1");
        Elfo night2 = new ElfoNoturno("EN2");
        Elfo green1 = new ElfoVerde("EV1");
        Elfo green2 = new ElfoVerde("EV2");
        exercito.alistarElfo(night1);
        exercito.alistarElfo(night2);
        exercito.alistarElfo(green1);
        exercito.alistarElfo(green2);
        List<Elfo> esperado = new ArrayList<>(Arrays.asList(green2, night2, green1, night1));
        // Act
        exercito.atacar(new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"), new Dwarf("D3"))));
        // Assert
        ArrayList<Elfo> resultado = exercito.getOrdemDoUltimoAtaque();
        assertEquals(esperado, resultado);
    }

    @Test(expected=NaoPodeAtacarException.class)
    public void exercitoDesproporcionalNãoAtaca() throws NaoPodeAtacarException, NaoPodeAlistarException {
        // Arrange
        Exercito exercito = new Exercito();
        exercito.mudarEstrategia(new AtaqueIntercalado());
        Elfo night1 = new ElfoNoturno("Noturno 1");
        Elfo night2 = new ElfoNoturno("Elfo Noturno 2");
        Elfo green1 = new ElfoVerde("Elfo Verde 1");
        exercito.alistarElfo(green1);
        exercito.alistarElfo(night1);
        exercito.alistarElfo(night2);
        // Act
        exercito.atacar(new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"), new Dwarf("D3"))));
        // Assert
        ArrayList<Elfo> resultado = exercito.getOrdemDoUltimoAtaque();
        assertTrue(resultado.isEmpty());
    }

    @Test(expected=NaoPodeAtacarException.class)
    public void exercitoSoDeUmTipoNãoAtaca() throws NaoPodeAtacarException, NaoPodeAlistarException {
        // Arrange
        Exercito exercito = new Exercito();
        exercito.mudarEstrategia(new AtaqueIntercalado());
        Elfo night1 = new ElfoNoturno("Noturno 1");
        Elfo night2 = new ElfoNoturno("Elfo Noturno 2");
        exercito.alistarElfo(night1);
        exercito.alistarElfo(night2);
        // Act
        exercito.atacar(new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"), new Dwarf("D3"))));
        // Assert
        ArrayList<Elfo> resultado = exercito.getOrdemDoUltimoAtaque();
        assertTrue(resultado.isEmpty());
    }

    @Test
    public void ataqueComExercitoVazio() throws NaoPodeAtacarException, NaoPodeAlistarException {
        Exercito exercito = new Exercito();
        exercito.mudarEstrategia(new AtaqueIntercalado());
        exercito.atacar(new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"))));
        List<Elfo> ordemAtaque = exercito.getOrdemDoUltimoAtaque();
        assertTrue(ordemAtaque.isEmpty());
    }

    @Test(expected=NaoPodeAtacarException.class)
    public void exercitoIntercaladoComElfoNoturnoMortoDesproporcional() throws NaoPodeAtacarException, NaoPodeAlistarException {
        // Arrange
        Exercito exercito = new Exercito();
        exercito.mudarEstrategia(new AtaqueIntercalado());
        Elfo night1 = new ElfoNoturno("EN1");
        for (int i = 0; i < 90; i++) night1.atirarFlecha(new Dwarf("D1"));
        Elfo night2 = new ElfoNoturno("EN2");
        Elfo green1 = new ElfoVerde("EV1");
        Elfo green2 = new ElfoVerde("EV2");
        exercito.alistarElfo(night1);
        exercito.alistarElfo(night2);
        exercito.alistarElfo(green1);
        exercito.alistarElfo(green2);
        // Act
        exercito.atacar(new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"), new Dwarf("D3"))));
        // Assert
        assertTrue(exercito.getOrdemDoUltimoAtaque().isEmpty());
    }

    @Test
    public void exercitoIntercaladoComElfoNoturnoMortoProporcional() throws NaoPodeAtacarException, NaoPodeAlistarException {
        // Arrange
        Exercito exercito = new Exercito();
        exercito.mudarEstrategia(new AtaqueIntercalado());
        Elfo night1 = new ElfoNoturno("EN1");
        for (int i = 0; i < 90; i++) night1.atirarFlecha(new Dwarf("D1"));
        Elfo night2 = new ElfoNoturno("EN2");
        Elfo night3 = new ElfoNoturno("EN3");
        Elfo green1 = new ElfoVerde("EV1");
        Elfo green2 = new ElfoVerde("EV2");
        exercito.alistarElfo(night1);
        exercito.alistarElfo(night2);
        exercito.alistarElfo(night3);
        exercito.alistarElfo(green1);
        exercito.alistarElfo(green2);
        List<Elfo> esperado = new ArrayList<>(Arrays.asList(green2, night2, green1, night3));
        // Act
        exercito.atacar(new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"), new Dwarf("D3"))));
        // Assert
        assertEquals(esperado, exercito.getOrdemDoUltimoAtaque());
    }
    
    @Test
    public void atacarDwarfs() throws NaoPodeAtacarException, NaoPodeAlistarException
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
    public void atacarDwarfsComExercitoNaoIntercaladoComMaisElfosNoturnos() throws NaoPodeAtacarException, NaoPodeAlistarException
    {
        // Arrange
        Exercito exe = this.criarExercitoComEstrategiaAtaqueIntercaladoComMaisNoturnos();
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
    public void atacarDwarfsComExercitoNaoIntercaladoComMaisElfosVerdes() throws NaoPodeAtacarException, NaoPodeAlistarException
    {
        // Arrange
        Exercito exe = this.criarExercitoComEstrategiaAtaqueIntercaladoComMaisVerdes();
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
    public void atacarDwarfsSemExercito() throws NaoPodeAtacarException, NaoPodeAlistarException
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
    
    private ArrayList<Dwarf> criarExercitoDeDwarfs(int n)
    {
        ArrayList<Dwarf> exe = new ArrayList<>();
        
        for(int i = 0; i < n; i++)
        {
            exe.add(new Dwarf("Dwarf" + i));
        }
        
        return exe;
    }
    
    private Exercito criarExercitoComEstrategiaAtaqueIntercaladoComMaisVerdes() throws NaoPodeAlistarException
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
    
    private Exercito criarExercitoComEstrategiaAtaqueIntercaladoComMaisNoturnos() throws NaoPodeAlistarException
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
    
    private Exercito criarExercitoComEstrategiaAtaqueIntercalado() throws NaoPodeAlistarException
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
            elfo.atirarFlecha();
        
        return elfo;
    }
}

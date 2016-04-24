import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest
{
    @After
    public void tearDown()
    {
        System.gc();
    }
    
    @Test
    public void contadorDeElfosSemElfosNumElfoFilho()
    {
        assertEquals(0, Elfo.getContadorDeElfos());
    }
    
    @Test
    public void criarEAnalisarContadorDeElfosNumElfoFilho()
    {        
        new Elfo("Alfredo");
        
        assertEquals(1, Elfo.getContadorDeElfos());
    }
    
    @Test
    public void criar()
    {
        Float vidaEsperada = 100f;
        ElfoNoturno elfo = new ElfoNoturno("Atchim");
        assertTrue(vidaEsperada.equals(elfo.getVidaElfoNoturno()));
    }
    
    @Test
    public void perde5PorcentoDeVida()
    {
        Float vidaEsperada = 95f;
        ElfoNoturno elfo = new ElfoNoturno("Atchim");
        
        elfo.atirarFlecha();
        
        assertTrue(vidaEsperada.equals(elfo.getVidaElfoNoturno()));
    }
    
    @Test
    public void podeMorrer()
    {
        Float vidaEsperada = 0f;
        ElfoNoturno elfo = new ElfoNoturno("Atchim", 1000000);
        
        while(true)
        {
            if(!elfo.atirarFlecha())
                break;
        }
        
        assertTrue(vidaEsperada.equals(elfo.getVidaElfoNoturno()));
    }
}
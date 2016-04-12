import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest
{
    @Test
    public void criar()
    {
        Float vidaEsperada = 100f;
        ElfoNoturno elfo = new ElfoNoturno("Atchim");
        assertTrue(vidaEsperada.equals(elfo.getVida()));
    }
    
    @Test
    public void perde5PorcentoDeVida()
    {
        Float vidaEsperada = 95f;
        ElfoNoturno elfo = new ElfoNoturno("Atchim");
        
        elfo.atirarFlechas();
        
        assertTrue(vidaEsperada.equals(elfo.getVida()));
    }
    
    @Test
    public void podeMorrer()
    {
        Float vidaEsperada = 0f;
        ElfoNoturno elfo = new ElfoNoturno("Atchim", 1000000);
        
        while(true)
        {
            if(!elfo.atirarFlechas())
                break;
        }
        
        assertTrue(vidaEsperada.equals(elfo.getVida()));
    }
}
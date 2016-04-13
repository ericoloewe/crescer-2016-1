import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoTest
{
    @After
    public void tearDown()
    {
        System.gc();
    }
    
    @Test
    public void addElfoAoExercito()
    {
        Exercito exe = new Exercito();
        
        assertFalse(exe.alistarElfo(new Elfo("Auriel")));
    }
    
    @Test
    public void addElfoVerdeAoExercito()
    {
        Exercito exe = new Exercito();
        
        assertTrue(exe.alistarElfo(new ElfoVerde("Auriel")));
    }
    
    @Test
    public void addElfoNoturnoAoExercito()
    {
        Exercito exe = new Exercito();
        
        assertTrue(exe.alistarElfo(new ElfoNoturno("Auriel")));
    }
}

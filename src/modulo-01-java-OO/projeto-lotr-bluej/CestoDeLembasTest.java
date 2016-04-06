

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CestoDeLembasTest
{
    @Test
    public void criarCestoCom2Lembas()
    {
        CestoDeLembas cesto = new CestoDeLembas(2);
        boolean esperado = false;
        boolean obtido = cesto.podeDividirEmPares();
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void criarCestoCom6Lembas()
    {
        CestoDeLembas cesto = new CestoDeLembas(6);
        boolean esperado = true;
        boolean obtido = cesto.podeDividirEmPares();
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void criarCestoCom101Lembas()
    {
        CestoDeLembas cesto = new CestoDeLembas(101);
        boolean esperado = false;
        boolean obtido = cesto.podeDividirEmPares();
        
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void criarCestoComMenosUmLembas()
    {
        CestoDeLembas cesto = new CestoDeLembas(-1);
        boolean esperado = false;
        boolean obtido = cesto.podeDividirEmPares();
        
        assertEquals(esperado, obtido);
    }
}
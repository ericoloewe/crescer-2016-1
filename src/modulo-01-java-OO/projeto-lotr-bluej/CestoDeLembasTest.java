

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CestoDeLembasTest
{
    @Test
    public void criarCestoCom2Lembas() {
        CestoDeLembas cesto = new CestoDeLembas(2);
        boolean esperado = false;
        boolean obtido = cesto.podeDividirEmPares();
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void criarCestoCom4Lembas() {
        CestoDeLembas cesto = new CestoDeLembas(4);
        boolean esperado = true;
        boolean obtido = cesto.podeDividirEmPares();
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void criarCestoComMenosUmLembas() {
        CestoDeLembas cesto = new CestoDeLembas(-1);
        assertEquals(false, cesto.podeDividirEmPares());
    }
    
    @Test
    public void criarCestoComMenos101Lembas() {
        CestoDeLembas cesto = new CestoDeLembas(101);
        assertEquals(false, cesto.podeDividirEmPares());
    }
}






















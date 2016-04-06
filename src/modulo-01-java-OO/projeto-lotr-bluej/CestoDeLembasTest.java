

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CestoDeLembasTest
{
    @Test
<<<<<<< HEAD
    public void criarCestoCom2Lembas()
    {
        CestoDeLembas cesto = new CestoDeLembas(2);
        boolean esperado = false;
        boolean obtido = cesto.podeDividirEmPares();
        
=======
    public void criarCestoCom2Lembas() {
        CestoDeLembas cesto = new CestoDeLembas(2);
        boolean esperado = false;
        boolean obtido = cesto.podeDividirEmPares();
>>>>>>> 57176bd8f0845366c0cda6e11abf05a2bb7afaf1
        assertEquals(esperado, obtido);
    }
    
    @Test
<<<<<<< HEAD
    public void criarCestoCom6Lembas()
    {
        CestoDeLembas cesto = new CestoDeLembas(6);
        boolean esperado = true;
        boolean obtido = cesto.podeDividirEmPares();
        
=======
    public void criarCestoCom4Lembas() {
        CestoDeLembas cesto = new CestoDeLembas(4);
        boolean esperado = true;
        boolean obtido = cesto.podeDividirEmPares();
>>>>>>> 57176bd8f0845366c0cda6e11abf05a2bb7afaf1
        assertEquals(esperado, obtido);
    }
    
    @Test
<<<<<<< HEAD
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
=======
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





















>>>>>>> 57176bd8f0845366c0cda6e11abf05a2bb7afaf1

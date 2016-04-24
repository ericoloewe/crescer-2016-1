import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @After
    public void tearDown()
    {
        System.gc();
    }
    
    @Test
    public void criarElfo()
    {
        String nomeEsperado = "Alfredo";
        int flechasEsperadas = 42;
        int experienciaEsperada = 0;
        
        Elfo elfo = new Elfo("Alfredo");
        
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
        assertEquals(experienciaEsperada, elfo.getExperiencia());
    }
    
    @Test
    public void criarElfoComFlechas()
    {
        String nomeEsperado = "Alfredo";
        int flechasEsperadas = 100;
        int experienciaEsperada = 0;
        
        Elfo elfo = new Elfo("Alfredo", 100);   
        
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
        assertEquals(experienciaEsperada, elfo.getExperiencia());
    }
    
    @Test
    public void contadorDeElfosSemElfos()
    {
        assertEquals(0, Elfo.getContadorDeElfos());
    }
    
    @Test
    public void criarEAnalisarContadorDeElfos()
    {        
        new Elfo("Alfredo");
        
        assertEquals(1, Elfo.getContadorDeElfos());
    }
    
    @Test
    public void criarEAnalisarContadorDeElfosCom3Elfos()
    {        
        new Elfo("Alfredo");
        new Elfo("Alfredo");
        new Elfo("Alfredo");
        
        assertEquals(3, Elfo.getContadorDeElfos());
    }
    
    @Test
    public void aumentaExperienciaAoAtirarUmaFlecha()
    {
        Elfo elfo = new Elfo("Alfredo");
        
        int esperado = elfo.getExperiencia() + 1;
        elfo.atirarFlecha();
        int obtido = elfo.getExperiencia();
        
        assertEquals(obtido, esperado);
    }
    
    @Test
    public void diminuiFlechasAoAtirarUmaFlecha()
    {
        Elfo elfo = new Elfo("Alfredo");
        
        int esperado = elfo.getFlechas() - 1;
        elfo.atirarFlecha();
        int obtido = elfo.getFlechas();
        
        assertEquals(obtido, esperado);
    }
    
    @Test
    public void atirarFlechaEmUmDwarfEDiminuirAVidaDoMesmo()
    {
        Elfo elfo = new Elfo("Alfredo");
        Dwarf dwarf = new Dwarf("Joaquim");        
        
        int esperado = dwarf.getVida() - 10;
        elfo.atirarFlecha(dwarf);
        int obtido = dwarf.getVida();
        
        assertEquals(obtido, esperado);
    }
    
    @Test
    public void retornoToStringCoerenteAoQueFoiSolicitado()
    {
        Elfo elfo = new Elfo("Alfredo");      
        
        String esperado = "Alfredo possui " + elfo.getFlechas() + " flechas e " + elfo.getExperiencia() + " níveis de experiência.";
        String obtido = elfo.toString();
        
        assertEquals(esperado, obtido);
    }
}

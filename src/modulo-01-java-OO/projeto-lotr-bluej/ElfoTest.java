import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void aumentaExperienciaAoAtirarUmaFlecha()
    {
        Elfo elfo = new Elfo("Alfredo");
        
        int esperado = elfo.getExperiencia() + 1;
        elfo.atirarFlechas();
        int obtido = elfo.getExperiencia();
        
        assertEquals(obtido, esperado);
    }
    
    @Test
    public void diminuiFlechasAoAtirarUmaFlecha()
    {
        Elfo elfo = new Elfo("Alfredo");
        
        int esperado = elfo.getFlechas() - 1;
        elfo.atirarFlechas();
        int obtido = elfo.getFlechas();
        
        assertEquals(obtido, esperado);
    }
    
    @Test
    public void atirarFlechaEmUmDwarfEDiminuirAVidaDoMesmo()
    {
        Elfo elfo = new Elfo("Alfredo");
        Dwarf dwarf = new Dwarf("Joaquim");        
        
        int esperado = dwarf.getVida() - 10;
        elfo.atirarFlechas(dwarf);
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

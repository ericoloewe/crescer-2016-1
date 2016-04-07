import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DwarfTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DwarfTest
{
    @Test
    public void dwarfNasceVivo() {
        Dwarf dwarf = new Dwarf("Balin");
        
        assertEquals(Status.VIVO, dwarf.getStatus());
    }
    
    @Test
    public void diminuirVidaDoDwarf()
    {
        Dwarf dwarf = new Dwarf("Joaquim");
        
        int esperado = dwarf.getVida() - 1;
        dwarf.perdeVida();
        int obtido = dwarf.getVida();
                
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void diminuirVidaDoDwarfComQuantidade()
    {
        Dwarf dwarf = new Dwarf("Joaquim");
        
        int esperado = dwarf.getVida() - 10;
        dwarf.perdeVida(10);
        int obtido = dwarf.getVida();
                
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void matarDwarf()
    {
        Dwarf dwarf = new Dwarf("Joaquim");
        Status esperado = Status.MORTO;
        
        dwarf.perdeVida(dwarf.getVida());        
        Status obtido = dwarf.getStatus();
        
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void dwarfComVidaMenos1()
    {
        Dwarf dwarf = new Dwarf("Joaquim");
        int esperado = 0;
        
        dwarf.perdeVida(dwarf.getVida()+1);
        int obtido = dwarf.getVida();
        
        assertEquals(esperado, obtido);
    }
}

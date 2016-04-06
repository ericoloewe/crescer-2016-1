

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
}

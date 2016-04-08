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
    public void minhaSorte() 
    {
        Dwarf dwarf = new Dwarf("Balin");        
        double esperado = 101.0;
        
        double obtido = dwarf.getNumeroSorte();
        
        assertTrue(esperado == obtido);
    }
    
    @Test
    public void minhaSorteComNomeMeirelesOuSeixasComAnoBissexto() 
    {
        Dwarf meireles = new Dwarf("Meireles", new DataTerceiraEra(1,1,2000));
        Dwarf seixas = new Dwarf("Seixas", new DataTerceiraEra(1,1,2000));
        double esperado = 101;
        
        double obtido = meireles.getNumeroSorte();        
        assertTrue(esperado == obtido);
        obtido = seixas.getNumeroSorte();        
        assertTrue(esperado == obtido);
    }
    
    @Test
    public void minhaSorteComNomeMeirelesOuSeixasSemAnoBissexto() 
    {
        Dwarf meireles = new Dwarf("Meireles");
        Dwarf seixas = new Dwarf("Seixas");
        double esperado = 33;
        
        double obtido = meireles.getNumeroSorte();        
        assertTrue(esperado == obtido);
        obtido = seixas.getNumeroSorte();        
        assertTrue(esperado == obtido);
    }
    
    @Test
    public void minhaSorteComVida90() 
    {
        Dwarf dwarf = new Dwarf("Balin");        
        double esperado = 101.0;
        
        dwarf.perdeVida();
        dwarf.perdeVida();
        double obtido = dwarf.getNumeroSorte();
        
        assertTrue(esperado == obtido);
    }
    
    @Test
    public void minhaSorteComAnoBissexto() 
    {
        Dwarf dwarf = new Dwarf("Balin", new DataTerceiraEra(1,1,2000));        
        double esperado = 101.0;
        
        double obtido = dwarf.getNumeroSorte();
        
        assertTrue(esperado == obtido);
    }
    
    @Test
    public void minhaSorteComAnoBissextoEVida90() 
    {
        Dwarf dwarf = new Dwarf("Balin", new DataTerceiraEra(1,1,2000));        
        double esperado = -3333;
        
        dwarf.perdeVida();
        dwarf.perdeVida();
        double obtido = dwarf.getNumeroSorte();
        
        assertTrue(esperado == obtido);
    }
    
    @Test
    public void dwarfNasceVivo() 
    {
        Dwarf dwarf = new Dwarf("Balin");
        
        assertEquals(Status.VIVO, dwarf.getStatus());
    }
    
    @Test
    public void dwarfNasceComAniversario() 
    {
        DataTerceiraEra data = new DataTerceiraEra(1, 1, 2016);
        Dwarf dwarf = new Dwarf("Balin", data);
        
        assertEquals(dwarf.getDataNascimento(), data);
    }
    
    @Test
    public void diminuirVidaDoDwarf()
    {
        Dwarf dwarf = new Dwarf("Joaquim");
        
        int esperado = dwarf.getVida() - 10;
        dwarf.perdeVida();
        int obtido = dwarf.getVida();
                
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void diminuirVidaDoDwarfComQuantidade()
    {
        Dwarf dwarf = new Dwarf("Joaquim");
        
        int esperado = dwarf.getVida() - 10;
        dwarf.perdeVida();
        int obtido = dwarf.getVida();
                
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void matarDwarf()
    {
        Dwarf dwarf = new Dwarf("Joaquim");
        Status esperado = Status.MORTO;
        
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        
        Status obtido = dwarf.getStatus();
        
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void dwarfComVidaMenos10()
    {
        Dwarf dwarf = new Dwarf("Joaquim");
        int esperado = 0;
        
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        
        int obtido = dwarf.getVida();
        
        assertEquals(esperado, obtido);
    }
}

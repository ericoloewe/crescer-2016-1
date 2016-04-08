import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void criarDwarf() 
    {
        Dwarf dwarf = new Dwarf("Joaquim");

        assertEquals(dwarf.getVida(), 110);
        assertEquals(dwarf.getNome(), "Joaquim");
        assertEquals(dwarf.getExperiencia(), 0);
        assertEquals(dwarf.getStatus(), Status.VIVO);
    }
    
    @Test
    public void criarDwarfComDataNasc() 
    {
        DataTerceiraEra data = new DataTerceiraEra(1,1,1996);
        Dwarf dwarf = new Dwarf("Joaquim", data);

        assertEquals(dwarf.getVida(), 110);
        assertEquals(dwarf.getNome(), "Joaquim");
        assertEquals(dwarf.getExperiencia(), 0);
        assertEquals(dwarf.getStatus(), Status.VIVO);
        assertEquals(dwarf.getDataNascimento(), data);
    }
    
    @Test
    public void sorteNaPerdaDeVidaDoPedroQueNasceuNumAnoBissextoEQuePerdeu20Vidas() 
    {
        Dwarf dwarf = new Dwarf("Pedro", new DataTerceiraEra(1,1,1996));
        int vidaEsperada = 90;
        int experienciaEsperada = 2;
        
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        int vidaObtida = dwarf.getVida();
        int experienciaObitida = dwarf.getExperiencia();
        
        assertEquals(vidaEsperada, vidaObtida);
        assertEquals(experienciaEsperada, experienciaObitida);
        
    }
    
    @Test
    public void sorteNaPerdaDeVidaDoJoaquim() 
    {
        Dwarf dwarf = new Dwarf("Joaquim");
        int vidaEsperada = 100;
        int experienciaEsperada = 0;
        
        dwarf.perdeVida();
        int vidaObtida = dwarf.getVida();
        int experienciaObitida = dwarf.getExperiencia();
        
        assertEquals(vidaEsperada, vidaObtida);
        assertEquals(experienciaEsperada, experienciaObitida);
    }
    
    @Test
    public void sorteNaPerdaDeVidaDoSeixasQueNasceuNumAnoBissexto() 
    {
        Dwarf dwarf = new Dwarf("Seixas", new DataTerceiraEra(1,1,1996));
        int vidaEsperada = 100;
        int experienciaEsperada = 0;
        
        dwarf.perdeVida();
        int vidaObtida = dwarf.getVida();
        int experienciaObitida = dwarf.getExperiencia();
        
        assertEquals(vidaEsperada, vidaObtida);
        assertEquals(experienciaEsperada, experienciaObitida);
    }
    
    @Test
    public void sorteNaPerdaDeVidaDoSeixas() 
    {
        Dwarf dwarf = new Dwarf("Seixas", new DataTerceiraEra(1,1,1995));
        int vidaEsperada = 110;
        int experienciaEsperada = 0;
        
        dwarf.perdeVida();
        int vidaObtida = dwarf.getVida();
        int experienciaObitida = dwarf.getExperiencia();
        
        assertEquals(vidaEsperada, vidaObtida);
        assertEquals(experienciaEsperada, experienciaObitida);
    }
    
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

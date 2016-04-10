import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest
{
    @Test
    public void criarIrishDwarf() 
    {
        IrishDwarf irishDwarf = new IrishDwarf("Joaquim");

        assertEquals(irishDwarf.getVida(), 110);
        assertEquals(irishDwarf.getNome(), "Joaquim");
        assertEquals(irishDwarf.getExperiencia(), 0);
        assertEquals(irishDwarf.getStatus(), Status.VIVO);
    }
    
    @Test
    public void criarIrishDwarfComDataNasc() 
    {
        DataTerceiraEra data = new DataTerceiraEra(1,1,1996);
        IrishDwarf irishDwarf = new IrishDwarf("Joaquim", data);

        assertEquals(irishDwarf.getVida(), 110);
        assertEquals(irishDwarf.getNome(), "Joaquim");
        assertEquals(irishDwarf.getExperiencia(), 0);
        assertEquals(irishDwarf.getStatus(), Status.VIVO);
        assertEquals(irishDwarf.getDataNascimento(), data);
    }
    
    @Test
    public void irishDwarfTentaSorteComListaVazia() 
    {
        IrishDwarf irishDwarf = new IrishDwarf("Balin", new DataTerceiraEra(1,1,2000));
        
        irishDwarf.tentarSorte();
        
        assertTrue(irishDwarf.getInventario().getItens().size() == 0);
    }
    
    @Test
    public void irishDwarfTentaSorteComSucesso() 
    {
        IrishDwarf irishDwarf = new IrishDwarf("Balin", new DataTerceiraEra(1,1,2000));
        irishDwarf.adicionarItemAoInventario(new Item(3, "Chapeu"));
        irishDwarf.adicionarItemAoInventario(new Item(3, "Espada"));
        int esperado = 6003;
        
        irishDwarf.perdeVida();
        irishDwarf.perdeVida();
        irishDwarf.tentarSorte();
        
        for(Item item : irishDwarf.getInventario().getItens())
        {
            assertEquals(item.getQuantidade(), esperado);
        }
    }
    
    @Test
    public void irishDwarfTentaSorteComMaisSucesso() 
    {
        IrishDwarf irishDwarf = new IrishDwarf("Balin", new DataTerceiraEra(1,1,2000));
        irishDwarf.adicionarItemAoInventario(new Item(5, "Chapeu"));
        irishDwarf.adicionarItemAoInventario(new Item(5, "Espada"));
        int esperado = 120005;
        
        irishDwarf.perdeVida();
        irishDwarf.perdeVida();
        irishDwarf.tentarSorte();
        
        for(Item item : irishDwarf.getInventario().getItens())
        {
            assertEquals(item.getQuantidade(), esperado);
        }
    }
    
    @Test
    public void irishDwarfTentaSorteSemSucesso() 
    {
        IrishDwarf irishDwarf = new IrishDwarf("Balin", new DataTerceiraEra(1,1,2000));
        irishDwarf.adicionarItemAoInventario(new Item(10, "Vida"));
        irishDwarf.adicionarItemAoInventario(new Item(10, "Espada"));
        int esperado = 10;
        
        irishDwarf.tentarSorte();
        
        for(Item item : irishDwarf.getInventario().getItens())
        {
            assertEquals(item.getQuantidade(), esperado);
        }
    }
    
    @Test
    public void sorteNaPerdaDeVidaDoPedroQueNasceuNumAnoBissextoEQuePerdeu20Vidas() 
    {
        IrishDwarf irishDwarf = new IrishDwarf("Pedro", new DataTerceiraEra(1,1,1996));
        int vidaEsperada = 90;
        int experienciaEsperada = 2;
        
        irishDwarf.perdeVida();
        irishDwarf.perdeVida();
        irishDwarf.perdeVida();
        int vidaObtida = irishDwarf.getVida();
        int experienciaObitida = irishDwarf.getExperiencia();
        
        assertEquals(vidaEsperada, vidaObtida);
        assertEquals(experienciaEsperada, experienciaObitida);
        
    }
    
    @Test
    public void sorteNaPerdaDeVidaDoJoaquim() 
    {
        IrishDwarf irishDwarf = new IrishDwarf("Joaquim");
        int vidaEsperada = 100;
        int experienciaEsperada = 0;
        
        irishDwarf.perdeVida();
        int vidaObtida = irishDwarf.getVida();
        int experienciaObitida = irishDwarf.getExperiencia();
        
        assertEquals(vidaEsperada, vidaObtida);
        assertEquals(experienciaEsperada, experienciaObitida);
    }
    
    @Test
    public void sorteNaPerdaDeVidaDoSeixasQueNasceuNumAnoBissexto() 
    {
        IrishDwarf irishDwarf = new IrishDwarf("Seixas", new DataTerceiraEra(1,1,1996));
        int vidaEsperada = 100;
        int experienciaEsperada = 0;
        
        irishDwarf.perdeVida();
        int vidaObtida = irishDwarf.getVida();
        int experienciaObitida = irishDwarf.getExperiencia();
        
        assertEquals(vidaEsperada, vidaObtida);
        assertEquals(experienciaEsperada, experienciaObitida);
    }
    
    @Test
    public void sorteNaPerdaDeVidaDoSeixas() 
    {
        IrishDwarf irishDwarf = new IrishDwarf("Seixas", new DataTerceiraEra(1,1,1995));
        int vidaEsperada = 110;
        int experienciaEsperada = 0;
        
        irishDwarf.perdeVida();
        int vidaObtida = irishDwarf.getVida();
        int experienciaObitida = irishDwarf.getExperiencia();
        
        assertEquals(vidaEsperada, vidaObtida);
        assertEquals(experienciaEsperada, experienciaObitida);
    }
    
    @Test
    public void minhaSorte() 
    {
        IrishDwarf irishDwarf = new IrishDwarf("Balin");        
        double esperado = 101.0;
        
        double obtido = irishDwarf.getNumeroSorte();
        
        assertTrue(esperado == obtido);
    }
    
    @Test
    public void minhaSorteComNomeMeirelesOuSeixasComAnoBissexto() 
    {
        IrishDwarf meireles = new IrishDwarf("Meireles", new DataTerceiraEra(1,1,2000));
        IrishDwarf seixas = new IrishDwarf("Seixas", new DataTerceiraEra(1,1,2000));
        double esperado = 101;
        
        double obtido = meireles.getNumeroSorte();        
        assertTrue(esperado == obtido);
        obtido = seixas.getNumeroSorte();        
        assertTrue(esperado == obtido);
    }
    
    @Test
    public void minhaSorteComNomeMeirelesOuSeixasSemAnoBissexto() 
    {
        IrishDwarf meireles = new IrishDwarf("Meireles");
        IrishDwarf seixas = new IrishDwarf("Seixas");
        double esperado = 33;
        
        double obtido = meireles.getNumeroSorte();        
        assertTrue(esperado == obtido);
        obtido = seixas.getNumeroSorte();        
        assertTrue(esperado == obtido);
    }
    
    @Test
    public void minhaSorteComVida90() 
    {
        IrishDwarf irishDwarf = new IrishDwarf("Balin");        
        double esperado = 101.0;
        
        irishDwarf.perdeVida();
        irishDwarf.perdeVida();
        double obtido = irishDwarf.getNumeroSorte();
        
        assertTrue(esperado == obtido);
    }
    
    @Test
    public void minhaSorteComAnoBissexto() 
    {
        IrishDwarf irishDwarf = new IrishDwarf("Balin", new DataTerceiraEra(1,1,2000));        
        double esperado = 101.0;
        
        double obtido = irishDwarf.getNumeroSorte();
        
        assertTrue(esperado == obtido);
    }
    
    @Test
    public void minhaSorteComAnoBissextoEVida90() 
    {
        IrishDwarf irishDwarf = new IrishDwarf("Balin", new DataTerceiraEra(1,1,2000));        
        double esperado = -3333;
        
        irishDwarf.perdeVida();
        irishDwarf.perdeVida();
        double obtido = irishDwarf.getNumeroSorte();
        
        assertTrue(esperado == obtido);
    }
    
    @Test
    public void irishDwarfNasceVivo() 
    {
        IrishDwarf irishDwarf = new IrishDwarf("Balin");
        
        assertEquals(Status.VIVO, irishDwarf.getStatus());
    }
    
    @Test
    public void irishDwarfNasceComAniversario() 
    {
        DataTerceiraEra data = new DataTerceiraEra(1, 1, 2016);
        IrishDwarf irishDwarf = new IrishDwarf("Balin", data);
        
        assertEquals(irishDwarf.getDataNascimento(), data);
    }
    
    @Test
    public void diminuirVidaDoIrishDwarf()
    {
        IrishDwarf irishDwarf = new IrishDwarf("Joaquim");
        
        int esperado = irishDwarf.getVida() - 10;
        irishDwarf.perdeVida();
        int obtido = irishDwarf.getVida();
                
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void diminuirVidaDoIrishDwarfComQuantidade()
    {
        IrishDwarf irishDwarf = new IrishDwarf("Joaquim");
        
        int esperado = irishDwarf.getVida() - 10;
        irishDwarf.perdeVida();
        int obtido = irishDwarf.getVida();
                
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void matarIrishDwarf()
    {
        IrishDwarf irishDwarf = new IrishDwarf("Joaquim");
        Status esperado = Status.MORTO;
        
        irishDwarf.perdeVida();
        irishDwarf.perdeVida();
        irishDwarf.perdeVida();
        irishDwarf.perdeVida();
        irishDwarf.perdeVida();
        irishDwarf.perdeVida();
        irishDwarf.perdeVida();
        irishDwarf.perdeVida();
        irishDwarf.perdeVida();
        irishDwarf.perdeVida();
        irishDwarf.perdeVida();
        
        Status obtido = irishDwarf.getStatus();
        
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void irishDwarfComVidaMenos10()
    {
        IrishDwarf irishDwarf = new IrishDwarf("Joaquim");
        int esperado = 0;
        
        irishDwarf.perdeVida();
        irishDwarf.perdeVida();
        irishDwarf.perdeVida();
        irishDwarf.perdeVida();
        irishDwarf.perdeVida();
        irishDwarf.perdeVida();
        irishDwarf.perdeVida();
        irishDwarf.perdeVida();
        irishDwarf.perdeVida();
        irishDwarf.perdeVida();
        irishDwarf.perdeVida();
        irishDwarf.perdeVida();
        
        int obtido = irishDwarf.getVida();
        
        assertEquals(esperado, obtido);
    }
}

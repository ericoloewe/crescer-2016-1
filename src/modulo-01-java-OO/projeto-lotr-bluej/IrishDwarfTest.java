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
        int esperado = 15005;
        
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
}

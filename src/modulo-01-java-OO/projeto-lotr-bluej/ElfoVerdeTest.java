import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest
{
    @After
    public void tearDown()
    {
        System.gc();
    }
    
    @Test
    public void contadorDeElfosSemElfosNumElfoFilho()
    {
        assertEquals(0, Elfo.getContadorDeElfos());
    }
    
    @Test
    public void criarEAnalisarContadorDeElfosNumElfoFilho()
    {        
        new Elfo("Alfredo");
        
        assertEquals(1, Elfo.getContadorDeElfos());
    }
    
    @Test
    public void addERemoverItemNaListaDeItemsComSucesso()
    {
        Item espada = new Item(10, "Espada de aço valiriano");
        Item arco = new Item(20, "Arco e Flecha de Vidro");
        Elfo elfo = new ElfoVerde("Elfo");
        
        assertTrue(elfo.adicionarItemAoInventario(espada));
        assertTrue(elfo.adicionarItemAoInventario(arco));
        
        assertTrue(elfo.removerItemDoInventario(espada));
        assertTrue(elfo.removerItemDoInventario(arco));
    }
    
    @Test
    public void addERemoverItemNaListaDeItemsSemSucesso()
    {
        Item espada = new Item(20, "Espada");
        Item arco = new Item(10, "Arco e Flecha");
        Elfo elfo = new ElfoVerde("Elfo");
        
        assertFalse(elfo.adicionarItemAoInventario(espada));
        assertFalse(elfo.adicionarItemAoInventario(arco));
        
        assertFalse(elfo.removerItemDoInventario(espada));
        assertFalse(elfo.removerItemDoInventario(arco));
    }
}

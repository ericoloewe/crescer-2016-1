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
        
        elfo.adicionarItemAoInventario(espada);
        elfo.adicionarItemAoInventario(arco);
        assertEquals(2, elfo.getInventario().getItens().size());
        
        elfo.removerItemDoInventario(espada);
        elfo.removerItemDoInventario(arco);
        assertEquals(0, elfo.getInventario().getItens().size());
    }
    
    @Test
    public void addERemoverItemNaListaDeItemsSemSucesso()
    {
        Item espada = new Item(20, "Espada");
        Item arco = new Item(10, "Arco e Flecha");
        Elfo elfo = new ElfoVerde("Elfo");
        
        elfo.adicionarItemAoInventario(espada);
        elfo.adicionarItemAoInventario(arco);
        assertEquals(0, elfo.getInventario().getItens().size());
        
        elfo.removerItemDoInventario(espada);
        elfo.removerItemDoInventario(arco);
        assertEquals(0, elfo.getInventario().getItens().size());
    }
}

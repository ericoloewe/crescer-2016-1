import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest
{
    @Test
    public void addERemoverItemNaListaDeItems()
    {
        Item item = new Item(10, "");
        Inventario inv = new Inventario();
        
        inv.adicionarItem(item);
        
        assertTrue(inv.adicionarItem(item));
        
        assertTrue(inv.removerItem(item));
    }
    
    @Test
    public void descricaoDeItems()
    {
        String esperado = "Adaga,Escudo,Bracelete";
        Inventario inv = new Inventario();
        inv.adicionarItem(new Item(10, "Adaga"));
        inv.adicionarItem(new Item(100, "Escudo"));
        inv.adicionarItem(new Item(100, "Bracelete"));
        
        String obtido = inv.getDescricoesItens();
        
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void descricaoDeItemsComNull()
    {
        String esperado = "Adaga,Escudo,null";
        Inventario inv = new Inventario();
        inv.adicionarItem(new Item(10, "Adaga"));
        inv.adicionarItem(new Item(100, "Escudo"));
        inv.adicionarItem(new Item(100, null));
        
        String obtido = inv.getDescricoesItens();
        
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void descricaoDeItemsVazia()
    {
        String esperado = "";
        Inventario inv = new Inventario();
        
        String obtido = inv.getDescricoesItens();
        
        assertEquals(esperado, obtido);
    }
}

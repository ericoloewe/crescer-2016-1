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
}

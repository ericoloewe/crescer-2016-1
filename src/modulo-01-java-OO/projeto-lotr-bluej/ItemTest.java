import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest
{
    @Test
    public void criarItem()
    {
        Item item = new Item(10, "Lorem ipsum dolor sit amet");
        
        assertEquals(item.getQuantidade(), 10);
        assertEquals(item.getDescricao(), "Lorem ipsum dolor sit amet");
    }
    
    @Test
    public void igualarDoisItems()
    {
        Item item = new Item(10, "Lorem ipsum dolor sit amet");
        Item item2 = new Item(10, "Lorem ipsum dolor sit amet");
        
        assertEquals(item, item2);
    }
    
    @Test
    public void igualarDoisItemsComNull()
    {
        Item item = new Item(10, null);
        Item item2 = new Item(10, null);
        
        assertEquals(item, item2);
    }
    
    @Test
    public void igualarDoisItemsNãoIguais()
    {
        Item item = new Item(10, "Lorem ipsum dolor sit amet");
        Item item2 = new Item(20, "Lorem ipsum dolor");
        assertThat(item, not(item2));
    }
}

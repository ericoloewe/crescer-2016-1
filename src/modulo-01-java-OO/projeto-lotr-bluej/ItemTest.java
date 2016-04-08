

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ItemTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ItemTest
{
    @Test
    public void criarItem()
    {
        Item item = new Item(10, "Lorem ipsum dolor sit amet");
        
        assertEquals(item.getQuantidade(), 10);
        assertEquals(item.getDescricao(), "Lorem ipsum dolor sit amet");
    }
}

import java.util.*;
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
    
    @Test
    public void numeroMaisPopular()
    {
        Inventario inv = new Inventario();
        Item esperado = new Item(1000, "Bracelete");
        inv.adicionarItem(new Item(10, "Adaga"));
        inv.adicionarItem(new Item(100, "Escudo"));
        inv.adicionarItem(esperado);
        
        Item obtido = inv.itemComMaiorQuantidade();
        
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void numeroMaisPopularComListaVazia()
    {
        Inventario inv = new Inventario();
        
        Item obtido = inv.itemComMaiorQuantidade();
        
        assertNull(obtido);
    }
    
    @Test
    public void ordenaLista()
    {
        Inventario inv = new Inventario();
        ArrayList<Integer> esperado = new ArrayList<>(Arrays.asList(10, 100, 1000));
        inv.adicionarItem(new Item(100, "Escudo"));
        inv.adicionarItem(new Item(10, "Adaga"));
        inv.adicionarItem(new Item(1000, "Bracelete"));
        
        inv.ordenarItens();
        
        ArrayList<Item> obtido = inv.getItens();
        
        for(int i = 0; i < obtido.size(); i++)
        {
            assertTrue(esperado.get(i).equals(obtido.get(i).getQuantidade()));
        }
    }
    
    @Test
    public void ordenaListaCom100Elementos()
    {
        Inventario inv = new Inventario();
        ArrayList<Integer> esperado = new ArrayList<>();
        for(int i = 0; i < 100; i++)
        {
            esperado.add(i);
        }
        for(int i = 99; i >= 0; i--)
        {
            inv.adicionarItem(new Item(i, String.format("Item %d", i)));
        }
        
        inv.ordenarItens();        
        ArrayList<Item> obtido = inv.getItens();
        
        for(int i = 0; i < obtido.size(); i++)
        {
            assertTrue(esperado.get(i).equals(obtido.get(i).getQuantidade()));
        }
    }
    
    @Test
    public void ordenaListaVazia()
    {
        Inventario inv = new Inventario();
        
        inv.ordenarItens();
        
        ArrayList<Item> obtido = inv.getItens();
        
        assertEquals(obtido.size(), 0);
    }
}

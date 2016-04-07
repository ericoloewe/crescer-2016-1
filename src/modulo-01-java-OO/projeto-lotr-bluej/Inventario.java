import java.util.*;

public class Inventario
{
    private ArrayList<Item> items = new ArrayList<Item>();
    
    public Inventario()
    {
    }
    
    public Inventario(Item item)
    {
        this.adicionarItem(item);
    }
    
    public void adicionarItem(Item item)
    {
        this.items.add(item);
    }
    
    public void removerItem(Item item)
    {
        this.items.remove(item);
    }
    
    public boolean containsItem(Item item)
    {
        return this.items.contains(item);
    }
}

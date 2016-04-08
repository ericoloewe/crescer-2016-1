import java.util.*;

public class Inventario
{
    private ArrayList<Item> items = new ArrayList<Item>();
    
    public boolean adicionarItem(Item item)
    {
        this.items.add(item);
        return this.items.contains(item);
    }
    
    public boolean removerItem(Item item)
    {
        return this.items.remove(item);
    }
    
    public ArrayList<Item> getItens()
    {
        return this.items;
    }
}

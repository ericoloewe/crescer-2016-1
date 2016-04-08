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
    
    public String getDescricoesItens()
    {
        Item last = this.items.get(this.items.size() - 1);
        String descricaoItens = new String("");
        
        for(Item item : this.items)
        {
            descricaoItens += item == last ? item.getDescricao() : String.format("%s,", item.getDescricao());
        }
        
        return descricaoItens;
    }
}

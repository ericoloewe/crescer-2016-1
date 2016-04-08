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
        Item last = this.items.size() > 0 ? this.items.get(this.items.size() - 1) : null;
        String descricaoItens = new String("");
        
        for(Item item : this.items)
        {
            // verifica se é o ultimo item da lista, se não, atribui uma virgula a string
            descricaoItens += (item == last) ? item.getDescricao() : String.format("%s,", item.getDescricao());
        }
        
        return descricaoItens;
    }
    
    public Item itemComMaiorQuantidade()
    {
        Item itemComMaiorQuantidade = this.items.size() > 0 ? this.items.get(0) : null;
        
        for(Item item : this.items)
        {
            if(item.getQuantidade() > itemComMaiorQuantidade.getQuantidade())
            {
                itemComMaiorQuantidade = item;
            }
        }
        
        return itemComMaiorQuantidade;
    }
}

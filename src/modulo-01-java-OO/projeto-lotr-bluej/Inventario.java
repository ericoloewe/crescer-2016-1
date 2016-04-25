import java.util.*;

public class Inventario
{
    private ArrayList<Item> items = new ArrayList<Item>();
    
    public void adicionarItem(Item item)
    {
        this.items.add(item);
    }
    
    public void removerItem(Item item)
    {
        this.items.remove(item);
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
    
    public void ordenarItens()
    {
        ordenarItens(0, this.items.size()-1);
    }

    // primeiro, seria o primeiro item da lista
    // ultimo, seria o ultimo item da lista
    private void ordenarItens(int primeiro, int ultimo)
    {
        if (primeiro >= ultimo)
            return;
        Item pivo = this.items.get((ultimo+primeiro)/2);
        int i=primeiro, j=ultimo;
        
        while (i < j)
        {
            while (this.items.get(i).getQuantidade() < pivo.getQuantidade()) i++;
            while (this.items.get(j).getQuantidade() > pivo.getQuantidade()) j--;
            if (i <= j) {
                Item aux=this.items.get(i);
                this.items.set(i, this.items.get(j));
                this.items.set(j, aux);
                i++;
                j--;
            }                
        }
        
        this.ordenarItens(primeiro, j);
        this.ordenarItens(i, ultimo);

    }
}

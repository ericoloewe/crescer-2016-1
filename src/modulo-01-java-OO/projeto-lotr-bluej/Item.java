public class Item
{
    private int quantidade;
    private String descricao;
    
    public Item(int quantidade, String descricao) 
    {
        this.quantidade = quantidade;
        this.descricao = descricao;
    }
    
    public void setQuantidade(int quantidade)
    {
        this.quantidade = quantidade;
    }
    
    public int getQuantidade()
    {
        return this.quantidade;
    }
    
    public String getDescricao()
    {
        return this.descricao;
    }
}

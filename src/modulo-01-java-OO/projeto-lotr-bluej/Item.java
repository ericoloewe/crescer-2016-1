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
    
    /*
     * Metodo criado para comparar dois items
     * Este metodo compara a quantidade dos items, alem de comparar sua descrição,
     * e na comparação da descrição, vemos se a descrição é nulla, e caso não for, vemos se ela é igual a outra,
     * e caso for nulla, vemos se a atual descrição tambem é nulla
     */
    public boolean equals(Object obj)
    {
        return  ((Item) obj).getQuantidade() == this.quantidade &&
                (((Item) obj).getDescricao() != null &&
                        ((Item) obj).getDescricao().equals(this.descricao) ||
                   ((Item) obj).getDescricao() == null &&
                        ((Item) obj).getDescricao() == this.descricao);
    }
}

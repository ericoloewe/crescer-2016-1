public class IrishDwarf extends Dwarf
{    
    public IrishDwarf(String nome)
    {
        super(nome);
    }
    
    public IrishDwarf(String nome, DataTerceiraEra dataNascimento)
    {
        super(nome, dataNascimento);
    }
    
    public void tentarSorte()
    {
        Inventario inventario = new Inventario();
        if(this.getNumeroSorte() == -3333.0)
        {
            for(Item item : this.inventario.getItens())
            {
                item.setQuantidade(this.calculaRecompensaDoItem(item.getQuantidade()));
                inventario.adicionarItem(item);
            }
            this.inventario = inventario;
        }
    }
    
    private int calculaRecompensaDoItem(int quantidade)
    {        
        return somaAte(quantidade) * 1000 + quantidade;
    }
    
    private int somaAte(int n)
    {
        return n*(n+1)/2;
    }
}

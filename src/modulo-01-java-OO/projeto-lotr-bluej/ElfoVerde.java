public class ElfoVerde extends Elfo
{
    public ElfoVerde()
    {
        super();
    }
    
    public ElfoVerde(String nome)
    {
        super(nome);
    }
    
    public boolean atirarFlechas()
    {
        if(this.flechas > 0) {
            this.experiencia += 2;
            this.flechas--;
            return true;
        }
        return false;
    }
    
    public boolean adicionarItemAoInventario(Item item)
    {
        if(item.getDescricao() == "Espada de aço valiriano" || item.getDescricao() == "Arco e Flecha de Vidro")
            return this.inventario.adicionarItem(item);
        return false;
    }
}

public class Elfo extends Personagem
{    
    protected int flechas;
    private static int contadorDeElfos;
    
    public Elfo()
    {
        super("");
        this.flechas = 42;
        Elfo.contadorDeElfos++;
    }
    
    public Elfo(String nome)
    {
        this();
        this.nome = nome;
    }
    
    public Elfo(String nome, int flechas)
    {
        this(nome);
        this.flechas = flechas;
    }
    
    protected void finalize() throws Throwable {
        Elfo.contadorDeElfos--;
        super.finalize();
    }
    
    public boolean atirarFlecha()
    {
		if(this.flechas > 0) {
        	this.experiencia++;
        	this.flechas--;
        	return true;
    	}
    	return false;
    }
    
    public void atirarFlecha(Dwarf dwarf) 
    {
        if(this.atirarFlecha()) {
            dwarf.perdeVida();
        }        
    }

    public void atirarFlechaRefactory()
    {
        experiencia++;
        flechas--;
    }    
    
    public int getFlechas()
    {
        return this.flechas;
    }
    
    public static int getContadorDeElfos()
    {
        return Elfo.contadorDeElfos;
    }
    
    public void adicionarItemAoInventario(Item item)
    {
        this.inventario.adicionarItem(item);
    }
    
    public void removerItemDoInventario(Item item)
    {
        this.inventario.removerItem(item);
    }
    
    public String toString()
    {
        return this.nome + " possui " + this.flechas + " flechas e " + this.experiencia + " níveis de experiência.";
    }
    
    public void tentarSorte()
    {
        
    }
}

public class Elfo
{
    private String nome;
    private int experiencia;
    private int flechas;
    private Inventario inventario;
    
    public Elfo()
    {
        this.nome = "";
        this.experiencia = 0;
        this.flechas = 42;
        this.inventario = new Inventario();
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
    
    public boolean atirarFlechas()
    {
		if(this.flechas > 0) {
        	this.experiencia++;
        	this.flechas--;
        	return true;
    	}
    	return false;
    }
    
    public void atirarFlechas(Dwarf dwarf) 
    {
        if(atirarFlechas()) {
            dwarf.perdeVida();
        }        
    }

    public void atirarFlechaRefactory()
    {
        experiencia++;
        flechas--;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public Inventario getInventario()
    {
        return this.inventario;
    }
    
    public int getExperiencia()
    {
        return this.experiencia;
    }
    
    public int getFlechas()
    {
        return this.flechas;
    }
    
    public String toString()
    {
        return this.nome + " possui " + this.flechas + " flechas e " + this.experiencia + " níveis de experiência.";
    }
}

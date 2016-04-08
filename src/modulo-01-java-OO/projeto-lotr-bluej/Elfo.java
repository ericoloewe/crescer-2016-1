public class Elfo
{
    private String nome;
    private int experiencia;
    private int flechas;
    
    public Elfo()
    {
        nome = "";
        experiencia = 0;
        flechas = 42;
    }
    
    public Elfo(String nome)
    {
        this.nome = nome;
		this.experiencia = 0;
        this.flechas = 42;
    }
    
    public Elfo(String nome, int flechas)
    {
        this.nome = nome;
		this.experiencia = 0;
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


/**
 * Escreva a descrição da classe Elfo aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Elfo
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String nome;
    private int experiencia;
    private int flechas;
    
    /**
     * COnstrutor para objetos da classe Elfo
     */
    public Elfo()
    {
        // inicializa variáveis de instância
        nome = "";
        experiencia = 0;
        flechas = 42;
    }
    
    /**
     * COnstrutor para objetos da classe Elfo
     */
    public Elfo(String nome)
    {
        // inicializa variáveis de instância
        this.nome = nome;
		this.experiencia = 0;
        this.flechas = 42;
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
            dwarf.perdeVida(10);
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
}

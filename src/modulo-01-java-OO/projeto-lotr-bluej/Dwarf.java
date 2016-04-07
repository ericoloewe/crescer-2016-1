/**
 * Write a description of class Anao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dwarf
{
    // instance variables - replace the example below with your own
    private int vida;
    private String nome;
    private Status status;
    
    /**
     * Constructor for objects of class Anao
     */
    public Dwarf()
    {
        // initialise instance variables
        this.vida = 110;
        this.nome = "";
        this.status = Status.VIVO;
    }
    
    /**
     * Constructor for objects of class Anao
     */
    public Dwarf(String nome)
    {
        // initialise instance variables
        this.vida = 110;
        this.nome = nome;
        this.status = Status.VIVO;
    }
    
    public void setNome(String novoNome)
    {
        this.nome = novoNome;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public int getVida()
    {
        return this.vida;
    }
    
    public Status getStatus()
    {
        return this.status;
    }
    
    public void setVida(int vida)
    {
        if(vida >= 0)
        {
            this.vida = vida;
        } else {
            this.vida = 0;
        }
    }
    
    public void perdeVida() 
    {
        this.setVida(this.vida-1);
        if(this.vida == 0) {
            this.matarDwarf();
        }
    }
    
    public void perdeVida(int quantidade)
    {
        this.setVida(this.vida - quantidade);
        if(this.vida == 0) {
            this.matarDwarf();
        }
    }
    
    public void matarDwarf()
    {
        this.status = Status.MORTO;
    }
}

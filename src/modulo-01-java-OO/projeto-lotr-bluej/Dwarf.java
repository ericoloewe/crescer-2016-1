
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

    /**
     * Constructor for objects of class Anao
     */
    public Dwarf()
    {
        // initialise instance variables
        this.vida = 110;
    }
    
    public void perdeVida() {
        this.vida--;
    }
    
    public void perdeVida(int quantidade) {
        this.vida -= quantidade;
    }
}

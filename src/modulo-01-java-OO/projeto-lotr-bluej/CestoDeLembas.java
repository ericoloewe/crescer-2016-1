
/**
 * Write a description of class CestoDeLembas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CestoDeLembas
{
    // instance variables - replace the example below with your own
    private int quantidadeDeLembas;

    /**
     * Constructor for objects of class CestoDeLembas
     */
    public CestoDeLembas()
    {
        // initialise instance variables
        quantidadeDeLembas = 0;
    }
    
    /**
     * Constructor for objects of class CestoDeLembas
     */
    public CestoDeLembas(int quantidadeDeLembas)
    {
        // initialise instance variables
        this.quantidadeDeLembas = quantidadeDeLembas;
    }
    
    public boolean podeDividirEmPares() 
    {
        return (this.quantidadeDeLembas > 2 && this.quantidadeDeLembas <= 100 && this.quantidadeDeLembas%2 == 0);
    }
}

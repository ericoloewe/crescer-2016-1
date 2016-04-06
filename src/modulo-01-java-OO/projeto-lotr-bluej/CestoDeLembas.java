<<<<<<< HEAD

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
=======
public class CestoDeLembas {
    
    private int numeroDePaes;
    
    public CestoDeLembas(int numeroDePaes) {
        this.numeroDePaes = numeroDePaes;
    }
    
    public boolean podeDividirEmPares() {
        return numeroDePaes > 2 && numeroDePaes <= 100 && numeroDePaes % 2 == 0;
        // terneiro
        // return podeDividir ? true : false;
    }
}











>>>>>>> 57176bd8f0845366c0cda6e11abf05a2bb7afaf1

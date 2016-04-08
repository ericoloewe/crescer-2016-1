public class CestoDeLembas
{
    private int quantidadeDeLembas;

    public CestoDeLembas()
    {
        quantidadeDeLembas = 0;
    }
    
    public CestoDeLembas(int quantidadeDeLembas)
    {
        this.quantidadeDeLembas = quantidadeDeLembas;
    }
    
    public boolean podeDividirEmPares() 
    {
        return (this.quantidadeDeLembas > 2 && this.quantidadeDeLembas <= 100 && this.quantidadeDeLembas%2 == 0);
    }
}
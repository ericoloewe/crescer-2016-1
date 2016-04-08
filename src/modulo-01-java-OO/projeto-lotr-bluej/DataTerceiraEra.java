public class DataTerceiraEra
{
    private int dia;
    private int mes;
    private int ano;
    
    public DataTerceiraEra()
    {
        this.dia = 1;
        this.mes = 1;
        this.ano = 1;
    }
    
    public DataTerceiraEra(int dia, int mes, int ano)
    {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    public int getDia()
    {
        return this.dia;
    }
    
    public int getMes()
    {
        return this.mes;
    }
    
    public int getAno()
    {
        return this.ano;
    }
    
    public boolean ehBissexto()
    {
        return (this.ano % 4 == 0 && this.ano % 100 != 0 ) || this.ano % 400 == 0;
    }
}

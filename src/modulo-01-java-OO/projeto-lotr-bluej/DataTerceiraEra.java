
/**
 * Escreva a descrição da classe DataTerceiraEra aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class DataTerceiraEra
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int dia;
    private int mes;
    private int ano;
    
    public DataTerceiraEra()
    {
        // inicializa variáveis de instância
        this.dia = 1;
        this.mes = 1;
        this.ano = 1;
    }
    
    public DataTerceiraEra(int dia, int mes, int ano)
    {
        // inicializa variáveis de instância
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

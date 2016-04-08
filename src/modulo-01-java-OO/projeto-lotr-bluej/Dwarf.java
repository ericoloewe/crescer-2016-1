public class Dwarf
{
    private int vida;
    private int experiencia;
    private String nome;
    private Status status;
    private Inventario inventario;
    private DataTerceiraEra dataNascimento;
    
    public Dwarf(String nome)
    {
        // initialise instance variables
        this.vida = 110;
        this.experiencia = 0;
        this.nome = nome;
        this.status = Status.VIVO;
        this.inventario = new Inventario();
        this.dataNascimento = new DataTerceiraEra();
    }
    
    public Dwarf(String nome, DataTerceiraEra dataNascimento)
    {
        // initialise instance variables
        this.vida = 110;
        this.experiencia = 0;
        this.nome = nome;
        this.status = Status.VIVO;
        this.inventario = new Inventario();
        this.dataNascimento = dataNascimento;
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
    
    public int getExperiencia()
    {
        return this.experiencia;
    }
    
    public DataTerceiraEra getDataNascimento()
    {
        return dataNascimento;
    }
    
    private void setVida(int vida)
    {
        if(vida >= 0) {
            this.vida = vida;
        } else {
            this.vida = 0;
        }
    }
    
    public void perdeVida() 
    {
        this.perdeVida(10);
    }
    
    private void perdeVida(int quantidade)
    {
        if(!this.sorteNaVida()) {
            this.setVida(this.vida - quantidade);
            if(this.vida == 0) {
                this.matarDwarf();
            }
        }
    }
    
    private boolean sorteNaVida()
    {
        double numSorte = this.getNumeroSorte();
        if(numSorte < 0) {
            this.experiencia += 2;
            return true;
        } else if(numSorte >= 0 && numSorte <= 100) {
            return true;
        } else {
            return false;
        }
    }
    
    private void matarDwarf()
    {
        this.status = Status.MORTO;
    }
    
    public double getNumeroSorte()
    {
        double theNumber = 101.0;
        
        if(this.dataNascimento.ehBissexto() && this.vida <= 90 && this.vida >= 80) {
            theNumber *= -33;
        } else if (!this.dataNascimento.ehBissexto() && (this.nome == "Seixas" || this.nome == "Meireles")) {
            theNumber *= 33;
            theNumber %= 100;
        }
        
        return theNumber;        
    }
}

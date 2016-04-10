public class IrishDwarf
{
    private int vida;
    private int experiencia;
    private String nome;
    private Status status;
    private Inventario inventario;
    private DataTerceiraEra dataNascimento;
    
    public IrishDwarf(String nome)
    {
        this.vida = 110;
        this.experiencia = 0;
        this.nome = nome;
        this.status = Status.VIVO;
        this.inventario = new Inventario();
        this.dataNascimento = new DataTerceiraEra();
    }
    
    public IrishDwarf(String nome, DataTerceiraEra dataNascimento)
    {
        this(nome);
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
        return this.dataNascimento;
    }
    
    public Inventario getInventario()
    {
        return this.inventario;
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
                this.matarIrishDwarf();
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
    
    private void matarIrishDwarf()
    {
        this.status = Status.MORTO;
    }
    
    public double getNumeroSorte()
    {
        double theNumber = 101.0;
        
        if(this.dataNascimento.ehBissexto() && this.vida <= 90 && this.vida >= 80) {
            theNumber *= -33;
        } else if (!this.dataNascimento.ehBissexto() && ("Seixas".equals(this.nome) || "Meireles".equals(this.nome))) {
            theNumber *= 33;
            theNumber %= 100;
        }
        
        return theNumber;        
    }
    
    public void tentarSorte()
    {
        Inventario inventario = new Inventario();
        if(this.getNumeroSorte() == -3333.0)
        {
            for(Item item : this.inventario.getItens())
            {
                item.setQuantidade(this.calculaRecompensaDoItem(item.getQuantidade()));
                inventario.adicionarItem(item);
            }
            this.inventario = inventario;
        }
    }
    
    private int calculaRecompensaDoItem(int quantidade)
    {        
        return fatorial(quantidade) * 1000 + quantidade;
    }
    
    private int fatorial(int n)
    {
        return n > 1 ? fatorial(n-1)*n : n;
    }
    
    public boolean adicionarItemAoInventario(Item item)
    {
        return this.inventario.adicionarItem(item);
    }
    
    public boolean removerItemDoInventario(Item item)
    {
        return this.inventario.removerItem(item);
    }
}

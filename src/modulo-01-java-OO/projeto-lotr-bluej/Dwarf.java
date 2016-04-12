public class Dwarf extends Personagem
{    
    private DataTerceiraEra dataNascimento;
    
    public Dwarf(String nome)
    {
        super(nome);
        this.vida = 110;
        this.dataNascimento = new DataTerceiraEra();
    }
    
    public Dwarf(String nome, DataTerceiraEra dataNascimento)
    {
        this(nome);
        this.dataNascimento = dataNascimento;
    }
    
    public int getVida()
    {
        return this.vida;
    }
    
    public Status getStatus()
    {
        return this.status;
    }
    
    public DataTerceiraEra getDataNascimento()
    {
        return this.dataNascimento;
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
    
    public static Dwarf descobrirMenosVida(Dwarf dwarf1, Dwarf dwarf2)
    {
        return dwarf1.getVida() < dwarf2.getVida() ? dwarf1 : dwarf2;
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
                item.setQuantidade(item.getQuantidade() + 1000);
                inventario.adicionarItem(item);
            }
            this.inventario = inventario;
        }
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

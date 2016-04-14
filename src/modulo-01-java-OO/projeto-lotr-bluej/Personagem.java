public abstract class Personagem
{
    protected String nome;
    protected Inventario inventario;
    protected int experiencia;
    protected int vida;
    protected Status status;
    
    public Personagem(String nome)
    {
        this.nome = nome;
        this.experiencia = 0;
        this.inventario = new Inventario();
        this.status = Status.VIVO;
        this.vida = 100;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public Inventario getInventario()
    {
        return this.inventario;
    }
    
    public int getExperiencia()
    {
        return this.experiencia;
    }
    
    public Status getStatus()
    {
        return this.status;
    }    
    
    public int getVida()
    {
        return this.vida;
    }
    
    public abstract void tentarSorte();
}

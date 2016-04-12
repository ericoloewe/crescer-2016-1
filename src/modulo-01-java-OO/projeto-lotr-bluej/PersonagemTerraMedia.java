public class PersonagemTerraMedia
{
    protected String nome;
    protected Inventario inventario;
    protected int experiencia;
    protected int vida;
    protected Status status;
    
    public PersonagemTerraMedia(String nome)
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
}

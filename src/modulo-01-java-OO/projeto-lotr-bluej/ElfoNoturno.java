/*
 * 7.2 Atualmente os Elfos Noturnos podem morrer atirando flechas? Justifique.
 * Não, pois não teria como chegar no valor zero, pois não reduzimos a vida dele em valor fixo, mas sim
 * na porcentagem de sua vida, e isso leva a reduzir infinitamente a sua vida, até o float estourar.
 */
public class ElfoNoturno extends Elfo
{
    private float vida;
    
    public ElfoNoturno(String nome)
    {
        super(nome);
        this.vida = 100;
    }
    
    public ElfoNoturno(String nome, int flechas)
    {
        this(nome);
        this.flechas = flechas;
    }
    
    public boolean atirarFlecha()
    {
        if(this.flechas > 0 && !this.morto()) {
            this.experiencia += 2;
            this.removerVida();
            return true;
        }
        return false;
    }
    
    public void atirarFlecha(Dwarf dwarf) 
    {
        super.atirarFlecha(dwarf);
        this.atirarFlecha();
    }
    
    private void removerVida()
    {
        this.vida = (this.vida*0.95f);
        if(this.vida < 1)
        {
            this.vida = 0;
            this.status = Status.MORTO;
        }
    }
    
    private boolean morto()
    {
        return this.status == Status.MORTO;
    }
    
    public float getVidaElfoNoturno()
    {
        return this.vida;
    }
}

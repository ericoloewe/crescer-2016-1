import java.util.*;

public class Exercito
{
    private HashMap<String, Elfo> exercito = new HashMap<>();
    private HashMap<Status, Elfo> exercitoAgrupadoPorStatus = new HashMap<>();
    
    public boolean alistarElfo(Elfo elfo)
    {
        if(elfo instanceof ElfoNoturno || elfo instanceof ElfoVerde)
        {          
            this.exercito.put(elfo.getNome(), elfo);
            return true;
        }
        return false;
    }
    
    public Elfo buscarElfo(String nome)
    {
        return this.exercito.get(nome);
    }
    
    public void agruparPorStatus()
    {
        for (Elfo elfo : this.exercito.values()) {
             this.exercitoAgrupadoPorStatus.put(elfo.getStatus(), elfo);
        }
    }
}

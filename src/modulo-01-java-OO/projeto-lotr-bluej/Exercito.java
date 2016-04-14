import java.util.*;

public class Exercito
{
    private HashMap<String, Elfo> exercito = new HashMap<>();
    private HashMap<Status, ArrayList<Elfo>> exercitoAgrupadoPorStatus = new HashMap<>();
    
    public HashMap<String, Elfo> getExercito()
    {
        return this.exercito;
    }
    
    public HashMap<Status, ArrayList<Elfo>> getExercitoAgrupadoPorStatus()
    {
        return this.exercitoAgrupadoPorStatus;
    }
    
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

import java.util.*;

public class Exercito
{
    private HashMap<String, Elfo> exercito = new HashMap<>();
    private HashMap<Status, ArrayList<Elfo>> exercitoAgrupadoPorStatus = new HashMap<>();
    private Estrategia estrategia = new NoturnosPorUltimo();
    
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
        this.exercitoAgrupadoPorStatus.clear();
        for (Elfo elfo : this.exercito.values()) 
        {
            if(this.exercitoAgrupadoPorStatus.containsKey(elfo.getStatus()))
                this.exercitoAgrupadoPorStatus.get(elfo.getStatus()).add(elfo);
            else
                this.exercitoAgrupadoPorStatus.put(elfo.getStatus(), new ArrayList<Elfo>(Arrays.asList(elfo)));
        }
    }
    
    public ArrayList<Elfo> buscar(Status status)
    {
        this.agruparPorStatus();
        return this.exercitoAgrupadoPorStatus.get(status);
    }
    
    public void atacar(ArrayList<Dwarf> alvo)
    {
        if(estrategia != null)
            this.estrategia.atacar(new ArrayList<Elfo>(this.exercito.values()), alvo);
    }
    
    public void mudarEstrategia(Estrategia estrategia)
    {
        this.estrategia = estrategia;
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return this.estrategia.getOrdemDoUltimoAtaque();
    }
}

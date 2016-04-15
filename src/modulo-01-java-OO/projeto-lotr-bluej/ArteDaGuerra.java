import java.util.*;

public class ArteDaGuerra implements Estrategia
{
    private Exercito exercito = new Exercito();
    private ArrayList<Elfo> exercitoOrdenado = new ArrayList<>();
    
    public ArteDaGuerra(Exercito exercito)
    {
        this.exercito = exercito;
    }
    
    public Exercito getExercito()
    {
        return this.exercito;
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque()
    {
        return this.exercitoOrdenado;
    }
    
    public void atacar(ArrayList<Dwarf> hordaDeDwarfs)
    {
        if(this.exercito != null)
        {            
            this.exercitoOrdenado = ordenarExercitoParaOAtaque(hordaDeDwarfs);
            for (Elfo elfo : this.exercitoOrdenado) 
            {
                elfoAtacarDwarfs(elfo, hordaDeDwarfs);
            }
        }
    }
    
    private ArrayList<Elfo> ordenarExercitoParaOAtaque(ArrayList<Dwarf> hordaDeDwarfs)
    {
        ArrayList<Elfo> exercito = new ArrayList<>();
        exercito.addAll(this.exercito.getExercito().values());
        this.removerMortos(exercito);
        this.removeElfosNoturnosQueNaoPodemAtacar(exercito, hordaDeDwarfs.size());
        
        return exercito;
    }
    
    private void removerMortos(ArrayList<Elfo> exercito)
    {
        exercito.removeAll(this.exercito.buscar(Status.MORTO) == null ? new ArrayList<Elfo>() : this.exercito.buscar(Status.MORTO));
    }
    
    private ArrayList<Elfo> removeElfosNoturnosQueNaoPodemAtacar(ArrayList<Elfo> exercito, int numDeDwarfs)
    {
        float intencoes = this.exercito.getExercito().size() * numDeDwarfs;
        int numDeElfosNoturnosQuePodemAtacar = new Double(Math.floor(intencoes * 0.3)).intValue();
        int numDeElfosNoturnosJaVistos = 0;
        
        for(int i = 0; i < exercito.size(); i++)
        {
            if(exercito.get(i) instanceof ElfoNoturno)
            {
                if(numDeElfosNoturnosJaVistos < numDeElfosNoturnosQuePodemAtacar)
                    numDeElfosNoturnosJaVistos++;
                else if (numDeElfosNoturnosJaVistos >= numDeElfosNoturnosQuePodemAtacar)
                    exercito.remove(i);
            }
        }
        
        return exercito;
    }
    
    private void elfoAtacarDwarfs(Elfo elfo, ArrayList<Dwarf> hordaDeDwarfs)
    {
        for(Dwarf dwarf : hordaDeDwarfs)
        {
            elfo.atirarFlechas(dwarf);
        }
    }
}

import java.util.*;

public class ArteDaGuerra implements Estrategia
{
    private Exercito exercito = new Exercito();
    
    public ArteDaGuerra(Exercito exercito)
    {
        this.exercito = exercito;
    }
    
    public Exercito getExercito()
    {
        return this.exercito;
    }
    
    public void atacar(ArrayList<Dwarf> hordaDeDwarfs)
    {
        ArrayList<Elfo> exercitoAAtacar = new ArrayList<>();

        exercitoAAtacar.addAll(this.exercito.getExercito().values());
        exercitoAAtacar.removeAll(this.exercito.buscar(Status.MORTO) == null ? new ArrayList<Elfo>() : this.exercito.buscar(Status.MORTO));
        exercitoAAtacar = removeElfosNoturnosQueNaoPodemAtacar(exercitoAAtacar, hordaDeDwarfs.size());
        
        for (Elfo elfo : exercitoAAtacar) 
        {
            elfoAtacarDwarfs(elfo, hordaDeDwarfs);
        }
    }
    
    private ArrayList<Elfo> removeElfosNoturnosQueNaoPodemAtacar(ArrayList<Elfo> exercitoDeElfos, int numDeDwarfs)
    {
        float intencoes = exercitoDeElfos.size() * numDeDwarfs;
        int numDeElfosNoturnosQuePodemAtacar = new Double(Math.floor(intencoes * 0.3)).intValue();
        int numDeElfosNoturnosJaVistos = 0;
        
        for(int i = 0; i < exercitoDeElfos.size(); i++)
        {
            if(exercitoDeElfos.get(i) instanceof ElfoNoturno)
            {
                if(numDeElfosNoturnosJaVistos < numDeElfosNoturnosQuePodemAtacar)
                    numDeElfosNoturnosJaVistos++;
                else if (numDeElfosNoturnosJaVistos >= numDeElfosNoturnosQuePodemAtacar)
                    exercitoDeElfos.remove(i);
            }
        }
        
        return exercitoDeElfos;
    }
    
    private void elfoAtacarDwarfs(Elfo elfo, ArrayList<Dwarf> hordaDeDwarfs)
    {
        for(Dwarf dwarf : hordaDeDwarfs)
        {
            elfo.atirarFlechas(dwarf);
        }
    }
}

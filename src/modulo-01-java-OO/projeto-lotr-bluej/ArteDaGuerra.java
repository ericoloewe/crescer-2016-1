import java.util.*;

public class ArteDaGuerra implements Estrategia
{
    private ArrayList<Elfo> exercitoOrdenado = new ArrayList<>();
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque()
    {
        return this.exercitoOrdenado;
    }
    
    public void atacar(ArrayList<Elfo> exercito, ArrayList<Dwarf> hordaDeDwarfs)
    {
        if(exercito == null)
            return;         
        
        this.exercitoOrdenado = ordenarExercitoParaOAtaque(exercito, hordaDeDwarfs);
        
        for (Elfo elfo : this.exercitoOrdenado) 
        {
            elfoAtacarDwarfs(elfo, hordaDeDwarfs);
        }
    }
    
    private ArrayList<Elfo> ordenarExercitoParaOAtaque(ArrayList<Elfo> exercito, ArrayList<Dwarf> hordaDeDwarfs)
    {
        this.manterCom(Status.VIVO, exercito);
        this.removeElfosNoturnosQueNaoPodemAtacar(exercito, hordaDeDwarfs.size());
        
        return exercito;
    }
    
    private ArrayList<Elfo> removeElfosNoturnosQueNaoPodemAtacar(ArrayList<Elfo> exercito, int numDeDwarfs)
    {
        int numDeElfosNoturnosQuePodemAtacar = (int)(exercito.size() * numDeDwarfs * 0.3);
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
    
    private void manterCom(Status status, ArrayList<Elfo> exercito)
    {
        for(int i = 0; i < exercito.size(); i++)
        {
            if(exercito.get(i).getStatus() != status)
                exercito.remove(i);
        }
    }
}

import java.util.*;

public class ArteDaGuerra implements Estrategia
{
    private ArrayList<Elfo> exercitoOrdenado = new ArrayList<>();
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque()
    {
        return this.exercitoOrdenado;
    }
    
    public void atacar(ArrayList<Elfo> exercito, ArrayList<Dwarf> hordaDeDwarfs) throws NaoPodeAtacarException
    {
        if(exercito == null)
            throw new NaoPodeAtacarException("Você não pode atacar sem um exercito!");
        
        ordenarExercitoParaOAtaque(exercito, hordaDeDwarfs);
        
        for (Elfo elfo : exercito) 
        {
            this.exercitoOrdenado.add(elfo);
            elfoAtacarDwarfs(elfo, hordaDeDwarfs);
        }
    }
    
    private void ordenarExercitoParaOAtaque(ArrayList<Elfo> exercito, ArrayList<Dwarf> hordaDeDwarfs)
    {
        this.manterCom(Status.VIVO, exercito);
        this.removeElfosNoturnosQueNaoPodemAtacar(exercito, hordaDeDwarfs.size());
    }
    
    private void removeElfosNoturnosQueNaoPodemAtacar(ArrayList<Elfo> exercito, int numDeDwarfs)
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
    }
    
    private void elfoAtacarDwarfs(Elfo elfo, ArrayList<Dwarf> hordaDeDwarfs)
    {
        for(Dwarf dwarf : hordaDeDwarfs)
        {
            elfo.atirarFlecha(dwarf);
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

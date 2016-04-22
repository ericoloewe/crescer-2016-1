import java.util.*;

public class NoturnosPorUltimo implements Estrategia
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
        
        this.manterCom(Status.VIVO, exercito);        
        
        exercito.sort(new Comparator<Elfo>() {
            public int compare(Elfo elfo1, Elfo elfo2)
            {
                boolean osDoisIguais = elfo1 instanceof ElfoVerde && elfo2 instanceof ElfoVerde || elfo1 instanceof ElfoNoturno && elfo2 instanceof ElfoNoturno;
                boolean primeiroElfoEhVerde = elfo1 instanceof ElfoVerde && elfo2 instanceof ElfoNoturno;
                return  osDoisIguais ? 0 : primeiroElfoEhVerde ? -1 : 1;
            }
        });
        
        for (Elfo elfo : exercito) 
        {
            elfoAtacarDwarfs(elfo, hordaDeDwarfs);
        }
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

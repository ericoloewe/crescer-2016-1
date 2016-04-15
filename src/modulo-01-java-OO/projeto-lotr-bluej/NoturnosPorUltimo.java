import java.util.*;

public class NoturnosPorUltimo implements Estrategia
{
    private Exercito exercito = new Exercito();
    private ArrayList<Elfo> exercitoOrdenado = new ArrayList<>();
    
    public NoturnosPorUltimo(Exercito exercito)
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
        ArrayList<Elfo> exercitoAAtacar = new ArrayList<>();

        exercitoAAtacar.addAll(this.exercito.getExercito().values());
        exercitoAAtacar.removeAll(this.exercito.buscar(Status.MORTO) == null ? new ArrayList<Elfo>() : this.exercito.buscar(Status.MORTO));
        
        exercitoAAtacar.sort(new Comparator<Elfo>() {
            public int compare(Elfo elfo1, Elfo elfo2)
            {
                boolean osDoisIguais = elfo1 instanceof ElfoVerde && elfo2 instanceof ElfoVerde || elfo1 instanceof ElfoNoturno && elfo2 instanceof ElfoNoturno;
                boolean primeiroElfoEhVerde = elfo1 instanceof ElfoVerde && elfo2 instanceof ElfoNoturno;
                return  osDoisIguais ? 0 : primeiroElfoEhVerde ? -1 : 1;
            }
        });
        
        for (Elfo elfo : exercitoAAtacar) 
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
}

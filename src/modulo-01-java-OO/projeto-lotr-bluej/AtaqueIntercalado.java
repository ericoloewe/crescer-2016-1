import java.util.*;

public class AtaqueIntercalado implements Estrategia
{
    private Exercito exercito = new Exercito();
    private ArrayList<Elfo> exercitoOrdenado = new ArrayList<>();
    
    public AtaqueIntercalado(Exercito exercito)
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
        if(this.exercito == null)
            return;
        int somaElfosVerdes = elfosVerdes().size();
        int somaElfosNoturnos = elfosNoturnos().size();
        
        int quantidadeDeElfosQuePodemAtacarDeCadaTipo = this.quantidadeDeElfosQuePodemAtacarDeCadaTipo(somaElfosVerdes, somaElfosNoturnos);
        
        ArrayList<Elfo> elfos = this.organizarExercito(quantidadeDeElfosQuePodemAtacarDeCadaTipo);
        
        for(Elfo elfo : elfos)
        {
            this.elfoAtacarDwarfs(elfo, hordaDeDwarfs);
        }
        
        this.exercitoOrdenado = elfos;
    }
    
    private ArrayList<Elfo> organizarExercito(int quantidadeDeElfosQuePodemAtacarDeCadaTipo)
    {
        ArrayList<Elfo> elfosVerdes = this.elfosVerdes();
        ArrayList<Elfo> elfosNoturnos = this.elfosNoturnos();
        ArrayList<Elfo> exercito = new ArrayList<>();
        boolean elfoVerdeAtacou = false, elfoNoturnoAtacou = false;
        
        for(int i = 0; i < quantidadeDeElfosQuePodemAtacarDeCadaTipo; i++)
        {
            if(!elfoVerdeAtacou)
            {
                exercito.add(elfosVerdes.get(i));
                elfoVerdeAtacou = true;
            } else {
                exercito.add(elfosNoturnos.get(i));
                elfoVerdeAtacou = false;
            }
        }
        
        for(int i = 0; i < quantidadeDeElfosQuePodemAtacarDeCadaTipo; i++)
        {
            if(!elfoNoturnoAtacou)
            {
                exercito.add(elfosNoturnos.get(i));
                elfoNoturnoAtacou = true;
            } else {
                exercito.add(elfosVerdes.get(i));
                elfoNoturnoAtacou = false;
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
    
    private int quantidadeDeElfosQuePodemAtacarDeCadaTipo(int somaElfosVerdes, int somaElfosNoturnos)
    {
        int soma = 0;
        
        for(int i = somaElfosVerdes; i >= 0; i++)
        {
            if(somaElfosNoturnos >= i)
            {
                soma += i;
                break;
            }
        }
        
        return soma;
    }
    
    private ArrayList<Elfo> elfosVerdes()
    {
        ArrayList<Elfo> elfosVerdes = new ArrayList<>();
        
        for(Elfo elfo : this.exercito.getExercito().values())
        {
            if(elfo instanceof ElfoVerde && !elfo.getStatus().equals(Status.MORTO))
                elfosVerdes.add(elfo);
        }
        
        return elfosVerdes;
    }
    
    private ArrayList<Elfo> elfosNoturnos()
    {
        ArrayList<Elfo> elfosNoturnos = new ArrayList<>();
        
        for(Elfo elfo : this.exercito.getExercito().values())
        {
            if(elfo instanceof ElfoNoturno && !elfo.getStatus().equals(Status.MORTO))
                elfosNoturnos.add(elfo);
        }
        
        return elfosNoturnos;
    }
}

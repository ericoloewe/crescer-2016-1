import java.util.*;

public class AtaqueIntercalado implements Estrategia
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
        int somaElfosVerdes = this.filtrarElfosPorTipo(exercito, ElfoVerde.class).size();
        int somaElfosNoturnos = this.filtrarElfosPorTipo(exercito, ElfoNoturno.class).size();
        
        int quantidadeDeElfosQuePodemAtacarDeCadaTipo = somaElfosVerdes <= somaElfosNoturnos ? somaElfosVerdes : somaElfosNoturnos;
        
        this.organizarExercito(exercito, quantidadeDeElfosQuePodemAtacarDeCadaTipo);
        
        for(Elfo elfo : exercito)
        {
            this.elfoAtacarDwarfs(elfo, hordaDeDwarfs);
        }
        
        this.exercitoOrdenado = exercito;
    }
    
    private void organizarExercito(ArrayList<Elfo> exercito, int quantidadeDeElfosQuePodemAtacarDeCadaTipo)
    {
        ArrayList<Elfo> elfos = new ArrayList<>();
        elfos.addAll(this.filtrarElfosPorTipo(exercito, ElfoVerde.class));
        elfos.addAll(this.filtrarElfosPorTipo(exercito, ElfoNoturno.class));
        boolean elfoVerdeAtacou = false;
        exercito.clear();
        
        for(int i = 0, c = 0; i < quantidadeDeElfosQuePodemAtacarDeCadaTipo*2; i++)
        {
            if(!elfoVerdeAtacou)
            {
                exercito.add(elfos.get(c));
                elfoVerdeAtacou = true;
            } else {
                exercito.add(elfos.get(c + quantidadeDeElfosQuePodemAtacarDeCadaTipo));
                elfoVerdeAtacou = false;
                c++;
            }
        }
    }
    
    private void elfoAtacarDwarfs(Elfo elfo, ArrayList<Dwarf> hordaDeDwarfs)
    {
        for(Dwarf dwarf : hordaDeDwarfs)
        {
            elfo.atirarFlechas(dwarf);
        }
    }
    
    private ArrayList<Elfo> filtrarElfosPorTipo(ArrayList<Elfo> exercito, Class elfoClass)
    {
        ArrayList<Elfo> elfosDoTipo = new ArrayList<>();

        for(Elfo elfo : exercito)
        {
            if(elfo.getClass() == elfoClass)
                elfosDoTipo.add(elfo);
        }
        
        return elfosDoTipo;
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

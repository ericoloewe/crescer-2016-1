import java.util.*;

public class AtaqueIntercalado implements Estrategia
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
        
        this.manterCom(Status.VIVO, exercito);    
        
        int somaElfosVerdes = this.filtrarElfosPorTipo(exercito, ElfoVerde.class).size();
        int somaElfosNoturnos = this.filtrarElfosPorTipo(exercito, ElfoNoturno.class).size();
        if(somaElfosVerdes != somaElfosNoturnos)
            throw new NaoPodeAtacarException("Você não pode atacar com essa estrategia se o exercito não estiver parelho!");
        
        this.organizarExercito(exercito);
        
        this.exercitoOrdenado.clear();
        
        for(Elfo elfo : exercito)
        {
            this.exercitoOrdenado.add(elfo);
            this.elfoAtacarDwarfs(elfo, hordaDeDwarfs);
        }
    }
    
    private void organizarExercito(ArrayList<Elfo> exercito)
    {
        ArrayList<Elfo> elfos = new ArrayList<>();
        elfos.addAll(this.filtrarElfosPorTipo(exercito, ElfoVerde.class));
        elfos.addAll(this.filtrarElfosPorTipo(exercito, ElfoNoturno.class));
        boolean elfoVerdeAtacou = false;
        exercito.clear();
        
        for(int i = 0, c = 0; i < elfos.size(); i++)
        {
            if(!elfoVerdeAtacou)
            {
                exercito.add(elfos.get(c));
                elfoVerdeAtacou = true;
            } else {
                exercito.add(elfos.get(c + (elfos.size()/2)));
                elfoVerdeAtacou = false;
                c++;
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

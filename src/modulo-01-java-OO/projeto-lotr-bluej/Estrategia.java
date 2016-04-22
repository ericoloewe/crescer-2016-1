import java.util.*;

public interface Estrategia
{
    public void atacar(ArrayList<Elfo> exercito, ArrayList<Dwarf> hordaDeDwarfs);
    public ArrayList<Elfo> getOrdemDoUltimoAtaque();
}

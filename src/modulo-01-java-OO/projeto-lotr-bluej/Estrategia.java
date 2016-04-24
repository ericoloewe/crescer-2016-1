import java.util.*;

public interface Estrategia
{
    public void atacar(ArrayList<Elfo> exercito, ArrayList<Dwarf> hordaDeDwarfs) throws NaoPodeAtacarException;
    public ArrayList<Elfo> getOrdemDoUltimoAtaque();
}

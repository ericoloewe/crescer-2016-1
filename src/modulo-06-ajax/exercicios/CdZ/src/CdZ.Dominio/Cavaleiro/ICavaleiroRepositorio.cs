using System.Collections.Generic;

namespace CdZ.Dominio
{
    public interface ICavaleiroRepositorio
    {
        int Adicionar(Cavaleiro cavaleiro);
        Cavaleiro Buscar(int id);
        IEnumerable<Cavaleiro> Todos();
        void Excluir(int id);
        void Atualizar(Cavaleiro cavaleiro);
    }
}

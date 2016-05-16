using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio
{
    // Por que esta interface existe?
    // No domínio (que são nossas regras de negócio) existe uma regra que eu devo ser capaz de buscar um
    // usuário por seu email e senha. 
    // Mas não me interessa de onde virá esses dados, afinal ele virá de um REPOSITÓRIO, só não sei qual a fonte.
    // Pode ser um banco de dados, web service, arquivo, etc...
    public interface IUsuarioRepositorio
    {
        Usuario BuscarUsuarioPorAutenticacao(string email, string senha);
    }
}

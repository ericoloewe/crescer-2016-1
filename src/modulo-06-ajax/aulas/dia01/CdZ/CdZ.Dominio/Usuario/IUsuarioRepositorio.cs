using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CdZ.Dominio
{
    public interface IUsuarioRepositorio
    {
        Usuario BuscarUsuarioPorAutenticacao(string email, string senha);
        void CriarUsuario(Usuario usuario);
    }
}

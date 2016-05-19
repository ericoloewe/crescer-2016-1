using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CdZ.Dominio
{
    public class Permissao
    {
        private Permissao() { }

        public Permissao(int id, string nome)
        {
            this.Id = id;
            this.Nome = nome;
        }

        public int Id { get; private set; }
        public string Nome { get; private set; }

        /*
         * Um usuário possui uma lista de permissões.
         * Assim como uma permissão pode estar em vários usuários.
         */
        public IList<Usuario> Usuarios { get; set; }
    }
}

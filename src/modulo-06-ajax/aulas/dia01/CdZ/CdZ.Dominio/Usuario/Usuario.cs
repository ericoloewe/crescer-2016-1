using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CdZ.Dominio
{
    public class Usuario
    {
        private Usuario()
        {

        }

        public Usuario(int id, string email, string senha, string nome, IList<Permissao> permissoes)
        {
            this.Id = id;
            this.Email = email;
            this.Senha = senha;
            this.Nome = nome;
            this.Permissoes = permissoes;
        }

        public int Id { get; private set; }
        public string Email { get; private set; }

        /*
         * Dentro do UsuarioServico, podemos alterar a senha do Usuario,
         * afinal, precisamos criptografá-la.
         * Por isso o internal set. Assim, podemos alterar a senha, mas somente
         * dentro deste projeto CdZ.Dominio.
         */
        public string Senha { get; internal set; }

        public string Nome { get; private set; }
        
        /*
         * Um usuário possui uma lista de permissões.
         * Assim como uma permissão pode estar em vários usuários.
         */
        public IList<Permissao> Permissoes { get; private set; }
        

        
        public void AtribuirPermissao(Permissao permissao)
        {
            if(this.Permissoes == null)
            {
                this.Permissoes = new List<Permissao>();
            }

            this.Permissoes.Add(permissao);
        }
    }
}

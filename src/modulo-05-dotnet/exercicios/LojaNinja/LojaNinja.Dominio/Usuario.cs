using LojaNinja.Dominio.Services;
using System.Collections.Generic;

namespace LojaNinja.Dominio
{
    public class Usuario
    {
        public Usuario(string nome, string email, string senha, int id = 0, IList<Permissao> permissoes = null)
        {
            Id = id;
            Nome = nome;
            Email = email;
            Permissoes = permissoes;
            Senha = senha;
        }

        public Usuario(int id, string nome, string email, string senha)
        {
            Id = id;
            Email = email;
            Nome = nome;
            Senha = senha;
        }

        public int Id { get; private set; }
        public string Nome { get; private set; }
        public string Email { get; private set; }
        public string Senha { get; private set; }

        public IList<Permissao> Permissoes { get; set; }

        public void CriptografarSenha()
        {
            Senha = CriptografiaServico.Criptografar(Senha);
        }
    }
}
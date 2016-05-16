using System;

namespace LojaNinja.Dominio
{
    public class Usuario
    {
        public Usuario(string nome, string email, string senha, string confirmacaoSenha, int id = 0, string[] permissoes = null)
        {
            Id = id;
            Nome = nome;
            Email = email;
            Permissoes = permissoes;
            if (VerificaSeSenhasSaoIguais(senha, confirmacaoSenha))
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
        public string[] Permissoes { get; private set; }

        private bool VerificaSeSenhasSaoIguais(string senha, string confirmSenha)
        {
            if (senha.Equals(confirmSenha))
                return true;
            throw new ArgumentException("Senhas não conferem");
        }
    }
}

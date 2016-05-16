using System;

namespace LojaNinja.Dominio
{
    public class Usuario
    {
        public Usuario(string nome, string senha, string confirmacaoSenha, int id = 0)
        {
            Id = id;
            Nome = nome;
            if (VerificaSeSenhasSaoIguais(senha, confirmacaoSenha))
                Senha = senha;
        }

        public Usuario(int id, string nome, string senha)
        {
            Id = id;
            Nome = nome;
            Senha = senha;
        }

        public Usuario()
        {
        }

        public int Id { get; private set; }
        public string Nome { get; set; }
        public string Email { get; set; }
        public string Senha { get; set; }
        public string[] Permissoes { get; set; }

        private bool VerificaSeSenhasSaoIguais(string senha, string confirmSenha)
        {
            if (senha.Equals(confirmSenha))
                return true;
            throw new ArgumentException("Senhas não conferem");
        }
    }
}

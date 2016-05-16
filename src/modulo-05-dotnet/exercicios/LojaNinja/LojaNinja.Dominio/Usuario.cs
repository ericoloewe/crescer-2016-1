using System;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;

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

        [Required]
        public int Id { get; private set; }

        [Required(ErrorMessage = "Nome do usuario não informado!")]
        [DisplayName("Nome")]
        public string Nome { get; set; }

        [Required(ErrorMessage = "Email do usuario não informado!")]
        [DisplayName("Email")]
        public string Email { get; set; }

        [Required(ErrorMessage = "Senha do usuario não informado!")]
        [DisplayName("Senha")]
        public string Senha { get; set; }

        [DisplayName("Permissoes")]
        public string[] Permissoes { get; set; }

        private bool VerificaSeSenhasSaoIguais(string senha, string confirmSenha)
        {
            if (senha.Equals(confirmSenha))
                return true;
            throw new ArgumentException("Senhas não conferem");
        }
    }
}

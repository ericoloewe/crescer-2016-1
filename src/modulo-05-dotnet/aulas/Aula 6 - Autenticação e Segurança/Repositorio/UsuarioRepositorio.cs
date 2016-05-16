using Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace Repositorio
{
    // Nós ainda não temos um banco de dados para guardar nossos dados,
    // Mas sabemos que por enquanto, podemos fingir termos um, com dados fixos. O que acham?
    public class UsuarioRepositorio : IUsuarioRepositorio
    {
        private List<Usuario> _usuarios;

        public UsuarioRepositorio()
        {
            _usuarios = new List<Usuario>();

            _usuarios.Add(new Usuario()
            {
                Email = "comum@teste.com",
                Senha = "e99a18c428cb38d5f260853678922e03", //abc123
                Nome = "Usuário Comum"
            });

            _usuarios.Add(new Usuario()
            {
                Email = "gold@teste.com",
                Senha = "a906449d5769fa7361d7ecc6aa3f6d28", //123abc
                Nome = "Usuário Gold",
                Permissoes = new string[] { "GOLD" }
            });
        }

        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            return _usuarios.FirstOrDefault(
                c => c.Email.Equals(email) && c.Senha.Equals(senha));
        }

    }
}

using LojaNinja.Dominio;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;

namespace LojaNinja.MVC.Models
{
    public class UsuarioViewModel
    {
        public UsuarioViewModel(Usuario usuario)
        {
            Email = usuario.Email;
            Nome = usuario.Nome;
            Permissoes = usuario.Permissoes;
        }

        public string Email { get; private set; }
        public string Nome { get; private set; }
        public string[] Permissoes { get; private set; }

        public bool TemPermissao(string permissao)
        {
            return Permissoes != null
                   && Permissoes.Any(p => p.Equals(permissao));
        }
    }

    public class LoginUsuarioViewModel
    {
        [Required]
        [DisplayName("E-mail")]
        [StringLength(100)]
        [EmailAddress]
        public string Email { get; set; }

        [Required]
        [DisplayName("Senha")]
        [StringLength(100)]
        public string Senha { get; set; }
    }
}
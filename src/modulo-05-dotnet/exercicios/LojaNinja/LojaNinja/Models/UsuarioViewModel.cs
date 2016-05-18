using LojaNinja.Dominio;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;

namespace LojaNinja.MVC.Models
{
    public class UsuarioViewModel
    {
        public UsuarioViewModel() { }
        public UsuarioViewModel(Usuario usuario)
        {
            Email = usuario.Email;
            Nome = usuario.Nome;
            Senha = usuario.Senha;
            Permissoes = usuario.Permissoes;
        }

        public int Id { get; set; }
        [EmailAddress]
        [DisplayName("E-mail")]
        public string Email { get; set; }
        public string Nome { get; set; }
        [DataType(DataType.Password)]
        public string Senha { get; set; }
        public IList<Permissao> Permissoes { get; set; }

        public bool TemPermissao(string permissao)
        {
            return Permissoes != null
                   && Permissoes.Any(p => p.Equals(permissao));
        }
    }

    public class CadastroUsuarioViewModel
    {
        public CadastroUsuarioViewModel() { }

        [Required]
        [StringLength(255)]
        [EmailAddress]
        [DisplayName("E-mail")]
        public string Email { get; set; }
        [Required]
        [StringLength(255)]
        public string Nome { get; set; }
        [Required]
        [StringLength(255, ErrorMessage = "A {0} deve ser menor que {2} caracteres.", MinimumLength = 8)]
        [DataType(DataType.Password)]
        public string Senha { get; set; }

        [DataType(DataType.Password)]
        [Display(Name = "Confirme sua senha")]
        [Compare("Senha", ErrorMessage = "A senha e sua confirmação não combinam.")]
        public string ConfirmaSenha { get; set; }
    }

    public class LoginUsuarioViewModel
    {
        [Required]
        [DisplayName("E-mail")]
        [StringLength(100)]
        [EmailAddress]
        public string Email { get; set; }

        [Required]
        [DataType(DataType.Password)]
        [StringLength(100)]
        public string Senha { get; set; }
    }
}
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;
using Dominio = CdZ.Dominio;

namespace CdZ.MVC.Models.Usuario
{
    public class UsuarioEditViewModel
    {
        public UsuarioEditViewModel()
        {

        }
        
        public int? Id { get; set; }

        [Required]
        [EmailAddress]
        [StringLength(250)]
        [DisplayName("E-mail")]
        public string Email { get; set; }

        [Required]
        [StringLength(100)]
        [DisplayName("Nome")]
        public string Nome { get; set; }

        [Required]
        [DisplayName("Senha")]
        [DataType(DataType.Password)]
        [StringLength(100)]
        [RegularExpression(@"((?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,50})", ErrorMessage = "A senha deve conter pelo menos uma letra minúscula, uma maiúscula e um número.")]
        public string Senha { get; set; }

        [DisplayName("Confirme Sua Senha")]
        [Compare("Senha", ErrorMessage = "As senhas não conferem")]
        public string ConfirmacaoSenha { get; set; }
    }
}
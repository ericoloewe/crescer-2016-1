using LojaNinja.Dominio;
using LojaNinja.MVC.Models;

namespace LojaNinja.MVC.Extensions
{
    public static class UsuarioExtension
    {
        public static Usuario ToUsuario(this CadastroUsuarioViewModel usuario)
        {
            return new Usuario(usuario.Nome, usuario.Email, usuario.Senha);
        }
        public static Usuario ToUsuario(this UsuarioViewModel usuario)
        {
            return new Usuario(usuario.Nome, usuario.Email, usuario.Senha);
        }

        public static UsuarioViewModel ToUsuarioViewModel(this Usuario usuario)
        {
            return new UsuarioViewModel()
            {
                Id = usuario.Id,
                Email = usuario.Email,
                Nome = usuario.Nome, 
                Senha = usuario.Senha,
                Permissoes = usuario.Permissoes
            };
        }
    }
}
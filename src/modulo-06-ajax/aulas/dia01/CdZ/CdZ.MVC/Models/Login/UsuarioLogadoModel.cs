using Dominio = CdZ.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CdZ.MVC.Models.Login
{
    public class UsuarioLogadoModel
    {
        public UsuarioLogadoModel(Dominio.Usuario usuario)
        {
            this.Email = usuario.Email;
            this.Nome = usuario.Nome;
            this.Permissoes = usuario.Permissoes == null ? 
                                null :
                                usuario.Permissoes.Select(p => p.Nome).ToArray();
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
}
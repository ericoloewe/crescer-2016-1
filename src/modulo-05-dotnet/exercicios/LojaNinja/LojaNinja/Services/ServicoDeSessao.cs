using LojaNinja.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LojaNinja.MVC.Services
{
    public class ServicoDeSessao
    {
        private const string COOKIE_AUTENTICACAO = "COOKIE_AUTENTICACAO";
        private const string USUARIO_LOGADO = "USUARIO_LOGADO";

        private static Dictionary<string, string> _usuariosLogados = new Dictionary<string, string>();

        public static UsuarioViewModel UsuarioLogado
        {
            get
            {
                return (UsuarioViewModel)HttpContext.Current.Session[USUARIO_LOGADO];
            }
        }

        public static bool EstaLogado
        {
            get
            {
                if (UsuarioLogado != null)
                {
                    HttpCookie cookieDeAutenticacao = HttpContext.Current.Request.Cookies.Get(COOKIE_AUTENTICACAO);

                    return _usuariosLogados.Any(
                                u => u.Key.Equals(cookieDeAutenticacao.Value)
                                && u.Value.Equals(UsuarioLogado.Email)
                            );
                }

                return false;
            }
        }

        public static void CriarSessao(UsuarioViewModel usuario)
        {
            string numeroToken = Guid.NewGuid().ToString();
            _usuariosLogados.Add(numeroToken, usuario.Email);

            HttpContext.Current.Session[USUARIO_LOGADO] = usuario;
            var cookieDeAutenticacao = new HttpCookie(COOKIE_AUTENTICACAO, numeroToken);

            HttpContext.Current.Response.Cookies.Set(cookieDeAutenticacao);
        }
    }
}
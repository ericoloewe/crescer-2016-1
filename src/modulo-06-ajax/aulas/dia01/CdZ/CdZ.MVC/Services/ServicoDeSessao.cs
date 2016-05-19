using CdZ.MVC.Models.Login;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CdZ.MVC.Services
{
    // Seria terrível se tivessemos Session e Cookies para todo lado em todo canto.
    // Para resolver isso, criamos esse Serviço, que encapsulará a lógica de autenticação e Sessão.
    public static class ServicoDeSessao
    {
        private const string COOKIE_AUTENTICACAO = "COOKIE_AUTENTICACAO";
        private const string USUARIO_LOGADO = "USUARIO_LOGADO";

        // Guardaremos os Tokens logados no momento para dentro desta lista.
        // Lembre-se: por se tratar de uma lista estática, todas as requisiões podem vê-la.
        private static Dictionary<string, string> _usuariosLogados = new Dictionary<string, string>();

        // Este cara apenas faz a mão de pegar o usuário logado da Sessão.
        // Mais fácil chamar por aqui do que ficar dando Cast em Session em tudo que é lugar não?
        public static UsuarioLogadoModel UsuarioLogado
        {
            get
            {
                return (UsuarioLogadoModel)HttpContext.Current.Session[USUARIO_LOGADO];
            }
        }

        // Esta propriedade nos informa se o usuário está logado ou não.
        // Para isso, ele verifica se existe o cookie de autenticação e se o mesmo ainda existe na lista acima.
        // Repare também que ele verifica se a sessão do usuário também está ativa.
        // IMPORTANTE: você deve estar se perguntando porque verificamos o cookie, se somente a sessão deve bastar...
        // Bem, você pode ter sessão sem o usuário estar autenticado. Lembra que eu posso ter um carrinho de compras
        // em uma loja virtual sem estar logado...       
        public static bool EstaLogado
        {
            get
            {
                if (UsuarioLogado != null)
                {
                    HttpCookie cookieDeAutenticacao = HttpContext.Current.Request.Cookies.Get(COOKIE_AUTENTICACAO);

                    bool cookieEstaOk = _usuariosLogados.Any(
                            u => u.Key.Equals(cookieDeAutenticacao.Value)
                            && u.Value.Equals(UsuarioLogado.Email)
                        );

                    return cookieEstaOk;
                }

                return false;
            }
        }

        // Aqui encapsulamos a lógica para criar a sessão para o usuário.
        public static void CriarSessao(UsuarioLogadoModel usuario)
        {
            // Um Guid gera um hash aleatório.
            string numeroToken = Guid.NewGuid().ToString();
            _usuariosLogados.Add(numeroToken, usuario.Email);

            HttpContext.Current.Session[USUARIO_LOGADO] = usuario;
            var cookieDeAutenticacao = new HttpCookie(COOKIE_AUTENTICACAO, numeroToken);

            HttpContext.Current.Response.Cookies.Set(cookieDeAutenticacao);
        }

        public static void Sair()
        {
            if(EstaLogado)
            {
                HttpCookie cookieDeAutenticacao = HttpContext.Current.Request.Cookies.Get(COOKIE_AUTENTICACAO);

                _usuariosLogados.Remove(cookieDeAutenticacao.Value);

                cookieDeAutenticacao.Expirar();

                HttpContext.Current.Session.Abandon();
            }
        }
    }
}
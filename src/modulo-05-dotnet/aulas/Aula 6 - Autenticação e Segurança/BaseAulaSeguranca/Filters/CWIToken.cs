using BaseAulaSeguranca.Models.Login;
using BaseAulaSeguranca.Services;
using Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace BaseAulaSeguranca.Filters
{
    // Este cara é nosso attribute decorator de validação. Como definimos em aula: o segurança da porta.
    // Para ele ser um "Segurança", deve herdar de AuthorizeAttribute
    public class CWIToken : AuthorizeAttribute
    {
        // para não fazermos this.Roles.Split o tempo todo, guardamos nesta variável.
        private string[] _permissoesRequeridas = null;

        public CWIToken()
        {
            // Caso tenhamos Roles (aquelas que colocamos o GOLD, lembra?), jogaremos ela já quebrada
            // em uma variável, para não repetirmos sempre isso.
            // O construtor deste AuthorizeAttributo é chamado quando entramos na Action.
            _permissoesRequeridas = String.IsNullOrWhiteSpace(this.Roles) ?
                                        null :
                                        this.Roles.Split(',');
        }

        // Criamos esta propriedade para encapsular a regra de AUTORIZAÇÃO.
        // Ou seja, estamos logados, mas precisamos saber se temos as permissões.
        // Se tivermos pelo menos uma das permissões, estamos OK.
        private bool TemAutorizacao
        {
            get
            {
                UsuarioLogadoModel usuarioLogado = ServicoDeSessao.UsuarioLogado;

                if (this._permissoesRequeridas != null)
                {
                    foreach (string permissao in _permissoesRequeridas)
                    {
                        if (usuarioLogado.TemPermissao(permissao))
                        {
                            return true;
                        }
                    }
                }
                else
                {
                    return true;
                }

                return false;
            }
        }

        // Este cara é o que define se podemos ou não executar a Action requisitada.
        protected override bool AuthorizeCore(HttpContextBase httpContext)
        {
            return ServicoDeSessao.EstaLogado && TemAutorizacao;
        }

        // Este cara diz o que deve acontecer depooois de verificar se temos AUTENTICAÇÃO e AUTORIZAÇÃO.
        public override void OnAuthorization(AuthorizationContext filterContext)
        {
            bool estaAutenticadoEAutorizado = this.AuthorizeCore(filterContext.HttpContext);

            if(!estaAutenticadoEAutorizado)
            {
                // se o usuário não está autenticado nem autorizado, envia ele de volta para a action Index da controller Login.
                filterContext.Result = new RedirectToRouteResult(
                                   new RouteValueDictionary
                                   {
                                       { "action", "Index" },
                                       { "controller", "Login" }
                                   });
            }

        }
        
    }
}
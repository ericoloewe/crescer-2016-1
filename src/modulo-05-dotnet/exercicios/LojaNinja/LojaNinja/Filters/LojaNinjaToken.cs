using LojaNinja.MVC.Models;
using LojaNinja.MVC.Services;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace LojaNinja.MVC.Filters
{
    public class LojaNinjaToken : AuthorizeAttribute
    {
        private readonly string[] _permissoesRequeridas = null;

        public LojaNinjaToken()
        {
            _permissoesRequeridas = string.IsNullOrWhiteSpace(this.Roles) ?
                                        null :
                                        Roles.Split(',');
        }

        private bool TemAutorizacao
        {
            get
            {
                UsuarioViewModel usuarioLogado = ServicoDeSessao.UsuarioLogado;

                if (_permissoesRequeridas != null)
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

        protected override bool AuthorizeCore(HttpContextBase httpContext)
        {
            return ServicoDeSessao.EstaLogado && TemAutorizacao;
        }

        public override void OnAuthorization(AuthorizationContext filterContext)
        {
            bool estaAutenticadoEAutorizado = this.AuthorizeCore(filterContext.HttpContext);

            if (!estaAutenticadoEAutorizado)
            {
                filterContext.Result = new RedirectToRouteResult(
                                   new RouteValueDictionary
                                   {
                                       { "action", "Login" },
                                       { "controller", "Usuario" }
                                   });
            }

        }
    }
}
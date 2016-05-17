using System.Linq;
using LojaNinja.MVC.Services;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace LojaNinja.MVC.Filters
{
    public class LojaNinjaToken : AuthorizeAttribute
    {
        private string[] _permissoesRequeridas {
            get
            {
                return string.IsNullOrWhiteSpace(Roles) ?
                                        null :
                                        Roles.Split(',');
            }
        }

        private bool TemAutorizacao
        {
            get
            {
                var usuarioLogado = ServicoDeSessao.UsuarioLogado;
                return _permissoesRequeridas == null || 
                        _permissoesRequeridas.Any(permissao => usuarioLogado.TemPermissao(permissao));
            }
        }

        protected override bool AuthorizeCore(HttpContextBase httpContext)
        {
            return ServicoDeSessao.EstaLogado && TemAutorizacao;
        }

        public override void OnAuthorization(AuthorizationContext filterContext)
        {
            bool estaAutenticadoEAutorizado = AuthorizeCore(filterContext.HttpContext);

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
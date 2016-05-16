using System.Web.Mvc;
using LojaNinja.Dominio;
using LojaNinja.Repositorio;

namespace LojaNinja.MVC.Controllers
{
    public class UsuarioController : Controller
    {
        UsuarioServico _usuarioServico;

        public UsuarioController()
        {
            _usuarioServico = new UsuarioServico(new UsuarioRepositorioADO());
        }

        // GET: Usuario
        public ActionResult Index()
        {
            var usuario = _usuarioServico.BuscarUsuarioPorAutenticacao("comum@teste.com", "abc123");
            return View();
        }
    }
}
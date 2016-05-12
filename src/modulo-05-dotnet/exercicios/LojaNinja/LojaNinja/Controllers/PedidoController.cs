using LojaNinja.MVC.Models;
using System.Web.Mvc;

namespace LojaNinja.MVC.Controllers
{
    public class PedidoController : Controller
    {
        // GET: Pedido
        public ActionResult Index()
        {
            return View();
        }

        // GET: Pedido
        public ActionResult Novo()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Novo(PedidoViewModel pedido)
        {
            return View();
        }
    }
}
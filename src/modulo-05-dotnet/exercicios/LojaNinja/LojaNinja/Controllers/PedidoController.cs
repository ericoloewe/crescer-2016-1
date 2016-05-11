using LojaNinja.Models;
using System.Web.Mvc;

namespace LojaNinja.Controllers
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
    }
}
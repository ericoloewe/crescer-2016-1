using CdZ.Dominio;
using CdZ.MVC.Services;
using System.Web.Mvc;

namespace CdZ.MVC.Controllers
{
    public class CavaleiroController : Controller
    {
        private ICavaleiroRepositorio _cavaleiros = ServicoInjecaoDeDependecia.CriarCavaleiroRepositorio();

        [HttpGet]
        public ActionResult Index()
        {
            return View();
        }

        [HttpGet]
        public JsonResult Get()
        {
            return Json(new { data = _cavaleiros.Todos() }, JsonRequestBehavior.AllowGet);
        }
    }
}

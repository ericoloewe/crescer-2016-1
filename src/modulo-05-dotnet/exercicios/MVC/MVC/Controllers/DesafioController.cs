using System.Web.Mvc;

namespace MVC.Controllers
{
    public class DesafioController : Controller
    {
        // GET: Desafio
        public ActionResult Index(string aluno)
        {
            ViewBag.cssAtual = string.Format("~/Content/Estilos/{0}.css", aluno);
            return View();
        }
    }
}
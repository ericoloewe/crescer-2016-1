using System.Web.Mvc;

namespace MVC.Controllers
{
    public class DesafioController : Controller
    {
        // GET: Desafio
        public ActionResult Index(string aluno)
        {
            ViewBag.cssAtual = aluno;
            return View();
        }
    }
}
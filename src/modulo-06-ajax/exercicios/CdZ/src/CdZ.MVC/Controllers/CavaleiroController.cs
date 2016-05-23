using CdZ.Dominio;
using CdZ.MVC.Models.Cavaleiro;
using CdZ.MVC.Services;
using System.Net;
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
        public JsonResult Get(int pagina = 0)
        {
            /* Para simular erro, descomente
                var status = (int)HttpStatusCode.InternalServerError;
                throw new HttpException(status, "Ops");
            */
            //System.Threading.Thread.Sleep(3000);
            return Json(new { data = _cavaleiros.Todos(pagina) }, JsonRequestBehavior.AllowGet);
        }

        [HttpGet]
        public JsonResult QuantidadeDeCavaleiros()
        {
            return Json(_cavaleiros.QuantidadeDeCavaleiros(), JsonRequestBehavior.AllowGet);
        }

        [HttpPost]
        public JsonResult Post(CavaleiroViewModel cavaleiro)
        {
            //System.Threading.Thread.Sleep(3000);
            var novoId = _cavaleiros.Adicionar(cavaleiro.ToModel());
            Response.StatusCode = (int)HttpStatusCode.Created;
            return Json(new { id = novoId });
        }

        [HttpDelete]
        public JsonResult Delete(int id)
        {
            _cavaleiros.Excluir(id);
            return Json(new { Mensagem = "Cavaleiro deletado com sucesso." });
        }
    }
}

using System;
using System.Web.Mvc;
using MVC.Models;

namespace MVC.Controllers
{
    public class StreetFighterController : Controller
    {        
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Sobre()
        {
            var sobreMim = new SobreMimModel()
            {
                Nome = "Érico de Souza Loewe",
                Foto = "~/Content/Imagens/minha_foto.jpg",
                EstadoCivil = EstadoCivil.Solteiro,
                DataNascimento = new DateTime(1996, 9, 16),
                Altura = 180,
                Peso = 78
            };
            return View(sobreMim);
        }

        public ActionResult FichaTecnica()
        {
            return View();
        }
    }
}
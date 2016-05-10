using MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVC.Controllers
{
    public class ExemploController : Controller
    {
        public ActionResult Index(int? id)
        {
            var personagens = new List<PersonagemModel>()
                {
                    new PersonagemModel()
                    {
                        Nome = "Sasuke",
                        Id = 16,
                        Fodao = false
                    },
                    new PersonagemModel()
                    {
                        Nome = "Vegeta",
                        Id = 30,
                        Fodao = true
                    },
                    new PersonagemModel()
                    {
                        Nome = "Patrik",
                        Id = 11,
                        Fodao = true
                    },
                    new PersonagemModel()
                    {
                        Nome = "Pepe",
                        Id = 1,
                        Fodao = true
                    }
                };

            ViewBag.MensagemBoasVindas = "Olá, seja bem vindo!";

            if (id == null)
            {
                TempData["Erro"] = "Você não informou o ID, tente novamente mais tarde!";

                return RedirectToAction("Index", "Teste");
            }
            else
            {
                var personagemEscolhido = personagens.FirstOrDefault(x => x.Id == id);

                return View(personagemEscolhido);
            }

            //return RedirectToAction("Index", "Teste");
            //return View(personagens);
            //return View("HelloWorld");
            //return View("~/Views/Erros/NotFound.cshtml");
        }

        public ActionResult UsandoLayout()
        {
            return View();
        }
    }    
}
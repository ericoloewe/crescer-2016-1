using System;
using System.Web.Mvc;
using LojaNinja.Dominio;
using LojaNinja.MVC.Extensions;
using LojaNinja.MVC.Filters;
using LojaNinja.MVC.Models;
using LojaNinja.MVC.Services;
using LojaNinja.Repositorio;

namespace LojaNinja.MVC.Controllers
{
    public class UsuarioController : Controller
    {
        private readonly UsuarioServico _usuarioServico;

        public UsuarioController()
        {
            _usuarioServico = new UsuarioServico(new UsuarioRepositorioADO());
        }

        // GET: /Usuario/Login
        [AllowAnonymous]
        public ActionResult Login()
        {
            return View();
        }

        // POST: /Usuario/Login
        [HttpPost]
        [AllowAnonymous]
        [ValidateAntiForgeryToken]
        public ActionResult Login(LoginUsuarioViewModel usuario)
        {
            if (ModelState.IsValid)
            {
                try
                {
                    var usuarioViewModel = _usuarioServico.BuscarUsuarioPorAutenticacao(usuario.Email, usuario.Senha);
                    if (usuarioViewModel != null)
                    {
                        ServicoDeSessao.CriarSessao(usuarioViewModel.ToUsuarioViewModel());
                        return RedirectToAction("Index", "Home");
                    }
                }
                catch (Exception ex)
                {
                    ModelState.AddModelError("", ex.Message);
                    
                }
            }
            return View(usuario);
        }

        // GET: /Usuario/Cadastro
        public ActionResult Cadastro()
        {
            return View();
        }

        // POST: /Usuario/Cadastro
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Cadastro(CadastroUsuarioViewModel usuario)
        {
            if (ModelState.IsValid)
            {
                _usuarioServico.CadastrarUsuario(usuario.ToUsuario());
                return RedirectToAction("Index", "Home");
            }
            return View(usuario);
        }

        [LojaNinjaToken(Roles = "ADMIN")]
        // GET: Usuario
        public ActionResult Index()
        {
            var usuario = _usuarioServico.BuscarUsuarioPorAutenticacao("comum@teste.com", "abc123");
            return View();
        }
    }
}
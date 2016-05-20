using CdZ.Dominio;
using CdZ.MVC.Filters;
using CdZ.MVC.Models.Usuario;
using CdZ.MVC.Services;
using CdZ.Repositorio.EF;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace CdZ.MVC.Controllers
{
    [CdZAutorizador]
    public class UsuarioController : Controller
    {
        UsuarioServico _usuarioServico;

        public UsuarioController()
        {
            _usuarioServico = new UsuarioServico(
                    ServicoInjecaoDeDependecia.CriarUsuarioRepositorio()
                );
        }

        [HttpGet]
        public ActionResult Cadastro()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Cadastrar(UsuarioEditViewModel viewModel)
        {
            if(ModelState.IsValid)
            {
                Usuario usuario = new Usuario(
                        id: 0,
                        email: viewModel.Email,
                        nome: viewModel.Nome,
                        senha: viewModel.Senha,
                        permissoes: null
                    );

                _usuarioServico.CriarUsuario(usuario);
            }

            return View("Cadastrar");
        }
    }
}
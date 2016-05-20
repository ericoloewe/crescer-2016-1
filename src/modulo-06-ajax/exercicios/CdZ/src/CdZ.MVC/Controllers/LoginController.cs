using CdZ.Dominio;
using CdZ.MVC.Models.Login;
using CdZ.MVC.Services;
using System.Web.Mvc;

namespace CdZ.MVC.Controllers
{
    public class LoginController : Controller
    {
        private UsuarioServico _usuarioServico;

        public LoginController()
        {
            _usuarioServico = new UsuarioServico(
                    ServicoInjecaoDeDependecia.CriarUsuarioRepositorio()
                );
        }

        [HttpGet]
        public ActionResult Index()
        {
            if (!ServicoDeSessao.EstaLogado)
            {
                return View();
            }

            return AcaoInicial();
        }

        [HttpGet]
        public ActionResult Loggout()
        {
            ServicoDeSessao.Sair();
            return RedirectToAction("Index");
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Entrar(LoginViewModel loginViewModel)
        {
            if (ModelState.IsValid)
            {
                Usuario usuarioEncontrado =
                    _usuarioServico.BuscarUsuarioPorAutenticacao(
                            loginViewModel.Email, loginViewModel.Senha
                        );

                if (usuarioEncontrado != null)
                {
                    var usuarioLogadoModel = new UsuarioLogadoModel(usuarioEncontrado);

                    ServicoDeSessao.CriarSessao(usuarioLogadoModel);
                    return AcaoInicial();
                }
                else
                {
                    ModelState.AddModelError("INVALID_USER", "Usuário ou senha inválido.");
                }
            }

            return View("Index", loginViewModel);
        }
        
        private ActionResult AcaoInicial()
        {
            return RedirectToAction("Index", "Cavaleiro");
        }
    }
}
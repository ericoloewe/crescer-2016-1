using BaseAulaSeguranca.Filters;
using BaseAulaSeguranca.Models.Login;
using BaseAulaSeguranca.Services;
using Dominio;
using Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace BaseAulaSeguranca.Controllers
{
    public class LoginController : Controller
    {
        // Iremos utilizar o serviço de usuários.
        private UsuarioServico _usuarioServico;

        public LoginController()
        {
            // O serviço de usuário sabe que precisamos de alguém que persista usuário, alguém que implementa
            // as regras dessa persistência, afinal, o Método BuscarUsuarioPorAutenticacao do serviço utiliza
            // o repositório, concorda?
            // Bem, no domínio, só temos as regras de persistência, não a implementação.
            // Aqui na camada WEB, onde tudo se junta, podemos definir quem vai ter o papel do que.
            // Neste caso, definimos que a regra de persistência de usuário será realizada pela classe UsuarioRepositorio.
            _usuarioServico = new UsuarioServico(
                    new UsuarioRepositorio()
                );
        }

        [HttpGet]
        public ActionResult Index()
        {
            // Se o usuário está logado, enviamos ele direto para a AreaSecreta, caso contrário, Login.
            if (!ServicoDeSessao.EstaLogado)
            {
                return View();
            }

            return RedirectToAction("AreaSecreta");
        }

        // Utilizados o [HttpPost] para dizer que esta action só pode ser acessada via POST.
        // Sempre que vamos fazer um post de um formulário, devemos utilizar o @Html.AntiForgeryToken.
        // Colocando o [ValidateAntiForgeryToken], estamos dizendo para a action validar esta etapa de segurança para
        // que o form não seja válido caso enviado mais de uma vez (caso alguém intercepte o form e o reenvie).
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Entrar(LoginViewModel loginViewModel)
        {
            if(ModelState.IsValid)
            {
                // Buscamos o usuário de nosso "Banco de Dados" por seu login e senha.
                Usuario usuarioEncontrado =
                    _usuarioServico.BuscarUsuarioPorAutenticacao(
                            loginViewModel.Email, loginViewModel.Senha
                        );

                if(usuarioEncontrado != null)
                {
                    // É sempre bom criar uma Model só para o usuário logado.
                    // Digamos que você queira utilizar somente a classe Usuário para isso,
                    // então se quisesse guardar coisas que são da sessão e não da classe usuário, como faria?
                    // mudaria a classe Usuario? Não, porque não é de sua responsabilidade os dados de sessão.
                    // mas uma view model pode ser mais flexivel.
                    var usuarioLogadoModel = new UsuarioLogadoModel(usuarioEncontrado);

                    // Encapsulamos aqui a regra para criar a sessão.
                    ServicoDeSessao.CriarSessao(usuarioLogadoModel);
                    return RedirectToAction("AreaSecreta");
                }
                else
                {
                    ModelState.AddModelError("INVALID_USER", "Usuário ou senha inválido.");
                }
            }

            return View("Index", loginViewModel);
        }

        [HttpGet]
        [CWIToken]
        public ActionResult AreaSecreta()
        {
            UsuarioLogadoModel usuarioLogado = ServicoDeSessao.UsuarioLogado;
            ViewBag.NomeUsuarioLogado = usuarioLogado.Nome;
            return View();
        }

        // Aqui, exigimos que somente alguém que tenha a permissão GOLD possa entrar.
        [HttpGet]
        [CWIToken(Roles = "GOLD")]
        public ActionResult AreaSuuuperSecreta()
        {
            return View();
        }
    }
}
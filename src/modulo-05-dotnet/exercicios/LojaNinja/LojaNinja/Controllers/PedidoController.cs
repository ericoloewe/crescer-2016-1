using LojaNinja.MVC.Models;
using System.Web.Mvc;
using LojaNinja.Dominio;
using LojaNinja.Repositorio;

namespace LojaNinja.MVC.Controllers
{
    public class PedidoController : Controller
    {
        private readonly RepositorioPedidos _repositorio = new RepositorioPedidos();

        // GET: Pedido
        public ActionResult Index()
        {
            return View();
        }

        // GET: Pedido
        public ActionResult Salvar()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Salvar(PedidoViewModel pedido)
        {
            if (ModelState.IsValid)
            {
                if (pedido.Id == 0)
                    _repositorio.IncluirPedido(
                        new Pedido(pedido.DataEntrega, pedido.NomeProduto, pedido.ValorVenda,
                            pedido.TipoPagamento, pedido.NomeCliente, pedido.Cidade, pedido.Estado));
                else
                    _repositorio.AtualizarPedido(
                        new Pedido(pedido.DataEntrega, pedido.NomeProduto, pedido.ValorVenda,
                            pedido.TipoPagamento, pedido.NomeCliente, pedido.Cidade, pedido.Estado, pedido.Id));
            }

            return RedirectToAction("Index");
        }
    }
}
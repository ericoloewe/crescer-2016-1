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

        // GET: /Pedido/Detalhes
        public ActionResult Detalhes(int id)
        {
            return View(_repositorio.ObterPedidoPorId(id));
        }

        // GET: /Pedido/Salvar
        public ActionResult Salvar(int id = 0)
        {
            if (id > 0)
            {
                var pedido = _repositorio.ObterPedidoPorId(id);
                return View(new PedidoViewModel()
                {
                    Id = pedido.Id,
                    NomeCliente = pedido.NomeCliente,
                    NomeProduto = pedido.NomeProduto,
                    Cidade = pedido.Cidade,
                    Estado = pedido.Estado,
                    DataEntrega = pedido.DataEntrega,
                    TipoPagamento = pedido.TipoPagamento,
                    ValorVenda = pedido.ValorVenda
                });
            }
            return View();
        }

        // POST: /Pedido/Salvar
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
using System.Collections.Generic;
using LojaNinja.MVC.Models;
using System.Web.Mvc;
using LojaNinja.Dominio;
using LojaNinja.Repositorio;

namespace LojaNinja.MVC.Controllers
{
    public class PedidoController : Controller
    {
        private readonly IPedidoRepositorio _repositorio = new PedidoRepositorio();

        // GET: Pedido
        [HttpGet]
        public ActionResult Index(string cliente = null, string produto = null, string geral = null)
        {
            List<Pedido> pedidos;

            if (cliente != null)
                pedidos = _repositorio.ObterPedidoPorCliente(cliente);
            else if (produto != null)
                pedidos = _repositorio.ObterPedidoPorProduto(produto);
            else if (geral != null)
                pedidos = _repositorio.ObterPedidoQueContenha(geral);
            else
                pedidos = _repositorio.ObterPedidos();

            return View(pedidos);
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

                return RedirectToAction("Index");
            }

            return View(pedido);
        }

        public ActionResult Deletar(int id)
        {
            var produtoAntigo = _repositorio.ObterPedidoPorId(id);
            _repositorio.ExcluirPedido(id);
            return View(produtoAntigo);
        }
    }
}
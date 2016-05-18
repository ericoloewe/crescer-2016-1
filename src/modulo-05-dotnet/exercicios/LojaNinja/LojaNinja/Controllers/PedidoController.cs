using System.Collections.Generic;
using LojaNinja.MVC.Models;
using System.Web.Mvc;
using LojaNinja.Dominio;
using LojaNinja.MVC.Filters;
using LojaNinja.Repositorio;
using LojaNinja.Dominio.Services;

namespace LojaNinja.MVC.Controllers
{
    [LojaNinjaToken]
    public class PedidoController : Controller
    {
        private readonly PedidoServico _pedidoServico;

        public PedidoController()
        {
            _pedidoServico = new PedidoServico(new PedidoRepositorio());
        }

        // GET: Pedido
        [HttpGet]
        public ActionResult Index(string cliente = null, string produto = null, string geral = null)
        {
            List<Pedido> pedidos;

            if (cliente != null)
                pedidos = _pedidoServico.ObterPedidoPorCliente(cliente);
            else if (produto != null)
                pedidos = _pedidoServico.ObterPedidoPorProduto(produto);
            else if (geral != null)
                pedidos = _pedidoServico.ObterPedidoQueContenha(geral);
            else
                pedidos = _pedidoServico.ObterPedidos();

            return View(pedidos);
        }

        // GET: /Pedido/Detalhes
        public ActionResult Detalhes(int id)
        {
            return View(_pedidoServico.ObterPedidoPorId(id));
        }

        // GET: /Pedido/Salvar
        public ActionResult Salvar(int id = 0)
        {
            if (id > 0)
            {
                var pedido = _pedidoServico.ObterPedidoPorId(id);
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
        [ValidateAntiForgeryToken]
        public ActionResult Salvar(PedidoViewModel pedido)
        {
            if (ModelState.IsValid)
            {
                if (pedido.Id == 0)
                    _pedidoServico.IncluirPedido(
                        new Pedido(pedido.DataEntrega, pedido.NomeProduto, pedido.ValorVenda,
                            pedido.TipoPagamento, pedido.NomeCliente, pedido.Cidade, pedido.Estado));
                else
                    _pedidoServico.AtualizarPedido(
                        new Pedido(pedido.DataEntrega, pedido.NomeProduto, pedido.ValorVenda,
                            pedido.TipoPagamento, pedido.NomeCliente, pedido.Cidade, pedido.Estado, pedido.Id));

                return RedirectToAction("Index");
            }

            return View(pedido);
        }

        public ActionResult Deletar(int id)
        {
            var produtoAntigo = _pedidoServico.ObterPedidoPorId(id);
            _pedidoServico.ExcluirPedido(id);
            return View(produtoAntigo);
        }
    }
}
using System.Collections.Generic;

namespace LojaNinja.Dominio.Services
{
    public class PedidoServico
    {
        private IPedidoRepositorio _pedidoRepositorio;

        public PedidoServico(IPedidoRepositorio pedidoRepositorio)
        {
            _pedidoRepositorio = pedidoRepositorio;
        }

        public List<Pedido> ObterPedidoPorCliente(string cliente)
        {
            return _pedidoRepositorio.ObterPedidoPorCliente(cliente);
        }

        public List<Pedido> ObterPedidoPorProduto(string produto)
        {
            return _pedidoRepositorio.ObterPedidoPorProduto(produto);
        }

        public List<Pedido> ObterPedidoQueContenha(string geral)
        {
            return _pedidoRepositorio.ObterPedidoQueContenha(geral);
        }

        public List<Pedido> ObterPedidos()
        {
            return _pedidoRepositorio.ObterPedidos();
        }

        public Pedido ObterPedidoPorId(int id)
        {
            return _pedidoRepositorio.ObterPedidoPorId(id);
        }

        public void IncluirPedido(Pedido pedido)
        {
            _pedidoRepositorio.IncluirPedido(pedido);
        }

        public void AtualizarPedido(Pedido pedido)
        {
            _pedidoRepositorio.AtualizarPedido(pedido);
        }

        public void ExcluirPedido(int id)
        {
            _pedidoRepositorio.ExcluirPedido(id);
        }
    }
}

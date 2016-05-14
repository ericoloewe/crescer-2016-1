using System.Collections.Generic;
using LojaNinja.Dominio;

namespace LojaNinja.Repositorio
{
    public interface IRepositorioPedidos
    {
        List<Pedido> ObterPedidos();
        List<Pedido> ObterPedidoQueContenha(string str);
        Pedido ObterPedidoPorId(int id);
        List<Pedido> ObterPedidoPorProduto(string produto);
        List<Pedido> ObterPedidoPorCliente(string cliente);
        void IncluirPedido(Pedido pedido);
        void AtualizarPedido(Pedido pedido);
        void ExcluirPedido(int id);
    }
}

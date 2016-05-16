using System.Collections.Generic;

namespace LojaNinja.Dominio
{
    public interface IPedidoRepositorio
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

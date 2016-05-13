using System;
using LojaNinja.Dominio;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace LojaNinja.Test
{
    [TestClass]
    public class PedidoTest
    {
        [TestMethod]
        public void CriarPedidoComConstrutorParaCriarNovosPedidos()
        {
            var dataPedido = DateTime.Today;
            var dataEntregaDesejada = DateTime.Today.AddDays(8);
            var nomeProduto = "Quisque libero metus condimentum";
            var valorVenda = 999;
            TipoPagamento tipoPagamento = TipoPagamento.Mastercard;
            var nomeCliente = "Vestibulum suscipit nulla quis";
            var cidade = "Proin pretium leo ac";
            var estado = "In hac habitasse platea";

            var pedido = new Pedido(dataEntregaDesejada, nomeProduto, valorVenda, tipoPagamento, nomeCliente, cidade, estado);

            Assert.AreEqual(0, pedido.Id);
            Assert.AreEqual(dataEntregaDesejada, pedido.DataEntrega);
            Assert.AreEqual(dataPedido, pedido.DataPedido);
            Assert.AreEqual(nomeProduto, pedido.NomeProduto);
            Assert.AreEqual(valorVenda, pedido.ValorVenda);
            Assert.AreEqual(tipoPagamento, pedido.TipoPagamento);
            Assert.AreEqual(nomeCliente, pedido.NomeCliente);
            Assert.AreEqual(cidade, pedido.Cidade);
            Assert.AreEqual(estado, pedido.Estado);
            Assert.AreEqual(false, pedido.Urgente);
        }

        [TestMethod]
        public void CriarPedidoUrgenteComConstrutorParaCriarNovosPedidos()
        {
            var dataPedido = DateTime.Today;
            var dataEntregaDesejada = DateTime.Today.AddDays(1);
            var nomeProduto = "Quisque libero metus condimentum";
            var valorVenda = 999;
            TipoPagamento tipoPagamento = TipoPagamento.Mastercard;
            var nomeCliente = "Vestibulum suscipit nulla quis";
            var cidade = "Proin pretium leo ac";
            var estado = "In hac habitasse platea";

            var pedido = new Pedido(dataEntregaDesejada, nomeProduto, valorVenda, tipoPagamento, nomeCliente, cidade, estado);

            Assert.AreEqual(0, pedido.Id);
            Assert.AreEqual(dataEntregaDesejada, pedido.DataEntrega);
            Assert.AreEqual(dataPedido, pedido.DataPedido);
            Assert.AreEqual(nomeProduto, pedido.NomeProduto);
            Assert.AreEqual(valorVenda, pedido.ValorVenda);
            Assert.AreEqual(tipoPagamento, pedido.TipoPagamento);
            Assert.AreEqual(nomeCliente, pedido.NomeCliente);
            Assert.AreEqual(cidade, pedido.Cidade);
            Assert.AreEqual(estado, pedido.Estado);
            Assert.AreEqual(true, pedido.Urgente);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void CriarPedidoComDataDeEntregaInvalidaNoConstrutorParaCriarNovosPedidos()
        {
            var dataEntregaDesejada = DateTime.Today.AddDays(-3);
            var nomeProduto = "Quisque libero metus condimentum";
            var valorVenda = 999;
            TipoPagamento tipoPagamento = TipoPagamento.Mastercard;
            var nomeCliente = "Vestibulum suscipit nulla quis";
            var cidade = "Proin pretium leo ac";
            var estado = "In hac habitasse platea";

            new Pedido(dataEntregaDesejada, nomeProduto, valorVenda, tipoPagamento, nomeCliente, cidade, estado);
        }

        [TestMethod]
        public void CriarPedidoComConstrutorParaCriarPedidosRecuperadosDoRepositorio()
        {
            var id = 1;
            var dataPedido = DateTime.Today;
            var dataEntregaDesejada = DateTime.Today;
            var nomeProduto = "Quisque libero metus condimentum";
            var valorVenda = 999;
            TipoPagamento tipoPagamento = TipoPagamento.Mastercard;
            var nomeCliente = "Vestibulum suscipit nulla quis";
            var cidade = "Proin pretium leo ac";
            var estado = "In hac habitasse platea";
            var urgente = true;

            var pedido = new Pedido(id, nomeProduto, valorVenda, dataEntregaDesejada, dataPedido, tipoPagamento, nomeCliente, cidade, estado, urgente);

            Assert.AreEqual(id, pedido.Id);
            Assert.AreEqual(dataEntregaDesejada, pedido.DataEntrega);
            Assert.AreEqual(dataPedido, pedido.DataPedido);
            Assert.AreEqual(nomeProduto, pedido.NomeProduto);
            Assert.AreEqual(valorVenda, pedido.ValorVenda);
            Assert.AreEqual(tipoPagamento, pedido.TipoPagamento);
            Assert.AreEqual(nomeCliente, pedido.NomeCliente);
            Assert.AreEqual(cidade, pedido.Cidade);
            Assert.AreEqual(estado, pedido.Estado);
            Assert.AreEqual(urgente, pedido.Urgente);
        }

        [TestMethod]
        public void MetodoToStringDeveRetornarUmaStringSeparandoOsValoresComPontoEVirgurla()
        {
            var dataPedido = DateTime.Today;
            var dataEntregaDesejada = DateTime.Today.AddDays(8);
            var nomeProduto = "Quisque libero metus condimentum";
            var valorVenda = 999;
            TipoPagamento tipoPagamento = TipoPagamento.Mastercard;
            var nomeCliente = "Vestibulum suscipit nulla quis";
            var cidade = "Proin pretium leo ac";
            var estado = "In hac habitasse platea";

            var pedido = new Pedido(dataEntregaDesejada, nomeProduto, valorVenda, tipoPagamento, nomeCliente, cidade, estado);

            var pedidoToString = string.Format("\n##ID##;{0};{1};{2};{3};{4};{5};{6};{7};{8}", dataPedido, dataEntregaDesejada, nomeProduto, valorVenda, tipoPagamento, nomeCliente, cidade, estado, false);

            Assert.AreEqual(pedidoToString, pedido.ToString());
        }
    }
}

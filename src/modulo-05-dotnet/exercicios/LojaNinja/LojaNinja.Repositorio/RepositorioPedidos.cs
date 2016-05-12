using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace LojaNinja.Repositorio
{
    public class RepositorioPedidos
    {
        private const string PATH_ARQUIVO = @"C:\Users\erico.loewe\Documents\crescer-2016-1\src\modulo-05-dotnet\exercicios\LojaNinja\LojaNinja\App_Data\Pedidos.txt";

        public List<Pedido> ObterPedidos()
        {
            var linhasArquivo = File.ReadAllLines(PATH_ARQUIVO).ToList();

            return ConverteLinhasEmPedidos(linhasArquivo);
        }

        public Pedido ObterPedidoPorId(int id)
        {
            return DeLinhaStringParaPedido(
                        File.ReadAllLines(PATH_ARQUIVO)
                                .ToList()
                                    .FirstOrDefault(x => Convert.ToInt32(x.Split(';')[0]) == id));
        }

        public void IncluirPedido(Pedido pedido)
        {
            throw new NotImplementedException();
        }

        public void AtualizarPedido(Pedido pedido)
        {
            throw new NotImplementedException();
        }

        public void ExcluirPedido(int id)
        {
            throw new NotImplementedException();
        }

        private List<Pedido> ConverteLinhasEmPedidos(List<string> linhasArquivo)
        {
            //Remove linha do cabeçalho
            linhasArquivo.RemoveAt(0);

            //Retorna lista de produtos
            return linhasArquivo.Select(linha => DeLinhaStringParaPedido(linha)).ToList();
        }

        private Pedido DeLinhaStringParaPedido(string linha)
        {
            var id = Convert.ToInt32(linha.Split(';')[0]);
            var dataPedido = Convert.ToDateTime(linha.Split(';')[1]);
            var dataEntregaDesejada = Convert.ToDateTime(linha.Split(';')[2]);
            var nomeProduto = linha.Split(';')[3];
            var valorVenda = Convert.ToDecimal(linha.Split(';')[4]);
            TipoPagamento tipoPagamento;
            Enum.TryParse(linha.Split(';')[5], out tipoPagamento);
            var nomeCliente = linha.Split(';')[6];
            var cidade = linha.Split(';')[7];
            var estado = linha.Split(';')[8];
            var urgente = Convert.ToBoolean(linha.Split(';')[9]);

            return new Pedido(id, nomeProduto, valorVenda, dataEntregaDesejada, dataPedido, tipoPagamento, nomeCliente, cidade, estado, urgente);
        }
    }
}

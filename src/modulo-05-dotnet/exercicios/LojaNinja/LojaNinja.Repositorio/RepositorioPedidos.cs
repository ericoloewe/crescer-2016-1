using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;

namespace LojaNinja.Repositorio
{
    public class RepositorioPedidos
    {
        private readonly List<Pedido> _listaDePedidos = new List<Pedido>();
        private const string PATH_ARQUIVO = @"B:\Erico\Documents\Repos\crescer-2016-1\src\modulo-05-dotnet\exercicios\LojaNinja\LojaNinja\App_Data\Pedidos.txt";
        //private const string PATH_ARQUIVO = @"C:\Users\erico.loewe\Documents\crescer-2016-1\src\modulo-05-dotnet\exercicios\LojaNinja\LojaNinja\App_Data\Pedidos.txt";

        public RepositorioPedidos()
        {
            _listaDePedidos.AddRange(PegarPedidosDoArquivo());
        }

        public List<Pedido> ObterPedidos()
        {
            return _listaDePedidos;
        }

        public Pedido ObterPedidoPorId(int id)
        {
            return _listaDePedidos.FirstOrDefault(p => p.Id == id);
        }

        public void IncluirPedido(Pedido pedido)
        {
            _listaDePedidos.Add(pedido);
            AddPedidoAoArquivo(pedido);
        }

        public void AtualizarPedido(Pedido pedido)
        {
            throw new NotImplementedException();
        }

        public void ExcluirPedido(int id)
        {
            throw new NotImplementedException();
        }

        private void AddPedidoAoArquivo(Pedido pedido)
        {
            using (var sw = new StreamWriter(PATH_ARQUIVO, true))
            {
                string id = string.Format("{0}", _listaDePedidos.Max(p => p.Id) + 1);
                sw.Write(pedido.ToString().Replace("##ID##", id));
            }
        }

        private List<Pedido> PegarPedidosDoArquivo()
        {
            var linhasArquivo = File.ReadAllLines(PATH_ARQUIVO).ToList();

            //Remove linha do cabeçalho
            linhasArquivo.RemoveAt(0);

            //Retorna lista de produtos
            return linhasArquivo.Select(ConverteDeLinhaStringParaPedido).ToList();
        }

        private Pedido ConverteDeLinhaStringParaPedido(string linha)
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

using System;

namespace LojaNinja.Dominio
{
    public class Pedido
    {
        /// <summary>
        /// Construtor utilizado para montar pedidos novos
        /// </summary>
        public Pedido(DateTime dataEntregaDesejada, string nomeProduto, decimal valor, TipoPagamento tipoPagamento, string nomeCliente, string cidade, string estado, int id = 0)
        {
            Id = id;
            NomeProduto = nomeProduto;
            ValorVenda = valor;
            TipoPagamento = tipoPagamento;
            NomeCliente = nomeCliente;
            Cidade = cidade;
            Estado = estado;

            // Uma data de pedido não é alterada!
            if (id == 0) //DateTime.Now contaria as horas, minutos e segundos, isso inviabliziaria algumas validações a seguir
                DataPedido = DateTime.Today;

            DataEntrega = dataEntregaDesejada;
            var diasRestantesParaConcluirEntrega = dataEntregaDesejada.Subtract(DataPedido).TotalDays;
            ValidaPossibilidadeEntrega(diasRestantesParaConcluirEntrega);
            DefineUrgenciaDoPedido(diasRestantesParaConcluirEntrega);
        }

        /// <summary>
        /// Construtor utilizado para montar pedidos recuperados do repositório
        /// </summary>
        public Pedido(int id, string nomeProduto, decimal valorVenda, DateTime dataEntrega, DateTime dataPedido, TipoPagamento tipoPagamento, string nomeCliente, string cidade, string estado, bool urgente)
        {
            Id = id;
            NomeProduto = nomeProduto;
            ValorVenda = valorVenda;
            DataEntrega = dataEntrega;
            DataPedido = dataPedido;
            TipoPagamento = tipoPagamento;
            NomeCliente = nomeCliente;
            Cidade = cidade;
            Estado = estado;
            Urgente = urgente;
        }

        public int Id { get; private set; }
        public string NomeProduto { get; private set; }
        public decimal ValorVenda { get; private set; }
        public DateTime DataEntrega { get; private set; }
        public DateTime DataPedido { get; private set; }
        public TipoPagamento TipoPagamento { get; private set; }
        public string NomeCliente { get; private set; }
        public string Cidade { get; private set; }
        public string Estado { get; private set; }
        public bool Urgente { get; private set; }

        private void ValidaPossibilidadeEntrega(double diasRestantesParaConcluirEntrega)
        {
            if (diasRestantesParaConcluirEntrega < 1)
                throw new ArgumentException("A data de entrega desejada deve ser no mínimo 1 dia maior do que a data atual.");
        }

        private void DefineUrgenciaDoPedido(double diasRestantesParaConcluirEntrega)
        {
            Urgente = diasRestantesParaConcluirEntrega < 7;
        }

        public bool Contem(string str)
        {
            string strCompleta = string.Format("{0};{1};{2};{3:c};{4};{5};{6};{7};{8};{9}", DataPedido.ToShortDateString(), DataEntrega.ToShortDateString(), NomeProduto, ValorVenda, TipoPagamento, NomeCliente, Cidade, Estado, Urgente, Id);
            return strCompleta.Contains(str) ||
                    strCompleta.IndexOf(str, StringComparison.InvariantCultureIgnoreCase) >= 0;
        }

        public override string ToString()
        {
            return string.Format("\n##ID##;{0};{1};{2};{3};{4};{5};{6};{7};{8}", DataPedido, DataEntrega, NomeProduto, ValorVenda, TipoPagamento, NomeCliente, Cidade, Estado, Urgente);
        }
    }
}

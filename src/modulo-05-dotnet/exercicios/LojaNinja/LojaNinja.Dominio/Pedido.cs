using System;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;

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
            DataEntrega = dataEntregaDesejada;
            NomeProduto = nomeProduto;
            ValorVenda = valor;
            TipoPagamento = tipoPagamento;
            NomeCliente = nomeCliente;
            Cidade = cidade;
            Estado = estado;

            //DateTime.Now contaria as horas, minutos e segundos, isso inviabliziaria algumas validações a seguir
            DataPedido = DateTime.Today;
            
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

        [Required]
        public int Id { get; private set; }

        [Required(ErrorMessage = "Nome do produto não informado!")]
        [DisplayName("Nome do produto")]
        public string NomeProduto { get; private set; }

        [Required(ErrorMessage = "Valor do produto não informado!")]
        [DisplayName("Valor do produto")]
        public decimal ValorVenda { get; private set; }

        [Required(ErrorMessage = "Selecione a data de entrega desejada!")]
        [DisplayName("Data de entrega desejada")]
        public DateTime DataEntrega { get; private set; }

        [Required(ErrorMessage = "É obrigatorio uma data de pedido!")]
        [DisplayName("Data de pedido desejada")]
        public DateTime DataPedido { get; private set; }

        [Required(ErrorMessage = "Forma de pagamento não informada!")]
        [EnumDataType(typeof(TipoPagamento))]
        [DisplayName("Forma de pagamento")]
        public TipoPagamento TipoPagamento { get; private set; }

        [Required(ErrorMessage = "Nome do cliente não informado!")]
        [DisplayName("Nome do cliente")]
        public string NomeCliente { get; private set; }

        [Required(ErrorMessage = "Cidade não informada!")]
        public string Cidade { get; private set; }

        [Required(ErrorMessage = "Estado não informado!")]
        public string Estado { get; private set; }

        [Required(ErrorMessage = "Urgencia não informada!")]
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

        public override string ToString()
        {
            return string.Format("\n##ID##;{0};{1};{2};{3};{4};{5};{6};{7};{8}", DataPedido, DataEntrega, NomeProduto, ValorVenda, TipoPagamento, NomeCliente, Cidade, Estado, Urgente);
        }
    }
}

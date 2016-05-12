using System;
using System.ComponentModel.DataAnnotations;

namespace LojaNinja.Dominio
{
    public class Pedido
    {
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
        public string NomeProduto { get; private set; }

        [Required(ErrorMessage = "Valor do produto não informado!")]
        public decimal ValorVenda { get; private set; }

        [Required(ErrorMessage = "Selecione a data de entrega desejada!")]
        public DateTime DataEntrega { get; private set; }

        [Required(ErrorMessage = "É obrigatorio uma data de pedido!")]
        public DateTime DataPedido { get; private set; }

        [Required(ErrorMessage = "Forma de pagamento não informada!")]
        [EnumDataType(typeof(TipoPagamento))]
        public TipoPagamento TipoPagamento { get; private set; }

        [Required(ErrorMessage = "Nome do cliente não informado!")]
        public string NomeCliente { get; private set; }

        [Required(ErrorMessage = "Cidade não informada!")]
        public string Cidade { get; private set; }

        [Required(ErrorMessage = "Estado não informado!")]
        public string Estado { get; private set; }

        [Required(ErrorMessage = "Urgencia não informada!")]
        public bool Urgente { get; private set; }

        public override string ToString()
        {
            return string.Format("{0};{1};{2};{3};{4};{5};{6};{7};{8};{9}", Id, DataPedido, DataEntrega, NomeProduto, ValorVenda, TipoPagamento, NomeCliente, Cidade, Estado, Urgente);
        }
    }
}

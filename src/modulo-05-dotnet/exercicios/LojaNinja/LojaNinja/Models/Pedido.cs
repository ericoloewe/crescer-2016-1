using System;
using System.ComponentModel;

namespace LojaNinja.Models
{
    public class Pedido
    {
        [DisplayName("Nome do produto")]
        public string NomeProduto { get; set; }

        [DisplayName("Valor do produto")]
        public double ValorVenda { get; set; }

        [DisplayName("Data de entrega desejada")]
        public DateTime DataEntrega { get; set; }

        [DisplayName("Forma de pagamento")]
        public TipoPagamento TipoPagamento { get; set; }

        [DisplayName("Nome do cliente")]
        public string NomeCliente { get; set; }
        public string Cidade { get; set; }
        public string Estado { get; set; }
    }
}
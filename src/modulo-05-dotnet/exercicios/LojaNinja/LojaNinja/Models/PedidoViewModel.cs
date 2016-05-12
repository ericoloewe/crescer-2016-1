using LojaNinja.Dominio;
using System;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;

namespace LojaNinja.MVC.Models
{
    public class PedidoViewModel
    {
        [Required(ErrorMessage = "Nome do produto não informado!")]
        [DisplayName("Nome do produto")]        
        public string NomeProduto { get; set; }

        [Required(ErrorMessage = "Valor do produto não informado!")]
        [DisplayName("Valor do produto")]
        public double ValorVenda { get; set; }

        [Required(ErrorMessage = "Selecione a data de entrega desejada!")]
        [DisplayName("Data de entrega desejada")]
        public DateTime DataEntrega { get; set; }

        [Required(ErrorMessage = "Forma de pagamento não informada!")]
        [DisplayName("Forma de pagamento")]
        [EnumDataType(typeof(TipoPagamento))]
        public TipoPagamento TipoPagamento { get; set; }

        [Required(ErrorMessage = "Nome do cliente não informado!")]
        [DisplayName("Nome do cliente")]
        public string NomeCliente { get; set; }

        public string Cidade { get; set; }

        public string Estado { get; set; }
    }
}
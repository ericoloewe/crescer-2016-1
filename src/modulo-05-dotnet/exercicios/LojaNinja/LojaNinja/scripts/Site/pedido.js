"use strict";

var Pedido = function (id, nomeProduto, valorVenda, dataEntrega, dataPedido, tipoPagamento, nomeCliente, cidade, estado, urgente) {
    this.Id = id;
    this.NomeProduto = nomeProduto;
    this.ValorVenda = valorVenda;
    this.DataEntrega = dataEntrega;
    this.DataPedido = dataPedido;
    this.TipoPagamento = tipoPagamento;
    this.NomeCliente = nomeCliente;
    this.Cidade = cidade;
    this.Estado = estado;
    this.Urgente = urgente;
}

Pedido.prototype.toString = function () {
    return this.Id + ";" + this.NomeProduto + ";" + this.ValorVenda + ";" + this.DataEntrega + ";" + this.DataPedido + ";" + this.TipoPagamento + ";" + this.NomeCliente + ";" + this.Cidade + ";" + this.Estado + ";" + this.Urgente;
};

Pedido.prototype.contains = function(str) {
    return this.toString().contains(str);
};

Pedido.prototype.paraTrTabela = function() {
    return $("<tr>").append($("<td>").text(this.NomeProduto))
                        .append($("<td>").text(this.ValorVenda))
                        .append($("<td>").text(this.DataEntrega))
                        .append($("<td>").text(this.DataPedido))
                        .append($("<td>").text(this.NomeCliente))
                        .append($("<td>").text(this.Estado))
                        .append($("<td>").text(this.Cidade))
                        .append($("<td>").text(this.DataEntrega));
};

Array.prototype.paraTrsTabela = function() {
    return this.map(function(pedido) {
        return pedido.paraTrTabela();
    });
};

String.prototype.contains = function(substring) {
    return this.indexOf(substring) !== -1 ||
            this.toLocaleUpperCase().indexOf(substring) !== -1 ||
            this.toLocaleLowerCase().indexOf(substring) !== -1;
};

(function () {
    window.App = window.App || {};

    App.CadastroDePedidos = {
        iniciar: function () {
            this.buscarElementos();
            this.vincularEventos();
            this.arrumarValidators();
        },

        buscarElementos: function () {
            this.$form = $(".cadastro-de-pedidos");
        },

        vincularEventos: function () {
            try {
                this.$form.find("#DataEntrega").datepicker({
                    format: "dd/mm/yyyy"
                });
            } catch(error)
            {
                console.log(error.message);
            }
        },

        arrumarValidators: function () {
            try {
                $.validator.methods.number = function (value, element) {
                    var regex = /^(\d*)(\,\d{1,2})?$/; //99999,99
                    return this.optional(element) || regex.test(value);
                }
                $.validator.methods.date = function (value, element) {
                    var date = new Date(value.replace(/(\d{2})[/](\d{2})[/](\d{4})/, "$2/$1/$3")); //31/12/2015
                    return this.optional(element) || !/Invalid|NaN/.test(date.toString());
                }
            } catch (error) {
                console.log(error.message);
            }
        }
    };

    App.ListagemDePedidos = {
        listaDePedidos: new Array(),

        iniciar: function () {
            this.buscarElementos();
            this.vincularEventos();
            this.pegarPedidosDaTabela();
        },

        buscarElementos: function () {
            this.$formularioDeBusca = $("[busca-pedidos]");
            this.$tabelaPedidos = $(".tabela-de-pedidos");
        },

        vincularEventos: function () {
            var self = this;
            this.$formularioDeBusca.find("input").keyup(function () {
                var value = $(this).val();
                self.preencherTabela(self.listaDePedidos.filter(function(p) {
                    return p.contains(value);
                }));
            });
        },

        pegarPedidosDaTabela: function () {
            var lista = Array();
            var $pedidos = this.$tabelaPedidos.find("tr");
            $pedidos.splice(0, 1);

            $pedidos.each(function (i, p) {
                var pedido = p.querySelectorAll("td");
                lista.push(new Pedido(p.dataset.pedidoId, pedido[0].innerHTML, pedido[1].innerHTML, pedido[2].innerHTML, pedido[3].innerHTML, null, pedido[4].innerHTML, pedido[5].innerHTML, pedido[6].innerHTML, pedido[7].innerHTML.contains("up") ? true : false));
            });

            this.listaDePedidos = lista;
        },

        preencherTabela: function(pedidos) {
            //this.$tabelaPedidos.find("tr td")
            //                    .parent()
            //                    .html(pedidos.paraTrsTabela());
        }
    };

    App.CadastroDePedidos.iniciar();
    App.ListagemDePedidos.iniciar();
})();
"use strict";

(function() {
    window.App = window.App || {};

    App.CadastroDePedidos = {
        iniciar: function() {
            this.buscarElementos();
            this.vincularEventos();
            this.arrumarValidators();
        },

        buscarElementos: function() {
            this.$form = $(".cadastro-de-pedidos");
        },

        vincularEventos: function() {
            this.$form.find("#DataEntrega").datepicker({
                format: "dd/mm/yyyy"
            });
        },

        arrumarValidators: function() {
            $.validator.methods.number = function (value, element) {
                var regex = /^(\d*)(\,\d{1,2})?$/; //99999,99
                return this.optional(element) || regex.test(value);
            }
            $.validator.methods.date = function (value, element) {
                var date = new Date(value.replace(/(\d{2})[/](\d{2})[/](\d{4})/, "$2/$1/$3")); //31/12/2015
                return this.optional(element) || !/Invalid|NaN/.test(date.toString());
            }

        }
    };

    App.CadastroDePedidos.iniciar();
})();
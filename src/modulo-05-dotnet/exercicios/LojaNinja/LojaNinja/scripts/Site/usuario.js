"use strict";

(function () {
    window.App = window.App || {};

    App.CadastroDeUsuario = {
        iniciar: function () {
            this.buscarElementos();
            this.vincularEventos();
            this.arrumarValidators();
        },

        buscarElementos: function () {
            this.$form = $(".cadastro-de-usuario");
        },

        vincularEventos: function () {
        },

        arrumarValidators: function () {
        }
    };

    App.CadastroDeUsuario.iniciar();
})();
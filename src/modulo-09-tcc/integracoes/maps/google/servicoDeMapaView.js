"use strict";
(function () {
    window.App = window.App || {};

    App.ServicoDeMapaView = {
        gMap: null,
        servico: null,

        iniciar: function() {
            this.buscarElementos();
            this.vincularEventos();
            this.servico = new ServicoDeMapa(this);
            this.instanciarMapa();
        },

        buscarElementos: function () {
            this.$mapa = $("#mapa");
        },

        vincularEventos: function () {
            var self = this;
        },

        instanciarMapa: function () {
            this.gMap = this.servico.novoMapa(this.$mapa);
        },

        definirLocalizacao: function(localizacao) {
            this.gMap.setCenter(localizacao);
        },

        definirLocalizacaoAtual: function() {
            console.log(this.servico.localizacaoAtual());
            this.definirLocalizacao(this.servico.localizacaoAtual());
        }
    };

    App.ServicoDeMapaView.iniciar();
})();
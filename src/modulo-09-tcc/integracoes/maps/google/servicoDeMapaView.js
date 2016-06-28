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
            this.$btnOrigem = $("#buscar-origem-btn");
            this.$inputOrigem = $("#buscar-origem");
            this.$listaOrigens = $("#buscar-origem-list");
            this.$btnDestino = $("#buscar-destino-btn");
            this.$inputDestino = $("#buscar-destino");
            this.$listaDestinos = $("#buscar-destino-list");
            this.$rotas = $("#rotas");
        },

        atualizarElementos: function() {
            this.$listaOrigens = $("#buscar-origem-list");
            this.$btnOrigem = $("#buscar-origem-btn");
            this.$listaDestinos = $("#buscar-destino-list");
            this.$btnDestino = $("#buscar-destino-btn");
            this.$rotas = $("#rotas");

            this.$listaDestinos.find("[data-destino-location]").unbind("click");
            this.$btnDestino.unbind("click");
            this.$listaOrigens.find("[data-destino-location]").unbind("click");
            this.$btnOrigem.unbind("click");
            this.$rotas.unbind("click");

            this.vincularEventos();
        },

        vincularEventos: function () {
            var self = this;

            this.$rotas.click(function() {
                self.criarRota(self.$listaOrigens.find(">.active").data("origem-location-id"), self.$btnDestino.find(">.active").data("origem-location-id"));
            });

            this.$btnOrigem.click(function() {
                self.servico.buscarLocalizacao(self.$inputOrigem.val())
                .done(function(data) {
                    console.log(data);
                    self.apresentarOrigens(data.results);
                });
            });

            this.$listaOrigens.find("[data-origem-location]").click(function() {
                self.definirLocalizacao($(this).data("origem-location"));
                self.$listaOrigens.find("[data-origem-location]").removeClass("active");
                $(this).addClass("active");
            });

            this.$btnDestino.click(function() {
                self.servico.buscarLocalizacao(self.$inputDestino.val())
                .done(function(data) {
                    console.log(data);
                    self.apresentarDestinos(data.results);
                });
            });

            this.$listaDestinos.find("[data-destino-location]").click(function() {
                self.definirLocalizacao($(this).data("destino-location"));
                self.$listaOrigens.find("[data-destino-location]").removeClass("active");
                $(this).addClass("active");
            });
        },

        apresentarDestinos: function(enderecos) {
            var self = this;

            this.$listaDestinos
            .append(
                enderecos
                .filter(function(endereco) {
                    return self.$listaDestinos.find("li").size() === 0 || self.$listaDestinos.find("li[data-destino-location-id='"+ endereco.place_id +"']").size() === 0;
                })
                .map(function(endereco) {
                    return $("<button>")
                                .addClass("list-group-item aberto")
                                .attr("data-destino-location", JSON.stringify(endereco.geometry.location))
                                .attr("data-destino-location-id", endereco.place_id)
                                .text(endereco.formatted_address);
                })
            );
            this.atualizarElementos();
        },

        apresentarOrigens: function(enderecos) {
            var self = this;

            this.$listaOrigens
            .append(
                enderecos
                .filter(function(endereco) {
                    return self.$listaOrigens.find("li").size() === 0 || self.$listaOrigens.find("li[data-origem-location-id='"+ endereco.place_id +"']").size() === 0;
                })
                .map(function(endereco) {
                    return $("<button>")
                                .addClass("list-group-item aberto")
                                .attr("data-origem-location", JSON.stringify(endereco.geometry.location))
                                .attr("data-origem-location-id", endereco.place_id)
                                .text(endereco.formatted_address);
                })
            );
            this.atualizarElementos();
        },

        instanciarMapa: function () {
            this.gMap = this.servico.novoMapa(this.$mapa);
        },

        definirLocalizacao: function(localizacao) {
            this.gMap.setCenter(localizacao);
        },

        criarRota: function(origem, destino) {
            this.servico.criarRota(origem, destino);
        },

        definirLocalizacaoAtual: function() {
            console.log(this.servico.localizacaoAtual());
            this.definirLocalizacao(this.servico.localizacaoAtual());
        }
    };

    App.ServicoDeMapaView.iniciar();
})();
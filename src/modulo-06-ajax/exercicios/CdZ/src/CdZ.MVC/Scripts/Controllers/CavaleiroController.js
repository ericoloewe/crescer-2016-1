﻿"use strict";
(function() {
    window.App = window.App || {};

    App.ListaDeCavaleirosController = {
        cavaleiros: Array(),

        atualizarCavaleiros: function () {
            var self = this;

            App.ServicoDeCavaleiros
                .buscarCavaleiros()
                .done(function (response) {
                    self.addCavaleiroNovos(response.data);
                })
                .fail(function (response) {
                    console.error(":(");
                    App.Mensagem.erro(response.Message);
                    console.log(response);
                });
        },

        addCavaleiroNovos: function (cavaleiros) {
            var self = this;
            var ehPrimeiraVezQueEstaRodando = this.cavaleiros.length === 0;
            var cavaleirosAAdicionar = cavaleiros.filter(function(cavaleiroNovo) {
                return !self.cavaleiros.some(function(cavaleiro) {
                    return cavaleiro.Id === cavaleiroNovo.Id;
                });
            });

            cavaleirosAAdicionar.forEach(function (cavaleiro) {
                self.addCavaleiro(cavaleiro);
            });

            if (cavaleirosAAdicionar.length > 0 && !ehPrimeiraVezQueEstaRodando)
                App.ServicoDeNotificacao.notificar(String.format("{0} novos cavaleiros foram adicionados!", cavaleirosAAdicionar.length), "Novo Cavaleiro", "http://fdata.over-blog.com/1/92/30/28/avatar-blog-1040706665-tmpphpTQzPov.jpg");
        },

        addCavaleiro: function (cavaleiro) {
            this.cavaleiros.push(new Cavaleiro(cavaleiro.Id, cavaleiro.Nome, cavaleiro.AlturaCm, cavaleiro.Signo, cavaleiro.TipoSanguineo, cavaleiro.DataNascimento, cavaleiro.Golpes, cavaleiro.LocalNascimento, cavaleiro.LocalTreinamento, cavaleiro.Imagens));
            App.ListaDeCavaleirosView.criarDivCavaleiro(cavaleiro);
        },

        deletarCavaleiro: function (idCavaleiro) {
            //TODO:
        },

        criarCavaleiro: function(cavaleiro) {
            App.ServicoDeCavaleiros
                .criarCavaleiro(cavaleiro)
                .fail(function (response) {
                    console.log(response);
                    App.Mensagem.erro(response.Message);
                });
        }
    };
})();
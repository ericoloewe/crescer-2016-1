"use strict";
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
                    console.log("...");
                })
                .fail(function (response) {
                    console.error(":(");
                    App.Mensagem.erro(response.Message);
                    console.log(response);
                });
        },

        addCavaleiroNovos: function (cavaleiros) {
            var self = this;

            cavaleiros.filter(function(cavaleiroNovo) {
                return !self.cavaleiros.some(function (cavaleiro) {
                    return cavaleiro.Id === cavaleiroNovo.Id;
                });
            }).forEach(function(cavaleiro) {
                self.addCavaleiro(cavaleiro);
            });
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
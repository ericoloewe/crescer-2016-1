"use strict";
(function() {
    window.App = window.App || {};

    App.CavaleiroController = {
        cavaleiros: Array(),
        paginaAtual: 0,

        atualizarCavaleiros: function () {
            var self = this;

            App.ServicoDeCavaleiros
                .buscarCavaleiros(this.paginaAtual)
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
            var cavaleiroAAdicionar = new Cavaleiro(cavaleiro.Id, cavaleiro.Nome, cavaleiro.AlturaCm, cavaleiro.PesoLb, cavaleiro.Signo, cavaleiro.TipoSanguineo, undefined, cavaleiro.Golpes, cavaleiro.LocalNascimento, cavaleiro.LocalTreinamento, cavaleiro.Imagens);
            cavaleiroAAdicionar.setDataNascimentoDoFormatoServidor(cavaleiro.DataNascimento);
            this.cavaleiros.push(cavaleiroAAdicionar);
            App.ListaDeCavaleirosView.criarDivCavaleiro(cavaleiroAAdicionar);
        },

        deletarCavaleiro: function (idCavaleiro) {
            App.ServicoDeCavaleiros
                .deletarCavaleiros(idCavaleiro)
                .done(function (response) {
                    App.ListaDeCavaleirosView.removerCavaleiroDaTela(idCavaleiro);
                })
                .fail(function (response) {
                    console.log(response);
                    App.Mensagem.erro(response.Message);
                });
        },

        criarCavaleiro: function(cavaleiro) {
            App.ServicoDeCavaleiros
                .criarCavaleiro(cavaleiro)
                .fail(function (response) {
                    console.log(response);
                    App.Mensagem.erro(response.Message);
                });
        },

        buscarCavaleiroPorId: function (cavaleiroId) {
            return this.cavaleiros.filter(function (cavaleiro) {
                return cavaleiro.Id === cavaleiroId;
            })[0];
        }
    };
})();
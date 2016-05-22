"use strict";
(function() {
    window.App = window.App || {};

    App.ListaDeCavaleirosView = {
        iniciar: function() {
            var self = this;
            console.log("ok");
            this.atualizarLista();
            this.criarListaDeCavaleiros();
            this.buscarElementos();
            this.vincularEventos();

            setInterval(this.atualizarLista, 5000);
        },

        buscarElementos() {
            this.$listaDeCavaleiros = $(".lista-de-cavaleiros");
            this.$btnCriarAleatorio = $("#btnCriarAleatorio");
        },

        criarListaDeCavaleiros: function() {
            var $listaDeImagens = $("<div>").addClass("lista-de-cavaleiros").addClass("row");
            $("body > .container").append($listaDeImagens);
        },

        vincularEventos: function() {
            var self = this;

            this.$btnCriarAleatorio.click(function() {
                App.ListaDeCavaleirosController.criarCavaleiro({
                    Nome: "Xiru " + new Date().getTime(),
                    AlturaCm: 187,
                    Signo: 7,
                    TipoSanguineo: 1,
                    DataNascimento: new Date(),
                    Golpes: ["Cólera do Dragão", "Cólera dos 100 dragões"],
                    LocalNascimento: {
                        Texto: "Beijing"
                    },
                    LocalTreinamento: {
                        Texto: "5 picos de rosan"
                    },
                    Imagens: [
                        {
                            Url: "http://images.uncyc.org/pt/3/37/Shiryumestrepokemon.jpg",
                            IsThumb: true
                        }, {
                            Url: "http://images.uncyc.org/pt/thumb/5/52/Shyryugyarados.jpg/160px-Shyryugyarados.jpg",
                            IsThumb: false
                        }
                    ]
                });
            });
        },

        atualizarLista: function() {
            console.log("Atualizando...");
            App.ListaDeCavaleirosController.atualizarCavaleiros();
        },

        criarDivCavaleiro: function(cavaleiro) {
            var self = this;

            if (cavaleiro.Imagens.length !== 0) {
                cavaleiro.Imagens.forEach(function(imagem, i) {
                    self.$listaDeCavaleiros.append(
                        $("<div>").attr("data-id-cavaleiro", cavaleiro.Id)
                        .addClass("col-sm-2")
                        .addClass("cavaleiro")
                        .prepend($("<a>").addClass("glyphicon")
                            .addClass("glyphicon-remove")
                            .attr("deletar-cavaleiro", "")
                            .attr("href", ""))
                        .append($("<img>").attr("alt", cavaleiro.Nome)
                            .attr("src", imagem.Url).addClass("img-thumbnail"))
                    );
                });
            } else
                self.$listaDeCavaleiros.append(
                    $("<div>").attr("data-id-cavaleiro", cavaleiro.Id)
                    .addClass("col-sm-2")
                    .addClass("cavaleiro").prepend($("<h4>").text(cavaleiro.Nome)));
        }
    };

    App.ListaDeCavaleirosView.iniciar();
})();
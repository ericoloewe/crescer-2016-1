"use strict";
(function() {
    window.App = window.App || {};

    App.ListaDeCavaleirosView = {
        iniciar: function() {
            this.atualizarLista();
            this.criarListaDeCavaleiros();
            this.buscarElementos();
            this.vincularEventos();

            setInterval(this.atualizarLista, 5000);
        },

        buscarElementos() {
            this.$listaDeCavaleiros = $(".lista-de-cavaleiros");
        },

        criarListaDeCavaleiros: function() {
            var $listaDeImagens = $("<div>").addClass("lista-de-cavaleiros").addClass("row");
            $("body > .container").append($listaDeImagens);
        },

        vincularEventos: function() {
            var self = this;
        },

        atualizarLista: function() {
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

    App.CadastroDeCavaleirosView = {
        iniciar: function() {
            this.buscarElementos();
            this.vincularEventos();
        },

        buscarElementos() {
            this.$btnCriarAleatorio = $("#btnCriarAleatorio");
            this.$btnCriar = $("#btnCriar");
            this.$btnSubmit = $("[btn-submit]");
            this.$modalCavaleiro = $("#modal-cavaleiro");
            this.$form = this.$modalCavaleiro.find("[form-cavaleiro]");
        },

        vincularEventos: function () {
            var self = this;
            this.$btnCriarAleatorio.click(function () {
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

            this.$modalCavaleiro.modal({
                show: false
            });

            this.$modalCavaleiro.on("show.bs.modal", function (event) {
                var title = $(event.relatedTarget).data("form-title") !== undefined ? $(event.relatedTarget).data("form-title") : "Editar cavaleiro";

                $(this).find(".modal-title").text(title);
            });

            this.$btnSubmit.click(function (e) {
                var cavaleiro = App.Converte.doFormParaUmCavaleiro(self.$form);
                console.log(cavaleiro);
                App.ListaDeCavaleirosController.criarCavaleiro(cavaleiro);

                return e.preventDefault();
            });

            this.$form.find(".add-golpe").click(function (e) {
                $(".golpes").prepend(
                    $("<div>").addClass("col-sm-4")
                                .prepend(
                                    $("<input>").attr("type", "text")
                                                    .addClass("form-control")
                                                    .attr("name", "golpes[]")
                                )
                );

                return e.preventDefault();
            });

            this.$form.find(".add-imagem").click(function (e) {
                var $inputText = $("<div>").addClass("col-sm-8");
                var $inputCheck = $("<div>").addClass("col-sm-4");
                $inputText.prepend(
                    $("<input>").attr("type", "text")
                                    .addClass("form-control")
                                    .attr("name", "urls[]")
                );

                $inputCheck.prepend(
                    $("<label>").prepend("É thumbnail?").prepend(
                            $("<input>").attr("type", "checkbox").attr("name", "isThumb[]")
                    )
                );

                $(".imagens").prepend($("<div>")
                                .addClass("imagem")
                                .addClass("col-sm-6")
                                .prepend($inputCheck)
                                .prepend($inputText)
                );

                return e.preventDefault();
            });
        }
    };

    App.ListaDeCavaleirosView.iniciar();
    App.CadastroDeCavaleirosView.iniciar();
})();
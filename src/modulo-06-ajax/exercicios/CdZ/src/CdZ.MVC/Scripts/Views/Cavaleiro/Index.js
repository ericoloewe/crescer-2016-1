"use strict";
(function() {
    window.App = window.App || {};

    App.ListaDeCavaleirosView = {
        iniciar: function () {
            var self = this;
            this.atualizarLista();
            this.criarListaDeCavaleiros();
            this.buscarElementos();
            this.vincularEventos();

            setInterval(function() {
                self.atualizarLista();
                self.vincularEventos();
            }, 5000);
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

            $(".cavaleiro").on("click", function () {
                console.log($(this).data("id-cavaleiro"));
                App.CadastroDeCavaleirosView
                    .$form
                        .prepend(
                            App.CadastroDeCavaleirosView
                                    .$form.find("#Id")
                                        .val($(this).data("id-cavaleiro"))
                                );
                App.CadastroDeCavaleirosView.$modalCavaleiro.modal("show");
            });
        },

        atualizarLista: function() {
            App.CavaleiroController.atualizarCavaleiros();
            this.$listaDeCavaleiros = $(".lista-de-cavaleiros");
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
                App.CavaleiroController.criarCavaleiro(new Cavaleiro(
                    undefined,
                    "Xiru " + new Date().getTime(),
                    1.80,
                    80,
                    7,
                    1,
                    new Date(),
                     ["Cólera do Dragão", "Cólera dos 100 dragões"],
                    new Local(undefined, "Beijing"),
                    new Local(undefined, "5 picos de rosan"),
                    [
                        new Image(undefined, "http://images.uncyc.org/pt/3/37/Shiryumestrepokemon.jpg", true),
                        new Image(undefined, "http://images.uncyc.org/pt/thumb/5/52/Shyryugyarados.jpg/160px-Shyryugyarados.jpg", false)
                    ]
                ));
            });

            this.$modalCavaleiro.modal({
                show: false
            });

            this.$modalCavaleiro.on("show.bs.modal", function (event) {
                var title = $(event.relatedTarget).data("form-title") !== undefined ? $(event.relatedTarget).data("form-title") : "Editar cavaleiro";

                $(this).find(".modal-title").text(title);
            });

            this.$btnSubmit.click(function (e) {
                var cavaleiro = self.doFormParaUmCavaleiro(self.$form);

                App.CavaleiroController.criarCavaleiro(cavaleiro);

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
        },

        doFormParaUmCavaleiro: function ($cavaleiro) {
            // Obtém o objeto nativo Form através da posição 0 no objeto jQuery e cria um FormData a partir dele
            var cavaleiroForm = new FormData($cavaleiro[0]);
            var imagens = new Array();
            $cavaleiro.find(".imagens .imagem").each(function () {
                imagens.push(new Imagem(
                                    undefined,
                                    $(this).find("input[type=text]").val(),
                                    $(this).find("input[type=checkbox]").is(":checked")
                                )
                            );
            });

            var cavaleiro =  new Cavaleiro(
                cavaleiroForm.get("id") === null ? undefined : cavaleiroForm.get("id"),
                cavaleiroForm.get("nome"),
                undefined,
                undefined,
                cavaleiroForm.get("signo"),
                cavaleiroForm.get("tipoSanguineo"),
                undefined,
                cavaleiroForm.getAll("golpes[]"),
                new Local(undefined, cavaleiroForm.get("localNascimento")),
                new Local(undefined, cavaleiroForm.get("localTreinamento")),
                imagens
            );

            cavaleiro.setDataNascimento(cavaleiroForm.get("dataNascimento"));
            cavaleiro.setAltura(cavaleiroForm.get("altura"));
            cavaleiro.setPeso(cavaleiroForm.get("peso"));

            return cavaleiro;
        }
    };

    App.ListaDeCavaleirosView.iniciar();
    App.CadastroDeCavaleirosView.iniciar();
})();
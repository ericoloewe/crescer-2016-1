"use strict";
(function() {
    window.App = window.App || {};

    App.ListaDeCavaleirosView = {
        iniciar: function () {
            var self = this;
            this.atualizarLista();
            this.buscarElementos();
            this.vincularEventos();

            setInterval(function() {
                self.atualizarLista();
                self.desvicularEventos();
                self.vincularEventos();
            }, 5000);
        },

        buscarElementos() {
            this.$listaDeCavaleiros = $(".lista-de-cavaleiros");
        },

        desvicularEventos: function() {
            this.$listaDeCavaleiros.find(".cavaleiro").find("[editar-cavaleiro], [deletar-cavaleiro], [detalhes-cavaleiro]").unbind("click");
        },

        vincularEventos: function() {
            var self = this;

            this.$listaDeCavaleiros.find(".cavaleiro").find("[editar-cavaleiro]").click(function () {
                App.CadastroDeCavaleirosView
                    .prepararEditarCavaleiro($(this).parent().parent().data("id-cavaleiro"));
            });

            this.$listaDeCavaleiros.find(".cavaleiro").find("[deletar-cavaleiro]").click(function () {
                if (confirm("Deseja realmente deletar esse cavaleiro"))
                    App.CavaleiroController.deletarCavaleiro($(this).parent().parent().data("id-cavaleiro"));
            });

            this.$listaDeCavaleiros.find(".cavaleiro").find("[detalhes-cavaleiro]").click(function () {
                // TODO:
            });

            $("[paginacao]").on("click", function () {
            });
        },

        atualizarLista: function() {
            App.CavaleiroController.atualizarCavaleiros();
            this.$listaDeCavaleiros = $(".lista-de-cavaleiros");
        },

        criarDivCavaleiro: function(cavaleiro) {
            this.$listaDeCavaleiros.find("tbody").append(
                $("<tr>").attr("data-id-cavaleiro", cavaleiro.Id)
                    .addClass("cavaleiro")
                    .append($("<td>").append(
                                $("<img>").attr("alt", cavaleiro.Nome)
                                    .attr("src", cavaleiro.thumbnail().Url).addClass("img-thumbnail"))
                            )
                    .append($("<td>").append(
                                cavaleiro.Nome
                            ))
                    .append($("<td>").append(
                                cavaleiro.dataNascimentoNoFormatoBr()
                            ))
                    .append($("<td>").append(
                                $("<button>")
                                    .attr("deletar-cavaleiro", "")
                                    .addClass("btn btn-default btn-xs")
                                    .text(" Deletar")
                                    .prepend($("<i>").addClass("glyphicon glyphicon-remove"))
                                )
                                .append(" | ")
                                .append(
                                    $("<button>")
                                        .attr("editar-cavaleiro", "")
                                        .addClass("btn btn-default btn-xs")
                                        .text(" Editar")
                                        .prepend($("<i>").addClass("glyphicon glyphicon-pencil"))
                                )
                                .append(" | ")
                                .append(
                                    $("<button>")
                                        .attr("detalhes-cavaleiro", "")
                                        .addClass("btn btn-default btn-xs")
                                        .text(" Detalhes")
                                        .prepend($("<i>").addClass("glyphicon glyphicon-search"))
                                )
                            )
            );
        },

        removerCavaleiroDaTela: function(idCavaleiro) {
            this.$listaDeCavaleiros.find(String.format("[data-id-cavaleiro='{0}']", idCavaleiro)).remove();
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
                    new Array("Cólera do Dragão", "Cólera dos 100 dragões"),
                    new Local(undefined, "Beijing"),
                    new Local(undefined, "5 picos de rosan"),
                    new Array(
                        new Image(undefined, "http://images.uncyc.org/pt/3/37/Shiryumestrepokemon.jpg", true),
                        new Image(undefined, "http://images.uncyc.org/pt/thumb/5/52/Shyryugyarados.jpg/160px-Shyryugyarados.jpg", false)
                    )
                ));
            });

            this.$modalCavaleiro.modal({
                show: false
            });

            this.$modalCavaleiro.on("show.bs.modal", function (event) {
                var title = $(event.relatedTarget).data("form-title") !== undefined ? $(event.relatedTarget).data("form-title") : "Editar cavaleiro";

                $(this).find(".modal-title").text(title);
            });

            this.$modalCavaleiro.on("hidden.bs.modal", function (event) {
                self.clearForm();
            });

            this.$btnSubmit.click(function (e) {
                self.$form.find("button[type='submit']").trigger("click");
                return e.preventDefault();
            });

            this.$form.on("submit", function () {
                var cavaleiro = self.doFormParaUmCavaleiro(self.$form);

                App.CavaleiroController.criarCavaleiro(cavaleiro);

                return e.preventDefault();
            });

            this.$form.find(".add-golpe").click(function (e) {
                $(".golpes").prepend(self.createGolpeInput());

                return e.preventDefault();
            });

            this.$form.find(".add-imagem").click(function (e) {
                $(".imagens").prepend(self.createImgInput());

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

            cavaleiro.setDataNascimentoDoFormatoBr(cavaleiroForm.get("dataNascimento"));
            cavaleiro.setAltura(cavaleiroForm.get("altura"));
            cavaleiro.setPeso(cavaleiroForm.get("peso"));

            return cavaleiro;
        },

        prepararEditarCavaleiro: function (cavaleiroId) {
            this.preencherFormComCavaleiro(App.CavaleiroController.buscarCavaleiroPorId(cavaleiroId))

            this.$modalCavaleiro.modal("show");
        },

        preencherFormComCavaleiro: function (cavaleiro) {
            var self = this;
            this.$form.find("#Id").val(cavaleiro.Id);
            this.$form.find("#nome").val(cavaleiro.Nome);
            this.$form.find("#tipoSanguineo").val(cavaleiro.TipoSanguineo);
            this.$form.find("#dataNascimento").val(cavaleiro.dataNascimentoNoFormatoBr());
            this.$form.find("#altura").val(cavaleiro.AlturaCm);
            this.$form.find("#peso").val(cavaleiro.PesoLb);
            this.$form.find("#signo").val(cavaleiro.Signo);
            this.$form.find("#localNascimento").val(cavaleiro.LocalNascimento.Texto);
            this.$form.find("#localTreinamento").val(cavaleiro.LocalTreinamento.Texto);

            cavaleiro.Golpes.forEach(function (golpe) {
                self.$form.find("#golpes").append(self.createGolpeInput(golpe.Nome));
            });

            cavaleiro.Imagens.forEach(function (img) {
                self.$form.find("#imagens").append(self.createImgInput(img));
            });
        },

        createGolpeInput: function (golpe) {
            return $("<div>").addClass("col-sm-4")
                                .prepend(
                                    $("<input>").attr("type", "text")
                                                    .addClass("form-control")
                                                    .attr("name", "golpes[]").val(golpe)
                                );
        },

        createImgInput: function (img) {
            var $inputText = $("<div>").addClass("col-sm-8");
            var $inputCheck = $("<div>").addClass("col-sm-4");
            $inputText.prepend(
                $("<input>").attr("type", "text")
                                .addClass("form-control")
                                .attr("name", "urls[]").val(img === undefined ? null :  img.Url)
            );

            $inputCheck.prepend(
                $("<label>").prepend("É thumbnail?").prepend(
                        $("<input>")
                            .attr("type", "checkbox")
                            .attr("name", "isThumb[]")
                            .attr("checked", img === undefined ? null : img.IsThumb)
                )
            );

            return $("<div>")
                            .addClass("imagem")
                            .addClass("col-sm-6")
                            .prepend($inputCheck)
                            .prepend($inputText);
        },

        clearForm: function () {
            this.$form[0].reset();
            this.$form.find("#golpes").empty();
            this.$form.find("#imagens").empty();
        }
    };

    App.PaginacaoDaListaDeCavaleirosView = {
        paginaAtual: 0,

        iniciar: function () {
            this.buscarElementos();
            this.vincularEventos();
        },

        buscarElementos: function() {
            this.$paginacao = $("[paginacao]");
        },

        vincularEventos: function() {

        },

        criarPaginacao: function (quantidadeDePaginas) {
            var $paginacao = $();
            for (var i = 0; i < quantidadeDePaginas; i++) {
                $paginacao.add($("<li>").prepend("<a>").text(i));
            }
            this.$paginacao
                    .find("[paginacao-anterior]")
                    .after($paginacao);
        }
    };

    App.ListaDeCavaleirosView.iniciar();
    App.CadastroDeCavaleirosView.iniciar();
    App.PaginacaoDaListaDeCavaleirosView.iniciar();
})();
"use strict";
(function () {
    window.App = window.App || {};

    App.ListaDeCategoriasView = {
        tempoDeRefreshDaPaginaEmMs: 30000,
        paginacao: null,
        controller: App.CategoriaController,
        mensagemDeSemResultados: "Sem categorias a exibir",

        iniciar: function () {
            var self = this;
            this.controller.iniciar();
            this.paginacao = new PaginacaoView(App.CategoriaController);
            this.atualizarLista();
            this.buscarElementos();
            this.vincularEventos();

            setInterval(function () {
                self.atualizarLista();
            }, this.tempoDeRefreshDaPaginaEmMs);
        },

        buscarElementos: function() {
            this.$listaDeCategorias = $(".lista-de-categorias");
        },

        desvicularEventos: function () {
            this.$listaDeCategorias.find(".categoria").find("[editar-categoria], [deletar-categoria], [detalhes-categoria]").unbind("click");
        },

        vincularEventos: function () {
            var self = this;

            this.$listaDeCategorias.find(".categoria").find("[editar-categoria]").click(function () {
                var categoria = new Categoria($(this).closest(".categoria").data("id-categoria"), $(this).closest(".categoria").find(".nome").text());
                App.CadastroDeCategoriasView.prepararEditarCategoria(categoria);
            });

            this.$listaDeCategorias.find(".categoria").find("[deletar-categoria]").click(function () {
                var $btn = $("<button>").addClass("btn btn-danger")
                                .attr("message-btn-delete", "").text("Confirmar")
                                .attr("data-categoria-id", $(this).closest(".categoria").data("id-categoria"))
                                .attr("data-dismiss", "modal")
                                .click(function () { self.controller.deletarCategoria($(this).data("categoria-id")); });

                App.Modal.confirmacao("Deseja realmente deletar essa categoria?", $btn);
            });
        },

        atualizarLista: function () {
            this.controller.verificarAlteracoesNasCategorias();
        },

        atualizarEventos: function () {
            this.$listaDeCategorias = $(".lista-de-categorias");
            this.desvicularEventos();
            this.vincularEventos();
        },

        criarElementoNaTela: function (categoria) {
            this.$listaDeCategorias.find("tbody").append(
                $("<tr>").attr("data-id-categoria", categoria.Id)
                    .addClass("categoria")
                    .append($("<td>").addClass("nome").append(
                                categoria.Nome
                            ))
                    .append($("<td>").addClass("acoes").append(
                                $("<button>")
                                    .attr("deletar-categoria", "")
                                    .addClass("btn btn-default btn-xs")
                                    .text(" Deletar")
                                    .prepend($("<i>").addClass("glyphicon glyphicon-remove"))
                                )
                                .append(" | ")
                                .append(
                                    $("<button>")
                                        .attr("editar-categoria", "")
                                        .addClass("btn btn-default btn-xs")
                                        .text(" Editar")
                                        .prepend($("<i>").addClass("glyphicon glyphicon-pencil"))
                                )
                            )
            );
        },

        removerCategoriaDaTela: function (idCategoria) {
            this.$listaDeCategorias.find(String.format("[data-id-categoria='{0}']", idCategoria)).remove();
        },

        criarMensagemDeSemResultadosNaTela: function () {
            this.$listaDeProdutos.html(
                $("<div>")
                    .addClass("alert alert-info")
                    .append($("<strong>").text(this.mensagemDeSemResultados))
            );
        },

        esvaziarLista: function () {
            this.$listaDeCategorias.find("tbody").empty();
        }
    };

    App.ListaDeCategoriasView.iniciar();
})();
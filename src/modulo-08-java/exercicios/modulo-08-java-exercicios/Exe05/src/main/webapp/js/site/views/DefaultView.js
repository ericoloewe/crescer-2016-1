"use strict";
(function () {
    window.App = window.App || {};

    App.ListaDeCategoriasComQuantidadeDeProdutosView = {
        controller: App.CategoriasSidebarController,
        mensagemDeSemResultados: "Sem categorias a exibir",

        iniciar: function () {
            var self = this;
            this.atualizarLista();
            this.buscarElementos();
            this.vincularEventos();
        },

        buscarElementos: function() {
            this.$listaDeCategorias = $(".categorias-sidebar");
            this.$arrowCategorias = $(".arrow-categorias");
        },

        vincularEventos: function () {
            var self = this;
            this.$arrowCategorias.click(function() {
                self.$listaDeCategorias.toggleClass("active");
                $(this).find(".glyphicon").toggleClass("glyphicon-chevron-down");
                $(this).find(".glyphicon").toggleClass("glyphicon-chevron-up");
            });
        },

        criarElementoNaTela: function (categoria) {
            this.$listaDeCategorias.append(
                $("<li>").attr("data-id-categoria", categoria.Id)
                    .append(
                        $("<a>")
                            .attr("href", String.format("/Home/Index/?idCategoria={0}", categoria.Id))
                            .text(String.format("({0}) {1}", categoria.QuantidadeDeProdutos, categoria.Nome))
                    )
            );
        },

        atualizarLista: function() {
            this.controller.atualizarLista();
        }
    };

    App.ListaDeCategoriasComQuantidadeDeProdutosView.iniciar();
})();
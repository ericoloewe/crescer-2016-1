"use strict";
(function () {
    window.App = window.App || {};

    App.CategoriaService = {
        lista: function (pagina, quantidadePorPagina) {
            return $.ajax({
                url: App.Url.buscar,
                type: "GET",
                data: {
                    pagina: pagina,
                    quantidadePorPagina: quantidadePorPagina
                }
            });
        },

        total: function () {
            return $.ajax({
                url: App.Url.buscarQuantidade,
                type: "GET"
            });
        },

        deletar: function (id) {
            return $.ajax({
                url: App.Url.deletar,
                type: "DELETE",
                data: {
                    id: id
                }
            });
        },

        criar: function (categoria) {
            return $.ajax({
                url: App.Url.criar,
                type: "POST",
                data: {
                    Nome: categoria.Nome
                }
            });
        },

        atualizar: function (categoria) {
            return $.ajax({
                url: App.Url.atualizar,
                type: "PUT",
                data: {
                    Id: categoria.Id,
                    Nome: categoria.Nome
                }
            });
        },

        contagemDeProdutos: function() {
            return $.ajax({
                url: "/Categoria/ListarContagemDeProdutos",
                type: "GET"
            });
        }
    };
})();
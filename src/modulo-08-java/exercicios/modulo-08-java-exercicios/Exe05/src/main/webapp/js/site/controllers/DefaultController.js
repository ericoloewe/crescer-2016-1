"use strict";
(function () {
    window.App = window.App || {};

    App.CategoriasSidebarController = {
        servico: App.DefaultService,

        atualizarLista: function() {
            this.servico.contagemDeProdutos()
                .done(function(response) {
                    response.forEach(function(categoria) {
                        App.ListaDeCategoriasComQuantidadeDeProdutosView.criarElementoNaTela(categoria);
                    });
                })
                .fail(function(response) {
                    console.log(response);
                });
        }
    };
})();
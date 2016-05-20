"use strict";

(function () {
    window.App = window.App || {};

    App.ListagemDeCapaDosAlbuns = {
        iniciar: function () {
            this.criarElementos();
            this.buscarElementos();
            this.carregarAlbuns();
        },
        
        criarElementos: function () {
            $("body").prepend(
                $("<div>").addClass("container").append(
                    $("<div>").addClass("lista-de-capas-dos-albuns").addClass("row")
                )
            );
        },

        buscarElementos: function () {
            this.$lista = $(".lista-de-capas-dos-albuns");
        },

        carregarAlbuns: function () {
            var self = this;
            App.ServicoDeBuscaDoSpotify
                    .imagensDosAlbunsDoIronMaiden({
                        tamanhoDaImagem: 300,
                        $templateDaImagem: self.templateDaCapa(),
                        $OndeColocarTemplate: self.$lista
                    })
        },
        
        templateDaCapa: function() {
            return $("<div>").addClass("col-sm-2")
                        .append($("<img>").addClass("img-thumbnail"));
            
        }
    };
    
     App.ListagemDeCapaDosAlbuns.iniciar();
})();
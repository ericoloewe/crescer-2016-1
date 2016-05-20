"use strict";

(function () {
    window.App = window.App || {};

    App.ConsultaDeArtistas = {
        iniciar: function () {
            this.criarElementos();
            this.buscarElementos();
            this.vincularEventos();
        },
        
        criarElementos: function () {
            $(".content").append(
                $("<div>").addClass("container").append(
                    $("<div>").addClass("lista-de-albuns-do-artista").addClass("row")
                )
            );
        },

        buscarElementos: function () {
            this.$formularioDeBusca = $("form[busca-artista]");
            this.$lista = $(".lista-de-albuns-do-artista");
        },
        
        vincularEventos: function () {
            var self = this;
            
            this.$formularioDeBusca.submit(function(e) {
                self.limparLista();
                self.carregarAlbunsDoArtista($(this).find("#consulta-artista").val());
                
                return e.preventDefault();
            })
        },

        carregarAlbunsDoArtista: function (artista) {
            var self = this;
            App.ServicoDeBuscaDoSpotify
                    .appendImagensDosAlbunsDoArtista(artista, {
                        tamanhoDaImagem: 300,
                        $templateDaImagem: self.templateDaCapa(),
                        $OndeColocarTemplate: self.$lista
                    });
        },
        
        templateDaCapa: function() {
            return $("<div>").addClass("col-sm-2")
                        .append($("<img>").addClass("img-thumbnail"));
            
        },
        
        limparLista: function() {
            this.$lista.html("");
        }
    };
    
     App.ConsultaDeArtistas.iniciar();
})();
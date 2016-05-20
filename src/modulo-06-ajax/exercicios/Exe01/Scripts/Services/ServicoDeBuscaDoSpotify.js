(function () {
    window.App = window.App || {};

    App.ServicoDeBuscaDoSpotify = {        
        buscarAlbunsDoIronMaiden: function() {
            var URL = "https://api.spotify.com/v1/artists/6mdiAmATAx73kdxrNrnlao/albums?limit=50";
            
            return $.ajax({
                url: URL
            }).fail(function(error) {
                console.error(error);
                alert("Problemas ao buscar lista do spotify");
            });
        },
        
        /*
         *  funcao utilizada para colocar os albuns na tela
         *  ela recebe um objeto por parametro, com as seguintes definicoes:
         *  tamanhoDaImagem: number
         *  $templateDaImagem: jqueryObject
         *  $OndeColocarTemplate: jqueryObject
         */
        imagensDosAlbunsDoIronMaiden: function(configuracoes) {
            this.buscarAlbunsDoIronMaiden()
                        .done(function(data) {
                            configuracoes.$OndeColocarTemplate
                                .append(
                                    data.items.map(function(album) {
                                        var url =  album.images.filter(function(img) {
                                            return img.height === configuracoes.tamanhoDaImagem;
                                        })[0].url;
                                        return configuracoes.$templateDaImagem.is("img") ? 
                                                configuracoes.$templateDaImagem.attr("src", url)[0].outerHTML :
                                                    configuracoes.$templateDaImagem.find("img").attr("src", url).parent()[0].outerHTML;
                                    }).join("")
                                );
                        });
        }
    };
})();
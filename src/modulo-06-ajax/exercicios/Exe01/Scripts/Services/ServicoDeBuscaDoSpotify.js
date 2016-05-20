(function () {
    window.App = window.App || {};

    App.ServicoDeBuscaDoSpotify = {        
        buscarAlbunsDoIronMaiden: function() {
            var URL = "https://api.spotify.com/v1/artists/6mdiAmATAx73kdxrNrnlao/albums?limit=50";
            
            return $.ajax({
                url: URL
            }).fail(function(error) {
                console.error(error);
                App.Mensagem.erro("Problemas ao buscar lista do spotify");
            });
        },
        
        
        appendImagensDosAlbunsDoIronMaiden: function(configuracoes) {
            var self = this;
            this.buscarAlbunsDoIronMaiden()
                        .done(function(data) {
                            self.aplicarConfiguracoes(data, configuracoes);
                        });
        },
        
        buscarAlbunsDoArtista: function(artista, configuracoes) {
            var self = this;
            this.buscaArtistaPorNome(artista)
                .done(function(artistas) {
                    self.buscaArtistaPorId(artistas.artists.items[0].id)
                        .done(function(albuns) {
                            self.aplicarConfiguracoes(albuns, configuracoes);
                        });
                });
        },
        
        buscaArtistaPorId: function(id) {
            var URL = "https://api.spotify.com/v1/artists/" + id + "/albums?limit=50";
            
            return $.ajax({
                url: URL
            }).fail(function(error) {
                console.error(error);
                App.Mensagem.erro("Problemas ao buscar artista do spotify");
            });
        },
        
        buscaArtistaPorNome: function(artista) {
            var URL = "https://api.spotify.com/v1/search?q="+ artista +"&type=artist";
            
            return $.ajax({
                url: URL
            }).fail(function(error) {
                console.error(error);
                App.Mensagem.erro("Problemas ao buscar artista do spotify");
            });
        },
        
        /*
         *  funcao utilizada para colocar os albuns na tela
         *  ela recebe um objeto por parametro, com as seguintes definicoes:
         *  tamanhoDaImagem: number
         *  $templateDaImagem: jqueryObject
         *  $OndeColocarTemplate: jqueryObject
         *  e um objeto data, que é de onde ela tira as informações 
         */
        aplicarConfiguracoes: function(data, configuracoes) {
            var self = this;
            configuracoes.$OndeColocarTemplate
                    .append(
                        data.items.map(function(album) {
                            if(configuracoes.$templateDaImagem && configuracoes.tamanhoDaImagem)
                                return self.aplicarConfiguracoesDoAppendDeImagensDoAlbum(album, configuracoes);
                            return null;
                        }).join("")
                    );
        },
        
        aplicarConfiguracoesDoAppendDeImagensDoAlbum: function(album, configuracoes) {
            var imagem = this.buscarImagensDoTamanhoSolicitado(album.images, configuracoes.tamanhoDaImagem)[0];
            if(imagem !== undefined)                
                return configuracoes.$templateDaImagem.is("img") ? 
                    configuracoes.$templateDaImagem.attr("src", imagem.url)[0].outerHTML :
                        configuracoes.$templateDaImagem.find("img").attr("src", imagem.url).parent()[0].outerHTML;
        },
        
        buscarImagensDoTamanhoSolicitado: function(images, tamanho) {
            return images.filter(function(img) {
                return img.height === tamanho;
            })
        }
    };
})();
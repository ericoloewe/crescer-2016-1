"use strict";

var ServicoDeMapa = function (view) {
    this.view = view;
    this.mapa = null;
    this.geocoder = new google.maps.Geocoder();
};

ServicoDeMapa.prototype = {
    novoMapa: function ($mapa) {
        this.mapa = new google.maps.Map($mapa[0], {
            center: { lat: -34.397, lng: 150.644 },
            zoom: 8
        });

        return this.mapa;
    },

    localizacaoAtual: function () {
        var localizacao = null;

        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function (posicaoAtual) {
                localizacao = {
                    lat: posicaoAtual.coords.latitude,
                    lng: posicaoAtual.coords.longitude
                };
                console.log(localizacao);
            }, function () {
                alert("Erro ao buscar localização atual");
            });
        } else {
            alert("Navegador não suporta Geolocation");
        }

        return localizacao;
    },

    novoAlfinete: function () {
        return new google.maps.Marker({
            map: this.mapa,
            // Define the place with a location, and a query string.
            place: {
                location: localizacao,
                query: query

            },
            // Attributions help users find your site again.
            attribution: {
                source: 'Google Maps JavaScript API',
                webUrl: 'https://developers.google.com/maps/'
            }
        });
    },

    novoInformativo: function (conteudo) {
        return new google.maps.InfoWindow({
            content: conteudo
        });
    },

    novaNota: function () {
        // TODO:
    },

    buscarLocalizacao: function (localizacao) {
        return this.geocoder.geocode({'address': localizacao.endereco});
    }
};
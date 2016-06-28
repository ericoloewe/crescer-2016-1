"use strict";

var ServicoDeMapa = function (view) {
    this.view = view;
    this.mapa = null;
    this.geocoder = new google.maps.Geocoder();
    this.directionsService = new google.maps.DirectionsService;
    this.directionsDisplay = new google.maps.DirectionsRenderer;
};

ServicoDeMapa.prototype = {
    novoMapa: function ($mapa) {
        this.mapa = new google.maps.Map($mapa[0], {
            center: { lat: -34.397, lng: 150.644 },
            zoom: 10
        });

        this.directionsDisplay.setMap(this.mapa);

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

    buscarLocalizacao: function (endereco) {
        return $.ajax({
            method: "GET",
            url: "https://maps.googleapis.com/maps/api/geocode/json",
            data: {
                address: endereco
            }
        })
    },

    criarRota: function (origem, destino) {
        var self = this;
        this.directionsService.route({
            origin: origem,
            destination: destino,
            travelMode: google.maps.TravelMode.DRIVING
        }, function (response, status) {
            if (status === google.maps.DirectionsStatus.OK) {
                self.directionsDisplay.setDirections(response);
            } else {
                window.alert('Directions request failed due to ' + status);
            }
        })
    }
};
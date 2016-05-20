'use strict';
(function () {
    window.App = window.App || {};

    App.ServicoDeCavaleiros = {
        buscarCavaleiros: function () {
            return $.ajax({ url: urlCavaleiroGet, type: 'GET'/*, timeout: 2000 */ });
        }
    };

})();
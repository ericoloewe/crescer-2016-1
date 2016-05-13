"use strict";

(function() {
    window.App = window.App || {};

    App.Tools = {
        iniciar: function () {
            this.buscarElementos();
            this.vincularEventos();
        },

        buscarElementos: function () {
            this.$tooltips = $('[data-toggle="tooltip"]');
        },

        vincularEventos: function () {
            this.$tooltips.tooltip();
        }
    };

    App.Tools.iniciar();
})();
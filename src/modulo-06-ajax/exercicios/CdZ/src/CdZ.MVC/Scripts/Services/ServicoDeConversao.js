"use strict";
(function () {
    window.App = window.App || {};

    App.Converte = {
        deDataBrParaPadraoISO: function (data) {
            if (typeof data === "string") {
                var dia = data.substr(0, 2), mes = data.substr(3, 2), ano = data.substr(6, 4);
                return new Date(Date.parse(mes + "/" + dia + "/" + ano)).toISOString();
            }
            return null;
        },

        deMetrosParaCentimetros: function (altura) {
            return parseFloat(altura) * 100;
        },

        deCentimetrosParaMetros: function (altura) {
            return parseFloat(altura) / 100;
        },

        deKgParaLibras: function (peso) {
            return parseFloat(peso) * 2.20462;
        },

        deLibrasParaKg: function(peso) {
            return parseFloat(peso) / 2.20462;
        }
    };
})();
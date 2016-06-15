"use strict";
(function () {
    window.App = window.App || {};

    App.DefaultService = {
        contagemDeProdutos: function () {
            return $.ajax({
                url: "/Categoria/ListarContagemDeProdutos",
                type: "GET"
            });
        }
    };
})();
"use strict";
(function () {
    window.App = window.App || {};

    App.ServicoDeCavaleiros = {
        urlBuscarTodosCavaleiros: "/Cavaleiro/Get",
        urlCriarNovoCavaleiro: "/Cavaleiro/Post",

        buscarCavaleiros: function () {
            var self = this;
            return $.ajax({ url: self.urlBuscarTodosCavaleiros, type: "GET" });
        },

        criarCavaleiro: function (cavaleiro) {
            var self = this;
            return $.ajax({
                url: self.urlCriarNovoCavaleiro,
                type: "POST",
                data: {
                    Nome: cavaleiro.Nome,
                    AlturaCm: cavaleiro.AlturaCm,
                    Signo: cavaleiro.Signo,
                    TipoSanguineo: cavaleiro.TipoSanguineo,
                    DataNascimento: cavaleiro.DataNascimento,
                    Golpes: cavaleiro.Golpes,
                    LocalNascimento: cavaleiro.LocalNascimento,
                    LocalTreinamento: cavaleiro.LocalTreinamento,
                    Imagens: cavaleiro.Imagens
                }
            });
        }
    };
})();
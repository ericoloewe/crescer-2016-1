"use strict";
(function () {
    window.App = window.App || {};

    App.ServicoDeCavaleiros = {
        urlBuscarTodosCavaleiros: "/Cavaleiro/Get",
        urlCriarNovoCavaleiro: "/Cavaleiro/Post",
        urlDeletarCavaleiro: "/Cavaleiro/Delete",

        buscarCavaleiros: function (pagina) {
            var self = this;
            return $.ajax({
                url: self.urlBuscarTodosCavaleiros,
                type: "GET",
                data: {
                    pagina: pagina
                }
            });
        },

        deletarCavaleiros: function (idCavaleiro) {
            var self = this;
            return $.ajax({
                url: self.urlDeletarCavaleiro,
                type: "DELETE",
                data: {
                    id: idCavaleiro
                }
            });
        },

        criarCavaleiro: function (cavaleiro) {
            var self = this;
            return $.ajax({
                url: self.urlCriarNovoCavaleiro,
                type: "POST",
                data: {
                    Nome: cavaleiro.Nome,
                    AlturaCm: cavaleiro.AlturaCm,
                    PesoLb: cavaleiro.PesoLb,
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
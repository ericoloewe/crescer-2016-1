"use strict";
(function () {
    window.App = window.App || {};

    App.ServicoDeCavaleiros = {
        urlBuscarTodosCavaleiros: "/Cavaleiro/Get",
        urlCriarNovoCavaleiro: "/Cavaleiro/Post",
        urlDeletarCavaleiro: "/Cavaleiro/Delete",
        urlBuscarQuantidadeDeCavaleiros: "/Cavaleiro/QuantidadeDeCavaleiros",

        buscarCavaleiros: function (pagina) {
            return $.ajax({
                url: this.urlBuscarTodosCavaleiros,
                type: "GET",
                data: {
                    pagina: pagina
                }
            });
        },

        quantidadeDeCavaleiros: function (pagina) {
            return $.ajax({
                url: this.urlBuscarQuantidadeDeCavaleiros,
                type: "GET"
            });
        },

        deletarCavaleiros: function (idCavaleiro) {
            return $.ajax({
                url: this.urlDeletarCavaleiro,
                type: "DELETE",
                data: {
                    id: idCavaleiro
                }
            });
        },

        criarCavaleiro: function (cavaleiro) {
            return $.ajax({
                url: this.urlCriarNovoCavaleiro,
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
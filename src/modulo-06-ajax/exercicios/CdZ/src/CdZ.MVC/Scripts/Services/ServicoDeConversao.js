"use strict";
(function () {
    window.App = window.App || {};

    App.Converte = {
        deDataBrParaPadraoISO: function (data) {
            var dia = data.substr(0, 2), mes = data.substr(3, 2), ano = data.substr(6, 4);
            return new Date(Date.parse(mes + "/" + dia + "/" + ano)).toISOString();
        },

        deMetrosParaCentimetros: function (altura) {
            return parseFloat(altura) * 100;
        },

        deKgParaLibras: function (peso) {
            return parseFloat(peso) * 2, 20462;
        },

        doFormParaUmCavaleiro: function ($cavaleiro) {
            // Obtém o objeto nativo Form através da posição 0 no objeto jQuery e cria um FormData a partir dele
            var cavaleiro = new FormData($cavaleiro[0]);
            var imagens = new Array();
            $cavaleiro.find(".imagens .imagem").each(function () {
                imagens.push(new Imagem(
                                    undefined,
                                    $(this).find("input[type=text]").val(),
                                    $(this).find("input[type=checkbox]").is(":checked")
                                )
                            );
            });

            return new Cavaleiro(
                undefined,
                cavaleiro.get("nome"),
                App.Converte.deMetrosParaCentimetros(cavaleiro.get("altura")),
                App.Converte.deKgParaLibras(cavaleiro.get("peso")),
                cavaleiro.get("signo"),
                cavaleiro.get("tipoSanguineo"),
                App.Converte.deDataBrParaPadraoISO(cavaleiro.get("dataNascimento")),
                cavaleiro.getAll("golpes[]"),
                new Local(undefined, cavaleiro.get("localNascimento")),
                new Local(undefined, cavaleiro.get("localTreinamento")),
                imagens
            );
        }
    };
})();
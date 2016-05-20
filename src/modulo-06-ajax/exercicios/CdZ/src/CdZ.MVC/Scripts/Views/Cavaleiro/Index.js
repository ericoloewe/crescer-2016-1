'use strict';
(function () {
    window.App = window.App || {};

    App.ListaDeCavaleiros = {
        cavaleiros: new Array(),

        iniciar: function () {
            var self = this;
            this.atualizarLista();
            this.criarListaDeCavaleiros();
            this.buscarElementos();
            this.carregarCavaleiros();
            this.vincularEventos();

            setInterval(function () {
                self.atualizarLista();
            }, 5000);
        },

        buscarElementos() {
            this.$listaDeCavaleiros = $(".lista-de-cavaleiros");
        },

        carregarCavaleiros: function () {
            var self = this;
            App.ServicoDeCavaleiros.buscarCavaleiros()
                .then(
                    function onSuccess(res) {
                        res.data.forEach(function (cava) {
                            self.addCavaleiro(cava);
                        });
                    },
                    function onError(res) {
                        console.error(':(');
                        console.error(res);

                        var criarSpanComErro = function (msg) {
                            return $('<span>').text(msg).addClass('erro');
                        };

                        $('#feedback')
                        .append(criarSpanComErro(res.status))
                        .append($('<br>'))
                        .append(criarSpanComErro(res.statusText));
                    }
                );
        },

        criarListaDeCavaleiros: function () {
            var self = this;
            var $listaDeImagens = $("<div>").addClass("lista-de-cavaleiros").addClass("row");
            $("body > .container").append($listaDeImagens);
        },

        vincularEventos: function () {
            var self = this;

            this.$listaDeCavaleiros.find("[deletar-cavaleiro]").click(function (e) {
                if (confirm("Voce deseja realmente deletar esse cavaleiro?")) {
                    self.deletarCavaleiro($(this).parent().data("id-cavaleiro"));
                    $(this).parents().find("[data-id-cavaleiro=" + $(this).parent().data("id-cavaleiro") + "]").remove();
                }
                return e.preventDefault();
            })
        },

        addCavaleiro: function (cavaleiro) {
            this.cavaleiros.push(cavaleiro);
            this.criarDivCavaleiro(cavaleiro);
        },

        deletarCavaleiro: function (idCavaleiro) {
            //TODO:
        },

        atualizarLista: function () {
            //TODO:
            console.log(this.cavaleiros);
            App.ServicoDeCavaleiros
                .buscarCavaleiros()
                    .done(function (data) {

                    })
                    .fail(function (data) {

                    });
        },

        criarDivCavaleiro: function (cavaleiro) {
            var self = this;
            var $cavaleiro = $("<div>").attr("data-id-cavaleiro", cavaleiro.Id)
                                                            .addClass("col-sm-2")
                                                            .addClass("cavaleiro");
            $cavaleiro.prepend($("<h4>").text(cavaleiro.Nome));
            if (cavaleiro.Imagens.length != 0) {
                cavaleiro.Imagens.forEach(function (imagem, i) {
                    self.$listaDeCavaleiros.append($cavaleiro
                                                            .prepend($("<a>").addClass("glyphicon")
                                                                            .addClass("glyphicon-remove")
                                                                            .attr("deletar-cavaleiro", "")
                                                                            .attr("href", ""))
                                                            .append($("<img>").attr("alt", cavaleiro.Nome)
                                                                    .attr("src", imagem.url).addClass("img-thumbnail"))
                                                    )
                });
            } else
                self.$listaDeCavaleiros.append($cavaleiro);
        },

        getCavaleiroPorId: function (idCavaleiro) {
            //TODO:
        }
    };

    function registrarEventoDoBotao() {
        $('#btnCriar').click(function () {

            $.ajax({
                url: urlCavaleiroPost,
                type: 'POST',
                data: {
                    Nome: 'Xiru ' + new Date().getTime(),
                    AlturaCm: 187,
                    Signo: 7,
                    TipoSanguineo: 1,
                    DataNascimento: new Date(),
                    Golpes: ['Cólera do Dragão', 'Cólera dos 100 dragões'],
                    LocalNascimento: {
                        Texto: 'Beijing'
                    },
                    LocalTreinamento: {
                        Texto: '5 picos de rosan'
                    },
                    Imagens: [{
                        Url: 'http://images.uncyc.org/pt/3/37/Shiryumestrepokemon.jpg',
                        IsThumb: true
                    }, {
                        Url: 'http://images.uncyc.org/pt/thumb/5/52/Shyryugyarados.jpg/160px-Shyryugyarados.jpg',
                        IsThumb: false
                    }]
                }
            });

        });
    };
    registrarEventoDoBotao();

    App.ListaDeCavaleiros.iniciar();

})();
"use strict";

var PaginacaoView = function (controller) {
    this.controller = controller;
    this.$paginacao = $("[paginacao]");
};

PaginacaoView.prototype = {
    vincularEventos: function () {
        var self = this;
        this.$paginacao.find("[data-pagina-index]").click(function (e) {
            self.controller.base.irAPagina($(this).data("pagina-index"));
            self.ajustarPaginacao();

            return e.preventDefault();
        });
    },

    criarPaginacao: function (quantidadeDePaginas) {
        var $paginacao = $();

        for (var i = 0; i < quantidadeDePaginas; i++) {
            $paginacao = $paginacao.add(
                                        $("<li>")
                                            .attr("data-pagina-index", i)
                                            .prepend(
                                                $("<a>")
                                                    .attr("href", "")
                                                    .text(i + 1)
                                            )
                                        );
        }

        this.$paginacao.find("[data-pagina-index]:not([paginacao-anterior],[paginacao-proxima])").remove();
        this.$paginacao
                .find("[paginacao-anterior]")
                .after($paginacao);

        this.$paginacao.find("[paginacao-anterior]").addClass("disabled");
        this.ajustarPaginacao();

        this.vincularEventos();
    },

    ajustarPaginacao: function () {
        var pagAtual = this.controller.base.servicoPaginacao.PaginaAtual;
        var maxPaginas = this.controller.base.servicoPaginacao.quantidadeDePaginas() - 1;

        this.limparPaginacao();

        this.$paginacao.find(String.format("[data-pagina-index={0}]", pagAtual)).addClass("active");
        if (pagAtual === maxPaginas)
            this.$paginacao.find("[paginacao-proxima]").addClass("disabled");
        if (pagAtual === 0)
            this.$paginacao.find("[paginacao-anterior]").addClass("disabled");
    },

    limparPaginacao: function () {
        this.$paginacao.find("[data-pagina-index]").removeClass("active");
        this.$paginacao.find("[paginacao-anterior], [paginacao-proxima]").removeClass("disabled");
    }
};
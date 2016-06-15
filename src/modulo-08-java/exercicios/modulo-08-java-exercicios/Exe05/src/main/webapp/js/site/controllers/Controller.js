"use strict";

var Controller = function (listView, formView, servico, servicoPaginacao, filho, items) {
    this.listView = listView;
    this.formView = formView;
    this.servico = servico;
    this.servicoPaginacao = servicoPaginacao;
    this.filho = filho;
    this.items = items || new Array();
    this.parametrosBusca = {};
};

Controller.prototype = {
    atualizarPaginacao: function (quantidadeDeCategorias) {
        this.servicoPaginacao.QuantidadeDeItens = quantidadeDeCategorias;
        this.servicoPaginacao.atualizarPaginaAtual();
        this.listView.paginacao.criarPaginacao(this.servicoPaginacao.quantidadeDePaginas());
    },

    irAPagina: function (pagina) {
        this.servicoPaginacao.definePagina(pagina);
        this.atualizarTelaEEventos();
    },

    verificarAlteracoes: function () {
        var self = this;

        this.filho.atualizarParametrosBusca();
        this.servico
            .total(this.parametrosBusca)
            .done(function(quantidade) {
                if (quantidade !== self.servicoPaginacao.QuantidadeDeItens) {
                    self.atualizar(quantidade);
                }
            });
    },

    forcarAtualizacao: function () {
        var self = this;

        this.filho.atualizarParametrosBusca();
        this.servico
            .total(this.parametrosBusca)
            .done(function (quantidade) {
                self.atualizar(quantidade);
            });
    },

    atualizar: function (quantidade) {
        var quantidadeAnterior = this.servicoPaginacao.QuantidadeDeItens;
        this.atualizarPaginacao(quantidade);
        this.atualizarTelaEEventos();
        this.filho.notificarItemAdicionado(quantidade, quantidadeAnterior);
    },

    atualizarTelaEEventos: function () {
        var self = this;

        this.servico
            .lista(this.servicoPaginacao.PaginaAtual, this.servicoPaginacao.ItensPorPagina, this.parametrosBusca)
            .done(function(response) {
                self.addItensNovos(response);
                self.listView.atualizarEventos();
            });
    },

    addItensNovos: function (itens) {
        var self = this;

        this.itens = new Array();
        if (itens.length <= 0) {
            self.listView.criarMensagemDeSemResultadosNaTela();
            return;
        }
        this.listView.esvaziarLista();
        itens.forEach(function (item) {
            self.addItem(item);
        });
    },

    addItem: function (item) {
        var itemAAdicionar = this.filho.criarNovoItem(item);
        this.items.push(itemAAdicionar);
        this.listView.criarElementoNaTela(itemAAdicionar);
    },

    deletarItem: function (id) {
        var self = this;
        this.servico
            .deletar(id)
            .done(function (response) {
                self.verificarAlteracoes();
                App.Mensagem.informativa("Item deletado com sucesso!");
            })
            .fail(function (response) {
                App.Modal.erro(response.responseJSON.Mensagem);
            });
    },

    criarItem: function (item) {
        var self = this;
        this.servico
            .criar(item)
            .done(function (response) {
                self.verificarAlteracoes();
                self.formView.clearForm();
                App.Modal.sucesso(response.Mensagem);
                console.log(response);
            })
            .fail(function (response) {
                self.formView.colocarBtnSubmitNoEstadoOriginal();
                App.Modal.erro(response.responseJSON.Mensagem);
            });
    },

    atualizarItem: function (item) {
        var self = this;
        this.servico
            .atualizar(item)
            .done(function (response) {
                self.forcarAtualizacao();
                self.formView.clearForm();
                App.Modal.sucesso(response.Mensagem);
                console.log(response);
            })
            .fail(function (response) {
                self.formView.colocarBtnSubmitNoEstadoOriginal();
                App.Modal.erro(response.responseJSON.Mensagem);
            });
    },

    buscarPorId: function (id) {
        // TODO:
    },

    notificarItemAdicionado: function (title, messageToFormat, quantidade, quantidadeAnterior) {
        var foiAddItens = quantidadeAnterior !== 0 && (quantidade - quantidadeAnterior) > 0;
        if (foiAddItens)
            App.ServicoDeNotificacao.notificar(String.format(messageToFormat, (quantidade - quantidadeAnterior)), title, "/Content/Images/logo.png");
    }
};
var ServicoDePaginacao = function(quantidadeDeItens, itensPorPagina) {
    this.QuantidadeDeItens = quantidadeDeItens;
    this.ItensPorPagina = itensPorPagina;
    this.PaginaAtual = 0;
};

ServicoDePaginacao.prototype = {
    temItensNaPagina: function (pagina) {
        // verifica se a pagina é maior que zero e menor que a quantidade de paginas -1 (-1 pois a pagina atual comeca em 0)
        return pagina >= 0 && pagina <= (this.quantidadeDePaginas() - 1);
    },

    atualizarPaginaAtual: function() {
        if (!this.temItensNaPagina(this.PaginaAtual)) {
            this.definePagina("anterior");
        }
    },

    definePagina: function(pagina) {
        if (typeof pagina === "number") {
            if (pagina >= 0 && pagina <= this.quantidadeDePaginas())
                this.PaginaAtual = pagina;
        } else if (pagina === "anterior") {
            this.PaginaAtual = this.paginaAnterior();
        } else {
            this.PaginaAtual = this.proximaPagina();
        }
    },

    atualizarQuantidadeDeItens: function(quantidadeDeItens) {
        this.QuantidadeDeItens = quantidadeDeItens;
    },

    quantidadeDePaginas: function() {
        return Math.ceil(this.QuantidadeDeItens / this.ItensPorPagina);
    },

    proximaPagina: function () {
        /*
         * quantidade de paginas - 1 pois o indice de paginas começa no 0 e o retorno de 
         * quantidadeDePaginas é realmente a quantidade de paginas que possui até então
         */
        return (this.quantidadeDePaginas() - 1) === this.PaginaAtual ? this.PaginaAtual : this.PaginaAtual + 1;
    },

    paginaAnterior: function () {
        return 0 === this.PaginaAtual ? 0 : this.PaginaAtual - 1;
    }
};
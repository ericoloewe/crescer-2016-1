var ServicoDePaginacao = function(quantidadeDeItens, itensPorPagina) {
    this.QuantidadeDeItens = quantidadeDeItens;
    this.ItensPorPagina = itensPorPagina;
    this.PaginaAtual = 0;
};

ServicoDePaginacao.prototype = {
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
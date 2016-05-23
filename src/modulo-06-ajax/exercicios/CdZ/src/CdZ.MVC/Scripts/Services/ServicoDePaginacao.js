var ServicoDePaginacao = function(quantidadeDeItens, itensPorPagina) {
    this.QuantidadeDeItens = quantidadeDeItens;
    this.ItensPorPagina = itensPorPagina;
    this.PaginaAtual = 0;
};

ServicoDePaginacao.prototype = {
    quantidadeDePaginas: function() {
        return Math.ceil(this.QuantidadeDeItens / this.ItensPorPagina);
    },
    proximaPagina: function () {
        return this.quantidadeDePaginas() === this.PaginaAtual ? this.PaginaAtual : this.PaginaAtual++;
    },
    paginaAnterior: function () {
        return 0 === this.PaginaAtual ? 0 : this.PaginaAtual--;
    }
};
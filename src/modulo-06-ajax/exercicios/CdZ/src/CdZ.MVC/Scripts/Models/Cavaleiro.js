/*
 * Model - Cavaleiro
 */

var Cavaleiro = function (id, nome, alturaCm, pesoLb, signo, tipoSanguineo, dataNascimento, golpes, localNascimento, localTreinamento, imagens) {
    this.Id = id;
    this.Nome = nome;
    this.AlturaCm = alturaCm;
    this.PesoLb = pesoLb;
    this.Signo = signo;
    this.TipoSanguineo = tipoSanguineo;
    this.DataNascimento = dataNascimento;
    this.Golpes = golpes;
    this.LocalNascimento = localNascimento;
    this.LocalTreinamento = localTreinamento;
    this.Imagens = imagens;
};

Cavaleiro.prototype = {

};
/*
 * Model - Cavaleiro
 */

var Cavaleiro = function (id, nome, alturaEmM, pesoEmKg, signo, tipoSanguineo, dataNascimento, golpes, localNascimento, localTreinamento, imagens) {
    this.Id = id;
    this.Nome = nome;
    this.Signo = signo;
    this.TipoSanguineo = tipoSanguineo;
    this.Golpes = golpes;
    this.LocalNascimento = localNascimento;
    this.LocalTreinamento = localTreinamento;
    this.Imagens = imagens;
    this.DataNascimento = dataNascimento;
    this.AlturaCm = alturaEmM;
    this.PesoLb = pesoEmKg;
};

Cavaleiro.prototype = {
    setDataNascimentoDoFormatoServidor: function (dataNascimento) {
        this.DataNascimento = App.Converte.deDataServidorParaPadraoISO(dataNascimento);
    },

    setDataNascimentoDoFormatoBr: function (dataNascimento) {
        this.DataNascimento = App.Converte.deDataBrParaPadraoISO(dataNascimento);
    },

    dataNascimentoNoFormatoBr: function() {
        return App.Converte.dePadraoISOParaDataBr(this.DataNascimento);
    },

    setAltura: function (alturaEmM) {
        this.AlturaCm = App.Converte.deMetrosParaCentimetros(alturaEmM);
    },

    alturaEmMetros: function() {
        return App.Converte.deMetrosParaCentimetros(this.AlturaCm);
    },

    setPeso: function (pesoEmKg) {
        this.PesoLb = App.Converte.deKgParaLibras(pesoEmKg);
    },

    pesoEmKg: function() {
        return App.Converte.deLibrasParaKg(this.PesoLb);
    },

    thumbnail: function () {
        return this.Imagens.filter(function (img) {
            return img.IsThumb === true;
        })[0];
    }
};
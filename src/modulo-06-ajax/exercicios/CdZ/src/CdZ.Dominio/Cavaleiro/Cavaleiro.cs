using System;
using System.Collections.Generic;

namespace CdZ.Dominio
{
    public class Cavaleiro
    {
        public int Id { get; private set; }
        public string Nome { get; set; }
        public double AlturaCm { get; set; }
        public double PesoLb { get; set; }
        public DateTime DataNascimento { get; private set; }
        public Signo Signo { get; private set; }
        public TipoSanguineo TipoSanguineo { get; private set; }
        public Local LocalNascimento { get; private set; }
        public Local LocalTreinamento { get; set; }
        public IList<Golpe> Golpes { get; private set; }
        public IList<Imagem> Imagens { get; private set; }

        /*
         * Precisamos deste construtor por causa do Entity Framework.
         */
        private Cavaleiro()
        {
            Golpes = new List<Golpe>();
            Imagens = new List<Imagem>();
        }

        /// <summary>
        /// Construtor utilizado para montar cavaleiros novos
        /// </summary>
        public Cavaleiro(string nome, double alturaCm, double pesoLb, DateTime dataNascimento, Signo signo, TipoSanguineo tipoSanguineo, Local localNascimento, Local localTreinamento, IList<Golpe> golpes, IList<Imagem> imagens)
            : this()
        {
            Nome = nome;
            AlturaCm = alturaCm;
            PesoLb = pesoLb;
            DataNascimento = dataNascimento;
            Signo = signo;
            TipoSanguineo = tipoSanguineo;
            LocalNascimento = localNascimento;
            LocalTreinamento = localTreinamento;
            Imagens = imagens;
            Golpes = golpes;
        }
    }
}

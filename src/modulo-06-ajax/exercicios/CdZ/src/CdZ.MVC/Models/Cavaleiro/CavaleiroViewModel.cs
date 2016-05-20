using CdZ.Dominio;
using System;
using System.Linq;
using System.Collections.Generic;
using Dominio = CdZ.Dominio;

namespace CdZ.MVC.Models.Cavaleiro
{
    public class CavaleiroViewModel
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public double AlturaCm { get; set; }
        public double PesoLb { get; set; }
        public DateTime DataNascimento { get; set; }
        public Signo Signo { get; set; }
        public TipoSanguineo TipoSanguineo { get; set; }
        public Local LocalNascimento { get; set; }
        public Local LocalTreinamento { get; set; }
        public IList<string> Golpes { get; set; }
        public IList<ImagemViewModel> Imagens { get; set; }
        public CavaleiroViewModel()
        {
            // TODO: corrigir model-bind
            DataNascimento = DateTime.Today;
        }

        public Dominio.Cavaleiro ToModel()
        {
            var golpesObj = Golpes.Select(_ => new Golpe(_)).ToList();
            var imagensObj = Imagens.Select(_ => _.ToModel()).ToList();

            return new Dominio.Cavaleiro(Nome, AlturaCm, PesoLb, DataNascimento, Signo, TipoSanguineo, LocalNascimento, LocalTreinamento, golpesObj, imagensObj);
        }
    }
}
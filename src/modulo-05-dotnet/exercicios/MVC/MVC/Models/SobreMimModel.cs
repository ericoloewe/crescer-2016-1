using System;

namespace MVC.Models
{
    public class SobreMimModel
    {
        public string Nome { get; set; }
        public EstadoCivil EstadoCivil { get; set; }
        public DateTime DataNascimento { get; set; }
        public int Altura { get; set; }
        public int Peso { get; set; }
    }
}
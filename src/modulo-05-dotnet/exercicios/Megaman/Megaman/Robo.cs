using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Megaman
{
    abstract class Robo
    {
        public abstract string Nome { get; }
        public int Vida { get; protected set; }
        protected int Ataque { get; set; }
        protected int Defesa { get; set; }

        public Robo()
        {
            Vida = 100;
            Ataque = 5;
        }

        public void Atacar(Robo robo)
        {

        }
    }
}

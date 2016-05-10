using System;

namespace Megaman
{
    class Rush : Robo, IUpgrade
    {
        public string Nome { get; set; }
        public int Quantidade { get; set; }
        public Rush()
        {
            Ataque = 4;
            Defesa = 3;
        }        
    }
}

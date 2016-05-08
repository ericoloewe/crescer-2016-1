namespace Megaman
{
    public class Protoman : Robo
    {
        private bool _jaMorreu;
        private int _vida;

        public override int Vida
        {
            get
            {
                return _vida;
            }
            protected set
            {
                if (_vida <= 0)
                {
                    _vida = 20;
                    _jaMorreu = true;
                }
                else
                    _vida = value;
            }
        }

        public Protoman()
        {
            Defesa = 2;
            _vida = 100;
            _jaMorreu = false;
        }

        public override void Atacar(Robo robo)
        {
            if (_jaMorreu)
                Ataque = 7;
            robo.RealizarAtaque(Ataque);
        }
    }
}

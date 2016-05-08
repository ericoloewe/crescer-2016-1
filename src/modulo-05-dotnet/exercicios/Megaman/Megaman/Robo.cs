namespace Megaman
{
    public abstract class Robo
    {
        public virtual int Vida { get; protected set; }
        protected int Ataque { get; set; }
        protected int Defesa { get; set; }

        protected Robo()
        {
            Vida = 100;
            Ataque = 5;
        }

        public virtual void Atacar(Robo robo)
        {
            robo.RealizarAtaque(Ataque);
        }

        protected internal void RealizarAtaque(int ataque)
        {
            Vida -= (ataque - Defesa);
        }

        public override string ToString()
        {
            return $"Nome: Vida: {Vida}, Ataque: {Ataque}, Defesa: {Defesa}";
        }
    }
}

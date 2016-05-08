namespace Megaman
{
    public class Megaman : Robo
    {
        public Megaman()
        {
            Ataque = 6;
        }

        public override void Atacar(Robo robo)
        {
            if (Vida < 30)
                robo.RealizarAtaque(Ataque + 3);
            else
                robo.RealizarAtaque(Ataque);
        }
    }
}

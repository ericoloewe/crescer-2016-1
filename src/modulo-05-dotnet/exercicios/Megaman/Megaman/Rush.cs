using System;

namespace Megaman
{
    public class Rush : Robo, IUpgrade
    {
        public string Nome { get; set; }
        public int Quantidade { get; set; }
        public Rush()
        {
            Ataque = 4;
            Defesa = 3;
        }

        public override void EquiparUpgrade(IUpgrade upgrade)
        {
            if (ListaDeUpgrades.Count < 2)
            {
                base.EquiparUpgrade(upgrade);
                return;
            }
            throw new InvalidOperationException("Você não pode cadastrar mais que 2 upgrades");
        }
    }
}

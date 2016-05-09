using System;
using System.Collections.Generic;

namespace Megaman
{
    public abstract class Robo
    {
        public virtual int Vida { get; protected set; }
        protected int Ataque { get; set; }
        protected int Defesa { get; set; }
        protected List<IUpgrade> ListaDeUpgrades = new List<IUpgrade>();

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

        public void EquiparUpgrade(IUpgrade upgrade)
        {
            if (upgrade == null)
                throw new NullReferenceException("O upgrade não pode ser null");
            ListaDeUpgrades.Add(upgrade);
            if (upgrade is UpgradeDeAtaque)
                Ataque += upgrade.Quantidade;
            else if (upgrade is UpgradeDeDefesa)
                Defesa += upgrade.Quantidade;
            else if (upgrade is UpgradeLendario)
            {
                Ataque += upgrade.Quantidade;
                Defesa += upgrade.Quantidade;
            }
        }

        public override string ToString()
        {
            return $"Nome: Vida: {Vida}, Ataque: {Ataque}, Defesa: {Defesa}";
        }
    }
}

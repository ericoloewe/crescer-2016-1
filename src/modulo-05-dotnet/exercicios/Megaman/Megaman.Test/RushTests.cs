using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Megaman.Test
{
    [TestClass]
    public class RushTests
    {
        [TestMethod]
        public void CriarRushCom4DeAtaqueE3DeDefesa()
        {
            var rush = new Rush();

            Assert.AreEqual("Nome: Vida: 100, Ataque: 4, Defesa: 3", rush.ToString());
        }

        [TestMethod]
        public void EquiparUpgradeDeAtaque()
        {
            var bot = new Rush();
            var outroBot = new Bot();

            bot.EquiparUpgrade(new UpgradeDeAtaque() { Nome = "Canhão de Plasma", Quantidade = 2 });
            bot.Atacar(outroBot);

            Assert.AreEqual(94, outroBot.Vida);
        }

        [TestMethod]
        public void EquiparUpgradeDeDefesa()
        {
            var bot = new Rush();
            var outroBot = new Bot();

            bot.EquiparUpgrade(new UpgradeDeDefesa() { Nome = "Escudo de Energia", Quantidade = 2 });
            outroBot.Atacar(bot);

            Assert.AreEqual(100, bot.Vida);
        }

        [TestMethod]
        public void EquiparUpgradeLendario()
        {
            var bot = new Rush();
            var outroBot = new Bot();

            bot.EquiparUpgrade(new UpgradeLendario() { Nome = "Botas de Super Velocidade", Quantidade = 1 });
            outroBot.Atacar(bot);
            bot.Atacar(outroBot);

            Assert.AreEqual(99, bot.Vida);
            Assert.AreEqual(95, outroBot.Vida);
        }

        [TestMethod]
        [ExpectedException(typeof(InvalidOperationException))]
        public void TentarEquiparMaisDeDoisUpgrades()
        {
            var bot = new Rush();
            var outroBot = new Bot();

            bot.EquiparUpgrade(new UpgradeLendario() { Nome = "Botas de Super Velocidade", Quantidade = 1 });
            bot.EquiparUpgrade(new UpgradeDeDefesa() { Nome = "Escudo de Energia", Quantidade = 2 });
            bot.EquiparUpgrade(new UpgradeDeAtaque() { Nome = "Canhão de Plasma", Quantidade = 2 });
        }
    }
}

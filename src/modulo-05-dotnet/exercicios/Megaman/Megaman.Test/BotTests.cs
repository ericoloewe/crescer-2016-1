using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Megaman.Test
{
    [TestClass]
    public class BotTests
    {
        [TestMethod]
        public void CriarRoboCom100DeVida()
        {
            var bot = new Bot();

            Assert.AreEqual(100, bot.Vida);
            Assert.AreEqual("Nome: Vida: 100, Ataque: 5, Defesa: 0", bot.ToString());
        }

        [TestMethod]
        public void AtacarOutroRoboDeveReduzir5NaVida()
        {
            var bot = new Bot();
            var outroBot = new Bot();

            bot.Atacar(outroBot);

            Assert.AreEqual(95, outroBot.Vida);
        }

        [TestMethod]
        [ExpectedException(typeof(NullReferenceException))]
        public void AtacarComNull()
        {
            var bot = new Bot();

            bot.Atacar(null);
        }

        [TestMethod]
        public void EquiparUpgradeDeAtaque()
        {
            var bot = new Bot();
            var outroBot = new Bot();

            bot.EquiparUpgrade(new UpgradeDeAtaque() {Nome = "Canhão de Plasma", Quantidade = 2});
            bot.Atacar(outroBot);

            Assert.AreEqual(93, outroBot.Vida);
        }

        [TestMethod]
        public void EquiparUpgradeDeDefesa()
        {
            var bot = new Bot();
            var outroBot = new Bot();

            bot.EquiparUpgrade(new UpgradeDeDefesa() { Nome = "Escudo de Energia", Quantidade = 2 });
            outroBot.Atacar(bot);

            Assert.AreEqual(97, bot.Vida);
        }

        [TestMethod]
        public void EquiparUpgradeLendario()
        {
            var bot = new Bot();
            var outroBot = new Bot();

            bot.EquiparUpgrade(new UpgradeLendario() { Nome = "Botas de Super Velocidade", Quantidade = 1 });
            outroBot.Atacar(bot);
            bot.Atacar(outroBot);

            Assert.AreEqual(96, bot.Vida);
            Assert.AreEqual(94, outroBot.Vida);
        }

        [TestMethod]
        [ExpectedException(typeof(NullReferenceException))]
        public void EquiparNull()
        {
            var bot = new Bot();

            bot.EquiparUpgrade(null);
        }
    }
}

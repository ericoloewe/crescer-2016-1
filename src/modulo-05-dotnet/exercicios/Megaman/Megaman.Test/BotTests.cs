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
        [ExpectedException(typeof(System.NullReferenceException))]
        public void AtacarComNull()
        {
            var bot = new Bot();

            bot.Atacar(null);
        }
    }
}

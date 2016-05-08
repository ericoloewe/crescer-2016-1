using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Megaman.Test
{
    [TestClass]
    public class MegamanTests
    {
        [TestMethod]
        public void CriarMegamanCom100DeVida()
        {
            var megaman = new Megaman();

            Assert.AreEqual(100, megaman.Vida);
            Assert.AreEqual("Nome: Vida: 100, Ataque: 6, Defesa: 0", megaman.ToString());
        }

        [TestMethod]
        public void AtacarOutroRoboDeveReduzir6NaVida()
        {
            var bot = new Megaman();
            var outroBot = new Bot();

            bot.Atacar(outroBot);

            Assert.AreEqual(94, outroBot.Vida);
        }

        [TestMethod]
        public void AtacarOutroRoboCom2DeDefesaDeveReduzir4NaVida()
        {
            var bot = new Megaman();
            var outroBot = new Protoman();

            bot.Atacar(outroBot);

            Assert.AreEqual(96, outroBot.Vida);
        }
    }
}

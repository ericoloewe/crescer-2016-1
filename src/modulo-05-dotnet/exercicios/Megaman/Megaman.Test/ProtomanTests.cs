using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Megaman.Test
{
    [TestClass]
    public class ProtomanTests
    {
        [TestMethod]
        public void CriarProtomanCom100DeVida()
        {
            var protoman = new Protoman();

            Assert.AreEqual(100, protoman.Vida);
            Assert.AreEqual("Nome: Vida: 100, Ataque: 5, Defesa: 2", protoman.ToString());
        }

        [TestMethod]
        public void AtacarOutroRoboDeveReduzir5NaVida()
        {
            var protoman = new Protoman();
            var outroBot = new Bot();

            protoman.Atacar(outroBot);

            Assert.AreEqual(95, outroBot.Vida);
        }

        [TestMethod]
        public void AtacarOutroProtomanDeveReduzir3NaVida()
        {
            var protoman = new Protoman();
            var outroBot = new Protoman();

            protoman.Atacar(outroBot);

            Assert.AreEqual(97, outroBot.Vida);
        }

        [TestMethod]
        public void MatarProtomanDeveReceber20DeVida()
        {
            var protoman = new Protoman();
            var outroRobo = new Megaman();

            while (protoman.Vida > 0)
            {
                outroRobo.Atacar(protoman);
            }

            outroRobo.Atacar(protoman);

            Assert.AreEqual(20, protoman.Vida);
        }
    }
}

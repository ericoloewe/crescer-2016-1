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
            var megaman = new Megaman();
            var outroRobo = new Bot();

            megaman.Atacar(outroRobo);

            Assert.AreEqual(94, outroRobo.Vida);
        }

        [TestMethod]
        public void AtacarOutroRoboCom2DeDefesaDeveReduzir4NaVida()
        {
            var megaman = new Megaman();
            var outroRobo = new Protoman();

            megaman.Atacar(outroRobo);

            Assert.AreEqual(96, outroRobo.Vida);
        }

        [TestMethod]
        public void AtacarComMenos30DeVida()
        {
            var megaman = new Megaman();
            var outroRobo = new Bot();

            while (megaman.Vida >= 30)
            {
                outroRobo.Atacar(megaman);
            }

            megaman.Atacar(outroRobo);

            Assert.AreEqual(91, outroRobo.Vida);
        }

        [TestMethod]
        [ExpectedException(typeof(System.NullReferenceException))]
        public void AtacarComNull()
        {
            var megaman = new Megaman();

            megaman.Atacar(null);
        }
    }
}

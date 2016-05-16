using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Dominio;
using DominioTest.Mocks;

namespace DominioTest
{
    [TestClass]
    public class UsuarioServicoTest
    {
        private UsuarioServico CriarUsuarioServico()
        {
            return new UsuarioServico(
                    new UsuarioRepositorioMock()
                 );
        }

        [TestMethod]
        public void UsuarioComumEhEncontradoComSucesso()
        {
            UsuarioServico usuarioServico = CriarUsuarioServico();
            Usuario usuario = usuarioServico.BuscarUsuarioPorAutenticacao("comum@teste.com", "abc123");

            Assert.AreEqual("comum@teste.com", usuario.Email);
            Assert.IsNull(usuario.Permissoes);
        }

        [TestMethod]
        public void UsuarioGoldEhEncontradoComSucesso()
        {
            UsuarioServico usuarioServico = CriarUsuarioServico();
            Usuario usuario = usuarioServico.BuscarUsuarioPorAutenticacao("gold@teste.com", "123abc");

            Assert.AreEqual("gold@teste.com", usuario.Email);
            Assert.AreEqual("GOLD", usuario.Permissoes[0]);
        }

        [TestMethod]
        public void BuscaDeUsuarioComEmailIncorretoDeveRetornarNull()
        {
            UsuarioServico usuarioServico = CriarUsuarioServico();
            Usuario usuario = usuarioServico.BuscarUsuarioPorAutenticacao("silver@teste.com", "123abc");

            Assert.IsNull(usuario);
        }

        [TestMethod]
        public void BuscaDeUsuarioComSenhaIncorretaDeveRetornarNull()
        {
            UsuarioServico usuarioServico = CriarUsuarioServico();
            Usuario usuario = usuarioServico.BuscarUsuarioPorAutenticacao("gold@teste.com", "123abcd");

            Assert.IsNull(usuario);
        }

        [TestMethod]
        public void BuscaDeUsuarioComParametrosEmBrancoDeveRetornarNull()
        {
            UsuarioServico usuarioServico = CriarUsuarioServico();
            Usuario usuario = usuarioServico.BuscarUsuarioPorAutenticacao("", "");

            Assert.IsNull(usuario);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentNullException))]
        public void ParametrosNulosCausamException()
        {
            UsuarioServico usuarioServico = CriarUsuarioServico();
            Usuario usuario = usuarioServico.BuscarUsuarioPorAutenticacao(null, null);
        }
    }
}

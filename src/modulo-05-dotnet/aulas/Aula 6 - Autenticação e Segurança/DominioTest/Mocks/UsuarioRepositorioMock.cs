using Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DominioTest.Mocks
{
    // Bem, aqui entramos no conceito de MOCK.
    // MOCK nada mais é que uma classe FAKE, onde possui dados fixos.
    // Pense: como seria rodar testes unitários direto em um banco de dados?
    // Você sempre precisaria apagar o banco e rodar os scripts de novo somente para
    // testar a criptografia de sua classe UsuarioServico.
    // Não seria bom ter sempre dados fixos para testar? Para isso serve o MOCK.
    class UsuarioRepositorioMock : IUsuarioRepositorio
    {
        private IList<Usuario> _usuarios;
        
        public UsuarioRepositorioMock()
        {
            // Ao inves de pesquisar no banco, pesquisamos em uma lista fixa.
            _usuarios = new List<Usuario>();

            _usuarios.Add(new Usuario()
            {
                Email = "comum@teste.com",
                Senha = "e99a18c428cb38d5f260853678922e03", //abc123
                Nome = "Usuário Comum"
            });

            _usuarios.Add(new Usuario()
            {
                Email = "gold@teste.com",
                Senha = "a906449d5769fa7361d7ecc6aa3f6d28", //123abc
                Nome = "Usuário Gold",
                Permissoes = new string[] { "GOLD" }
            });
        }

        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            return _usuarios.FirstOrDefault(u => u.Email.Equals(email) && u.Senha.Equals(senha));
        }
    }
}

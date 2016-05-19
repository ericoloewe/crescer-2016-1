using LojaNinja.Dominio;
using System.Linq;

namespace LojaNinja.Repositorio.EF
{
    public class UsuarioRepositorioEF : IUsuarioRepositorio
    {
        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            using(var db = new LojaNinjaContext())
            {
                return db.Usuario.FirstOrDefault(u => u.Email.Equals(email) && u.Senha.Equals(senha));
            }
        }

        public void CadastrarUsuario(Usuario usuario)
        {
            using (var db = new LojaNinjaContext())
            {
                db.Usuario.Add(usuario);
                db.SaveChanges();
            }
        }

        public Usuario BuscarUsuarioPorId(int id)
        {
            using (var db = new LojaNinjaContext())
            {
                return db.Usuario.FirstOrDefault(u => id.Equals(u.Id));
            }
        }
    }
}

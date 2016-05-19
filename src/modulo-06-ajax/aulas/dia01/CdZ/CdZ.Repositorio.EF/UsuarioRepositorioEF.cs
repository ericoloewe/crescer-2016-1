using CdZ.Dominio;
using System.Linq;

namespace CdZ.Repositorio.EF
{
    public class UsuarioRepositorioEF : IUsuarioRepositorio
    {
        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            using (var db = new ContextoDeDados())
            {
                /*
                 * Neste caso, o usuário possui uma lista de permissões.
                 * Essa lista de permissões é uma tabela no banco também.
                 * Podemos, através do include, dizer que, além de carregar os dados
                 * do usuário, deve trazer carregados as permissões dele.
                 */
                Usuario usuario = db.Usuario.Include("Permissoes").FirstOrDefault(
                    u =>
                        u.Email.Equals(email) 
                        && u.Senha.Equals(senha));

                return usuario;
            }
        }

        public void CriarUsuario(Usuario usuario)
        {
            using (var db = new ContextoDeDados())
            {
                db.Entry<Usuario>(usuario).State = System.Data.Entity.EntityState.Added;
                db.SaveChanges();
            }
        }
        
    }
}

using LojaNinja.Dominio;
using System;
using System.Configuration;
using System.Data.SqlClient;
using System.Transactions;
using LojaNinja.Repositorio.Extensions;

namespace LojaNinja.Repositorio
{
    public class UsuarioRepositorioADO : RepositorioBase, IUsuarioRepositorio
    {
        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            const string sql = "SELECT * FROM Usuario WHERE email=@p_email and senha=@p_senha";
            using (var db = new SqlConnection(ConnectionString))
            {
                var comando = new SqlCommand(sql, db);
                comando.Parameters.Add(new SqlParameter("p_email", email));
                comando.Parameters.Add(new SqlParameter("p_senha", senha));

                db.Open();

                var leitor = comando.ExecuteReader();
                if(leitor.Read())
                    return new Usuario(leitor.ParseInt("id"), leitor["nome"].ToString(), leitor["email"].ToString(), leitor["senha"].ToString());
            }
            throw new ArgumentException("Usuario não encontrado.");
        }

        public void CadastrarUsuario(Usuario usuario)
        {
            using (var scope = new TransactionScope())
            {
                using (var db = new SqlConnection(ConnectionString))
                {
                    try
                    {
                        const string sql = "INSERT INTO Usuario (nome, email, senha) VALUES('@p_nome', '@p_email', '@p_senha')";

                        var comando = new SqlCommand(sql, db);
                        comando.Parameters.Add(new SqlParameter("p_nome", usuario.Nome));
                        comando.Parameters.Add(new SqlParameter("p_email", usuario.Email));
                        comando.Parameters.Add(new SqlParameter("p_senha", usuario.Senha));

                        db.Open();

                        var linhasAfetadas = comando.ExecuteNonQuery();

                        if (linhasAfetadas != 1)
                        {
                            throw new Exception("Não foi possivel realizar o cadastro de usuarios.");
                        }

                        scope.Complete();
                    }
                    catch (Exception ex)
                    {
                        throw ex;
                    }
                }
            }
        }
    }
}

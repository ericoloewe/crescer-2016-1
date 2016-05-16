using LojaNinja.Dominio;
using System;
using System.Configuration;
using System.Data.SqlClient;
using System.Transactions;

namespace LojaNinja.Repositorio
{
    public class UsuarioRepositorioADO : IUsuarioRepositorio
    {
        private readonly string _stringConexao;
        public UsuarioRepositorioADO()
        {
            _stringConexao = ConfigurationManager.ConnectionStrings["LojaNinja"].ConnectionString;
        }
        
        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            string sql = "SELECT * FROM Usuarios WHERE email=@p_email and senha=@p_senha";
            using (var db = new SqlConnection(_stringConexao))
            {
                var comando = new SqlCommand(sql, db);
                comando.Parameters.Add(new SqlParameter("p_email", email));
                comando.Parameters.Add(new SqlParameter("p_senha", senha));

                db.Open();

                SqlDataReader leitor = comando.ExecuteReader();
                if(leitor.Read())
                    return new Usuario(int.Parse(leitor["id"].ToString()), leitor["nome"].ToString(), leitor["email"].ToString(), leitor["senha"].ToString());
            }
            throw new ArgumentException("Usuario não encontrado.");
        }
    }
}

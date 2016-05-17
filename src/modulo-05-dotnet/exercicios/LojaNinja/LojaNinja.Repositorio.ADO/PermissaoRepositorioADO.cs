using LojaNinja.Dominio;
using LojaNinja.Repositorio.Extensions;
using System;
using System.Data.SqlClient;
using System.Transactions;

namespace LojaNinja.Repositorio.ADO
{
    class PermissaoRepositorioADO : RepositorioBase, IPermissaoRepositorio
    {
        public PermissaoRepositorioADO()
        {
            VerificaExistenciaDasPermissoesBase();
        }

        private void VerificaExistenciaDasPermissoesBase()
        {
            try
            {
                BuscarPermissaoPorNome("COMUM");
            }
            catch (ArgumentException)
            {
                CadastrarPermissao(new Permissao("COMUM"));
            }
            try
            {
                BuscarPermissaoPorNome("ADMIN");
            }
            catch (ArgumentException)
            {
                CadastrarPermissao(new Permissao("ADMIN"));
            }
        }

        public void CadastrarPermissao(Permissao permissao)
        {
            using (var scope = new TransactionScope())
            {
                using (var db = new SqlConnection(ConnectionString))
                {
                    try
                    {
                        const string sql = "INSERT INTO Permissao (nome) VALUES (@p_nome)";

                        var comando = new SqlCommand(sql, db);
                        comando.Parameters.Add(new SqlParameter("p_nome", permissao.Nome));

                        db.Open();

                        var linhasAfetadas = comando.ExecuteNonQuery();

                        if (linhasAfetadas != 1)
                        {
                            throw new Exception("Não foi possivel realizar o cadastro da permissao.");
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

        public Permissao BuscarPermissaoPorNome(string nome)
        {
            const string sql = "SELECT * FROM Permissao WHERE nome=@p_nome";
            using (var db = new SqlConnection(ConnectionString))
            {
                var comando = new SqlCommand(sql, db);
                comando.Parameters.Add(new SqlParameter("p_nome", nome));

                db.Open();

                var leitor = comando.ExecuteReader();
                if (leitor.Read())
                    return new Permissao(leitor.ParseInt("id"), leitor["nome"].ToString());
            }
            throw new ArgumentException("Permissao não encontrada.");
        }
    }
}

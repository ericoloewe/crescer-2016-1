using System.Configuration;

namespace LojaNinja.Repositorio
{
    public abstract class RepositorioBase
    {
        public string ConnectionString => ConfigurationManager.ConnectionStrings["LojaNinja"].ConnectionString;
    }
}

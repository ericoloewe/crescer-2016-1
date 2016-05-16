namespace LojaNinja.Dominio
{
    public interface IUsuarioRepositorio
    {
        Usuario BuscarUsuarioPorAutenticacao(string email, string senha);
    }
}

namespace LojaNinja.Dominio
{
    public interface IUsuarioRepositorio
    {
        Usuario BuscarUsuarioPorAutenticacao(string email, string senha);
        void CadastrarUsuario(Usuario usuario);
        Usuario BuscarUsuarioPorId(int id);
    }
}

namespace LojaNinja.Dominio.Services
{
    public class UsuarioServico
    {
        private readonly IUsuarioRepositorio _usuarioRepositorio;

        public UsuarioServico(IUsuarioRepositorio usuarioRepositorio)
        {
            _usuarioRepositorio = usuarioRepositorio;
        }

        public void CadastrarUsuario(Usuario usuario)
        {
            usuario.CriptografarSenha();
            _usuarioRepositorio.CadastrarUsuario(usuario);
        }

        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            string senhaCriptografada = CriptografiaServico.Criptografar(senha);

            Usuario usuarioEncontrado = _usuarioRepositorio.BuscarUsuarioPorAutenticacao(email, senhaCriptografada);

            return usuarioEncontrado;
        }

        public Usuario BuscarUsuarioPorId(int id)
        {
            return _usuarioRepositorio.BuscarUsuarioPorId(id);
        }
    }
}

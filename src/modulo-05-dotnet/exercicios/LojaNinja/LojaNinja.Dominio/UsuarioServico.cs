using System.Security.Cryptography;
using System.Text;

namespace LojaNinja.Dominio
{
    public class UsuarioServico
    {
        private IUsuarioRepositorio _usuarioRepositorio;

        public UsuarioServico(IUsuarioRepositorio usuarioRepositorio)
        {
            _usuarioRepositorio = usuarioRepositorio;
        }

        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            string senhaCriptografada = Criptografar(senha);

            Usuario usuarioEncontrado = _usuarioRepositorio.BuscarUsuarioPorAutenticacao(email, senhaCriptografada);

            return usuarioEncontrado;
        }

        private string Criptografar(string texto)
        {
            using (MD5 md5Hash = MD5.Create())
            {
                byte[] data = md5Hash.ComputeHash(Encoding.UTF8.GetBytes(texto));
                StringBuilder sBuilder = new StringBuilder();

                for (int i = 0; i < data.Length; i++)
                {
                    sBuilder.Append(data[i].ToString("x2"));
                }

                return sBuilder.ToString();
            }
        }
    }
}

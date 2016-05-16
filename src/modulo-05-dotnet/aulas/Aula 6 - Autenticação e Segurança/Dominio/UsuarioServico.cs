using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace Dominio
{
    public class UsuarioServico
    {
        private IUsuarioRepositorio _usuarioRepositorio;

        // Nós sabemos que precisaremos buscar nosso usuário de um repositório,
        // Mas aqui, não nos interessa de onde ele vem, se vem do banco, se vem de um arquivo texto, etc.
        public UsuarioServico(IUsuarioRepositorio usuarioRepositorio)
        {
            _usuarioRepositorio = usuarioRepositorio;
        }

        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            // a senha por padrão está normal.
            // como no banco ela está criptografada, vamos criptografar ela e então comparar com a criptografada
            // no banco.
            string senhaCriptografada = Criptografar(senha);

            // você deve estar se perguntando por que diabos eu não uso direto o repositório ao invés de 
            // ter criado uma classe de serviço?
            // Bem, repositórios devem apenas buscar dados e guardar dados.
            // Aqui nós temos algo a mais, temos uma CRIPTOGRAFIA!
            // Criptografia não faz parte do repositório, por isso criamos essa classe intermediária.
            Usuario usuarioEncontrado = _usuarioRepositorio.BuscarUsuarioPorAutenticacao(email, senhaCriptografada);

            return usuarioEncontrado;
        }


        // Utilizamos este cara para criptografar um texto.
        // MD5 é muito simples e poderíamos utilizar SALT e etc, mas por hora, vamos simplificar.
        // No futuro, se precisarmos utilizar esse método em um outro lugar, devemos refatorar e
        // separá-lo em outra classe.
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

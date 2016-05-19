using CdZ.Dominio;
using CdZ.Repositorio.EF;

namespace CdZ.MVC.Services
{
    public static class ServicoInjecaoDeDependecia
    {
        public static IUsuarioRepositorio CriarUsuarioRepositorio()
        {
            return new UsuarioRepositorioEF();
        }

        public static ICavaleiroRepositorio CriarCavaleiroRepositorio()
        {
            return new CavaleiroRepositorioEF();
        }
    }
}
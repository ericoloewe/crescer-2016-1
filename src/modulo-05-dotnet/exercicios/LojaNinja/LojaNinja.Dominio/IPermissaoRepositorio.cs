namespace LojaNinja.Dominio
{
    public interface IPermissaoRepositorio
    {
        void CadastrarPermissao(Permissao permissao);
        Permissao BuscarPermissaoPorNome(string nome);
    }
}

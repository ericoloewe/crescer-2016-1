using System;

namespace CdZ.Dominio
{
    public class Local
    {
        public int Id { get; private set; }
        public string Texto { get; set; }

        /*
         * Precisamos deste construtor vazio por causa do Entity Framework.
         */
        // TODO: criar (View)Model para evitar mexer no domínio por necessidades de AJAX
        public Local() { }

        /// <summary>
        /// Usado na criação.
        /// </summary>
        public Local(string texto)
        {
            Texto = texto;
        }

        /// <summary>
        /// Usado para recuperar do repositório
        /// </summary>
        public Local(int id, string texto)
            : this(texto)
        {
            Id = id;
        }

        public void AtualizarId(int id)
        {
            if (Id != 0)
                throw new InvalidOperationException("Esse objeto já possuia Id, portanto ele já havia sido salvo no banco. Não é possível alterar esse valor.");

            Id = id;
        }
    }
}

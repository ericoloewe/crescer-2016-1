using System;

namespace CdZ.Dominio
{
    public class Imagem
    {
        public int Id { get; private set; }
        public string Url { get; private set; }
        public bool IsThumb { get; set; }

        /*
         * Precisamos deste construtor vazio por causa do Entity Framework.
         */
        private Imagem() { }

        /// <summary>
        /// Usado na criação.
        /// </summary>
        public Imagem(string url, bool isThumb)
        {
            Url = url;
            IsThumb = isThumb;
        }

        /// <summary>
        /// Usado para recuperar do repositório
        /// </summary>
        public Imagem(int id, string url, bool isThumb)
            : this(url, isThumb)
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

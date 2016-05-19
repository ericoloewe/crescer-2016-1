using System;

namespace CdZ.Dominio
{
    public class Golpe
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }

        /*
         * Precisamos deste construtor vazio por causa do Entity Framework.
         */
        private Golpe() { }

        /// <summary>
        /// Usado na criação.
        /// </summary>
        public Golpe(string nome)
        {
            Nome = nome;
        }

        /// <summary>
        /// Usado para recuperar do repositório
        /// </summary>
        public Golpe(int id, string nome)
            : this(nome)
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

using CdZ.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CdZ.Repositorio.EF
{
    /*
     * Esta é nossa representação do banco de dados.
     * Ela fará o meio de campo entre nossa aplicação e o banco de dados em si.
     */
    class ContextoDeDados : DbContext
    {
        /*
         * A classe deve saber onde está o banco de dados,
         * Então a classe DbContext precisa saber o nome da ConnectionString de acesso.
         */
        public ContextoDeDados() : base("ConexaoCdZ")
        {

        }

        /*
         * Aqui estão nossas tabelas. Todas as queries que executarmos serão feitas
         * através delas.
         */
        public DbSet<Usuario> Usuario { get; set; }
        public DbSet<Permissao> Permissao { get; set; }
        public DbSet<Cavaleiro> Cavaleiro { get; set; }

        /*
         * Fazemos um override neste método porque vamos adicionar comportamentos
         * fora do padrão.
         */
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            /*
             * Aqui estamos removendo a questão do entity framework de colocar
             * por padrão as tabelas no plural.
             */
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
            base.OnModelCreating(modelBuilder);
        }

    }
}

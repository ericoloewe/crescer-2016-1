using LojaNinja.Dominio;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;

namespace LojaNinja.Repositorio.EF
{
    class LojaNinjaContext : DbContext
    {
        public LojaNinjaContext() : base("LojaNinja")
        {
        }

        public DbSet<Usuario> Usuario { get; set; }
        public DbSet<Permissao> Permissao { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
            base.OnModelCreating(modelBuilder); 
        }
    }
}

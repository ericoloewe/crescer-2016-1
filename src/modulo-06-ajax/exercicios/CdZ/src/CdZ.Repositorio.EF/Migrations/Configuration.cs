namespace CdZ.Repositorio.EF.Migrations
{
    using Dominio;
    using System.Data.Entity.Migrations;

    internal sealed class Configuration : DbMigrationsConfiguration<CdZ.Repositorio.EF.ContextoDeDados>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = false;
        }

        protected override void Seed(CdZ.Repositorio.EF.ContextoDeDados context)
        {
            context.Cavaleiro.AddOrUpdate(
                p => p.Nome,
                new Cavaleiro("Seiya", 175, 143.65, new System.DateTime(1987, 11, 12), Signo.Sagitario, TipoSanguineo.B, new Local("Grécia"), new Local("Grécia"), new[] { new Golpe("Meteoro de Pegasus"), new Golpe("Centelha de Pegasus") }, new[] { new Imagem("http://fdata.over-blog.com/1/92/30/28/avatar-blog-1040706665-tmpphpTQzPov.jpg", true) })
            );

        }
    }
}

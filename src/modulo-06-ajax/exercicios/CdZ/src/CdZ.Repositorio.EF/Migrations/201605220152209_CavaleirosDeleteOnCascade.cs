namespace CdZ.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CavaleirosDeleteOnCascade : DbMigration
    {
        public override void Up()
        {
            Sql(@"
                truncate table [dbo].[Imagem]
                truncate table [dbo].[Golpe]
                delete [dbo].[Cavaleiro]
                delete [dbo].[Local]
            ");

            DropForeignKey("dbo.Golpe", "Cavaleiro_Id", "dbo.Cavaleiro");
            DropForeignKey("dbo.Imagem", "Cavaleiro_Id", "dbo.Cavaleiro");
            DropForeignKey("dbo.Cavaleiro", "LocalNascimento_Id", "dbo.Local");
            DropIndex("dbo.Cavaleiro", new[] { "LocalNascimento_Id" });
            DropIndex("dbo.Golpe", new[] { "Cavaleiro_Id" });
            DropIndex("dbo.Imagem", new[] { "Cavaleiro_Id" });
            AlterColumn("dbo.Cavaleiro", "LocalNascimento_Id", c => c.Int(nullable: false));
            AlterColumn("dbo.Golpe", "Cavaleiro_Id", c => c.Int(nullable: false));
            AlterColumn("dbo.Imagem", "Cavaleiro_Id", c => c.Int(nullable: false));
            CreateIndex("dbo.Cavaleiro", "LocalNascimento_Id");
            CreateIndex("dbo.Golpe", "Cavaleiro_Id");
            CreateIndex("dbo.Imagem", "Cavaleiro_Id");
            AddForeignKey("dbo.Golpe", "Cavaleiro_Id", "dbo.Cavaleiro", "Id", cascadeDelete: true);
            AddForeignKey("dbo.Imagem", "Cavaleiro_Id", "dbo.Cavaleiro", "Id", cascadeDelete: true);
            AddForeignKey("dbo.Cavaleiro", "LocalNascimento_Id", "dbo.Local", "Id", cascadeDelete: true);
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Cavaleiro", "LocalNascimento_Id", "dbo.Local");
            DropForeignKey("dbo.Imagem", "Cavaleiro_Id", "dbo.Cavaleiro");
            DropForeignKey("dbo.Golpe", "Cavaleiro_Id", "dbo.Cavaleiro");
            DropIndex("dbo.Imagem", new[] { "Cavaleiro_Id" });
            DropIndex("dbo.Golpe", new[] { "Cavaleiro_Id" });
            DropIndex("dbo.Cavaleiro", new[] { "LocalNascimento_Id" });
            AlterColumn("dbo.Imagem", "Cavaleiro_Id", c => c.Int());
            AlterColumn("dbo.Golpe", "Cavaleiro_Id", c => c.Int());
            AlterColumn("dbo.Cavaleiro", "LocalNascimento_Id", c => c.Int());
            CreateIndex("dbo.Imagem", "Cavaleiro_Id");
            CreateIndex("dbo.Golpe", "Cavaleiro_Id");
            CreateIndex("dbo.Cavaleiro", "LocalNascimento_Id");
            AddForeignKey("dbo.Cavaleiro", "LocalNascimento_Id", "dbo.Local", "Id");
            AddForeignKey("dbo.Imagem", "Cavaleiro_Id", "dbo.Cavaleiro", "Id");
            AddForeignKey("dbo.Golpe", "Cavaleiro_Id", "dbo.Cavaleiro", "Id");
        }
    }
}

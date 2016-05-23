namespace CdZ.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CascadeDeleteLocal : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Cavaleiro", "LocalNascimento_Id", "dbo.Local");
            DropIndex("dbo.Cavaleiro", new[] { "LocalNascimento_Id" });
            AlterColumn("dbo.Cavaleiro", "LocalNascimento_Id", c => c.Int());
            CreateIndex("dbo.Cavaleiro", "LocalNascimento_Id");
            AddForeignKey("dbo.Cavaleiro", "LocalNascimento_Id", "dbo.Local", "Id");
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Cavaleiro", "LocalNascimento_Id", "dbo.Local");
            DropIndex("dbo.Cavaleiro", new[] { "LocalNascimento_Id" });
            AlterColumn("dbo.Cavaleiro", "LocalNascimento_Id", c => c.Int(nullable: false));
            CreateIndex("dbo.Cavaleiro", "LocalNascimento_Id");
            AddForeignKey("dbo.Cavaleiro", "LocalNascimento_Id", "dbo.Local", "Id", cascadeDelete: true);
        }
    }
}

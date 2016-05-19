namespace CdZ.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;

    public partial class Inicial : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Cavaleiro",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Nome = c.String(),
                    AlturaCm = c.Double(nullable: false),
                    PesoLb = c.Double(nullable: false),
                    DataNascimento = c.DateTime(nullable: false),
                    Signo = c.Int(nullable: false),
                    TipoSanguineo = c.Int(nullable: false),
                    LocalNascimento_Id = c.Int(),
                    LocalTreinamento_Id = c.Int(),
                })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Local", t => t.LocalNascimento_Id)
                .ForeignKey("dbo.Local", t => t.LocalTreinamento_Id)
                .Index(t => t.LocalNascimento_Id)
                .Index(t => t.LocalTreinamento_Id);

            CreateTable(
                "dbo.Golpe",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Nome = c.String(),
                    Cavaleiro_Id = c.Int(),
                })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cavaleiro", t => t.Cavaleiro_Id)
                .Index(t => t.Cavaleiro_Id);

            CreateTable(
                "dbo.Imagem",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Url = c.String(),
                    IsThumb = c.Boolean(nullable: false),
                    Cavaleiro_Id = c.Int(),
                })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cavaleiro", t => t.Cavaleiro_Id)
                .Index(t => t.Cavaleiro_Id);

            CreateTable(
                "dbo.Local",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Texto = c.String(),
                })
                .PrimaryKey(t => t.Id);

            CreateTable(
                "dbo.Permissao",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Nome = c.String(),
                })
                .PrimaryKey(t => t.Id);

            CreateTable(
                "dbo.Usuario",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Email = c.String(),
                    Senha = c.String(),
                    Nome = c.String(),
                })
                .PrimaryKey(t => t.Id);

            CreateTable(
                "dbo.UsuarioPermissao",
                c => new
                {
                    Usuario_Id = c.Int(nullable: false),
                    Permissao_Id = c.Int(nullable: false),
                })
                .PrimaryKey(t => new { t.Usuario_Id, t.Permissao_Id })
                .ForeignKey("dbo.Usuario", t => t.Usuario_Id, cascadeDelete: true)
                .ForeignKey("dbo.Permissao", t => t.Permissao_Id, cascadeDelete: true)
                .Index(t => t.Usuario_Id)
                .Index(t => t.Permissao_Id);

            // Senha: admin123
            Sql(@"INSERT INTO Usuario 
                        (Email
                        ,Senha
                        ,Nome) 
                    VALUES 
                        ('saori@santuar.io'
                        ,'0192023a7bbd73250516f069df18b500'
                        ,'Saori Kido')
                  GO");

            Sql(@"INSERT INTO [dbo].[Permissao]
			                ([Nome])
		                VALUES
			                ('COMUM'),
			                ('ADMIN')
                GO");

            Sql(@"INSERT INTO [dbo].[UsuarioPermissao]
			                ([Usuario_Id]
			                ,[Permissao_Id])
		                VALUES
			                ((SELECT Id FROM Usuario WHERE Email = 'saori@santuar.io'),
			                 (SELECT Id FROM Permissao WHERE Nome = 'ADMIN'))
                GO");

        }

        public override void Down()
        {
            DropForeignKey("dbo.UsuarioPermissao", "Permissao_Id", "dbo.Permissao");
            DropForeignKey("dbo.UsuarioPermissao", "Usuario_Id", "dbo.Usuario");
            DropForeignKey("dbo.Cavaleiro", "LocalTreinamento_Id", "dbo.Local");
            DropForeignKey("dbo.Cavaleiro", "LocalNascimento_Id", "dbo.Local");
            DropForeignKey("dbo.Imagem", "Cavaleiro_Id", "dbo.Cavaleiro");
            DropForeignKey("dbo.Golpe", "Cavaleiro_Id", "dbo.Cavaleiro");
            DropIndex("dbo.UsuarioPermissao", new[] { "Permissao_Id" });
            DropIndex("dbo.UsuarioPermissao", new[] { "Usuario_Id" });
            DropIndex("dbo.Imagem", new[] { "Cavaleiro_Id" });
            DropIndex("dbo.Golpe", new[] { "Cavaleiro_Id" });
            DropIndex("dbo.Cavaleiro", new[] { "LocalTreinamento_Id" });
            DropIndex("dbo.Cavaleiro", new[] { "LocalNascimento_Id" });
            DropTable("dbo.UsuarioPermissao");
            DropTable("dbo.Usuario");
            DropTable("dbo.Permissao");
            DropTable("dbo.Local");
            DropTable("dbo.Imagem");
            DropTable("dbo.Golpe");
            DropTable("dbo.Cavaleiro");
        }
    }
}

-- Exe 01
BEGIN TRANSACTION
GO
	INSERT INTO Associado (IDAssociado, Nome, DataNascimento, CPF, Sexo) VALUES (3, 'Julio de Castilho', CONVERT(datetime, '14/12/1947', 103), 21234567895, 'M');
	INSERT INTO Associado (IDAssociado, Nome, DataNascimento, CPF, Sexo) VALUES (4, 'Antonio Augusto Borges de Medeiros', CONVERT(datetime, '19/03/1942', 103), 81234567891, 'M');
	INSERT INTO Associado (IDAssociado, Nome, DataNascimento, CPF, Sexo) VALUES (5, 'Osvaldo Aranha', CONVERT(datetime, '08/02/1958', 103), 01234567893, 'M');
COMMIT;

-- Exe 02
BEGIN TRANSACTION
GO
	SELECT * INTO CidadeAux FROM Cidade;
COMMIT;

-- Exe 03
BEGIN TRANSACTION
GO
	TRUNCATE TABLE CidadeAux;
	INSERT INTO CidadeAux (IDCidade, Nome, UF) SELECT * FROM Cidade;
COMMIT;

-- Exe 04
CREATE TABLE Produto (
	IDProduto      int Identity,
	Nome	       varchar(50)  not null,
	NomeDescritivo varchar(255) not null,
	DataCriacao    datetime     not null,
	LocalEstoque   varchar(50)  not null,
	Quantidade     int          not null,
	Preco          decimal(7,2) not null,

	constraint PK_Produto primary key (IDProduto)
)

-- Exe 05
BEGIN TRANSACTION
GO
	INSERT INTO Produto (Nome, NomeDescritivo, DataCriacao, LocalEstoque, Quantidade, Preco)
				 VALUES
					   ('Shot',
					   'Chocolate de Amendoim Shot',
					   CONVERT(datetime, '19/03/2016', 103),
					   'Central',
					   100,
					   4.5)
	INSERT INTO Produto (Nome, NomeDescritivo, DataCriacao, LocalEstoque, Quantidade, Preco)
				 VALUES
					   ('Cafe',
					   'Cafe Melita',
					   CONVERT(datetime, '19/02/2016', 103),
					   'Central',
					   1000,
					   4.5)
COMMIT;

SELECT * FROM Cidade;

SELECT * FROM CidadeAux;

SELECT * FROM Associado;
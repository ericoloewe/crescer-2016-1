-- Exe01
-- Retornar apenas o primeiro nome
Select LEFT(Nome, CHARINDEX(' ', Nome)) as PrimeiroNome
From Associado;

-- Exe02
-- Retornar nome e idade
Select Nome, (YEAR(GetDate()) - YEAR(DataNascimento)) as Idade
From Associado;

-- Exe03
-- Empregados admitidos entre 01/05/1980 e 20/01/1982 e o total de meses trabalhados até '31/12/2000'
Select *, (DATEDIFF(Month, DataAdmissao, convert(datetime, '31/12/2000', 103))) as MesesTrabalhados
From Empregado
Where DataAdmissao >= convert(datetime, '01/05/1980', 103)
	AND DataAdmissao <= convert(datetime, '20/01/1982', 103);

-- Exe04
-- Cargo com mais empregados
Select TOP(1) Cargo as CargoComMaisEmpregados
From Empregado
Group By Cargo
ORDER BY COUNT(1) DESC;

-- Exe06
-- Nome e data de quando completara 50 anos (listar dia da semana)
Select Nome, DataNascimento, 
		DateAdd(Year, 50, DataNascimento) as DataEmQueVaiFazerOuFez50, 
		DateName(WEEKDAY, DateAdd(Year, 50, DataNascimento)) as DiaDaSemanaEmQueVaiFazerOuFez50
From Associado;

-- Exe07
-- Quantidade de cidades por UF
Select UF, COUNT(1) as QuantidadeDeCidadePorEstado
From Cidade
Group By UF;

-- Exe08
-- Quantidade de cidades com mesmo nome e uf
Select UF, Nome, COUNT(1) as QuantidadeDeCidadeIguais
From Cidade
Group By UF, Nome
HAVING COUNT(1) > 1;

-- Exe09
-- Proximo ID a ser criado na tabela associado
Select MAX(IDAssociado) + 1 as ProximoID 
From Associado;

-- Exe10
-- Limpar CidadeAux
Truncate Table CidadeAux;
INSERT INTO CidadeAux 
	(Nome, IDCidade, UF)
		Select DISTINCT Nome, IDCidade, UF
		From Cidade;

-- Exe11
-- Limpar CidadeAux
Select UF, Nome, COUNT(1) as QuantidadeDeCidadeIguais
From Cidade
Group By UF, Nome
HAVING COUNT(1) > 1;

Begin Transaction
Go
Update Cidade
Set Nome = '*' + Nome
Where Exists
(
	Select 1 
	From Cidade cAux
	Where Nome = cAux.Nome
		And IDCidade = cAux.IDCidade
);

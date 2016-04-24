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
-- Alterar cidades duplicadas e acrescentar no inicio do nome um *
Begin Transaction
Go
Update Cidade
Set Nome = '*' + Nome
Where Nome In
(
	Select Nome
	From Cidade
	Group By UF, Nome
	HAVING COUNT(1) > 1
);
Commit;

Select * From Cidade;

-- Exe12
-- Listar associados mostrando o sexo por completo
Select Nome, Case 
			When Sexo = 'M'
				Then 'Masculino'
			When Sexo = 'F'
				Then 'Feminino'
			Else null
			End Sexo
From Associado;

-- Exe13
-- listar nome do empregado, salario e percentual descontado do imposto de renda, considerando:
-- Até R$ 1.164,00 = 0%
-- De R$ 1.164,00 a R$ 2.326,00 = 15%
-- Acima de R$ 2.326,00 = 27,5%.
Select NomeEmpregado, Salario, Case 
								When Salario < 1164
									Then '0%'
								When Salario >= 1164 and Salario < 2326
									Then '15%'
								Else '27,5%'
								End Percentual_A_Ser_Descontado
From Empregado;

-- Exe14
-- Listar associados mostrando o sexo por completo
Begin Transaction
Go
Delete From Cidade
Where Nome In
(
	Select c.Nome
	From Cidade c
	Left Join Associado a
	On c.IDCidade = a.IDCidade
	Where a.IDCidade Is Null
	Group By c.UF, c.Nome
	HAVING COUNT(1) > 1
)
AND
IDCidade Not In
(
	Select MIN(c.IDCidade)
	From Cidade c	
	Group By c.UF, c.Nome
	HAVING COUNT(1) > 1
);
Commit;

Select * From Cidade;

-- Exe15
-- Criar regra para não deixar add cidades repetidas
Alter Table Cidade
Add 
Constraint Nao_Repetir_Cidade 
UNIQUE(Nome, UF);
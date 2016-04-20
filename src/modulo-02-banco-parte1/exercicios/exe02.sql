-- Exe 01
Select NomeEmpregado as Nome
From Empregado
Order By DataAdmissao;

-- Exe 02
Select NomeEmpregado as Nome, Salario
From Empregado
Where Cargo = 'Atendente'
	OR Salario < 18500;

-- Exe 03
Select IDCidade as ID
From Cidade
Where Nome = 'Uberlândia';

-- Exe 04
Select IDCidade as ID, Nome
From Cidade
Where UF = 'RS';
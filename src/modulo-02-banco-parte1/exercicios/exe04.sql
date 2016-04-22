-- Exe01
-- selecionar o nome do empregado e o nome do departamento
Select e.NomeEmpregado, d.NomeDepartamento
From Empregado e
Inner Join Departamento d
On e.IDDepartamento = d.IDDepartamento;

-- Exe02
-- exibir nome do associado e sua cidade
Select a.Nome, c.Nome
From Associado a
Left Join Cidade c
On a.IDCidade = c.IDCidade;

-- Exe03
-- listar estados e total de cidade, onde a cidade não possui associado
Select c.UF, Count(c.Nome) as Total_Cidades
From Cidade c
Where c.IDCidade Not IN (
	Select cid.IDCidade
	From Cidade cid
	Inner Join Associado a
	On cid.IDCidade = a.IDCidade
)
Group By c.UF;

-- Exe04
-- listar nome do associado sua cidade e uma coluna que indique se a mesma é da região sul
Select a.Nome, c.Nome, 
	Case 
	when c.UF = 'RS' or c.UF = 'SC' or c.UF = 'PR'
		then '***'
	else null
End ehRegiaoSul
From Associado a
Left Join Cidade c
On a.IDCidade = c.IDCidade;

-- Exe04
-- listar nome do empregado, nome do gerente e o departamento de cada um
Select e.NomeEmpregado as Nome_Empregado,
	e.NomeEmpregado as Nome_Empregado
From Empregado e
Inner Join empregado g
On g.IDEmpregado = e.IDGerente;
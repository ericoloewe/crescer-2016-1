/*
 * Exe 01 - Liste os clientes e suas respectivas cidades.
 */
Select cl.IDCliente, cl.Nome, ci.Nome as NomeDaCidade, ci.UF 
From CLIENTE cl
Join CIDADE ci
On ci.IDCIDADE = cl.IDCIDADE;

/*
 * Exe 02 - Liste o total de pedidos realizados no mês de maio de 2016.
 */
Select COUNT(*)
From PEDIDO
Where TO_CHAR(DATAPEDIDO, 'YYYY') = '2016' and TO_CHAR(DATAPEDIDO, 'MM') = '05';

/*
 * Exe 03 - Liste todos os clientes que tenham o LTDA no nome ou razao social.
 */
 Select *
 From CLIENTE
 Where lower(RAZAOSOCIAL) like '%ltda%'
  or lower(NOME) like '%ltda%';
  
/*
 * Exe 04 - Crie (insira) um novo registro na tabela de Produto, com as seguintes informações:
 * Nome: Galocha Maragato
 * Preço de custo: 35.67
 * Preço de venda: 77.95
 * Situação: A
 */
 -- Ver tamanho dos produtos
SELECT MAX(IDPRODUTO)
FROM PRODUTO;
-- Criar sequencia para os produtos
CREATE SEQUENCE SQPRODUTO START WITH 8001;
-- Criando produto
Begin
  Insert Into 
  PRODUTO (IDPRODUTO, NOME, PRECOCUSTO, PRECOVENDA, SITUACAO) 
  VALUES (SQPRODUTO.nextval,'Galocha Maragato', 35.67, 77.95, 'A');
  COMMIT;
End;

/*
 * Exe 05 - Identifique e liste os produtos que não tiveram nenhum pedido, considere os relacionamentos no modelo de dados, pois não há relacionamento direto entre Produto e Pedido (será preciso relacionar PedidoItem).
 */
Select *
From PRODUTO p
Where p.IDPRODUTO Not In (
  Select prod.IDPRODUTO
  From PRODUTO prod
  Inner Join PEDIDOITEM pedit
  On pedit.IDPRODUTO = prod.IDPRODUTO
);

/*
 * Exe 06 - Liste todos os pedidos de um determinado cliente, considere que sempre que for executar esta consulta será informado o IDCliente como parâmetro. Deverão ser listados: Data do Pedido, Produto, Quantide, Valor Unitário, e valor total.
 */
Select ped.DATAPEDIDO, prod.NOME, pedit.QUANTIDADE, prod.PRECOVENDA as ValorUnitario, ped.VALORPEDIDO as ValorTotal
From Pedido ped
Inner Join PEDIDOITEM pedit
On ped.IDPEDIDO = pedit.IDPEDIDO
Inner Join PRODUTO prod
On pedit.IDPRODUTO = prod.IDPRODUTO
Where ped.IDCLIENTE = :pIDCLIENTE;

/*
 * Exe 07 - Faça uma consulta que receba um parâmetro sendo o IDProduto e liste a quantidade de itens na tabela PedidoItem com este IDProduto foram vendidos no último ano (desde janeiro/2016).
 */
Select SUM(nvl(pedit.QUANTIDADE, 0))
From PEDIDOITEM pedit
Inner Join PEDIDO ped
On pedit.IDPEDIDO = ped.IDPEDIDO
Where ped.DATAPEDIDO >= TO_DATE('2016-01', 'YYYY-MM')
AND pedit.IDPRODUTO = :pIDPRODUTO;

/*
 * Exe 08 - Utilizando de funções de agrupamento (aggregation function), faça uma consulta que liste agrupando por ano e mês a quantidade de pedidos comprados, a quantidade de produtos distintos comprados, o valor total dos pedidos, o menor valor de um pedido, o maior valor de um pedido e valor médio de um pedido.
 */
Select TO_CHAR(ped.DATAENTREGA, 'MM-YYYY') as ANO_MES, COUNT(distinct ped.IDPEDIDO), 
        COUNT(distinct pedit.IDPRODUTO), SUM(ped.VALORPEDIDO), MIN(ped.VALORPEDIDO), 
        MAX(ped.VALORPEDIDO), ROUND(AVG(ped.VALORPEDIDO), 2) as MEDIA
From PEDIDO ped
Inner Join PEDIDOITEM pedit
On pedit.IDPEDIDO = ped.IDPEDIDO
Group By TO_CHAR(ped.DATAENTREGA, 'MM-YYYY')
Order By ANO_MES;
/*
 * Exe 01
 */
Select cl.IDCliente, cl.Nome, ci.Nome as NomeDaCidade, ci.UF 
From CLIENTE cl
Join CIDADE ci
On ci.IDCIDADE = cl.IDCIDADE;

/*
 * Exe 02
 */
Select COUNT(*)
From PEDIDO
Where TO_CHAR(DATAPEDIDO, 'YYYY') = '2016' and TO_CHAR(DATAPEDIDO, 'MM') = '05';

/*
 * Exe 03
 */
 Select *
 From CLIENTE
 Where RAZAOSOCIAL like '%ltda%'
  or NOME like '%ltda%';
  
/*
 * Exe 04
 */
 -- Ver tamanho dos produtos
SELECT MAX(IDPRODUTO)
FROM PRODUTO;
-- Criar sequencia para os produtos
CREATE SEQUENCE SQPRODUTO START WITH 8001;
-- Criando produto
Begin;
Insert 
Into 
PRODUTO (IDPRODUTO, NOME, PRECOCUSTO, PRECOVENDA, SITUACAO) 
VALUES (SQPRODUTO.nextval,'Galocha Maragato', 35.67, 77.95, 'A');
COMMIT;
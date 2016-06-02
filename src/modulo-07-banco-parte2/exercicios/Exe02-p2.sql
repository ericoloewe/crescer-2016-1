/*
 *  1) Crie um procedimento que receba por parâmetro o IDPedido e atualize o valor do pedido conforme seus itens.
 *    - Valor unitário * Quantidade
 */

CREATE OR REPLACE PROCEDURE ATUALIZA_PEDIDO(pIDPEDIDO in PEDIDO.IDPEDIDO%Type) As
  vValorPedido PEDIDO.VALORPEDIDO%TYPE;
BEGIN
  --Buscando informações necessarias para atualizar os pedidos
  Select SUM(pedit.Quantidade) * SUM(prod.PRECOVENDA)
  Into vValorPedido
  From PedidoItem pedit
  Inner Join Produto prod
  On prod.IDPRODUTO = pedit.IDPRODUTO
  Where pedit.IDPEDIDO = pIDPEDIDO;
  --Atualizando preço
  Update Pedido
  Set ValorPedido = vValorPedido
  Where IDPEDIDO = pIDPEDIDO;
END;
-- Testes
Exec ATUALIZA_PEDIDO(:pIdPedido);
Select * From Pedido Where IDPEDIDO = :pIdPedido;

/*
 *  2) Crie uma função que receba por parâmetro o IDCliente e retorne a data do último pedido realizado pelo cliente.
 */

CREATE OR REPLACE FUNCTION DATA_ULTIMO_PEDIDO_CLIENTE (pIDCLIENTE in PEDIDO.IDCLIENTE%Type) RETURN PEDIDO.DATAPEDIDO%TYPE AS
vDataUltimoPedido PEDIDO.DATAPEDIDO%TYPE;
BEGIN
    Select max(ped.DataPedido)
    Into vDataUltimoPedido
    From Pedido ped
    Where ped.IDCLIENTE = pIDCLIENTE;
    
    Return vDataUltimoPedido;
END;

-- Testes
Select DATA_ULTIMO_PEDIDO_CLIENTE(:pIdCliente) From dual;

/*
 *  3) Crie uma função que receba por parâmetro o IDProduto e o período (mês e ano) e retorne a quantidade (total) desde produtos vendidos no período (considere todos os dias do mês).
 */
 
CREATE OR REPLACE FUNCTION PRODUTOS_VENDIDOS_NO_MES (pIDPRODUTO in PRODUTO.IDPRODUTO%Type, pPeriodo in VARCHAR2) RETURN PEDIDOITEM.QUANTIDADE%TYPE AS
vQuantidadeVendidaNoPeriodo PEDIDOITEM.QUANTIDADE%TYPE;
BEGIN
    Select Sum(pedit.QUANTIDADE)
    Into vQuantidadeVendidaNoPeriodo
    From PEDIDOITEM pedit
    Inner Join PEDIDO ped
    On ped.IDPEDIDO = pedit.IDPEDIDO
    WHERE  TO_CHAR(ped.DATAPEDIDO, 'mm/yyyy') = pPeriodo
      AND pedit.IDPRODUTO = pIDPRODUTO;
    
    Return vQuantidadeVendidaNoPeriodo;
END;

-- Testes
Select PRODUTOS_VENDIDOS_NO_MES(1, '01/2015') From dual;
/*
 *  1) Crie um procedimento que receba por par�metro o IDPedido e atualize o valor do pedido conforme seus itens.
 *    - Valor unit�rio * Quantidade
 */

CREATE OR REPLACE PROCEDURE ATUALIZA_PEDIDO(pIDPEDIDO in PEDIDO.IDPEDIDO%Type) As
  vValorPedido PEDIDO.VALORPEDIDO%TYPE;
BEGIN
  --Buscando informa��es necessarias para atualizar os pedidos
  Select SUM(pedit.Quantidade) * SUM(prod.PRECOVENDA)
  Into vValorPedido
  From PedidoItem pedit
  Inner Join Produto prod
  On prod.IDPRODUTO = pedit.IDPRODUTO
  Where pedit.IDPEDIDO = pIDPEDIDO;
  --Atualizando pre�o
  Update Pedido
  Set ValorPedido = vValorPedido
  Where IDPEDIDO = pIDPEDIDO;
END;
-- Testes
Exec ATUALIZA_PEDIDO(:pIdPedido);
Select * From Pedido Where IDPEDIDO = :pIdPedido;

/*
 *  2) Crie uma fun��o que receba por par�metro o IDCliente e retorne a data do �ltimo pedido realizado pelo cliente.
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
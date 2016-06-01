/*
 * 1) Fa�a um bloco PL/SQL que receba UM par�metro (em tempo de execu��o apenas): IDCliente, e ent�o pesquise nome do cliente e cidade (caso tenha), e outras informa��es referente a pedidos:
 *    - o Data da primeira compra (pedido) realizado;
 *    - o Data da �ltima compra realizada.
 *    - o Valor total dos pedidos, quantidade de pedidos e m�dia de valor dos pedidos.
 */

DECLARE
  vId CLIENTE.IDCliente%TYPE;
  vNome CLIENTE.Nome%TYPE;
  vCidade CIDADE.Nome%TYPE;
  vDataPrimeiraCompra PEDIDO.DATAPEDIDO%TYPE;
  vDataUtlimaCompra PEDIDO.DATAPEDIDO%TYPE;
  vValorTotalDosPedidos PEDIDO.VALORPEDIDO%TYPE;
  vMediaPedidos PEDIDO.VALORPEDIDO%TYPE;
  vQuantidadePedidos INTEGER;
BEGIN
  Select cli.IDCLIENTE, cli.Nome, cid.NOME
  Into vId, vNome, vCidade
  From Cliente cli
  Inner Join Cidade cid
  On cli.IDCIDADE = cid.IDCIDADE
  Where IDCliente = :p_IDCliente;
  
  Select Min(ped.DATAPEDIDO), Max(ped.DATAPEDIDO), Sum(ped.VALORPEDIDO), COUNT(1), AVG(ped.VALORPEDIDO)
  Into vDataPrimeiraCompra, vDataUtlimaCompra, vValorTotalDosPedidos, vQuantidadePedidos, vMediaPedidos
  From Pedido ped
  Where ped.IDCLIENTE = vId;
  
  DBMS_OUTPUT.PUT_LINE('Nome: ' || vNome);
  DBMS_OUTPUT.PUT_LINE('Cidade: ' || vCidade);
  DBMS_OUTPUT.PUT_LINE('Primeira compra feita em: ' || vDataPrimeiraCompra);
  DBMS_OUTPUT.PUT_LINE('Ultima compra feita em: ' || vDataUtlimaCompra);
  DBMS_OUTPUT.PUT_LINE('Valor total dos pedidos: ' || vValorTotalDosPedidos);
  DBMS_OUTPUT.PUT_LINE('Media: ' || vMediaPedidos);
  DBMS_OUTPUT.PUT_LINE('Total: ' || vQuantidadePedidos);
END;

/*
 * 2) Fa�a um bloco PL/SQL que receba DOIS par�metros (em tempo de execu��o apenas): nome e uf, verifique se j� existe um registro em Cidade para a combina��o, caso n�o exista fa�a um INSERT na tabela de Cidade.
 *    - o Utilize uma SEQUENCE para gerar o pr�ximo ID v�lido;
 *    - o Ignore o case sensitive na valida��o.
 *    - o Se j� existir a cidade+uf deve imprimir uma mensagem informando.
 */
 
DECLARE
  vNome CIDADE.NOME%TYPE;
  vUf CIDADE.UF%TYPE;
  vQuantidade INTEGER;
BEGIN
    vNome := :p_Nome;
    vUf := :p_UF;
    Select COUNT(1)
    Into vQuantidade
    From Cidade
    Where vNome = Nome
      And vUf = UF;
      
    If(vQuantidade > 0) Then
        DBMS_OUTPUT.PUT_LINE('Ja existe cidade com esse nome');
    Else
        Insert into Cidade (NOME, UF) Values (vNome, vUf);
        DBMS_OUTPUT.PUT_LINE('Cidade inserida com sucesso');
    End If;    
END;
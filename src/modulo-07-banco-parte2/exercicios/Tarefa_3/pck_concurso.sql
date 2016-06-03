create or replace package PCK_CONCURSO is

  -- Author  : ANDRENUNES
  -- Created : 03/06/2016 10:40:29
  -- Purpose : Gerar informações reference a cada concurso
  
  -- Public type declarations
  procedure geraProximoConcurso;
  procedure atualizaAcertadores;
  function SOMA_APOSTAS_CONCURSO(pIdConcurso in integer) return number;

end PCK_CONCURSO;

create or replace package body PCK_CONCURSO is

  -- Private type declarations
  function SOMA_APOSTAS_CONCURSO(pIdConcurso in integer) return number as
    vValorTotalArrecadado number(12, 2);
    
    begin
      select SUM(num_ap.NUMERO) * 0.453
      into vValorTotalArrecadado 
      from APOSTA ap
      inner join NUMERO_APOSTA num_ap
      on num_ap.IDAPOSTA = ap.IDAPOSTA
        where ap.IDCONCURSO = pIdConcurso;
      
      return vValorTotalArrecadado;
    end;
  
  /* Conforme especificacao deve gerar 1 registro na tabela concurso */
  procedure geraProximoConcurso as
       vMaiorIdConcurso CONCURSO.IDCONCURSO%TYPE;
       vValorTotalArrecadado number(12, 2);
       vDataNovoConcurso CONCURSO.DATA_SORTEIO%TYPE;
    begin
        vValorTotalArrecadado := 0;
        -- busca id do ultimo concurso
        select max(IDCONCURSO) into vMaiorIdConcurso from CONCURSO;
        
        -- busca o valor arrecadado do ultimo concurso
        select case ACUMULOU when 0 then 0 else PCK_CONCURSO.SOMA_APOSTAS_CONCURSO(IDCONCURSO) end
        into vValorTotalArrecadado
        from CONCURSO
        where IDCONCURSO = vMaiorIdConcurso;
        
        --busca a data do proximo sorte
        select case TO_CHAR(DATA_SORTEIO, 'D') when '4' then DATA_SORTEIO + 3 else DATA_SORTEIO + 4 end
        into vDataNovoConcurso
        from CONCURSO
        where IDCONCURSO = vMaiorIdConcurso;
        
        pck_megasena.salvaConcurso(vMaiorIdConcurso + 1, vDataNovoConcurso, vValorTotalArrecadado);
        
        --insert into concurso ...
        null; --> remover
    end;
  ----------------------------------------------------------------------
  /* Conforme especificacao deve atualizar a tabela de acertadores */    
  procedure atualizaAcertadores as
       -- variaveis       
    begin      
        --
        --insert into aposta_premiada ...
        null; --> remover
    end;
  ----------------------------------------------------------------------
  
begin
  -- Initialization
  null;
end PCK_CONCURSO;

exec PCK_CONCURSO.geraProximoConcurso;
Select * From concurso;
delete from concurso where idconcurso = 1825;
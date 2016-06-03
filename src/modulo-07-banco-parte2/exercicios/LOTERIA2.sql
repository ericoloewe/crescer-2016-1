create or replace type intArray AS VARRAY(15) of number;

create or replace function QUANTIDADE_DE_ACERTOS(pApostaId INTEGER) return integer as
 vAcertos integer;
 vExiste integer;
 CURSOR C_NumerosAposta is
    select NUMERO
    into vExiste
    from NUMERO_APOSTA
    where IDAPOSTA = pApostaId;
begin
  vAcertos := 0;
  
  for reg in C_NumerosAposta loop
    select count(1) into vExiste from dual
    where reg.NUMERO in (5, 10, 12, 22, 28, 48);
    if(vExiste > 0) then 
      vAcertos := vAcertos + 1; 
    end if;
  end loop;
  
  return vAcertos;
end;

create or replace function TEVE_GANHADOR(pConcursoId integer, pQuntidadeDeAcertosRequerida integer) return integer as
  vAcertos integer;
  CURSOR C_Apostas Is
  select QUANTIDADE_DE_ACERTOS(IDAPOSTA) as quantidade
  from APOSTA
  where IDCONCURSO = pConcursoId;
begin
  vAcertos := 0;
  
  for reg in C_Apostas loop
    if(reg.quantidade = pQuntidadeDeAcertosRequerida) then
      vAcertos := vAcertos + 1;
    end if;
  end loop;
  
  return vAcertos;
end;

--Quadra
select TEVE_GANHADOR(1816, 4) from dual;
--Quina
select TEVE_GANHADOR(1816, 5) from dual;
--Sena
select TEVE_GANHADOR(1816, 6) from dual;
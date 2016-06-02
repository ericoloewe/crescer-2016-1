--create or replace type MyArray AS VARRAY(15) of int;

create or replace function EXISTE_NUMERO_NA_APOSTA(pAposta MyArray, pNumero int) return int as
  vExiste integer;
  numero integer;
begin
    for i in 1 .. pAposta.count loop
      numero := pAposta(i);
      if(numero = pNumero) then
        vExiste := 1;
      end if;
    end loop;
    
    return vExiste;
end;

create or replace function QUANTIDADE_DE_ACERTOS(pAposta INTEGER) return integer as
 vAcertos integer;
 vExiste integer;
 vNumerosDaAposta MyArray;
begin
  vAcertos := 0;
  vNumerosDaAposta := MyArray(5, 10, 12, 22, 28, 48);
  
  for i in 1 .. vNumerosDaAposta.count loop
    select COUNT(1)
    into vExiste
    from ARQUIVO_APOSTA_A
    where APOSTA = pAposta
      and EXISTE_NUMERO_NA_APOSTA(MyArray(N1,N2,N3,N4,N5,N6), vNumerosDaAposta(i)) > 0;
    if(vExiste > 0) then 
      vAcertos := vAcertos + 1; 
    end if;
  end loop;
  
  return vAcertos;
end;

create or replace function TEVE_GANHADOR(pConcursoId INTEGER) return integer as
  vSena integer;
  vQuina integer;
  vQuadra integer;
  
  CURSOR C_Apostas Is
  select QUANTIDADE_DE_ACERTOS(APOSTA) as quantidade
  from ARQUIVO_APOSTA_A
  where CONCURSO = pConcursoId;
begin
  for reg in C_Apostas loop
    if(reg.quantidade = 4) then
      vQuadra := vQuadra + 1;
    elsif(reg.quantidade = 5) then
      vQuina := vQuina + 1;
    elsif(reg.quantidade = 6) then
      vSena := vSena + 1;
    end if;
  end loop;
  
  DBMS_OUTPUT.PUT_LINE('Sena: ' || vSena);
  DBMS_OUTPUT.PUT_LINE('Quina: ' || vQuina);
  DBMS_OUTPUT.PUT_LINE('Quadra ' || vQuadra);
  return vSena + vQuina + vQuadra;
end;

select TEVE_GANHADOR(1816) from dual;

select * from ARQUIVO_APOSTA_A;
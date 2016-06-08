/*
 *  
 */
select *
from
(
  select ci.UF, TO_CHAR(COUNT(distinct ap.IDAPOSTA), '999G999') as "Qtde Aposta", TO_CHAR(SUM(ap.VALOR), '999G999D99') as "Valor Arrecadado"
  from APOSTA ap
  inner join CIDADE ci
  on ap.IDCIDADE = ci.IDCIDADE
  where ap.IDCONCURSO = 1824
  group by ci.UF
  order by "Valor Arrecadado" desc
)
where rownum <= 5;
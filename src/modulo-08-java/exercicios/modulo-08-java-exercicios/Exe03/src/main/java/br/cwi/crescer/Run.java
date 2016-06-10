/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer;
 
import br.cwi.crescer.repositorio.File;
import br.cwi.crescer.util.MeuSQLUtils;

/**
 *
 * @author Érico de Souza Loewe
 */
public class Run {
    public static void main(String[] args) {
        MeuSQLUtils sqlUtils = new MeuSQLUtils();
        //sqlUtils.executarArquivoSql("teste.sql");
        //sqlUtils.executarQuerySql("select * from PESSOA").forEach(a -> {a.forEach((c, p) -> {System.out.format("| %s = %s |", c, p);}); System.out.println("");});
        sqlUtils.exportarParaArquivo("teste.csv", "PESSOA", "ID_PESSOA;NM_PESSOA");
    }
}

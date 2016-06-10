/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Érico de Souza Loewe
 */
public class ConnectionUtils {
    // Oracle Thin 
    // jdbc:oracle:thin:@<HOST>:<PORT>:<SID>
    // oracle.jdbc.driver.OracleDriver
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "CRESCER16";
    private static final String PASS = "CRESCER16";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

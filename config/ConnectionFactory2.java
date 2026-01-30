
package br.com.produto.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author VAGNERMELOPIRES
 */
public class ConnectionFactory2 {
    
    private static final String URL = "jdbc:mysql://localhost:3306/escoladao";
   
    private static final String USER = "root";
    
    private static final String PASS ="root";
    
    public static Connection getConnection() throws SQLException{
      
        return DriverManager.getConnection(URL,USER,PASS);
    }
    

}


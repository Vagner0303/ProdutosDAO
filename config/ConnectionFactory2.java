/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.produto.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Professor
 */

// Responsabilidade: apenas conectar no banco
public class ConnectionFactory2 {
    // endereço do banco 
    private static final String URL = "jdbc:mysql://localhost:3306/escoladao";
    // Usuário do MySQL
    private static final String USER = "root";
    // Senha do MySQL 
    private static final String PASS ="root";
    // Método que devolve uma conexão pronta
    public static Connection getConnection() throws SQLException{
        // Abre a conexão e retorna para quem chamou 
        return DriverManager.getConnection(URL,USER,PASS);
    }
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aluno.lab
 */
public class GerenciadorConexao {
     private static Connection conexao; // atributo de conexao

    public static Connection pegarConexao() throws SQLException{
        
        String url = "jdbc:mysql://127.0.0.1/db_banco"; // Para o java usar: JDBC
        String usuario = "root";
        String senha = "bancodedados";

        conexao = DriverManager.getConnection(url, usuario, senha); // Conexao com o banco atraves do Driver Java do MySql        
        return conexao;
    }
}

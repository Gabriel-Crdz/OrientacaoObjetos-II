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
        
        String url = "jdbc:postgresql://localhost:5432/db_banco"; // Para o java usar: JDBC
        String usuario = "postgres";
        String senha = "bancodedados";

        conexao = DriverManager.getConnection(url, usuario, senha); // Conexao com o banco atraves do Driver Java     
        return conexao;
    }
}

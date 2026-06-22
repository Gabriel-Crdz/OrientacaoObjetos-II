package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenciadorConexao {
    private static Connection conexao;

    public static Connection pegarConexao() throws ClassNotFoundException, SQLException{

        String url = "jdbc:mysql://127.0.0.1/db_mundo";
        // String url = "jdbc:postgresql://localhost:5432/db_mundo";

        String usuario = "root";
        String senha = "bancodedados";
        
        // Class.forName("org.postgresql.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexao = DriverManager.getConnection(
            url, usuario, senha);
        return conexao;
    }
}

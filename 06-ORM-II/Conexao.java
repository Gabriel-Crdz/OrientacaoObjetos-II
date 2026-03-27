import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static Connection conexao; // atributo de conexao

    public static Connection pegarConexao() throws SQLException{
        
        String url = "jdbc:mysql://127.0.0.1/db_locadora"; // Para o java usar: JDBC
        String usuario = "root";
        String senha = "bancodedados";

        conexao = DriverManager.getConnection(url, usuario, senha); // Conexao com o banco atraves do Driver Java do MySql        
        return conexao;
    }
}

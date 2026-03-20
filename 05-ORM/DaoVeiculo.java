import java.sql.Statement;
import java.sql.Connection;

public class DaoVeiculo {
    private Connection conn;
    private Statement st;

    private void conectar(){
        try{
            this.conn = Conexao.pegarConexao(); // Puxa a conexão
            this.st = conn.createStatement(); // Statement: uma ponte, convertendo objetos da aplicação em instruções SQL
        }
        catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void desconectar(){
        try{
            this.st.close(); // Encerra a comunicação
            this.conn.close(); // Encerra a conexão
        }
        catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public boolean inserir(Veiculo v){
        boolean resultado = false;
        try{
            this.conectar();
            /* Comando a ser executado */
            String sql = "INSERT INTO veiculos VALUES(" + 
            "null, '" 
            + v.getMarca() + "', '" 
            + v.getModelo() + "', " + "'" 
            + v.getChassi() + "', " 
            + v.getAno() + ");"; 

            System.out.println(sql);
            st.executeUpdate(sql); // Executa o comando no banco de dados
            resultado = true;
        }
        catch(Exception e){
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
        finally{
            this.desconectar();
        }

        return resultado;
    }
    
}

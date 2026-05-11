package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DaoCartao {
    private Connection conn;
    private Statement st;

    /* Metodos de conexão com o banco */
    private void conectar(){
        try{
            this.conn = GerenciadorConexao.pegarConexao(); // Puxa a conexão
            this.st = conn.createStatement(); // Statement: uma ponte, convertendo objetos da aplicação em instruções SQL
        }
        catch(SQLException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void desconectar(){
        try{
            this.st.close(); // Encerra a comunicação
            this.conn.close(); // Encerra a conexão
        }
        catch(SQLException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    public ArrayList<Cartao> listarTodos(){
        ArrayList<Cartao> resultado = new ArrayList<>();
        
        try{
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM cartao ORDER BY nome_titular ASC");

            while(rs.next()){ //Vai um por um até o proximo ser vazio, *não dá null pointer
                Cartao c = new Cartao(); //Dentro do objeto cartão, ele seta os valores seguinda as tabelas do banco de dados.

                c.setCodigo(rs.getInt("codigo"));
                c.setNumCartao(rs.getString("num_cartao"));
                c.setNomeTitular(rs.getString("nome_titular")); //Tem que ser exatamente o nome que está no banco.
                c.setAgencia(rs.getString("agencia"));
                c.setBandeira(rs.getString("bandeira"));
                c.setCvv(rs.getString("cvv"));
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                
                LocalDate data = rs.getDate("data_validade").toLocalDate(); // toLocalDate = converte o Date(banco de dados) para o LocalDate(java)
                
                String dataFormatada = data.format(formato);
                
                c.setDataValidade(dataFormatada); 
                c.setLimiteTotal(rs.getDouble("limite_total"));
                c.setFaturaAtual(rs.getDouble("fatura_atual"));

                resultado.add(c); //Coloca o Objeto "c" pre-setado dentro de um arraylist.
            }
        }
        catch (SQLException e) {
            System.out.println("Erro ao buscar os registros: " + e.getMessage());        
        } finally{
            this.desconectar();
        }

        return resultado;
    }
    
    public ArrayList<Cartao> filtrarTodos(String campo, String filtro){
        ArrayList<Cartao> resultado = new ArrayList<>();
        
        if(!campo.equals("num_cartao") && !campo.equals("nome_titular") && !campo.equals("agencia") && !campo.equals("bandeira")){
            return resultado;
        }
        
        try{
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM cartao WHERE " + campo + " LIKE '%" + filtro + "%' ORDER BY nome_titular ASC;");

            while(rs.next()){ //Vai um por um até o proximo ser vazio, *não dá null pointer
                Cartao c = new Cartao(); //Dentro do objeto cartão, ele seta os valores seguinda as tabelas do banco de dados.

                c.setCodigo(rs.getInt("codigo"));
                c.setNumCartao(rs.getString("num_cartao"));
                c.setNomeTitular(rs.getString("nome_titular")); //Tem que ser exatamente o nome que está no banco.
                c.setAgencia(rs.getString("agencia"));
                c.setBandeira(rs.getString("bandeira"));
                c.setCvv(rs.getString("cvv"));
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                
                LocalDate data = rs.getDate("data_validade").toLocalDate(); // toLocalDate = converte o Date(banco de dados) para o LocalDate(java)
                
                String dataFormatada = data.format(formato);
                
                c.setDataValidade(dataFormatada); 
                c.setLimiteTotal(rs.getDouble("limite_total"));
                c.setFaturaAtual(rs.getDouble("fatura_atual"));

                resultado.add(c); //Coloca o Objeto "c" pre-setado dentro de um arraylist.
            }
        }
        catch (SQLException e) {
            System.out.println("Erro ao buscar os registros: " + e.getMessage());        
        } finally{
            this.desconectar();
        }

        return resultado;
    }
    
    public boolean inserir(Cartao c){
        boolean resultado = false;

        try {
            this.conectar();
            String comando = "INSERT INTO cartao VALUES (" + "DEFAULT, '"
            + c.getNumCartao() + "', '"
            + c.getNomeTitular() + "', '"
            + c.getAgencia() + "', '"
            + c.getBandeira() + "', '"
            + c.getCvv() + "', '"
            + Date.valueOf(c.getDataValidade()) + "', " // Date.valueOf: Converte LocalDate(java) para Date(sql)
            + c.getLimiteTotal() + ", "
            + c.getFaturaAtual() + ");";

            // System.out.println(comando);

            st.executeUpdate(comando);
            resultado = true;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir registro: " + e.getMessage());
        
        } finally{
            this.desconectar();
        }

        return resultado;
    }

    public int alterar(Cartao c){
        int qtde = 0;
        try {
            this.conectar();
            String comando = "UPDATE cartao SET "
            + "num_cartao = '" + c.getNumCartao() + "', "
            + "nome_titular = '" + c.getNomeTitular() + "', "
            + "agencia = '" + c.getAgencia() + "', "
            + "bandeira = '" + c.getBandeira() + "', " 
            + "cvv = '" + c.getCvv() + "', "
            + "data_validade = '" + c.getDataValidade() + "', "
            + "limite_total = " + c.getLimiteTotal() + ", "
            + "fatura_atual = " + c.getFaturaAtual()
            + " WHERE codigo = " + c.getCodigo() + ";";

            // System.out.println(comando);
            st.executeUpdate(comando);
            qtde = st.getUpdateCount();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir registro: " + e.getMessage());
        
        } finally{
            this.desconectar();
        }

        return qtde;
    } 

    public int excluir(int cod){
        int qtde = 0;

        try {
            this.conectar();
            String comando = "DELETE FROM cartao WHERE codigo = " + cod + ";";
            st.execute(comando);
            
            qtde = st.getUpdateCount();

        } catch (SQLException e) {
            System.out.println("Erro ao deletar registro: " + e.getMessage());
        
        } finally{
            this.desconectar();
        }

        return qtde;
    }
}

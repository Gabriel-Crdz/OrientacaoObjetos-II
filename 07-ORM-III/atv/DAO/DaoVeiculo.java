package DAO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Veiculo;
import util.Conexao;

public class DaoVeiculo{
    private Connection conn;
    private Statement st;

    /* Metodos de acesso ao banco */
    private void conectar() {
        try {
            this.conn = Conexao.pegarConexao();
            this.st = conn.createStatement();
        } catch (Exception e1) {
            System.out.println("Erro: " + e1.getMessage());
        }
    }

    private void desconectar() {
        try {
            this.st.close();
            this.conn.close();
        } catch (Exception e1) {
            System.out.println("Erro: " + e1.getMessage());
        }
    }

    /* Metodos do CRUD */
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

            // System.out.println(sql); // Verificação se o sql esta correto
            st.executeUpdate(sql); // Executa o comando no banco de dados
            resultado = true; // retorna true
        }
        catch(Exception e){
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
        finally{
            this.desconectar(); // Por fim encerra a conexão com o banco de dados
        }

        return resultado;
    }

    public Veiculo consultar(int cod){
        Veiculo v = null;

        try{
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM veiculos WHERE codigo = " + cod + ";");
            while(rs.next()){ // Passa por cada item e faz o ORM
                v = new Veiculo();
                v.setCodigo(rs.getInt("codigo"));
                v.setMarca(rs.getString("marca")); // Para pegar os valores usa-se o nome do atributo no banco
                v.setModelo(rs.getString("modelo"));
                v.setChassi(rs.getString("chassi"));
                v.setAno(rs.getInt("ano"));
            }
        }catch(Exception e){
            System.out.println("ERRO:" + e.getMessage());
        }
        finally{
            this.desconectar();
        }

        return v;
    }

    public int alterar(Veiculo v){
        int qtd = 0;
        try{
            this.conectar();
            /* Comando a ser executado */
            String sql = "UPDATE veiculos SET " +
            "marca = '" + v.getMarca() + "', " +
            "modelo = '" + v.getModelo() + "', " +
            "chassi = '" + v.getChassi() + "', " +
            "ano = '" + v.getAno() +
            "' WHERE codigo = " + v.getCodigo() + ";"; 

            // System.out.println(sql); // Verificação se o sql esta correto
            st.executeUpdate(sql); // Executa o comando no banco de dados
            qtd = st.getUpdateCount(); // retorna o numero de atualizações
        }
        catch(Exception e){
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
        finally{
            this.desconectar(); // Por fim encerra a conexão com o banco de dados
        }

        return qtd;
    }

    public int excluir(int cod){
        int qtd = 0;

        try{
            this.conectar();
            String sql = "DELETE FROM veiculos WHERE codigo =" + cod + ";";
            st.executeUpdate(sql);
            qtd = st.getUpdateCount(); // Caso uma alteração aconteça ele retornara a quantidade de modificações(nesse caso 1)
        }
        catch(Exception e){
            System.out.println("ERRO" + e.getMessage());
        }
        finally{
            this.desconectar();
        }
        return qtd;
    }

    public ArrayList<Veiculo> listarTodos(){
        ArrayList<Veiculo> resultados = new ArrayList<Veiculo>();

        try{
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT *FROM veiculos ORDER BY modelo"); // ResultSet: armazena os dados vindos do banco de dados, em formato de tabela
            while(rs.next()){ // Passa por cada item e faz o ORM
                Veiculo v = new Veiculo();
                v.setCodigo(rs.getInt("codigo"));
                v.setMarca(rs.getString("marca")); // Para pegar os valores usa-se o nome do atributo no banco
                v.setModelo(rs.getString("modelo"));
                v.setChassi(rs.getString("chassi"));
                v.setAno(rs.getInt("ano"));

                resultados.add(v); // Adiciona o objeto na lista
            }
        }catch(Exception e){
            System.out.println("ERRO:" + e.getMessage());
        }
        finally{
            this.desconectar();
        }

        return resultados;
    }
    
}

package DAO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Vendedor;
import util.Conexao;

public class DaoVendedor {
    private Connection conn;
    private Statement st;

    private void conectar() { // método para conectar ao banco
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

    public boolean inserir(Vendedor v){
        boolean resultado = false;
        try{
            this.conectar();
            String sql = "INSERT INTO vendedores VALUES(" 
            + "null, '"
            + v.getCodigo() + "', '"
            + v.getNome() + "', '"
            + v.getContato() + "', '"
            + v.getSalarioBase() + "', '"
            + v.getAnoAdmissao() + "', '"
            + v.getCargo() + "');"; 

            System.out.println(sql);
            st.executeQuery(sql);
            resultado = true;
        }
        catch(Exception e){
            System.out.println("ERRO AO INSERIR: " + e.getMessage());
        }
        finally{
            this.desconectar();
        }
        return resultado;
    }

    public Vendedor consultar(int cod) {
        Vendedor v = null;

        try{
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM vendedor WHERE codigo = " + cod + ";");
            while(rs.next()){
                v = new Vendedor();
                v.setCodigo(rs.getInt("codigo"));
                v.setNome(rs.getString("nome"));
                v.setContato(rs.getString("contato"));
                v.setCargo(rs.getString("cargo"));
                v.setAnoAdmissao(rs.getInt("anoAdmissao"));
                v.setSalarioBase(rs.getFloat("salarioBase"));
            }
        }
        catch(Exception e){
            System.out.println("ERRO: " + e.getMessage());
        }
        finally{
            this.desconectar();
        }
        
        return v;
    }

    public int alterar(Vendedor v){
        int qtd = 0;
        try{
            this.conectar();
            String sql = "UPDATE vendedores SET " 
            + " nome = '" + v.getNome() + "', "
            + " contato = '" + v.getContato() + "', "
            + " cargo = '" +v.getCargo() + "', "
            + " anoAdmissao = '" + v.getAnoAdmissao() + "', "
            + " salarioBase = '" + v.getSalarioBase() + "', "
            + " WHERE codigo = " + v.getCodigo() + ";";

            System.out.println(sql);
            st.executeUpdate(sql);
            qtd = st.getUpdateCount();
        }
        catch(Exception e){
            System.out.println("ERRO AO ATUALIZAR: " + e.getMessage());
        }
        finally{
            this.desconectar(); // Por fim encerra a conexão com o banco de dados
        }

        return qtd;
    }

    public int excluir(int cod) {
        int qtd = 0;

        try{
            this.conectar();
            String sql = "DELETE FROM vendedores WHERE codigo = " + cod + ";";
            st.executeUpdate(sql);
            qtd = st.getUpdateCount(); // Caso uma alteração aconteça ele retornara a quantidade de modificações(nesse caso 1)
        }
        catch(Exception e){
            System.out.println("ERRO: " + e.getMessage());
        }
        finally{
            this.desconectar();
        }
        return qtd;
    }

    public ArrayList<Vendedor> listarTodos() {
        ArrayList<Vendedor> resultados = new ArrayList<Vendedor>();
        try{
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM vendedor ORDER BY nome");
            while(rs.next()){
                Vendedor v = new Vendedor();
                v.setCodigo(rs.getInt("codigo"));
                v.setNome(rs.getString("nome"));
                v.setContato(rs.getString("contato"));
                v.setCargo(rs.getString("cargo"));
                v.setAnoAdmissao(rs.getInt("anoAdmissao"));
                v.setSalarioBase(rs.getFloat("salarioBase"));

                resultados.add(v);
            }
        }
        catch(Exception e){
            System.out.println("ERRO: " + e.getMessage());
        }
        finally{
            this.desconectar();
        }

        return resultados;
    }
}

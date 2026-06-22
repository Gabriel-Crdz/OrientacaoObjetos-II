package DAO;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import util.GerenciadorConexao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class DaoGenerico {
    private Connection conn;
    private Statement st;

    private final String TB_PREFIX = "tb_";

    private void conectar(){
        try {
            this.conn = GerenciadorConexao.pegarConexao();
            this.st = conn.createStatement();
        } catch (ClassNotFoundException e1) {
            System.out.println("\nERRO: " + e1.getMessage());
        }catch(SQLException e2){
            System.out.println("\nERRO: " + e2.getMessage());
        }
    }

    private void desconectar(){
        try {
            st.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("\nERRO: " + e.getMessage());
        }
    }

    public void inserir(Object obj){

        Class<?> c = obj.getClass();
        Field fields[] = c.getDeclaredFields();

        try{

            /* Montando a query para o prepares statement */
            String query ="INSERT INTO " + TB_PREFIX + c.getSimpleName().toLowerCase();

            String campos = "("; // Inicia cada parte do camando SQL
            String aliases = " VALUES(";

            boolean separar = false;

            for (Field f : fields) {
                if(separar){ // Separação dos campos na string
                    campos += ", ";
                    aliases += ", ";
                }

                campos += f.getName(); // Insere o nome
                aliases += "?"; // Para cada nome deve ter uma interrogação(prepare statement)
                separar = true;
            }
            campos += ")"; // Fecha a area dos campos e dos aliases
            aliases += ");";

            query += campos + aliases; // Concatena para o comando SQL completo
            // System.out.println(query);

            /* Setando os valores para o prepare statement */
            this.conectar(); // Inicia a conexão
            PreparedStatement pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            int numParam = 0;

            for( Field f: fields){
                numParam++;
                f.setAccessible(true); // Torna os atributos acessiveis

                if(f.getType().isEnum()) {
                    if(f.get(obj) != null) {
                        pst.setString(numParam, ((Enum<?>) f.get(obj)).name());
                    }
                    else{
                        pst.setString(numParam, null);
                    }
                }
                else if(f.getType().isAssignableFrom(String.class)){ // Valida se o atributo e do tipo String
                    if(f.get(obj) != null){
                        pst.setString(numParam, f.get(obj).toString()); // Se não for nulo, salva o valor
                    }   
                    else{
                        pst.setString(numParam, ""); // Se não salva um valor vazio
                    }
                }
                else if(f.getType().isAssignableFrom(Integer.class) || f.getType().isAssignableFrom(Integer.TYPE)){
                    pst.setInt(numParam, Integer.parseInt(f.get(obj).toString()));
                }
                else if(f.getType().isAssignableFrom(Float.class) || f.getType().isAssignableFrom(Float.TYPE)) {
                    pst.setFloat(numParam, Float.valueOf(f.get(obj).toString()));
                }
                else if(f.getType().isAssignableFrom(Boolean.class) || f.getType().isAssignableFrom(Boolean.TYPE)){
                    pst.setBoolean(numParam, Boolean.valueOf(f.get(obj).toString()));
                }
                else if(f.getType().isAssignableFrom(LocalDate.class)){
                    if(f.get(obj) != null){
                        pst.setDate(numParam, Date.valueOf(f.get(obj).toString())); // Se não for nulo, salva o valor
                    }   
                    else{
                        pst.setString(numParam, null); // Se não salva um valor vazio
                    }
                }
            }

            pst.executeUpdate();
        }
        catch(Exception e){
            System.out.println("\nERRO: " + e.getMessage());
            System.out.println("Linha: " + e.getStackTrace()[0].getLineNumber());
        }
        finally{
            this.desconectar();
        }
    }

    /*
        O <T> avisa ao compilador que o tipo que entrar no parametro class<T> será o mesmo tipo retornado no ArrayList<T>
        O <T> serve apenas para indicar o tipo, poderia ser outra coisa no lugar
    */
    public <T> ArrayList<T> buscarTodos(Class<T> c){
        ArrayList<T> resultados = new ArrayList<>();

        Field fields[] = c.getDeclaredFields();

        try {
            this.conectar();
            ResultSet rs = st.executeQuery(
                "SELECT * FROM " +  TB_PREFIX + c.getSimpleName().toLowerCase() + ";");
            while(rs.next()){
                T objRet = c.getConstructor().newInstance(); // Instancia um objeto da classe

                for (Field f : fields) {
                    f.setAccessible(true);

                    if(f.getType().isAssignableFrom(String.class)){ 
                        f.set(objRet, rs.getString(f.getName().toString()));
                    }
                    else if(f.getType().isAssignableFrom(Integer.class) || f.getType().isAssignableFrom(Integer.TYPE)){
                        f.set(objRet, rs.getInt(f.getName().toString()));
                    }
                    else if(f.getType().isAssignableFrom(Float.class) || f.getType().isAssignableFrom(Float.TYPE)) {
                        f.set(objRet, rs.getFloat(f.getName().toString()));
                    }
                    else if(f.getType().isAssignableFrom(Boolean.class) || f.getType().isAssignableFrom(Boolean.TYPE)){
                        f.set(objRet, rs.getBoolean(f.getName().toString()));
                    }
                    else if(f.getType().isAssignableFrom(LocalDate.class)){
                        f.set(objRet, rs.getDate(f.getName().toString()).toLocalDate());
                    }
                    else if (f.getType().isEnum()) {
                        String valor = rs.getString(f.getName());

                        if (valor != null) {
                            Object enumValor = Enum.valueOf((Class<Enum>) f.getType(), valor);

                            f.set(objRet, enumValor);
                        }
                    }
                }
                resultados.add(objRet);
            }
        } catch (Exception e) {
            System.out.println("\nERRO: " + e.getMessage());
            System.out.println("Linha: " + e.getStackTrace()[0].getLineNumber());
        }finally{
            this.desconectar();
        }
        return resultados;
    }

    public <T> ArrayList<T> buscarTodosFiltro(Class<T> c, String campo, String filtro){
        ArrayList<T> resultados = new ArrayList<>();

        Field fields[] = c.getDeclaredFields();

        try {
            this.conectar();
            ResultSet rs = st.executeQuery(
                "SELECT * FROM " +  TB_PREFIX + c.getSimpleName().toLowerCase() + 
                " WHERE " + campo + " LIKE '%" + filtro + "%' ORDER BY " + campo + ";");
            while(rs.next()){
                T objRet = c.getConstructor().newInstance(); // Instancia um objeto da classe

                for (Field f : fields) {
                    f.setAccessible(true);
                    
                    if(f.getType().isAssignableFrom(String.class)){ 
                        f.set(objRet, rs.getString(f.getName().toString()));
                    }
                    else if(f.getType().isAssignableFrom(Integer.class) || f.getType().isAssignableFrom(Integer.TYPE)){
                        f.set(objRet, rs.getInt(f.getName().toString()));
                    }
                    else if(f.getType().isAssignableFrom(Float.class) || f.getType().isAssignableFrom(Float.TYPE)) {
                        f.set(objRet, rs.getFloat(f.getName().toString()));
                    }
                    else if(f.getType().isAssignableFrom(Boolean.class) || f.getType().isAssignableFrom(Boolean.TYPE)){
                        f.set(objRet, rs.getBoolean(f.getName().toString()));
                    }
                    else if(f.getType().isAssignableFrom(LocalDate.class)){
                        f.set(objRet, rs.getDate(f.getName().toString()).toLocalDate());
                    }
                    else if (f.getType().isEnum()) {
                        String valor = rs.getString(f.getName());

                        if (valor != null) {
                            Object enumValor = Enum.valueOf((Class<Enum>) f.getType(),valor);

                            f.set(objRet, enumValor);
                        }
                    }
                }
                resultados.add(objRet);
            }
        } catch (Exception e) {
            System.out.println("\nERRO: " + e.getMessage());
            System.out.println("Linha: " + e.getStackTrace()[0].getLineNumber());
        }finally{
            this.desconectar();
        }
        return resultados;
    }

    public <T> T consultar(Class<T> c, String campo, String filtro){
        T objRet = null; // Declara o objeto de retorno como nulo

        Field fields[] = c.getDeclaredFields();

        try {
            this.conectar();
            ResultSet rs = st.executeQuery(
                "SELECT * FROM " +  TB_PREFIX + c.getSimpleName().toLowerCase() + " WHERE " + campo + " = " + filtro + ";");
            while(rs.next()){
                objRet = c.getConstructor().newInstance(); // Instancia um objeto da classe, caso exista

                for (Field f : fields) {
                    f.setAccessible(true);
                    
                    if(f.getType().isAssignableFrom(String.class)){ 
                        f.set(objRet, rs.getString(f.getName().toString()));
                    }
                    else if(f.getType().isAssignableFrom(Integer.class) || f.getType().isAssignableFrom(Integer.TYPE)){
                        f.set(objRet, rs.getInt(f.getName().toString()));
                    }
                    else if(f.getType().isAssignableFrom(Float.class) || f.getType().isAssignableFrom(Float.TYPE)) {
                        f.set(objRet, rs.getFloat(f.getName().toString()));
                    }
                    else if(f.getType().isAssignableFrom(Boolean.class) || f.getType().isAssignableFrom(Boolean.TYPE)){
                        f.set(objRet, rs.getBoolean(f.getName().toString()));
                    }
                    else if(f.getType().isAssignableFrom(LocalDate.class)){
                        f.set(objRet, rs.getDate(f.getName().toString()).toLocalDate());
                    }
                    else if (f.getType().isEnum()) {
                        String valor = rs.getString(f.getName());

                        if (valor != null) {
                            Object enumValor = Enum.valueOf((Class<Enum>) f.getType(), valor);

                            f.set(objRet, enumValor);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("\nERRO: " + e.getMessage());
            System.out.println("Linha: " + e.getStackTrace()[0].getLineNumber());
        }finally{
            this.desconectar();
        }
        return objRet;
    }

    public int alterar(Object obj, String chave, int id){
        Class<?> c = obj.getClass();
        
        Field fields[] = c.getDeclaredFields();
        String comando = " UPDATE " + TB_PREFIX + c.getSimpleName().toLowerCase() + " SET ";

        boolean separar = false;
        for (Field f : fields) {
            if(!f.getName().equals(chave)){
                if (separar) {
                    comando += ", ";
                }
                separar = true;
                comando += f.getName() + " = ?";
            }
        }

        comando += " WHERE " + chave + " = " + id;
        // System.out.println("Query: " + comando);
        // System.exit(9);

        int qtde = 0;
        try{
            this.conectar();

            PreparedStatement pst = conn.prepareStatement(comando, Statement.RETURN_GENERATED_KEYS);

            /* Setando os valores */
            int numParam = 0;
            for (Field f : fields) {
                if(!f.getName().equals(chave)){
                    numParam++;
                    f.setAccessible(true);
                    if(f.getType().isAssignableFrom(String.class)){ // Valida se o atributo e do tipo String
                        if(f.get(obj) != null){
                            pst.setString(numParam, f.get(obj).toString()); // Se não for nulo, salva o valor
                        }   
                        else{
                            pst.setString(numParam, ""); // Se não salva um valor vazio
                        }
                    }
                    else if(f.getType().isAssignableFrom(Integer.class) || f.getType().isAssignableFrom(Integer.TYPE)){
                        pst.setInt(numParam, Integer.parseInt(f.get(obj).toString()));
                    }
                    else if(f.getType().isAssignableFrom(Float.class) || f.getType().isAssignableFrom(Float.TYPE)) {
                        pst.setFloat(numParam, Float.valueOf(f.get(obj).toString()));
                    }
                    else if(f.getType().isAssignableFrom(Boolean.class) || f.getType().isAssignableFrom(Boolean.TYPE)){
                        pst.setBoolean(numParam, Boolean.valueOf(f.get(obj).toString()));
                    }
                    else if(f.getType().isAssignableFrom(LocalDate.class)){
                        if(f.get(obj) != null){
                            pst.setDate(numParam, Date.valueOf(f.get(obj).toString())); // Se não for nulo, salva o valor
                        }   
                        else{
                            pst.setString(numParam, null); // Se não salva um valor vazio
                        }
                    }
                    else if (f.getType().isEnum()) {
                        if (f.get(obj) != null) {
                            pst.setString(numParam, ((Enum<?>) f.get(obj)).name());
                        } else {
                            pst.setString(numParam, null);
                        }
                    }
                }

            }

            pst.executeUpdate();
            qtde = pst.getUpdateCount();
        }
        catch(Exception e){
            System.out.println("\nERRO: " + e.getMessage());
            System.out.println("Linha: " + e.getStackTrace()[0].getLineNumber());
        }
        finally{
            this.desconectar();
        }

        return qtde;
    }

    public int excluir(Class<?> c, String chave, int valor){
        int qtde = 0;
        try{
            this.conectar();
            String comando = "DELETE FROM " + TB_PREFIX + c.getSimpleName().toLowerCase()
            + " WHERE " + chave + " = " + valor + ";";
            st.executeUpdate(comando);
            qtde = st.getUpdateCount();
        }
        catch(SQLException e){
            System.out.println("\nAVISO: Não é possivel excluir, porque existe uma outra entidade associada!");
        }
        catch(Exception e){
            System.out.println("\nERRO: " + e.getMessage());
            System.out.println("Linha: " + e.getStackTrace()[0].getLineNumber());
        }
        finally{
            this.desconectar();
        }

        return qtde;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author aluno.lab
 */
public class DaoCartao {
    private Connection conn;
    private Statement st;

    /* Metodos de conexão com o banco */
    private void conectar(){
        try{
            this.conn = GerenciadorConexao.pegarConexao(); // Puxa a conexão
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
}

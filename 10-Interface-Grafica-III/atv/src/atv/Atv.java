/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atv;

import java.util.ArrayList;
import model.DaoCartao;
import model.Cartao;
import view.CartaoView;
/**
 *
 * @author aluno.lab
 */
public class Atv {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DaoCartao daoCartao = new DaoCartao();
        ArrayList<Cartao> cartoes = daoCartao.listarTodos();
        for(Cartao c : cartoes){
            System.out.println(c.getNumCartao() + " - " + c.getNomeTitular());
        }
        com.formdev.flatlaf.FlatDarkLaf.setup(); // Tema Escuro da biblioteca
        
        new CartaoView().setVisible(true); // Chamando o view 
    }
    
}
    
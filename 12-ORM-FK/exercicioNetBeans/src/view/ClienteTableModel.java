/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.ClientePJ;

/**
 *
 * @author aluno.lab
 */
public class ClienteTableModel extends AbstractTableModel{
    public static final int COL_CODIGO = 0;
    public static final int COL_NOME = 1;
    public static final int COL_CNPJ = 2;
    public static final int COL_RUA = 3;
    public static final int COL_NUM = 4;
    public static final int COL_BAIRRO = 5;
    public static final int COL_CEP = 6;
    
    public ArrayList<ClientePJ> listaClientes;
    
    public ClienteTableModel(ArrayList<ClientePJ> clientes){
        this.listaClientes = clientes;
    
    }
    
    @Override
    public int getColumnCount(){
        return 7;
    }
    
    @Override
    public int getRowCount(){
        return listaClientes.size();
    }
    
    @Override
    public String getColumnName(int coluna){
        String nome = "";
        if(coluna == COL_CODIGO){nome = "Codigo";}
        if(coluna == COL_NOME){nome = "Nome";}
        if(coluna == COL_CNPJ){nome = "CNPJ";}
        if(coluna == COL_RUA){nome = "Rua";}
        if(coluna == COL_NUM){nome = "Numero";}
        if(coluna == COL_BAIRRO){nome = "Bairro";}
        if(coluna == COL_CEP){nome = "CEP";}
        
        return nome;
    }
    
    @Override
    public Object getValueAt(int linha, int coluna){
        ClientePJ c = listaClientes.get(linha);
        Object conteudo = "";
        
        if(coluna == COL_CODIGO){conteudo = c.getCodigoClientePJ();}
        if(coluna == COL_NOME){conteudo = c.getNome();}
        if(coluna == COL_CNPJ){conteudo = c.getCnpj();}
        if(coluna == COL_RUA){conteudo = c.getEnderecoPJ().getRua();}
        if(coluna == COL_NUM){conteudo = c.getEnderecoPJ().getNumero();}
        if(coluna == COL_BAIRRO){conteudo = c.getEnderecoPJ().getBairro();}
        if(coluna == COL_CEP){conteudo = c.getEnderecoPJ().getCep();}
   
        return conteudo;
    }
}

package view;

import java.util.ArrayList;
import model.Cartao;
import javax.swing.table.AbstractTableModel;

public class CartaoTableModel extends AbstractTableModel {
    public static final int COL_CODIGO = 0;
    public static final int COL_NUM_CARTAO = 1;
    public static final int COL_TITULAR = 2;
    public static final int COL_AGENCIA = 3;
    public static final int COL_BANDEIRA = 4;
    public static final int COL_CVV = 5;
    public static final int COL_DATA_VALIDADE = 6;
    public static final int COL_LIMITE_TOTAL = 7;
    public static final int COL_FATURA_ATUAL = 8;
    
    
    public ArrayList<Cartao> listaCartoes;
    
    public CartaoTableModel(ArrayList<Cartao> cartoes){
        this.listaCartoes = cartoes;
    
    }
    
    @Override
    public int getColumnCount(){
        return 9;
    }
    
    @Override
    public int getRowCount(){
        return listaCartoes.size();
    
    }
    
    @Override
    public String getColumnName(int coluna){
        String nome = "";
        if(coluna == COL_CODIGO){nome = "Codigo";}
        if(coluna == COL_NUM_CARTAO){nome = "Nº Cartao";}
        if(coluna == COL_TITULAR){nome = "Titular";}
        if(coluna == COL_AGENCIA){nome = "Agencia";}
        if(coluna == COL_BANDEIRA){nome = "Bandeira";}
        if(coluna == COL_CVV){nome = "CVV";}
        if(coluna == COL_DATA_VALIDADE){nome = "Validade";}
        if(coluna == COL_LIMITE_TOTAL){nome = "Limite";}
        if(coluna == COL_FATURA_ATUAL){nome = "Fatura";}
        return nome;
    }
    
    @Override
    public Object getValueAt(int linha, int coluna){
        Cartao c = listaCartoes.get(linha);
        Object conteudo = "";
        
        if(coluna == COL_CODIGO){conteudo = c.getCodigo();}
        if(coluna == COL_NUM_CARTAO){conteudo = c.getNumCartao();}
        if(coluna == COL_TITULAR){conteudo = c.getNomeTitular();}
        if(coluna == COL_AGENCIA){conteudo = c.getAgencia();}
        if(coluna == COL_BANDEIRA){conteudo = c.getBandeira();}
        if(coluna == COL_CVV){conteudo = c.getCvv();}
        if(coluna == COL_DATA_VALIDADE){conteudo = c.getDataValidade();}
        if(coluna == COL_LIMITE_TOTAL){conteudo = c.getLimiteTotal();}
        if(coluna == COL_FATURA_ATUAL){conteudo = c.getFaturaAtual();}
   
        return conteudo;
    }
}

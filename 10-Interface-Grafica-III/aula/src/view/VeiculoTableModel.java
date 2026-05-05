package view;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Veiculo;

/**
 *
 * @author gabriel
 */
public class VeiculoTableModel extends AbstractTableModel{
    /* Herda os metodos da classe table model para trabalhar com a tabela Veiculo */
    
    /* Define por indice as posições de cada coluna */
    public static final int COL_CODIGO = 0;
    public static final int COL_MARCA = 1;
    public static final int COL_MODELO = 2;
    public static final int COL_CHASSI = 3;
    public static final int COL_ANO = 4;
    
    public ArrayList<Veiculo> listaVeiculos;
    
    public VeiculoTableModel(ArrayList<Veiculo> veiculos){
        this.listaVeiculos = veiculos;
    }

    /* Metodos do Table Model */
    @Override
    public int getColumnCount(){
        return 5;
    }

    @Override
    public int getRowCount(){
        return listaVeiculos.size();
    }

    @Override
    public String getColumnName(int coluna){
        /* O java chamara esse metodo automaticamente, de acordo com a quantidade de colunas */
        String nome = "";
        if(coluna == COL_CODIGO){nome = "Codigo";}
        if(coluna == COL_MARCA){nome = "Marca";}
        if(coluna == COL_MODELO){nome = "Modelo";}
        if(coluna == COL_CHASSI){nome = "Chassi";}
        if(coluna == COL_ANO){nome = "Ano";}
        return nome;
    }

    @Override
    public Object getValueAt(int linha, int coluna){
        Veiculo v = listaVeiculos.get(linha);
        Object conteudo = "";
        
        if(coluna == COL_CODIGO){conteudo = v.getCodigo();}
        if(coluna == COL_MARCA){conteudo = v.getMarca();}
        if(coluna == COL_MODELO){conteudo = v.getModelo();}
        if(coluna == COL_CHASSI){conteudo = v.getChassi();}
        if(coluna == COL_ANO){conteudo = v.getAno();}

        return conteudo;
    }
}

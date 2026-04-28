package pkg08.pkginterface.grafica;

import java.util.ArrayList;
import model.DaoVeiculo;
import model.Veiculo;
import view.VeiculoView;

/**
 *
 * @author gabriel
 */
public class InterfaceGrafica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DaoVeiculo daoVeiculo = new DaoVeiculo();
        ArrayList<Veiculo> veiculos = daoVeiculo.listarTodos();
        for(Veiculo v : veiculos){
            System.out.println(v.getModelo() + " - " + v.getMarca());
        }
        
        com.formdev.flatlaf.FlatDarkLaf.setup(); // Tema Escuro da biblioteca
        
        new VeiculoView().setVisible(true); // Chamando o view 
    }
    
}

package atv;

import java.time.LocalDate;
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

        /* TESTES */
        ArrayList<Cartao> cartoes = daoCartao.listarTodos();
        for(Cartao c : cartoes){
            System.out.println(c.getNomeTitular() + " - " + c.getBandeira() + " - " + c.getFaturaAtual());
        }

        Cartao c = new Cartao();
        c.setNumCartao("4532019365045611");
        c.setNomeTitular("Luis Felipe Camilo Sversutti");
        c.setAgencia("car");
        c.setBandeira("Elo");
        c.setCvv("988");
        c.setDataValidade(LocalDate.now());
        c.setLimiteTotal(9000.00);
        c.setFaturaAtual(4352.23);
        // daoCartao.inserir(c);

        // c.setCodigo(13);
        // c.setBandeira("Visa");
        // daoCartao.alterar(c);

        // daoCartao.excluir(13);

        // com.formdev.flatlaf.FlatDarkLaf.setup(); // Tema Escuro da biblioteca
        
        // new CartaoView().setVisible(true); // Chamando o view 
    }
    
}
    
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DaoGenerico daoGen = new DaoGenerico();
        
        /* Teste Inserir */
        // Veiculo v = new Veiculo();
        // v.setAno(2020);
        // v.setModelo("Cobalt");
        // v.setMarca("Chevrolet");
        // v.setChassi("123qwe");

        // daoGen.inserir(v);

        /* Teste buscarTodos  */
        // ArrayList<Veiculo> itens = daoGen.buscarTodos(Veiculo.class);

        // for(Veiculo v : itens){
        //     System.out.println("Veiculo: " + v.getModelo());
        // }

        /* Teste buscarTodosFiltro */

        ArrayList<Veiculo> itens = daoGen.buscarTodosFiltro(Veiculo.class, "ano", "20");

        for(Veiculo v : itens){
            System.out.println("Veiculo: " + v.getModelo());
        }
    }
}

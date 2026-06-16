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

        /* Teste buscarTodos */
        ArrayList<Veiculo> itens = daoGen.buscarTodos(Veiculo.class);

        for (Veiculo v : itens) {
            System.out.println("Veiculo: " + v.getModelo());
        }

        /* Teste buscarTodosFiltro */
        // ArrayList<Veiculo> itens = daoGen.buscarTodosFiltro(Veiculo.class, "ano",
        // "20");

        // for(Veiculo v : itens){
        // System.out.println("Veiculo: " + v.getModelo());
        // }

        /* Teste consultar */
        // Veiculo v = daoGen.consultar(Veiculo.class, "codigo", "4");
        // if (v != null) {
        //     System.out.println("O veiculo é: " + v.getModelo());
        // } else {
        //     System.out.println("Não encontrado!");
        // }

        /* Teste alterar */
        Veiculo v = new Veiculo();
        v.setAno(2026);
        v.setModelo("ARG");
        v.setMarca("qwerty");
        v.setChassi("123456");

        int qtde = daoGen.alterar(v, "codigo", 2);
        System.out.println("Numero de Alterações: " + qtde);

        /* Teste exlcuir */
        // int qtde = daoGen.excluir(Veiculo.class, "codigo", 5);
        // System.out.println("Excluiu: " + qtde);

    }
}

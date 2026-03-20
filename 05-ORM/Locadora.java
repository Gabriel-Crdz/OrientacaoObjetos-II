public class Locadora {
    /* Classe cria apenas para teste(por enquanto sem Controller) */
    public static void main(String[] args) {
        DaoVeiculo daoVeiculo = new DaoVeiculo();
        Veiculo v = new Veiculo();
        v.setMarca("Ford");
        v.setModelo("Focus");
        v.setChassi("ABC123SDF");
        v.setAno(2017);

        boolean inserido = daoVeiculo.inserir(v); // Passando o objeto para o DAO, e pegando seu retorno
        System.out.println(inserido); // Resposta da insersão
    }
}

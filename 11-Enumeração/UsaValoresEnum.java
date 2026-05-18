public class UsaValoresEnum {
    public static void main(String[] args) {
        System.out.println("Dia: " + DiaSemanaEnum.QUA); // Mostra o valor chave do enum
        System.out.println("Dia: " + DiaSemanaEnum.QUA.getDia()); // Mostra o valor do elemento no enum, fazendo uso do construtor

        System.out.println("Campus: " + CampiIfprEnum.FOZ.getNome() + " - Inaugurado em " + CampiIfprEnum.FOZ.getAnoCriacao());

        System.out.println("Livro: " + LivrosEnum.DUNA.getNome() + " - Lançamento: " + LivrosEnum.DUNA.getAno());
    }
}

public class Cadastro {
    public static void main(String[] args) {
        PessoaEnum p1 = new PessoaEnum();
        
        p1.setEstadoCivil(EstadoCivilEnum.CASADO);

        System.out.println("Estado civil pessoa 1: " + p1.getEstadoCivil());
    }
}

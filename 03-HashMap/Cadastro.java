
import java.util.HashMap;

public class Cadastro {
    public static void main(String[] args) {

        /* Salvando Objetos no hash */
        HashMap<String, Estado> estados = new HashMap<String, Estado>(); // <K, V> K: tipo da chave, V: valor tipo do valor

        Estado e1 = new Estado();
        e1.setNome("Parana");
        e1.setRegiao("Sul");
        estados.put("PR", e1);

        Estado e2 = new Estado();
        e2.setNome("Bahia");
        e2.setRegiao("Nordeste");
        estados.put("BA", e2);

        Estado e3 = new Estado();
        e3.setNome("São Paulo");
        e3.setRegiao("Sudeste");
        estados.put("SP", e3);

        System.out.println("Estados: " + estados); // 

        System.out.println("\nVerificando se existe um estado:");
        String busca = "SP";

        if(estados.containsKey(busca)) {
            System.out.println(busca + " existe!");

            System.out.print("\nBuscando região: ");
            System.out.println(estados.get(busca).getRegiao()); // Buscando um atributo do objeto no hash
        }
        else System.out.println("Não encontrado!!");
        

        System.out.println("\nPercorrendo as chaves:");
        for (String chave : estados.keySet()) {
            System.out.println(chave);
        }

        System.out.println("\nPercorrendo os objetos:");
        for (Estado e : estados.values()) {
            System.out.println("Nome: " + e.getNome() + " - Regiao: " + e.getRegiao());
        }

    }
}
 
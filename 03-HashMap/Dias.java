
import java.util.HashMap;

public class Dias {
    public static void main(String[] args) {
        HashMap<String, String> diasSemana = new HashMap<String, String>(); // <K, V> K: tipo da chave, V: valor tipo do valor

        /* Inserindo valores (put) */
        diasSemana.put("DOM", "Domingo");
        diasSemana.put("SEG", "Segunda-feira");
        diasSemana.put("TER", "Terça-feira");
        diasSemana.put("QUA", "Quarta-feira");
        diasSemana.put("QUI", "Quinta-feira");
        diasSemana.put("SEX", "Sexta-feira");
        diasSemana.put("SAB", "Sabado");

        System.out.println("Mostrando os pares:");
        System.out.println(diasSemana);

        System.out.println("\nVerificando se um dia existe:");
        System.out.println("QUA existe?: " + diasSemana.containsKey("QUA")); // containsKey: verifica se uma chave existe
        System.out.println("AAA existe?: " + diasSemana.containsKey("AAA")); // Se existe: TRUE, se nao: FALSE

        System.out.println("\nPegando um item a partir da chave");
        System.out.println("O valor da chave TER é: " + diasSemana.get("TER")); // get: retorna o valor associado a chave
    
        System.out.println("\nQuantidade de pares chave-valor: " + diasSemana.size()); // size: retorna o tamanho do hash    
        
        String itemRemover = "TER";
        System.out.println("\nRemovendo o item: " + itemRemover);
        diasSemana.remove("TER");
        System.out.println("\nQuantidade de pares chave-valor: " + diasSemana.size()); // size: retorna o tamanho do hash    

        System.out.println("\nPercorrendo as cahves");
        for (String chave : diasSemana.keySet()) { //keySet: retorna as chaves do hash
            System.out.println(chave);
        }

        System.out.println("\nPercorrendo os valores");
        for (String item : diasSemana.values()) { // values: retorna os valores do hash
            System.out.println(item);
        }

        System.out.println("\nRemovendo todos os pares:");
        diasSemana.clear(); // clear: apaga TUDO
        System.out.println("\nQuantidade de pares chave-valor: " + diasSemana.size());

    }
}

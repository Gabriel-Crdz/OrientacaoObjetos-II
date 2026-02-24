import java.util.ArrayList;
import java.util.Iterator;

public class Exemplo1 {
    public static void main(String[] args) {
        String[] vetCores = {"Magenta", "Branco", "Verde", "Azul"};
        ArrayList<String> listaCores = new ArrayList<String>();

        /* Vetor */
        System.out.println("Percorrer vetor(For):");
        for(int i = 0; i < vetCores.length; i++){
            System.out.println(vetCores[i]);
        }

        System.out.println("\nPercorrer vetor(Foreach):");
        for (String cor : vetCores) {
            System.out.println(cor);
            listaCores.add(cor); // Adiciona as cores no arrayList
        }

        /* ArrayList */
        System.out.println("\nPercorrer ArrayList(For):");
        for(int count = 0; count < listaCores.size(); count++){
            System.out.println(listaCores.get(count));
        }

        System.out.println("\nPercorrer ArrayList(Foreach):");
        for (String cor : listaCores) {
            System.out.println(cor);
        }

        System.out.println("\nPercorrer ArrayList com Iterator:");
        Iterator<String> it = listaCores.iterator(); // Cria um ponteiro que aponta para Strings dentro de listaCores
        while(it.hasNext()){ // Valida se a um proximo item
            System.out.println(it.next()); // Aponta para a proximo item do tipo(String)
        }
    }
}

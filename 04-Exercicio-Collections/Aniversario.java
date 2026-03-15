import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Aniversario {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        HashMap<String, ArrayList<String>> aniversarios = new HashMap<>();
        menu(aniversarios);
    }

    public static void menu(HashMap<String, ArrayList<String>> aniversarios) throws Exception{
        int opc = -1;
        do { 
            System.out.println("\n==========MENU==========");
            System.out.println("[1] Adicionar aniversariante");
            System.out.println("[2] Listar datas");
            System.out.println("[3] Consultar data");
            System.out.println("[0] Sair");
            System.out.println("========================");
            
            System.out.print("Escolha uma opção: ");
            opc = Integer.parseInt(input.readLine());
            System.out.println(""); // Print apenas para espaçamento

            switch (opc) {
                case 1:
                    cadastrarAniversariante(aniversarios);
                    break;
                case 2:
                    listarDatas(aniversarios);
                    break;
                case 3:
                    detalharData(aniversarios);
                    break;
                case 0:
                    System.out.println("SAINDO...");
                    break;
                default:
                    System.out.println("Entrada Invalida!!");
                    break;
            }
        } while (opc != 0);
    }

    public static void cadastrarAniversariante(HashMap<String, ArrayList<String>> aniversarios) throws Exception{
        System.out.println("+===CADASTRANDO====");

        System.out.print("|= Informe o nome: ");
        String pessoa = input.readLine(); 
        
        System.out.print("|= Informe a data(dd/mm): ");
        String data = input.readLine();

        if(! aniversarios.containsKey(data)){
            ArrayList<String> aniversariantes = new ArrayList<>();

            aniversariantes.add(pessoa);

            aniversarios.put(data, aniversariantes);
        }

        else if(aniversarios.containsKey(data)) {
            ArrayList<String> aniversariantes = aniversarios.get(data);
            aniversariantes.add(pessoa);

            aniversarios.put(data, aniversariantes);
            
        }
    }

    public static void listarDatas(HashMap<String, ArrayList<String>> aniversarios){
        System.out.println("\n+===DATAS REGISTRADAS===");
        for(String data : aniversarios.keySet()){
            System.out.println("|= " + data);
        }
    }

    public static void detalharData(HashMap<String, ArrayList<String>> aniversarios) throws Exception{
        System.out.println("\n+===DETALHAR===");
        System.out.print("|= Informe a data (dd/mm): ");
        String busca = input.readLine();

        if(aniversarios.containsKey(busca)){
            ArrayList<String> aniversariantes = aniversarios.get(busca);

            System.out.println("Aniversariantes em " + busca + ":");

            for(String pessoa : aniversariantes){
                System.out.println(pessoa);
            }
        } 
        else{
            System.out.println("Nenhum aniversariante nesta data.");
        }
    }
}

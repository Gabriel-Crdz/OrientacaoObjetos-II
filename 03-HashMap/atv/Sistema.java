
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Sistema {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {

        HashMap<String, Aeroporto> aeroportos = new HashMap<String, Aeroporto>();
        menu(aeroportos);
    }

    public static void menu(HashMap<String, Aeroporto> aeroportos) throws Exception{
        int opc = -1;
        do { 
            System.out.println(""); // Print apenas para espaçamento
            System.out.println("==========MENU==========");
            System.out.println("[1] Cadastrar aeroporto");
            System.out.println("[2] Listar aeroportos");
            System.out.println("[3] Remover aeroportos");
            System.out.println("[4] Detalhar aeroporto");
            System.out.println("[0] Sair");
            System.out.println("========================");
            
            System.out.print("Escolha uma opção: ");
            opc = Integer.parseInt(input.readLine());
            System.out.println(""); // Print apenas para espaçamento

            switch (opc) {
                case 1:
                    cadastrarAeroporto(aeroportos);
                    break;
                case 2:
                    listarAeroportos(aeroportos);
                    break;
                case 3:
                    removerAeroportos(aeroportos);
                    break;
                case 4:
                    detalharAeroporto(aeroportos);
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

    public static void cadastrarAeroporto(HashMap<String, Aeroporto> aeroportos) throws Exception{
        System.out.println("+===CADASTRANDO====");

        Aeroporto aero = new Aeroporto();

        System.out.print("|= Sigla: ");
        String sigla = input.readLine();

        System.out.print("|= Nome: ");
        aero.setNome(input.readLine());

        System.out.print("|= Cidade: ");
        aero.setCidade(input.readLine());

        System.out.print("|= Altitude: ");
        aero.setAltitude(Integer.parseInt(input.readLine()));

        // System.out.println(a.getAltitude());
        // System.out.println(a.getCidade());
        // System.out.println(a.getNome());

        aeroportos.put(sigla, aero);
    }

    public static void listarAeroportos(HashMap<String, Aeroporto> aeroportos){
        for(Aeroporto aero : aeroportos.values()) {
            System.out.println(aero.getNome());
        }
    }

    public static void removerAeroportos(HashMap<String, Aeroporto> aeroportos) throws Exception{
        System.out.println("+===REMOVENDO====");
        System.out.print("Informe a sigla do aeroporto: ");
        String busca = input.readLine();

        if(aeroportos.containsKey(busca)) {
            aeroportos.remove(busca);
            System.out.println("\n" + busca + " foi removido!!");
        }
        else System.out.println("\n" + busca + " não foi encontrado!!");
    }

    public static void detalharAeroporto(HashMap<String, Aeroporto> aeroportos) throws Exception{
        System.out.println("+===DETALHAR====");
        System.out.print("Informe a sigla do aeroporto: ");
        String busca = input.readLine();

        if(aeroportos.containsKey(busca)) {
            Aeroporto aero = aeroportos.get(busca);
            System.out.println("+====================");
            System.out.println("| Sigla: " + busca);
            System.out.println("| Nome: " + aero.getNome());
            System.out.println("| Cidade: " + aero.getCidade());
            System.out.println("| Altitude: " + aero.getAltitude());
            
        }
        else System.out.println(busca + " não encontrado!!");

    }
}

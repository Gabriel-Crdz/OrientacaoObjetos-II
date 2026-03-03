import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sistema {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        menu();
    }

    public static void menu() throws Exception{
        int opc = -1;
        do { 
            System.out.println(""); // Print apenas para espaçamento
            System.out.println("==========MENU==========");
            System.out.println("[1] Cadastrar cliente");
            System.out.println("[2] Listar clientes");
            System.out.println("[3] Cadastrar Orçamento");
            System.out.println("[4] Listar Orçamentos");
            System.out.println("[0] Sair");
            System.out.println("========================");
            
            System.out.print("Escolha uma opção: ");
            opc = Integer.parseInt(input.readLine());
            System.out.println(""); // Print apenas para espaçamento

            switch (opc) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    // cadastrarCliente();
                    break;
                case 3:
                    // cadastrarCliente();
                    break;
                case 4:
                    // cadastrarCliente();
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
}

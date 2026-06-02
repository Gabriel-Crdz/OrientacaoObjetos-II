// import java.sql.Connection;
import java.util.Scanner;

public class Locadora {
    public static void main(String[] args) throws Exception{
        Locadora loc = new Locadora();
        loc.menuPrincipal();
    }

    public void menuPrincipal(){
        int opcao = -1;
        /*
        Se usar apenas: Scanner scanner = new Scanner(System.in);
        o VSCode sugere usar o Try-With-Resources.
        
        Surround with Try-With-Resources:
        This is a feature in Java 7 and beyond. try with resources allows to 
        skip writing the finally and closes all the resources being used 
        in try-block itself.
        
        Any object that implements java.lang.AutoCloseable, which includes 
        all objects which implement java.io.Closeable, can be used as a 
        resource. See this code example:
        
        static String readFirstLineFromFile(String path) throws IOException {
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                return br.readLine();
            }
        }
        */

        try (Scanner scanner = new Scanner(System.in)) {
            while (opcao != 0) {
            	System.out.println("\n-------------------------------");
            	System.out.println("MENU PRINCIPAL");            
            	System.out.println("[1] Gerenciar Veículos");            
            	System.out.println("[2] Gerenciar Vendedores");            
                System.out.println("[3] Gerenciar Clientes PJ");
                System.out.println("[0] Sair");            
            	System.out.println("\n-------------------------------");

                try {
                    opcao = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Informe um nro inteiro");
                }

                switch (opcao) {
                case 1:
                    GerenciadorVeiculo gv = new GerenciadorVeiculo();
                    gv.menu();
                    break;
                case 2:
                    //vendedor
                    break;
                case 3:
                    GerenciadorClientePJ gCliPJ = new GerenciadorClientePJ();
                    gCliPJ.menu();
                    break;
                case 0:
                    System.out.println("Até logo.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
                }
            }
        }
    }
}

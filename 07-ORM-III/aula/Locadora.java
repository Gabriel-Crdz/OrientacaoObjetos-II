import java.util.Scanner;

public class Locadora {
    public static void main(String[] args) {
       Locadora loc = new Locadora();
       loc.menuPrincipal();

    }

    private void menuPrincipal(){
        /* Try-with-resources: Quando esse bloco encerrar o scanner incerra liberando seu espaço na memoria */
        try(Scanner scan = new Scanner(System.in)){ 
            int opc = -1;
            do { 
                System.out.println("\n=========MENU=========");
                System.out.println("[1] Gerenciar Veiculos");
                System.out.println("[2] Gerenciar Vendedores");
                System.out.println("[0] Sair");
                System.out.println("======================");
                
                try{
                    System.out.print("Escolha uma opção: ");
                    opc = Integer.parseInt(scan.nextLine());
                }catch(Exception e){
                    System.out.println("ERRO: Informe um valor valido!");
                }
                System.out.println(""); // Print apenas para espaçamento

                switch (opc) {
                    case 1:
                        GerenciadorVeiculo gv = new GerenciadorVeiculo(); // Instancia um novo gerenciador
                        gv.menu(); // Chama o sub-menu dentro do gerenciador de veiculos
                        break;
                    case 2:
                        // Vendedor
                        break;
                    case 0:
                        System.out.println("SAINDO...");
                        break;
                    default:
                        System.out.println("ERRO: Opção invalida!");
                        break;
                }
            } while (opc != 0);
        }
    }
}

package view;

import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {
        /*
         * Try-with-resources: Quando esse bloco encerrar o scanner incerra liberando
         * seu espaço na memoria
         */
        try (Scanner scan = new Scanner(System.in)) {
            int opc = -1;
            do {
                System.out.println("\n==========SISTEMA==========");
                System.out.println("\n----------MENU----------");
                System.out.println("[1] Menu Pais");
                System.out.println("[2] Menu Cidade");
                System.out.println("[0] Sair");
                System.out.println("------------------------");

                try {
                    System.out.print("Escolha uma opção: ");
                    opc = Integer.parseInt(scan.nextLine());
                } catch (Exception e) {
                    System.out.println("ERRO: Informe um valor valido!");
                }

                new ProcessBuilder("clear").inheritIO().start().waitFor(); // Limpa o terminal

                switch (opc) {
                    case 1:
                        PaisView pv = new PaisView();
                        pv.exibirMenu();

                        break;
                    case 2:
                        CidadeView cv = new CidadeView();
                        cv.exibirMenu();
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
        catch(Exception e ){
            System.out.println("ERRO: " + e.getMessage());
        }
    }
}

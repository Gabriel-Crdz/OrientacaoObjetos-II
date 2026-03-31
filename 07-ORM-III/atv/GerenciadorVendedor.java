import java.util.Scanner;

public class GerenciadorVendedor {
    Scanner scan;
    DaoVendedor daoVendedor;

    GerenciadorVendedor(){ // Metodo Construtor
        scan = new Scanner(System.in);
        daoVendedor = new DaoVendedor();
    }

    public void menu(){
        int opc = -1;
        do { 
            System.out.println("\n==GERENCIAMENTO DE VENDEDORES==");
            System.out.println("\n----------MENU----------");
            System.out.println("[1] Cadastrar");
            System.out.println("[2] Consultar");
            System.out.println("[3] Alterar");
            System.out.println("[4] Excluir");
            System.out.println("[5] Listar Todos");
            System.out.println("[0] Sair");
            System.out.println("=============================");
            
            try{
                System.out.print("Escolha uma opção: ");
                opc = Integer.parseInt(scan.nextLine());
            }catch(Exception e){
                System.out.println("ERRO: Informe um valor valido!");
            }
            System.out.println(""); // Print apenas para espaçamento

            switch (opc) {
                case 1:
                    // this.cadastrar();
                    break;
                case 2:
                    // this.consultar();
                    break;
                case 3:
                    // this.alterar();
                    break;
                case 4:
                    // this.excluir();
                    break;
                case 5:
                    // this.listarTodos();
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

    public void cadastrar(){
        Vendedor v = new Vendedor();
        System.out.println("+==CADASTRO==");

        System.out.print("|= Informe o nome: ");
        v.setNome(scan.nextLine());

        System.out.print("|= Informe o contato: ");
        v.setContato(scan.nextLine());

        System.out.print("|= Informe o cargo");
        v.setCargo(scan.nextLine());

        System.out.print("|= Informe o ano de admissão: ");
        v.setAnoAdmissao(Integer.parseInt(scan.nextLine()));

        System.out.println("|= Informe o salario base: ");
        v.setSalarioBase(Float.valueOf(scan.nextLine()));

        String resultado = daoVendedor.inserir(v) ? "SUCESSO: Inserção realizada!" : "ERRO: Inserção não realizada!"; // Operador Ternario para validar o resultado da inserção
    }
}

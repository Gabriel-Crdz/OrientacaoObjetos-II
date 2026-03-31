import java.util.ArrayList;
import java.util.Scanner;


public class GerenciadorVeiculo {
    Scanner scan;
    DaoVeiculo daoVeiculo;

    GerenciadorVeiculo(){ // Metodo Construtor
        scan = new Scanner(System.in);
        daoVeiculo = new DaoVeiculo();
    }

    public void menu(){
        int opc = -1;
        do { 
            System.out.println("\n==GERENCIAMENTO DE VEICULOS==");
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
                    this.cadastrar();
                    break;
                case 2:
                    this.consultar();
                    break;
                case 3:
                    this.alterar();
                    break;
                case 4:
                    this.excluir();
                    break;
                case 5:
                    this.listarTodos();
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
        Veiculo v = new Veiculo();

        System.out.println("+==CADASTRO===");

        System.out.print("|= Informe a marca: ");
        v.setMarca(scan.nextLine());

        System.out.print("|= Informe o modelo: ");
        v.setModelo(scan.nextLine());

        System.out.print("|= Informe o chassi: ");
        v.setChassi(scan.nextLine());

        System.out.print("|= Informe o ano: ");
        v.setAno(Integer.parseInt(scan.nextLine()));

        String resultado = daoVeiculo.inserir(v) ? "SUCESSO: Inserção realizada!" : "ERRO: Inserção não realizada!"; // Operador Ternario para validar o resultado da inserção

        System.out.println(resultado);
    }

    public void consultar(){
        System.out.println("+===CONSULTANDO===");
        System.out.print("|= Informe o codigo: ");
        int cod = Integer.parseInt(scan.nextLine());
        Veiculo v = daoVeiculo.consultar(cod);
        
        if(v != null){
            System.out.println("-----Veiculo Encontrado------");
            System.out.println("| Codigo: " + v.getCodigo());
            System.out.println("| Marca: " + v.getMarca());
            System.out.println("| Modelo: " + v.getModelo());
            System.out.println("| Chassi: " + v.getChassi());
            System.out.println("| Ano: " + v.getAno());
            System.out.println("-----------------------------");
        }
    }

    public void alterar(){

        System.out.println("+==ALTERAR CADASTRO===");

        /* Busca do Registro */
        System.out.print("|= Informe o codigo: ");
        int cod = Integer.parseInt(scan.nextLine());

        Veiculo v = daoVeiculo.consultar(cod);

        if(v != null){ // Se existir um veiculo, mostra os dados e pede a alteração
            System.out.println("-----Veiculo Encontrado------");
            System.out.println("| Codigo: " + v.getCodigo());

            System.out.println("| Marca: " + v.getMarca());
            System.out.print("|= Informe o marca: ");
            String marca = scan.nextLine(); // Lê a entrada
            if(!marca.isEmpty()){ // Caso o usuario não deixe vazio, salva o novo valor
                v.setMarca(marca);
            }

            System.out.println("| Modelo: " + v.getModelo());
            System.out.print("|= Informe o modelo: ");
            String modelo = scan.nextLine(); // Lê a entrada
            if(!modelo.isEmpty()){ // Caso o usuario não deixe vazio, salva o novo valor
                v.setModelo(modelo);
            }

            System.out.println("| Chassi: " + v.getChassi());
            System.out.print("|= Informe o chassi: ");
            String chassi = scan.nextLine(); // Lê a entrada
            if(!chassi.isEmpty()){ // Caso o usuario não deixe vazio, salva o novo valor
                v.setChassi(chassi);
            }

            System.out.println("| Ano: " + v.getAno());
            System.out.print("|= Informe o ano: ");
            String ano = scan.nextLine(); // Lê a entrada
            if(!ano.isEmpty()){ // Caso o usuario não deixe vazio, salva o novo valor
                v.setAno(Integer.parseInt(ano));
            }

            int qtd = daoVeiculo.alterar(v);
            String resultado = qtd > 0 ? "SUCESSO: Atualização realizada!" : "ERRO: Atualização não realizada!";
            System.out.println(resultado);
        }

        else{
            System.out.println("AVISO: Nenhum veiculo encontrado!");
        }
    }

    public void excluir(){
        System.out.println("+===EXCLUINDO===");
        System.out.print("|= Informe o codigo: ");
        int cod = Integer.parseInt(scan.nextLine());
        
        String resultado = daoVeiculo.excluir(cod) > 0 ? "SUCESSO: Exclusão realizada!" : "ERRO: Exclusão não realizada!";
        System.out.println(resultado);
    }

    public void listarTodos(){
        ArrayList<Veiculo> veiculos = daoVeiculo.listarTodos();
        System.err.println("==========LISTA GERAL=========");
        System.out.printf("%-10s | %-15s | %-15s | %-20s | %-5s%n",
        "Codigo", "Marca", "Modelo", "Chassi", "Ano");
        for(Veiculo v : veiculos){
            System.out.printf(
            "%-10d | %-15s | %-15s | %-20s | %-5d%n",
            v.getCodigo(),
            v.getMarca(),
            v.getModelo(),
            v.getChassi(),
            v.getAno()
            );
        }
    }
}

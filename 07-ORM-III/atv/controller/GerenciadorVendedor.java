package controller;
import java.util.ArrayList;
import java.util.Scanner;

import model.Vendedor;
import DAO.DaoVendedor;

public class GerenciadorVendedor {
    Scanner scan;
    DaoVendedor daoVendedor;

    public GerenciadorVendedor(){ // Metodo Construtor
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
        Vendedor v = new Vendedor();
        System.out.println("+==CADASTRO==");

        System.out.print("|= Informe o nome: ");
        v.setNome(scan.nextLine());

        System.out.print("|= Informe o contato: ");
        v.setContato(scan.nextLine());

        System.out.print("|= Informe o cargo: ");
        v.setCargo(scan.nextLine());

        System.out.print("|= Informe o ano de admissão: ");
        v.setAnoAdmissao(Integer.parseInt(scan.nextLine()));

        System.out.print("|= Informe o salario base: ");
        v.setSalarioBase(Float.valueOf(scan.nextLine()));

        String resultado = daoVendedor.inserir(v) ? "SUCESSO: Inserção realizada!" : "ERRO: Inserção não realizada!"; // Operador Ternario para validar o resultado da inserção
        
        System.out.println(resultado);
    }

    public void consultar(){
        System.out.println("+===CONSULTANDO===");
        System.out.print("|= Informe o codigo: ");
        int cod = Integer.parseInt(scan.nextLine());
        Vendedor v = daoVendedor.consultar(cod);

        if(v != null){
            System.out.println("-----Vendedor Encontrado------");
            System.out.println("| Codigo: " + v.getCodigo());
            System.out.println("| Nome: " + v.getNome());
            System.out.println("| Contato: " + v.getContato());
            System.out.println("| Cargo: " + v.getCargo());
            System.out.println("| Admissão: " + v.getAnoAdmissao());
            System.out.println("| Salario: " + v.getSalarioBase());
            System.out.println("------------------------------");
        }
    }

    public void alterar(){
        System.out.println("+===CONSULTANDO===");
        System.out.print("|= Informe o codigo: ");
        int cod = Integer.parseInt(scan.nextLine());
        Vendedor v = daoVendedor.consultar(cod);

        if(v != null){ // Se existir um veiculo, mostra os dados e pede a alteração
            int opc = -1;
            do { 
                System.out.println("=======ALTERAR CADASTRO=======");
                System.out.println("------------DADOS-------------");
                System.out.println("Codigo: " + v.getCodigo());
                System.out.println("[1] Nome: " + v.getNome());
                System.out.println("[2] Contato: " + v.getContato());
                System.out.println("[3] Cargo: " + v.getCargo());
                System.out.println("[4] Ano de Admissão: " + v.getAnoAdmissao());
                System.out.println("[5] Salario Base: " + v.getSalarioBase());
                System.out.println("[0] Sair");
                System.out.println("==============================");
                
                try{
                    System.out.print("Escolha um dado para alterar: ");
                    opc = Integer.parseInt(scan.nextLine());
                }catch(Exception e){
                    System.out.println("ERRO: Informe um valor valido!");
                }
                System.out.println(""); // Print apenas para espaçamento

                switch (opc) {
                    case 1:
                        System.out.print("|= Informe o novo nome: ");
                        v.setNome(scan.nextLine());
                        break;
                    case 2:
                        System.out.print("|= Informe o novo contato: ");
                        v.setContato(scan.nextLine());
                        break;
                    case 3:
                        System.out.print("|= Informe o novo cargo: ");
                        v.setCargo(scan.nextLine());
                        break;
                    case 4:
                        System.out.print("|= Informe o ano da nova admissão: ");
                        v.setAnoAdmissao(Integer.parseInt(scan.nextLine()));
                        break;
                    case 5:
                        System.out.print("|= Informe o novo salario base: ");
                        v.setSalarioBase(Float.valueOf(scan.nextLine()));
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("ERRO: Opção invalida!");
                        break;
                }
            } while (opc != 0);

            int qtd = daoVendedor.alterar(v);
            String resultado = qtd > 0 ? "SUCESSO: Atualização realizada!" : "ERRO: Atualização não realizada!";
            System.out.println(resultado);
        }
        else{
            System.out.println("AVISO: Nenhum vendedor encontrado!");
        }
    }

    public void excluir(){
        System.out.println("+===EXCLUINDO===");
        System.out.print("|= Informe o codigo: ");
        int cod = Integer.parseInt(scan.nextLine());
        
        String resultado = daoVendedor.excluir(cod) > 0 ? "SUCESSO: Exclusão realizada!" : "ERRO: Exclusão não realizada!";
        System.out.println(resultado);
    }

    public void listarTodos(){
        ArrayList<Vendedor> vendedores = daoVendedor.listarTodos();
        System.err.println("==========LISTA GERAL=========");
        System.out.printf("%-10s | %-20s | %-20s | %-20s | %-10s | %-10s%n",
        "Codigo", "Nome", "Contato", "Cargo", "Admissao", "Salario Base");
        for(Vendedor v : vendedores){
            System.out.printf(
            "%-10d | %-20s | %-20s | %-20s | %-10d | %-10.2f%n",
            v.getCodigo(),
            v.getNome(),
            v.getContato(),
            v.getCargo(),
            v.getAnoAdmissao(),
            v.getSalarioBase()
            );
        }
    }
}

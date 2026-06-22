package view;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.DaoGenerico;
import model.Cidade;
import model.Pais;

public class CidadeView {

    private Scanner scan;
    private DaoGenerico dao;

    public CidadeView() {
        scan = new Scanner(System.in);
        dao = new DaoGenerico();
    }

    public void exibirMenu() throws Exception {
        try{
            int opc = -1;
            do {
                System.out.println("\n=======MENU CIDADE=======");
                System.out.println("[1] Cadastrar");
                System.out.println("[2] Listar todos");
                System.out.println("[3] Listar por filtro");
                System.out.println("[4] Consultar");
                System.out.println("[5] Alterar");
                System.out.println("[6] Excluir");
                System.out.println("[0] Sair");
                System.out.println("=========================");

                try {
                    System.out.print("Escolha uma opção: ");
                    opc = Integer.parseInt(scan.nextLine());
                } catch (Exception e) {
                    System.out.println("ERRO: Informe um valor valido!");
                }
                
                new ProcessBuilder("clear").inheritIO().start().waitFor(); // Limpa o terminal

                switch (opc) {
                    case 1:
                        cadastrar();
                        break;
                    case 2:
                        listar();
                        break;
                    case 3:
                        listarPorFiltro();
                        break;
                    case 4:
                        consultar();
                        break;
                    case 5:
                        alterar();
                        break;
                    case 6:
                        excluir();
                        break;
                    case 0:
                        System.out.println("Voltando...\n");
                        break;
                    default:
                        System.out.println("ERRO: Opção invalida!");
                        break;
                }
            } while (opc != 0);
        }
        catch(Exception e){
            System.out.println("\nERRO: " + e.getMessage());
        }
    }
    private void cadastrar() {
        System.out.println("========CADASTRO DE CIDADES========");

        try {
            Cidade c = new Cidade();

            System.out.print("\n| Nome: ");
            c.setNome(scan.nextLine());

            System.out.print("\n| Tamanho (km²): ");
            c.setTamanho(Float.parseFloat(scan.nextLine()));

            int entrada;
            do {
                System.out.println("\n+------Capital?------");
                System.out.println("| [1] Sim");
                System.out.println("| [2] Não");
                System.out.println("-----------------------");

                System.out.print("| Opção: ");
                entrada = Integer.parseInt(scan.nextLine());

                if (entrada == 1) {
                    c.setCapital(true);
                }
                else if (entrada == 2) {
                    c.setCapital(false);
                }
                else {
                    System.out.println("| AVISO: Opção inválida!");
                }

            } while(entrada != 1 && entrada != 2);

            System.out.print("\n| ID do País: ");
            c.setIdPais(Integer.parseInt(scan.nextLine()));

            dao.inserir(c);

            System.out.println("\nSUCESSO: cadastro realizado!");

        } catch (Exception e) {
            System.out.println("\nERRO: " + e.getMessage());
        }
    }

    private void listar() {
        System.out.println("========LISTA DE CIDADES========");

        try {
            ArrayList<Cidade> cidades = dao.buscarTodos(Cidade.class);

            if (cidades.isEmpty()) {
                System.out.println("\n| Nenhuma cidade cadastrada |");
                return;
            }

            System.out.printf("| %-5s | %-20s | %-15s | %-10s | %-20s |\n", 
                "ID", "NOME", "TAMANHO", "CAPITAL", "PAÍS");

            for (Cidade c : cidades) {
                Pais p = dao.consultar(Pais.class, "id", String.valueOf(c.getIdPais()));

                System.out.printf("| %-5d | %-20s | %-15.2f | %-10s | %-20s |\n",
                        c.getId(),
                        c.getNome(),
                        c.getTamanho(),
                        c.getCapitalString(),
                        p.getNome());
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    private void listarPorFiltro(){
        System.out.println("========BUSCA POR FILTRO========");

        try{
            System.out.print("|= Informe o nome do campo: ");
            String campo = scan.nextLine();

            System.out.print("|= Informe o valor do filtro: ");
            String filtro = scan.nextLine();

            ArrayList<Cidade> cidades = dao.buscarTodosFiltro(Cidade.class, campo, filtro);
            
            System.out.println("========LISTA DE CIDADES========");

            if (cidades.isEmpty()) {
                System.out.println("\nAVISO: Nenhuma cidade encontrado!");
                return;
            }

            System.out.printf("| %-5s | %-20s | %-15s | %-10s | %-20s |\n",
                "ID", "NOME", "TAMANHO", "CAPITAL", "PAÍS");

            for (Cidade c : cidades) {
                Pais p = dao.consultar(Pais.class, "id", String.valueOf(c.getIdPais()));

                System.out.printf("| %-5d | %-20s | %-15.2f | %-10s | %-20s |\n",
                        c.getId(),
                        c.getNome(),
                        c.getTamanho(),
                        c.getCapitalString(),
                        p.getNome());
            }
        }   
        catch(Exception e){
            System.out.println("\nERRO: " + e.getMessage());
        }
    }

    private void consultar(){
        System.out.println("========CONSULTA UNICA========");

        try{
            System.out.print("|= Informe o nome do campo: ");
            String campo = scan.nextLine();

            System.out.print("|= Informe o valor do filtro: ");
            String filtro = scan.nextLine();

            Cidade cidade = dao.consultar(Cidade.class, campo, filtro);
            
            if (cidade == null){
                System.out.println("\nAVISO: Nenhum cidade encontrado!");
                return;
            }

            System.out.println("\n----------RESULTADO----------");
            System.out.println("| ID: " + cidade.getId());
            System.out.println("| Nome: " + cidade.getNome());
            System.out.println("| Tamanho: " + cidade.getTamanho());
            System.out.println("| É Capital?: " + cidade.getCapitalString());
            System.out.println("| ID Pais: " + cidade.getIdPais());
            System.out.println("-----------------------------");
        }   
        catch(Exception e){
            System.out.println("\nERRO: " + e.getMessage());
        }
    }

    private void alterar(){
        System.out.println("========ALTERANDO CIDADE========");

        try{
            System.out.println("========CONSULTA UNICA========");

            System.out.print("|= Informe o ID da cidade: ");
            String filtro = scan.nextLine();

            Cidade cidade = dao.consultar(Cidade.class, "id", filtro);

            if (cidade == null) {
                System.out.println("\nAVISO: Nenhum cidade encontrada!");
                return;
            }

            int entrada;
            do{
                System.out.print("\n+------DADOS------\n");
                System.out.println("| [ID: " + cidade.getId() + " ]");
                System.out.println("| [1] Nome - " + cidade.getNome());
                System.out.println("| [2] Tamanho - " + cidade.getTamanho());
                System.out.println("| [3] É Capital? - " + cidade.getCapitalString());
                System.out.println("| [4] ID Pais - " + cidade.getIdPais());
                System.out.println("| [0] Voltar / Alterar");
                System.out.println("-----------------------");
                
                try{
                    System.out.print("|= Escolha uma Opção: ");
                    entrada = Integer.parseInt(scan.nextLine());
                }
                catch(Exception e){
                    System.out.println("| AVISO: " + e.getMessage());
                    entrada = -1;
                }

                if(entrada < 0 || entrada > 4){
                    System.out.println("\nAVISO: Informe um valor valido!");
                }
                else{
                    
                    new ProcessBuilder("clear").inheritIO().start().waitFor(); // Limpa o terminal

                    switch (entrada) {
                        case 1:
                            System.out.print("|= Novo nome: ");
                            cidade.setNome(scan.nextLine());
                        break;
                        case 2:
                            System.out.print("|= Novo tamanho: ");
                            cidade.setTamanho(Integer.parseInt(scan.nextLine()));
                        break;
                        case 3:
                            int entradaCap;
                            do {
                                System.out.println("\n+------Capital?------");
                                System.out.println("| [1] Sim");
                                System.out.println("| [2] Não");
                                System.out.println("-----------------------");

                                System.out.print("| Opção: ");
                                entradaCap = Integer.parseInt(scan.nextLine());

                                if (entradaCap == 1) {
                                    cidade.setCapital(true);
                                }
                                else if (entradaCap == 2) {
                                    cidade.setCapital(false);
                                }
                                else {
                                    System.out.println("| AVISO: Opção inválida!");
                                }

                            } while(entradaCap != 1 && entradaCap != 2);
                        break;
                        case 4:
                            System.out.print("|= Novo ID pais: ");
                            cidade.setIdPais(Integer.parseInt(scan.nextLine()));
                        break;
                        case 0:
                            System.out.println("\nVOLTANDO...\n");
                        break;
                        default:
                            System.out.println("AVISO: Opção invalida!");
                        break;
                    }
                }
            }while(entrada != 0);

            int qtde = dao.alterar(cidade, "id", cidade.getId());

            if(qtde > 0){
                System.out.println("\nSUCESSO: Alteração realizada!\n");
            }
            else{
                System.out.println("\nAVISO: Nenhuma alteração feita!\n");
            }
        } 
        catch (Exception e){
            System.out.println("\nERRO: " + e.getMessage());
        }
    }

    private void excluir(){
        System.out.println("========EXCLUINDO CIDADE========");

        System.out.print("|= Informe o ID da cidade: ");
        int id = Integer.parseInt(scan.nextLine());

        int qtde = dao.excluir(Cidade.class, "id", id);

        if(qtde > 0){
            System.out.println("\nSUCESSO: Exclusão realizada!\n");
        }
        else{
            System.out.println("\nAVISO: Nehuma exclusão feita!\n");
        }
    }
}

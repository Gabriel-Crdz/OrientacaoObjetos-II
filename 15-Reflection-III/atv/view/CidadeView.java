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
                        // listarPorFiltro();
                        break;
                    case 4:
                        // consultar();
                        break;
                    case 5:
                        // alterar();
                        break;
                    case 6:
                        // excluir();
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

            System.out.printf("| %-5s | %-20s | %-15s | %-10s | %-20s% | \n", "ID", "NOME", "TAMANHO", "CAPITAL", "PAÍS");

            for (Cidade c : cidades) {
                Pais p = dao.consultar(Pais.class, "id", c.getIdPais().toString());

                System.out.printf("| %-5d | %-20s | %-15.2f | %-10s | %-20s% | \n",
                        c.getId(),
                        c.getNome(),
                        c.getTamanho(),
                        c.isCapital() ? "Sim" : "Não",
                        p.getNome());
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }
}

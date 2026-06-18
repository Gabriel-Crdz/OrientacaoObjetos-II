package view;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.DaoGenerico;
import enums.ContinenteEnum;
import model.Pais;

public class PaisView {
    private Scanner scan;
    private DaoGenerico dao;

    public PaisView(){
        scan = new Scanner(System.in);
        dao = new DaoGenerico();
    }

    public void exibirMenu(){
        try{
            int opc = -1;
            do {
                System.out.println("\n=======MENU PAISES=======");
                System.out.println("| [1] Cadastrar");
                System.out.println("| [2] Listar todos");
                System.out.println("| [3] Listar por filtro");
                System.out.println("| [4] Consultar");
                System.out.println("| [5] Alterar");
                System.out.println("| [6] Excluir");
                System.out.println("| [0] Sair");
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
                        System.out.println("VOLTADO...\n");
                        break;
                    default:
                        System.out.println("ERRO: Opção invalida!");
                        break;
                }
            } while (opc != 0);
        } catch (Exception e) {
            System.out.println("\nERRO: " + e.getMessage());
        }
    }

    private void cadastrar(){
        System.out.println("========CADASTRO DE PAISES========");

        try{
            Pais p = new Pais();

            System.out.print("| Nome: ");
            p.setNome(scan.nextLine());
            
            int entrada;
            do{
                System.out.print("\n+------Continente------\n");
                System.out.println("| [1] Africa");
                System.out.println("| [2] America do Norte");
                System.out.println("| [3] America do Sul");
                System.out.println("| [4] Asia");
                System.out.println("| [5] Europa");
                System.out.println("| [6] Oceania");
                System.out.print("-----------------------");
                
                try{
                    System.out.print("| Numero do continente: ");
                    entrada = Integer.parseInt(scan.nextLine());
                    
                    ContinenteEnum continente = ContinenteEnum.fromChave(entrada);
                    p.setContinente(continente);
                }
                catch(Exception e){
                    System.out.println("| AVISO: " + e.getMessage());
                    entrada = 0;
                }
            
            }while(entrada < 1 || entrada > 6);

            System.out.print("| Ano de fundação: ");
            p.setFundacao(Integer.parseInt(scan.nextLine()));

            System.out.print("| Idioma Oficial: ");
            p.setIdiomaOficial(scan.nextLine());

            System.out.print("| População: ");
            p.setPopulacao(Integer.parseInt(scan.nextLine()));
            
            dao.inserir(p);

            System.out.println("\nSUCESSO: cadastro realizado!");
        }
        catch(Exception e){
            System.out.println("\nERRO: " + e.getMessage());
        }
    }

    private void listar() {
        ArrayList<Pais> paises = dao.buscarTodos(Pais.class);

        System.out.println("========LISTA DE PAISES========");

        if (paises.isEmpty()) {
            System.out.println("| Nenhum pais encontrado |");
            return;
        }

        System.out.printf(
                "| %-5s | %-20s | %-20s | %-15s | %-20s | %-12s% |\n",
                "ID", "NOME", "CONTINENTE", "FUNCAÇÃO", "IDIOMA", "POPULAÇÃO");

        for (Pais p : paises) {
            System.out.printf(
                    "| %-5d | %-20s | %-20s | %-15s | %-20s | %-12d% |\n",
                    p.getId(),
                    p.getNome(),
                    p.getContinente(),
                    p.getFundacao(),
                    p.getIdiomaOficial(),
                    p.getPopulacao());
        }
    }
}

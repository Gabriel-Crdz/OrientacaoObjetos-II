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
                    System.out.println("AVISO: Informe um valor valido!");
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
                        System.out.println("\nVOLTADO...\n");
                        break;
                    default:
                        System.out.println("AVISO: Opção invalida!");
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

            System.out.print("|= Nome: ");
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
                System.out.println("-----------------------");
                
                try{
                    System.out.print("|= Numero do continente: ");
                    entrada = Integer.parseInt(scan.nextLine());
                    
                    ContinenteEnum continente = ContinenteEnum.fromChave(entrada);
                    p.setContinente(continente);
                }
                catch(Exception e){
                    System.out.println("| AVISO: " + e.getMessage());
                    entrada = 0;
                }

                if(entrada < 1 || entrada > 6){
                    System.out.println("\nAVISO: Informe um valor valido!\n");
                }
            
            }while(entrada < 1 || entrada > 6);

            System.out.print("|= Ano de fundação: ");
            p.setFundacao(Integer.parseInt(scan.nextLine()));

            System.out.print("|= Idioma : ");
            p.setIdioma(scan.nextLine());

            System.out.print("|= População: ");
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
            System.out.println("\nAVISO: Nenhum pais encontrado!");
            return;
        }

        System.out.printf(
                "| %-5s | %-20s | %-20s | %-15s | %-20s | %-12s |\n",
                "ID", "NOME", "CONTINENTE", "FUNDAÇÃO", "IDIOMA", "POPULAÇÃO");

        for (Pais p : paises) {
            System.out.printf(
                    "| %-5d | %-20s | %-20s | %-15d | %-20s | %-12d |\n",
                    p.getId(),
                    p.getNome(),
                    p.getContinente().getdescricao(),
                    p.getFundacao(),
                    p.getIdioma(),
                    p.getPopulacao());
        }
    }

    private void listarPorFiltro(){
        System.out.println("========BUSCA POR FILTRO========");

        try{
            System.out.print("|= Informe o nome do campo: ");
            String campo = scan.nextLine();

            System.out.print("|= Informe o valor do filtro: ");
            String filtro = scan.nextLine();

            ArrayList<Pais> paises = dao.buscarTodosFiltro(Pais.class, campo, filtro);
            
            System.out.println("========LISTA DE PAISES========");

            if (paises.isEmpty()) {
                System.out.println("\nAVISO: Nenhum pais encontrado!");
                return;
            }

            System.out.printf(
                    "| %-5s | %-20s | %-20s | %-15s | %-20s | %-12s |\n",
                    "ID", "NOME", "CONTINENTE", "FUNDAÇÃO", "IDIOMA", "POPULAÇÃO");

            for (Pais p : paises) {
                System.out.printf(
                        "| %-5d | %-20s | %-20s | %-15d | %-20s | %-12d |\n",
                        p.getId(),
                        p.getNome(),
                        p.getContinente().getdescricao(),
                        p.getFundacao(),
                        p.getIdioma(),
                        p.getPopulacao());
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

            Pais pais = dao.consultar(Pais.class, campo, filtro);
            
            if (pais == null) {
                System.out.println("\nAVISO: Nenhum pais encontrado!");
                return;
            }

            System.out.println("\n----------RESULTADO----------");
            System.out.println("| ID: " + pais.getId());
            System.out.println("| Nome: " + pais.getNome());
            System.out.println("| Continente: " + pais.getContinente().getdescricao());
            System.out.println("| Fundação: " + pais.getFundacao());
            System.out.println("| Idioma: " + pais.getIdioma());
            System.out.println("| População: " + pais.getPopulacao());
            System.out.println("-----------------------------");
        }   
        catch(Exception e){
            System.out.println("\nERRO: " + e.getMessage());
        }
    }

    private void alterar(){
        System.out.println("========ALTERANDO PAIS========");

        try{
                System.out.println("========CONSULTA UNICA========");

                System.out.print("|= Informe o ID do pais: ");
                String filtro = scan.nextLine();

                Pais pais = dao.consultar(Pais.class, "id", filtro);

                if (pais == null) {
                    System.out.println("\nAVISO: Nenhum pais encontrado!");
                    return;
                }

            int entrada;
            do{
                System.out.print("\n+------DADOS------\n");
                System.out.println("| [ID: " + pais.getId() + " ]");
                System.out.println("| [1] Nome - " + pais.getNome());
                System.out.println("| [2] Continente - " + pais.getContinente().getdescricao());
                System.out.println("| [3] Fundação - " + pais.getFundacao());
                System.out.println("| [4] Idioma - " + pais.getIdioma());
                System.out.println("| [5] População - " + pais.getPopulacao());
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

                if(entrada < 0 || entrada > 5){
                    System.out.println("\nAVISO: Informe um valor valido!");
                }
                else{
                    
                    new ProcessBuilder("clear").inheritIO().start().waitFor(); // Limpa o terminal

                    switch (entrada) {
                        case 1:
                            System.out.print("|= Novo nome: ");
                            pais.setNome(scan.nextLine());
                        break;
                        case 2:
                            int entradaCont;
                            do{
                                System.out.print("\n+------Continente------\n");
                                System.out.println("| [1] Africa");
                                System.out.println("| [2] America do Norte");
                                System.out.println("| [3] America do Sul");
                                System.out.println("| [4] Asia");
                                System.out.println("| [5] Europa");
                                System.out.println("| [6] Oceania");
                                System.out.println("-----------------------");
                                
                                try{
                                    System.out.print("|= Numero do continente: ");
                                    entradaCont = Integer.parseInt(scan.nextLine());
                                    
                                    ContinenteEnum continente = ContinenteEnum.fromChave(entradaCont);
                                    pais.setContinente(continente);
                                }
                                catch(Exception e){
                                    System.out.println("| AVISO: " + e.getMessage());
                                    entradaCont = 0;
                                }

                                if(entradaCont < 1 || entradaCont > 6){
                                    System.out.println("\nAVISO: Informe um valor valido!\n");
                                }
                        
                            }while(entradaCont < 1 || entradaCont > 6);
                        break;
                        case 3:
                            System.out.print("|= Novo ano de fundação: ");
                            pais.setFundacao(Integer.parseInt(scan.nextLine()));
                        break;
                        case 4:
                            System.out.print("|= Novo idioma: ");
                            pais.setIdioma(scan.nextLine());
                        break;
                        case 5:
                            System.out.print("|= Nova população: ");
                            pais.setPopulacao(Integer.parseInt(scan.nextLine()));
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

            int qtde = dao.alterar(pais, "id", pais.getId());

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
        System.out.println("========EXCLUINDO PAIS========");

        System.out.print("|= Informe o ID do pais: ");
        int id = Integer.parseInt(scan.nextLine());

        int qtde = dao.excluir(Pais.class, "id", id);

        if(qtde > 0){
            System.out.println("\nSUCESSO: Exclusão realizada!\n");
        }
        else{
            System.out.println("\nAVISO: Nenhuma exclusão feita!\n");
        }
}
}

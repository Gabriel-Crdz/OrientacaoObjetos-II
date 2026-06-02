package controller;

import java.util.ArrayList;
import java.util.Scanner;

import dao.DaoVeiculo;
import model.Veiculo;


public class GerenciadorVeiculo {
    Scanner scanner;
    DaoVeiculo daoVeiculo;

    public GerenciadorVeiculo(){
        scanner = new Scanner(System.in);
        daoVeiculo = new DaoVeiculo();
    }

    public void menu(){
        int opcao = -1;
        while (opcao != 0) {
			System.out.println("\n-------------------------------");
			System.out.println("Gerenciamento de Veiculos");            
			System.out.println("[1] Cadastrar");            
			System.out.println("[2] Consultar");            
			System.out.println("[3] Alterar");            
			System.out.println("[4] Excluir");            
			System.out.println("[5] Listar Todos");            
			System.out.println("[0] Sair");            
			System.out.println("\n-------------------------------");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Informe um nro inteiro");
            }

            switch (opcao) {
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
                System.out.println("Até logo.");
                break;
            default:
                System.out.println("Opção inválida.");
                break;
            }
        }
    }

    public void cadastrar(){
        Veiculo v = new Veiculo();
        System.out.println("------------------------------");
        System.out.println("[Cadastro de Veículos]");
        System.out.println("Marca: ");
        v.setMarca(scanner.nextLine());
        System.out.println("Modelo: ");
        v.setModelo(scanner.nextLine());
        System.out.println("Chassi: ");
        v.setChassi(scanner.nextLine());
        System.out.println("Ano: ");
        v.setAno(Integer.parseInt(scanner.nextLine()));

        //passa para a camada model
        boolean inserido = daoVeiculo.inserir(v);
        if(inserido){
            System.out.println("Inserido com sucesso.");
        }
    }

    public void listarTodos(){
        ArrayList<Veiculo> veiculos = daoVeiculo.buscarTodos();
        System.out.println("----------------------------");
        System.out.println("Veículos Cadastrados");
        for(Veiculo v : veiculos){
            System.out.println("Código: " + v.getCodigo()
                + ", Marca: " + v.getMarca()
                + ", Modelo: " + v.getModelo()
                + ", Chassi: " + v.getChassi()
                + ", Ano: " + v.getAno());
        }
    }

    public void excluir(){
        System.out.println("----------------------------");
        System.out.println("Exclusão de veículo");
        System.out.println("Código:");
        int codigo = Integer.parseInt(scanner.nextLine());
        int qtde = daoVeiculo.excluir(codigo);
        if(qtde > 0){
            System.out.println("Excluído com sucesso.");
        }else{
            System.out.println("Não encontrado...");
        }
    }

    public void consultar(){
        System.out.println("----------------------------");
        System.out.println("Consulta de veículo");
        System.out.println("Código:");
        int codigo = Integer.parseInt(scanner.nextLine());
        Veiculo v = daoVeiculo.consultar(codigo);
        if(v != null){
            System.out.println("[Dados do veículo]");
            System.out.println("Código: " + v.getCodigo());
            System.out.println("Marca: " + v.getMarca());
            System.out.println("Modelo: " + v.getModelo());
            System.out.println("Chassi: " + v.getChassi());
            System.out.println("Ano: " + v.getAno());
        }else{
            System.out.println("Não encontrado...");
        }
    }

    public void alterar(){
        System.out.println("----------------------------");
        System.out.println("Alteração de veículo");
        System.out.println("Código:");
        int codigo = Integer.parseInt(scanner.nextLine());
        Veiculo v = daoVeiculo.consultar(codigo);

        if(v != null){
            System.out.println("[Dados do veículo]");
            System.out.println("[Código: " + v.getCodigo() + "]");

            System.out.println("[Marca: " + v.getMarca() + "]");
            String marca = scanner.nextLine();
            if(!marca.isEmpty()){
                v.setMarca(marca);
            }

            System.out.println("[Modelo: " + v.getModelo() + "]");
            String modelo = scanner.nextLine();
            if(!modelo.isEmpty()){
                v.setModelo(modelo);
            }

            System.out.println("[Chassi: " + v.getChassi() + "]");
            String chassi = scanner.nextLine();
            if(!chassi.isEmpty()){
                v.setChassi(chassi);
            }

            System.out.println("[Ano: " + v.getAno() + "]");
            String ano = scanner.nextLine();
            if(!ano.isEmpty()){
                v.setAno(Integer.parseInt(ano));
            }

            int qtdeAlterado = daoVeiculo.alterar(v);
            if(qtdeAlterado > 0){
                System.out.println("Atualizado com sucesso.");
            }else{
                System.out.println("Não foi possível atualizar.");
            }
        }else{
            System.out.println("Não encontrado...");
        }        
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Sistema {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static int contadorOrcamento = 1;

    public static void main(String[] args) throws Exception {
        menu();
    }

    public static void menu() throws Exception{
        int opc = -1;

        do { 
            System.out.println("");
            System.out.println("==========MENU==========");
            System.out.println("[1] Cadastrar cliente");
            System.out.println("[2] Listar clientes");
            System.out.println("[3] Cadastrar Orçamento");
            System.out.println("[4] Listar Orçamentos");
            System.out.println("[0] Sair");
            System.out.println("========================");

            System.out.print("Escolha uma opção: ");
            opc = Integer.parseInt(input.readLine());

            switch (opc) {

                case 1:
                    cadastrarCliente();
                    break;

                case 2:
                    listarClientes();
                    break;

                case 3:
                    cadastrarOrcamento();
                    break;

                case 4:
                    listarOrcamentos();
                    break;

                case 0:
                    System.out.println("SAINDO...");
                    break;

                default:
                    System.out.println("Entrada inválida!");
            }

        } while (opc != 0);
    }

    public static void cadastrarCliente() throws Exception{

        System.out.println("+===CADASTRO CLIENTE===");
        Cliente c = new Cliente();

        System.out.print("|= Nome: ");
        c.setNome(input.readLine());

        System.out.print("|= CPF: ");
        c.setCpf(input.readLine());

        System.out.print("|= Email: ");
        c.setEmail(input.readLine());

        System.out.print("|= Telefone: ");
        c.setFone(input.readLine());

        c.setOrcamento(new ArrayList<>());

        clientes.add(c);

    }

    // LISTAR CLIENTES
    public static void listarClientes(){

        if(clientes.isEmpty()){
            System.out.println("\nNenhum cliente cadastrado.\n");
            return;
        }

        System.out.println("====CLIENTES====");
        for(int i=0;i<clientes.size();i++){

            Cliente c = clientes.get(i);

            System.out.println("Cliente " + (i+1));
            System.out.println("Nome: " + c.getNome());
            System.out.println("CPF: " + c.getCpf());
            System.out.println("Email: " + c.getEmail());
            System.out.println("Telefone: " + c.getFone());
            System.out.println("-------------------");
        }
    }

    // CADASTRAR ORÇAMENTO
    public static void cadastrarOrcamento() throws Exception{

        if(clientes.isEmpty()){
            System.out.println("\nCadastre um cliente primeiro.");
            return;
        }

        listarClientes();

        System.out.println("+===CADASTRO ORÇAMENTO====");
        System.out.print("|= Escolha o número do cliente: ");
        int indice = Integer.parseInt(input.readLine()) - 1;

        System.out.println("\n+===DADOS DO ORÇAMENTO====");
        Cliente cliente = clientes.get(indice);

        Orcamento o = new Orcamento();

        o.setId(contadorOrcamento++);

        System.out.print("|= Valor total: ");
        o.setValorTotal(Double.parseDouble(input.readLine()));

        System.out.print("|= Data de criação: ");
        o.setDataCriacao(input.readLine());

        System.out.print("|= Data limite: ");
        o.setDataLimite(input.readLine());

        o.setStatus(true);

        cliente.getOrcamento().add(o);

    }

    // LISTAR ORÇAMENTOS
    public static void listarOrcamentos(){

        for(Cliente c : clientes){

            System.out.println("Cliente: " + c.getNome());

            ArrayList<Orcamento> lista = c.getOrcamento();

            if(lista.isEmpty()){
                System.out.println("Nenhum orçamento.");
            }

            for(Orcamento o : lista){

                System.out.println("ID: " + o.getId());
                System.out.println("Valor: " + o.getValorTotal());
                System.out.println("Data criação: " + o.getDataCriacao());
                System.out.println("Data limite: " + o.getDataLimite());
                System.out.println("Status: " + (o.isStatus() ? "Ativo" : "Finalizado"));
                System.out.println("-------------------");
            }
        }
    }
}
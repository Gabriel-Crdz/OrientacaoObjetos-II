
import java.util.ArrayList;
import java.util.Iterator;

public class ListaClientes {
    public static void main(String[] args) {
        ArrayList<Cliente> lista = new ArrayList<Cliente>();

        Cliente c1 = new Cliente();
        c1.setNome("Humberto");
        c1.setEmail("Humberto@ifpr");
        c1.setCpf("123456");
        lista.add(c1);

        Cliente c2 = new Cliente();
        c2.setNome("Vinicius");
        c2.setEmail("Vinicius@ifpr");
        c2.setCpf("124679");
        lista.add(c2);

        Cliente c3 = new Cliente();
        c3.setNome("Guilherme");
        c3.setEmail("Guilherme@ifpr");
        c3.setCpf("974321");
        lista.add(c3);


        Cliente c4 = new Cliente();
        c4.setNome("Marcos");
        c4.setEmail("marcos@ifpr");
        c4.setCpf("346234");
        lista.add(c4);

        System.out.println("\nPercorrer com iterator:");
        Iterator<Cliente> itCliente = lista.iterator();
        while(itCliente.hasNext()){
            Cliente c = itCliente.next(); // Aponta para o proximo objeto cliente
            System.out.println("Nome: " + c.getNome() + "| CPF: " + c.getCpf());
        }

        System.out.println("\nPercorrer com Foreach");
        for(Cliente c : lista){
            System.out.println("Nome: " + c.getNome() + "| CPF: " + c.getCpf());
        }

        /* Removendo itens da lista */
        Cliente removeCliente = new Cliente(); // Declarar um novo objeto
        removeCliente.setCpf("123456"); // Informa o valor do campo para encontrar aquele objeto especifico
        Iterator<Cliente> itRemove = lista.iterator();
        while(itRemove.hasNext()){
            System.out.println("\nRemovendo o cliente com CPF: " + removeCliente.getCpf());
            if(itRemove.next().getCpf().equals(removeCliente.getCpf())) itRemove.remove(); // Remove o objeto apontado pelo iterator
        }

        
        removeCliente.setCpf("124679"); // Informa o valor do campo para encontrar aquele objeto especifico
        for (Cliente c : lista) {
           if(c.getCpf().equals(removeCliente.getCpf())){
            System.out.println("Removendo o cliente de CPF: " + removeCliente.getCpf());
            itRemove.remove();
            break; // Se o elemento for o ultimo, dá exceção, a menos que use break
           }
        }
    }
}

package exercicio;
public class Testador {
    public static void main(String[] args) {
        Produto p =  new Produto("Pizza", 12, 2);
        Usuario u = new Usuario("Carlos Birinto", "Carlos.birinto@gmail.com", false);
        try{
            String conteudo = GeradorJson.serializar(p);
            System.out.println(conteudo);

            conteudo = GeradorJson.serializar(u);
            System.out.println(conteudo);
        }
        catch(Exception e){

        }
        
    }
}

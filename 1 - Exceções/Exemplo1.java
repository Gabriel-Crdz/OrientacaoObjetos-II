
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exemplo1 {
    public static void main(String[] args) {
        Exemplo1 e1 = new Exemplo1();
        e1.lerArquivo();
    }    
    
    public void lerArquivo(){
        try{
            String arqEntrada  = "arq.txt";
            BufferedReader reader = new BufferedReader(new FileReader(arqEntrada));
            String linha;
            while((linha = reader.readLine()) != null){
                System.err.println(linha);
            }
        } catch (FileNotFoundException e){
            System.err.println("Arquivo não encontrado!");
        } catch (IOException e){
            System.err.println("Erro na leitura do arquivo!"); 
        } catch (Exception e){
            System.err.println("Erro Inesperado!");
            System.err.println("Detalhes: " + e.getMessage());
        } finally{
            System.err.println("Saindo...");
        }
    }
}

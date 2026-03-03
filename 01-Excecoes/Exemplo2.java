import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exemplo2 {
    public static void main(String[] args){
        Exemplo2 e2 = new Exemplo2();

        /* Teste com arquivo existente */
        String status = e2.lerArquivo("arq.txt");
        System.out.println(status);

        /* Teste com arquivo inexistente */
        status = e2.lerArquivo("outroArq.txt");
        System.out.println(status);
    }    

    public String lerArquivo(String nomeArq){
        String retorno = "OK";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(nomeArq));
            String linha;
            while((linha = reader.readLine()) != null){
               System.out.println(linha);
            }
        } catch (FileNotFoundException e){
            retorno = "Arquivo não encontrado!";
        } catch (IOException e){
            retorno = "Erro na leitura do arquivo!"; 
        } catch (Exception e){
            retorno = "Erro Inesperado!";
            retorno += "Detalhes: " + e.getMessage();
        } finally{
            retorno += " Encerrando!";
        }
        return retorno;
    }
}

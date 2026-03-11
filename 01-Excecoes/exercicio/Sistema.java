import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Sistema {
    public static void main(String[] args) {

        String arqValido = validarArquivo();
        lerDados(arqValido);
    }

    static String validarArquivo(){
        boolean valido = false;
        String arq = "";

        while(valido == false){
            try{
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

                System.out.print("Informe o nome do arquivo: ");
                String arqEntrada = input.readLine();

                BufferedReader reader = new BufferedReader(new FileReader(arqEntrada));
                valido = true;
                arq = arqEntrada;
                reader.close();
            } 
            catch(FileNotFoundException e1){
                System.out.println("ERRO: Arquivo não encontrado!\n");
            }
            catch(IOException e2){
                System.out.println("ERRO: não foi possivel ler o arquivo!\n");
            }
            catch(Exception e3){
                System.out.println("ERRO: " + e3.getMessage() + "\n");
            }
        }
        return arq;
    }

    static void lerDados(String arq){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formatação da data

        try{
            BufferedReader reader = new BufferedReader(new FileReader(arq));

            String linha = reader.readLine();
            if(linha == null) throw new EmptyFileException(); // Se a linha for nula lança a exceção

            System.out.printf("%-10s | %-10s%n", "Nome", "Data"); // Formatação da tabela
            while((linha = reader.readLine()) != null){
                String[] campos = linha.split(";");
                LocalDate data = LocalDate.parse(campos[1], formato); // Converte String para data e soma 7 dias
                System.out.printf("%-10s | %-10s\n", campos[0], data.format(formato));
            }
            reader.close();
        }
        catch(EmptyFileException e1){
            System.out.println("ERRO: " + e1.getMessage());
        }
        catch(DateTimeParseException e2){
            System.out.println("ERRO: Data Invalida");
        }
        catch(Exception e3){
            System.out.println("ERRO: " + e3.getMessage());
        }
    }
}



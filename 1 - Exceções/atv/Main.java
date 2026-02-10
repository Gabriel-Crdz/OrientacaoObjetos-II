/*
    TO DO:
    fazer a leitura dos dados(validação das datas);
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        Main s1 = new Main();
        String arqValido = s1.validaArquivo();
        s1.lerDados(arqValido);
    }
}

public String validaArquivo() throws EmptyFileException{
    try {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String arqEntrada = input.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(arqEntrada));

        String linha;
        while(linha = reader.readLine() != null){
            if
        }
        
    } 
    catch (FileNotFoundException e1){
        System.out.println("ERRO: Arquivo nao encontrado!");
    }
    catch (IOException e2){
       System.out.println("ERRO: Erro na leitura do arquivo!");
    }
    catch(EmptyFileException e3){
        System.out.println("ERRO: " + e3.getMessage());
    }
}

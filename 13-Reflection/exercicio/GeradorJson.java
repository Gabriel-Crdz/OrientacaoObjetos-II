package exercicio;

import java.lang.reflect.Field;

public class GeradorJson {
    
    public static String serializar(Object obj) throws Exception{
        if(obj == null){
            return "null";
        }

        Class<?> c = obj.getClass();
        Field fields[] = c.getDeclaredFields(); 
        String conteudo = "";

        for (Field f : fields) {

            String nome = f.getName();
            f.setAccessible(true);

            Object valor = f.get(obj);

            String linha;
            if(valor instanceof String){
                linha = "\"" +  nome + "\": \"" + valor + "\"";
            }
            else{
                linha = "\"" +  nome + "\": " + String.valueOf(valor);
            }
            if(conteudo != ""){
                conteudo += ",";
            }

            conteudo += linha;
        }

        return "{ " + conteudo + " }";
    }
}

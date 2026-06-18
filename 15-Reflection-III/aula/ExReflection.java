import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ExReflection {
    public static void main(String[] args) {
        try{
            // Se eu sei o nome da classe
            // Class c = Class.forName("Veiculo");
            
            /* Se recebo um objeto e não sei seu tipo  */
            Veiculo v = new Veiculo();
            Class<?> c = v.getClass(); // <?>: Informa que recebera um objeto, mas sem saber a classe

            System.out.println(c.getName());

            System.out.println("-------------------------");
            System.out.println("Atributos\n");

            Field fields[] = c.getDeclaredFields(); // Captura os atributos declarados na classe

            for (Field f : fields) {
                System.out.println("Detalhado: " + f.toString());
                System.out.println("Somente o nome: " + f.getName());
                System.out.println("Somente Tipo: " + f.getType());
                System.out.println("");
            }

            System.out.println("-------------------------");
            System.out.println("Metodos:\n");

            Method metodos[] = c.getDeclaredMethods(); // Captura os metodos declarados na classe

            for(Method m : metodos){
                System.out.println("Detalhado: " + m.toString());
                System.out.println("Somente o nome: " + m.getName());

                Parameter parametros[] = m.getParameters(); // Captura os parametros declarados nos metodos da classe

                for (Parameter p : parametros) {
                    /* Nome de parametros só é armazenado no .class se compilar com - parameters */

                    System.out.println("Parametros: " + p.getName());
                    System.out.println("Tipos: " + p.getParameterizedType());
                    System.out.println("");
                }

                System.out.println("Dando um valor: ");
                if(m.getName().equals("setAno")){
                    m.invoke(v, 2026); // Invoca um Objeto existente da classe e chama o metodo

                    m.invoke(c.getDeclaredConstructor().newInstance(), 2020); // Instancia um Objeto e chama o metodo
                }

                
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
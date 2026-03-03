public class Exemplo3{
    public static void main(String[] args) throws Exception{
        Exemplo3 e = new Exemplo3();
        e.calcular();

    }
    
    public void calcular(){
        try {
            Operacoes opcMat = new Operacoes();
            float res = opcMat.dividir(12, 4);
            System.out.println(res);
            res = opcMat.dividir(4, 0);
            System.out.println(res);

        } catch (ZeroDivException e) {
            System.out.println(e.getMessage());
        }
    }
}
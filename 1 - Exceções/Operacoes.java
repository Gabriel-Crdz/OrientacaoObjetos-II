public class Operacoes {
    public float somar(float num1, float num2){
        return num1 + num2;
    }

    public float subtrair(float num1, float num2){
        return num1 - num2;
    }

    public float multiplicar(float num1, float num2){
        return num1 * num2;
    }

    public float dividir(float num1, float num2) throws ZeroDivException{
        if(num2 == 0){
            throw new ZeroDivException();
        }
        else{
            return num1 / num2;
        }
        
    }
}
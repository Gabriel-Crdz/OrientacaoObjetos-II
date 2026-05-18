enum Nivel{ // Declaração fora da classe
    BAIXO,
    MEDIO,
    ALTO
}

public class ExEnum2 {
    public static void main(String[] args) {
        Nivel nivelAtual = Nivel.MEDIO;

        switch (nivelAtual) {
            case BAIXO:
                System.out.println("Nível baixo");
                break;
            case MEDIO:
                System.out.println("Nível médio");
                break;
            case ALTO:
                System.out.println("Nível alto");
                break;  
        }

        /* percorrendo as opções */
        for (Nivel n : Nivel.values()) {
            System.out.println(n);
        }
    }
}

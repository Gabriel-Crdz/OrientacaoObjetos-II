public class ExEnum1 {
    enum Turno{ // Declaração dentro da classe
        MANHA,
        TARDE,
        NOITE
    }
    
    public static void main(String[] args) {
        Turno turnoCurso = Turno.NOITE;
        System.out.println(turnoCurso);
    }
}
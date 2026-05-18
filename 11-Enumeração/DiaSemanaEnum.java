public enum DiaSemanaEnum {
    SEG("Segunda-feira"),
    TER("Terça-feira"),
    QUA("Quarta-feira"),
    QUI("Quinta-feira"),
    SEX("Sexta-feira"),
    SAB("Sabado"),
    DOM("Domingo");

    private String dia;

    DiaSemanaEnum(String nomeDia){ // Metodo Construtor
        this.dia = nomeDia;
    }

    public String getDia(){
        return dia;
    }
}

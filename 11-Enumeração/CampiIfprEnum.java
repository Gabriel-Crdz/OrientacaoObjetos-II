public enum CampiIfprEnum {
    FOZ("IFPR Campus Foz do Iguaçu", 2009, "(45)3422-5300"),
    CASCAVEL("IFPR Campus Cascavel", 2011, "(45)3423-3344"),
    CURITIBA("IFPR Campus Curitiba", 2008, "(45)3112-1100"),
    CAPANEMA("IFPR Campus Capanema", 2014, "(45)2244-6565");

    String nome, fone;
    int anoCriacao;

    CampiIfprEnum(String nome , int ano, String fone){
        this.nome = nome;
        this.anoCriacao = ano;
        this.fone = fone;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }
    public void setFone(String fone) {
        this.fone = fone;
    }

    public int getAnoCriacao() {
        return anoCriacao;
    }
    public void setAnoCriacao(int anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    
}

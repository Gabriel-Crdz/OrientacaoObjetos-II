public enum LivrosEnum {
    DOM_CASMURRO("Dom Casmurro", 1889, "Romance"),
    DUNA("Duna", 1965, "Ficção Cientifica"),
    ILUMINADO("O Iluminado", 1977, "Terror"),
    SAPIENS("Sapiens: Uma Breve Historia da Huamnidade", 2011, "Historia");

    String nome, genero;
    int ano;

    LivrosEnum(String nome, int ano, String genero){
        this.nome = nome;
        this.ano = ano;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    
}
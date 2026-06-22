package model;

public class Cidade {
    private int id;
    private String nome;
    private Float tamanho;
    private boolean capital;
    private int idPais;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getTamanho() {
        return tamanho;
    }
    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }
    public int getIdPais() {
        return idPais;
    }
    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public boolean isCapital() {
        return capital;
    }
    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    public String getCapitalString() {
        return this.capital ? "Sim" : "Não";
    }
    
}

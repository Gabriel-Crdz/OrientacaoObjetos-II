package model;

public class Cidade {
    private Integer id;
    private String nome;
    private Float tamanho;
    private boolean capital;
    private Integer idPais;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
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
    public Integer getIdPais() {
        return idPais;
    }
    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public boolean isCapital() {
        return capital;
    }
    public void setCapital(boolean capital) {
        this.capital = capital;
    }
}

package model;

import enums.ContinenteEnum;

public class Pais {
    private int id;
    private String nome;
    private ContinenteEnum continente;
    private int fundacao;
    private String idioma;
    private int populacao;

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
    public ContinenteEnum getContinente() {
        return continente;
    }
    public void setContinente(ContinenteEnum continente) {
        this.continente = continente;
    }
    public String getIdioma() {
        return idioma;
    }
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    public int getPopulacao() {
        return populacao;
    }
    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }
    public int getFundacao() {
        return fundacao;
    }
    public void setFundacao(int fundacao) {
        this.fundacao = fundacao;
    }
}


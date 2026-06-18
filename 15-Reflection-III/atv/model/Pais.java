package model;

import enums.ContinenteEnum;

public class Pais {
    private Integer id;
    private String nome;
    private ContinenteEnum continente;
    private int fundacao;
    private String idiomaOficial;
    private Integer populacao;

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
    public ContinenteEnum getContinente() {
        return continente;
    }
    public void setContinente(ContinenteEnum continente) {
        this.continente = continente;
    }
    public String getIdiomaOficial() {
        return idiomaOficial;
    }
    public void setIdiomaOficial(String idiomaOficial) {
        this.idiomaOficial = idiomaOficial;
    }
    public Integer getPopulacao() {
        return populacao;
    }
    public void setPopulacao(Integer populacao) {
        this.populacao = populacao;
    }
    public int getFundacao() {
        return fundacao;
    }
    public void setFundacao(int fundacao) {
        this.fundacao = fundacao;
    }
}


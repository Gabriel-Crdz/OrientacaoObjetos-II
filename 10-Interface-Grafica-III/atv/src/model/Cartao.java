package model;

public class Cartao {
    private int codigo;
    private String numCartao;
    private String nomeTitular;
    private String agencia;
    private String bandeira;
    private String cvv;
    private String dataValidade;
    private double limiteTotal;
    private double faturaAtual;

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNumCartao() {
        return numCartao;
    }
    public void setNumCartao(String numCartao) {
        this.numCartao = numCartao;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }
    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getAgencia() {
        return agencia;
    }
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getBandeira() {
        return bandeira;
    }
    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getCvv() {
        return cvv;
    }
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getDataValidade() {
        return dataValidade;
    }
    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public double getLimiteTotal() {
        return limiteTotal;
    }
    public void setLimiteTotal(double limiteTotal) {
        this.limiteTotal = limiteTotal;
    }

    public double getFaturaAtual() {
        return faturaAtual;
    }
    public void setFaturaAtual(double faturaAtual) {
        this.faturaAtual = faturaAtual;
    }

}

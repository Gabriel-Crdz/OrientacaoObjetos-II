/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author gabriel
 */
public class Cartao {
    private int codigo;
    private int numCartao;
    private String nomeTitular;
    private String agencia;
    private String bandeira;
    private int cvv;
    private double limiteCredito;
    private int dataLimite;

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public int getNumCartao() {
        return numCartao;
    }
    public void setNumCartao(int numCartao) {
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

    public int getCvv() {
        return cvv;
    }
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }
    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public int getDataLimite() {
        return dataLimite;
    }
    public void setDataLimite(int dataLimite) {
        this.dataLimite = dataLimite;
    }
}

package model;

public class Vendedor {
    private int codigo;
    private String nome;
    private String contato;
    private String cargo;
    private int anoAdmissao;
    private float salarioBase;

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }
    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getAnoAdmissao() {
        return anoAdmissao;
    }
    public void setAnoAdmissao(int anoAdmissao) {
        this.anoAdmissao = anoAdmissao;
    }

    public float getSalarioBase() {
        return salarioBase;
    }
    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

}

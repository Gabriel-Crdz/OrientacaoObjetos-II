
import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String Cpf;
    private String email;
    private String fone;
    private ArrayList<Orcamento> Orcamento;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return Cpf;
    }
    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }
    public void setFone(String fone) {
        this.fone = fone;
    }
    
    public ArrayList<Orcamento> getOrcamento() {
        return Orcamento;
    }
    public void setOrcamento(ArrayList<Orcamento> orcamento) {
        Orcamento = orcamento;
    }
    
}

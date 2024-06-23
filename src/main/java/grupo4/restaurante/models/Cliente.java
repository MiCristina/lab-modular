package grupo4.restaurante.models;
public class Cliente {
    private int numPessoas;
    private String nome;

    public Cliente(String nome, int numPessoas) {
        this.nome = nome;
        this.numPessoas = numPessoas;
    }

    
    public int getNumPessoas() {
        return numPessoas;
    }

    public String getNome() {
        return nome;
    }
}

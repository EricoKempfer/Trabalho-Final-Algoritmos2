public class Cliente {
    private static int contadorId = 1;
    private int id;
    private String nome;
    private String cpf;
    private String cidade;

    public Cliente(String nome, String cpf, String cidade) {
        this.id = contadorId++;
        this.nome = nome;
        this.cpf = cpf;
        this.cidade = cidade;
    }

    // Getters e Setters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", CPF: " + cpf + ", Cidade: " + cidade;
    }
}
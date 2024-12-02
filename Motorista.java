public class Motorista {
    private static int contadorId = 1;
    private int id;
    private String nome;
    private String cpf;
    private String cnh;
    private String cidade;
    private boolean emViagem;

    public Motorista(String nome, String cpf, String cnh, String cidade) {
        this.id = contadorId++;
        this.nome = nome;
        this.cpf = cpf;
        this.cnh = cnh;
        this.cidade = cidade;
        this.emViagem = false;
    }

    // Getters e Setters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getCnh() { return cnh; }
    public void setCnh(String cnh) { this.cnh = cnh; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public boolean isEmViagem() { return emViagem; }
    public void setEmViagem(boolean emViagem) { this.emViagem = emViagem; }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", CPF: " + cpf + ", CNH: " + cnh + 
        ", Cidade: " + cidade + ", Em Viagem: " + (emViagem ? "Sim" : "Não");
    }
}
import java.util.List;

public class Viagem {
  private static int contadorId = 1;
  private int id;
  private String descricao;
  private String cidadeOrigem;
  private String cidadeDestino;
  private List<Produto> produtos;
  private Motorista motorista;
  private Cliente cliente;
  private String status; // "Iniciada" ou "Finalizada"

  public Viagem(String descricao, String cidadeOrigem, String cidadeDestino,
    List<Produto> produtos, Motorista motorista, Cliente cliente) {
  this.id = contadorId++;
  this.descricao = descricao;
  this.cidadeOrigem = cidadeOrigem;
  this.cidadeDestino = cidadeDestino;
  this.produtos = produtos;
  this.motorista = motorista;
  this.cliente = cliente;
  this.status = "Iniciada";
}

    // Getters e Setters
    public int getId() { return id; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getCidadeOrigem() { return cidadeOrigem; }
    public void setCidadeOrigem(String cidadeOrigem) { this.cidadeOrigem = cidadeOrigem; }
    public String getCidadeDestino() { return cidadeDestino; }
    public void setCidadeDestino(String cidadeDestino) { this.cidadeDestino = cidadeDestino; }
    public List < Produto > getProdutos() { return produtos; }
    public void setProdutos(List < Produto > produtos) { this.produtos = produtos; }
    public Motorista getMotorista() { return motorista; }
    public void setMotorista(Motorista motorista) { this.motorista = motorista; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

@Override
public String toString() {
  return "ID: " + id + ", Descrição: " + descricao +
    ", Cidade Origem: " + cidadeOrigem + ", Cidade Destino: " + cidadeDestino +
    ", Motorista: " + motorista.getNome() +
    ", Cliente: " + cliente.getNome() +
    ", Status: " + status +
    ", Produtos: " + produtos.stream()
      .map(Produto::getNome)
      .toList().toString();
}
}
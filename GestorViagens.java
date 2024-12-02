import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorViagens {
    private List<Viagem> viagens = new ArrayList<>();
    private GestorMotoristas gestorMotoristas;
    private GestorClientes gestorClientes;
    private GestorProdutos gestorProdutos;

    public GestorViagens(GestorMotoristas gestorMotoristas, GestorClientes gestorClientes, GestorProdutos gestorProdutos) {
        this.gestorMotoristas = gestorMotoristas;
        this.gestorClientes = gestorClientes;
        this.gestorProdutos = gestorProdutos;
    }

    public void listarViagens() {
        if (viagens.isEmpty()) {
            System.out.println("Nenhuma viagem cadastrada.");
        } else {
            viagens.forEach(System.out::println);
        }
    }

    public void iniciarViagem(Scanner scanner) {
        System.out.print("Digite uma descrição para a viagem: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite a cidade de origem: ");
        String cidadeOrigem = scanner.nextLine();
        System.out.print("Digite a cidade de destino: ");
        String cidadeDestino = scanner.nextLine();

        System.out.println("Selecione um motorista disponível:");
        gestorMotoristas.listar();
        System.out.print("Digite o ID do motorista: ");
        int idMotorista = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        Motorista motorista = gestorMotoristas.buscarPorId(idMotorista);

        if (motorista == null || motorista.isEmViagem()) {
            System.out.println("Motorista inválido ou já em viagem.");
            return;
        }

        System.out.println("Selecione um cliente:");
        gestorClientes.listar();
        System.out.print("Digite o ID do cliente: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        Cliente cliente = gestorClientes.buscarPorId(idCliente);

        if (cliente == null) {
            System.out.println("Cliente inválido.");
            return;
        }

        List<Produto> produtosSelecionados = new ArrayList<>();
        System.out.println("Selecione os produtos (digite 0 para encerrar):");
        gestorProdutos.listar();
        while (true) {
            System.out.print("Digite o ID do produto: ");
            int idProduto = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            if (idProduto == 0) break;

            Produto produto = gestorProdutos.buscarPorId(idProduto);
            if (produto != null) {
                produtosSelecionados.add(produto);
            } else {
                System.out.println("Produto inválido.");
            }
        }

        if (produtosSelecionados.isEmpty()) {
            System.out.println("Você deve selecionar ao menos um produto.");
            return;
        }

        Viagem novaViagem = new Viagem(descricao, cidadeOrigem, cidadeDestino, produtosSelecionados, motorista, cliente);
        viagens.add(novaViagem);
        motorista.setEmViagem(true);
        System.out.println("Viagem iniciada com sucesso!");
    }

    public void finalizarViagem(Scanner scanner) {
        listarViagens();
        System.out.print("Digite o ID da viagem para finalizar: ");
        int idViagem = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        Viagem viagem = buscarViagemPorId(idViagem);

        if (viagem == null) {
            System.out.println("Viagem não encontrada.");
        } else if ("Finalizada".equals(viagem.getStatus())) {
            System.out.println("A viagem já está finalizada.");
        } else {
            viagem.setStatus("Finalizada");
            viagem.getMotorista().setEmViagem(false);
            System.out.println("Viagem finalizada com sucesso!");
        }
    }

    private Viagem buscarViagemPorId(int id) {
        return viagens.stream()
                .filter(viagem -> viagem.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
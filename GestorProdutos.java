import java.util.Scanner;

public class GestorProdutos extends Gestor<Produto> {

    @Override
    protected Produto criarEntidade(Scanner scanner) {
        System.out.print("Digite o nome do produto: ");
        String productName = scanner.nextLine();
        System.out.print("Digite a quantidade: ");
        int productQuantity = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        return new Produto(productName, productQuantity);
    }

    @Override
    protected Produto buscarPorId(int id) {
        return entidades.stream()
                .filter(produto -> produto.getProductId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    protected Produto buscarPorNome(String nome) {
        return entidades.stream()
                .filter(produto -> produto.getProductName().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    @Override
    protected void atualizarEntidade(Produto produto, Scanner scanner) {
    boolean continuar = true;

    while (continuar) {
        System.out.println("Selecione o atributo que deseja editar:");
        System.out.println("1. Nome");
        System.out.println("2. Quantidade");
        System.out.println("3. Sair");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        switch (opcao) {
            case 1:
                System.out.print("Digite o novo nome (atual: " + produto.getProductName() + "): ");
                String productName = scanner.nextLine();
                produto.setProductName(productName);
                System.out.println("Nome atualizado!");
                break;
            case 2:
                System.out.print("Digite a nova quantidade (atual: " + produto.getProductQuantity() + "): ");
                int productQuantity = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer
                produto.setProductQuantity(productQuantity);
                System.out.println("Quantidade atualizada!");
                break;
            case 3:
                continuar = false;
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
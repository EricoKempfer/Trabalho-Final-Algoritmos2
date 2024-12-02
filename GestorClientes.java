import java.util.Scanner;

public class GestorClientes extends Gestor<Cliente> {

    @Override
    protected Cliente criarEntidade(Scanner scanner) {
        System.out.print("Digite o nome do cliente: ");
        String customerName = scanner.nextLine();
        System.out.print("Digite o CPF: ");
        String customerCpf = scanner.nextLine();
        System.out.print("Digite a cidade: ");
        String customerCity = scanner.nextLine();
        return new Cliente(customerName, customerCpf, customerCity);
    }

    @Override
    protected Cliente buscarPorId(int id) {
        return entidades.stream()
                .filter(cliente -> cliente.getCustomerId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    protected Cliente buscarPorNome(String nome) {
        return entidades.stream()
                .filter(cliente -> cliente.getCustomerName().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    @Override
    protected void atualizarEntidade(Cliente cliente, Scanner scanner) {
    boolean continuar = true;

    while (continuar) {
        System.out.println("Selecione o atributo que deseja editar:");
        System.out.println("1. Nome");
        System.out.println("2. CPF");
        System.out.println("3. Cidade");
        System.out.println("4. Sair");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        switch (opcao) {
            case 1:
                System.out.print("Digite o novo nome (atual: " + cliente.getCustomerName() + "): ");
                String customerName = scanner.nextLine();
                cliente.setCustomerName(customerName);
                System.out.println("Nome atualizado!");
                break;
            case 2:
                System.out.print("Digite o novo CPF (atual: " + cliente.getCustomerCpf() + "): ");
                String customerCpf = scanner.nextLine();
                cliente.setCustomerCpf(customerCpf);
                System.out.println("CPF atualizado!");
                break;
            case 3:
                System.out.print("Digite a nova cidade (atual: " + cliente.getCustomerCity() + "): ");
                String customerCity = scanner.nextLine();
                cliente.setCustomerCity(customerCity);
                System.out.println("Cidade atualizada!");
                break;
            case 4:
                continuar = false;
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
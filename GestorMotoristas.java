import java.util.Scanner;

public class GestorMotoristas extends Gestor<Motorista> {

    @Override
    protected Motorista criarEntidade(Scanner scanner) {
        System.out.print("Digite o nome do motorista: ");
        String driverName = scanner.nextLine();
        System.out.print("Digite o CPF: ");
        String driverCpf = scanner.nextLine();
        System.out.print("Digite a CNH: ");
        String driverCnh = scanner.nextLine();
        System.out.print("Digite a cidade: ");
        String driverCity = scanner.nextLine();
        return new Motorista(driverName, driverCpf, driverCnh, driverCity);
    }

    @Override
    protected Motorista buscarPorId(int id) {
        return entidades.stream()
                .filter(motorista -> motorista.getDriverId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    protected Motorista buscarPorNome(String nome) {
        return entidades.stream()
                .filter(motorista -> motorista.getDriverName().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    @Override
    protected void atualizarEntidade(Motorista motorista, Scanner scanner) {
    boolean continuar = true;

    while (continuar) {
        System.out.println("Selecione o atributo que deseja editar:");
        System.out.println("1. Nome");
        System.out.println("2. CPF");
        System.out.println("3. CNH");
        System.out.println("4. Cidade");
        System.out.println("5. Sair");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        switch (opcao) {
            case 1:
                System.out.print("Digite o novo nome (atual: " + motorista.getDriverName() + "): ");
                String driverName = scanner.nextLine();
                motorista.setDriverName(driverName);
                System.out.println("Nome atualizado!");
                break;
            case 2:
                System.out.print("Digite o novo CPF (atual: " + motorista.getDriverCpf() + "): ");
                String driverCpf = scanner.nextLine();
                motorista.setDriverCpf(driverCpf);
                System.out.println("CPF atualizado!");
                break;
            case 3:
                System.out.print("Digite a nova CNH (atual: " + motorista.getDriverCnh() + "): ");
                String driverCnh = scanner.nextLine();
                motorista.setDriverCnh(driverCnh);
                System.out.println("CNH atualizada!");
                break;
            case 4:
                System.out.print("Digite a nova cidade (atual: " + motorista.getDriverCity() + "): ");
                String driverCity = scanner.nextLine();
                motorista.setDriverCity(driverCity);
                System.out.println("Cidade atualizada!");
                break;
            case 5:
                continuar = false;
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

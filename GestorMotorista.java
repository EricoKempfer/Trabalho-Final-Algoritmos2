import java.util.Scanner;

public class GestorMotoristas extends Gestor<Motorista> {

    @Override
    protected Motorista criarEntidade(Scanner scanner) {
        System.out.print("Digite o nome do motorista: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite a CNH: ");
        String cnh = scanner.nextLine();
        System.out.print("Digite a cidade: ");
        String cidade = scanner.nextLine();
        return new Motorista(nome, cpf, cnh, cidade);
    }

    @Override
    protected Motorista buscarPorId(int id) {
        return entidades.stream()
                .filter(motorista -> motorista.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    protected Motorista buscarPorNome(String nome) {
        return entidades.stream()
                .filter(motorista -> motorista.getNome().equalsIgnoreCase(nome))
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
        scanner.nextLine(); // Limpar o buffer

        switch (opcao) {
            case 1:
                System.out.print("Digite o novo nome (atual: " + motorista.getNome() + "): ");
                String nome = scanner.nextLine();
                motorista.setNome(nome);
                System.out.println("Nome atualizado!");
                break;
            case 2:
                System.out.print("Digite o novo CPF (atual: " + motorista.getCpf() + "): ");
                String cpf = scanner.nextLine();
                motorista.setCpf(cpf);
                System.out.println("CPF atualizado!");
                break;
            case 3:
                System.out.print("Digite a nova CNH (atual: " + motorista.getCnh() + "): ");
                String cnh = scanner.nextLine();
                motorista.setCnh(cnh);
                System.out.println("CNH atualizada!");
                break;
            case 4:
                System.out.print("Digite a nova cidade (atual: " + motorista.getCidade() + "): ");
                String cidade = scanner.nextLine();
                motorista.setCidade(cidade);
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
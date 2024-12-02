import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Gestor<T> {
    protected List<T> entidades = new ArrayList<>();

    public void listar() {
        if (entidades.isEmpty()) {
            System.out.println("Nenhuma entidade cadastrada.");
        } else {
            entidades.forEach(System.out::println);
        }
    }

    public void cadastrar(Scanner scanner) {
        T novaEntidade = criarEntidade(scanner);
        entidades.add(novaEntidade);
        System.out.println("Entidade cadastrada com sucesso!");
    }

    public void editar(Scanner scanner) {
        System.out.println("Deseja buscar por (1) ID ou (2) Nome?");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        T entidadeEncontrada = null;

        if (opcao == 1) {
            System.out.print("Digite o ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            entidadeEncontrada = buscarPorId(id);
        } else if (opcao == 2) {
            System.out.print("Digite o Nome: ");
            String nome = scanner.nextLine();
            entidadeEncontrada = buscarPorNome(nome);
        } else {
            System.out.println("Opção inválida.");
            return;
        }

        if (entidadeEncontrada == null) {
            System.out.println("Entidade não encontrada.");
        } else {
            System.out.println("Entidade encontrada: " + entidadeEncontrada);
            atualizarEntidade(entidadeEncontrada, scanner);
            System.out.println("Entidade atualizada com sucesso!");
        }
    }

    public void remover(Scanner scanner) {
        System.out.print("Digite o ID da entidade para remover: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        T entidade = buscarPorId(id);

        if (entidade != null) {
            entidades.remove(entidade);
            System.out.println("Entidade removida com sucesso!");
        } else {
            System.out.println("Entidade não encontrada.");
        }
    }

    protected abstract T criarEntidade(Scanner scanner);
    protected abstract T buscarPorId(int id);
    protected T buscarPorNome(String nome) {
        // Exemplo genérico: substitua com lógica específica de busca, se necessário.
        return null;
    }
    protected abstract void atualizarEntidade(T entidade, Scanner scanner);
}
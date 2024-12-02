import java.util.*;

// Para compilar e executar o programa, utilize os comandos abaixo:
//cd "PASTA QUE ESTÁ O PROJETO" && javac App.java && java App
// cd "/home/erico-og/algoritmof/" && javac App.java && java App

public class App {

    private static Scanner scanner = new Scanner(System.in);
    private static GestorClientes gestorClientes = new GestorClientes();
    private static GestorMotoristas gestorMotoristas = new GestorMotoristas();
    private static GestorProdutos gestorProdutos = new GestorProdutos();
    private static GestorViagens gestorViagens = new GestorViagens(gestorMotoristas, gestorClientes, gestorProdutos);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n(=== CRUD para Gestão de Transporte de Carga ===)");
            System.out.println("1. Gerenciar Clientes");
            System.out.println("2. Gerenciar Motoristas");
            System.out.println("3. Gerenciar Produtos");
            System.out.println("4. Gerenciar Viagens");
            System.out.println("0. Sair");
            opcao = scanOption();

            switch (opcao) {
                case 1 -> menuGestor(gestorClientes, "Cliente");
                case 2 -> menuGestor(gestorMotoristas, "Motorista");
                case 3 -> menuGestor(gestorProdutos, "Produto");
                case 4 -> menuViagens();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void menuGestor(Gestor<?> gestor, String tipo) {
        int opcao;
        do {
            System.out.printf("\n--- Gerenciar %ss ---\n", tipo);
            System.out.println("1. Listar " + tipo + "s");
            System.out.println("2. Cadastrar " + tipo);
            System.out.println("3. Editar " + tipo);
            System.out.println("4. Remover " + tipo);
            System.out.println("0. Voltar");
            opcao = scanOption();

            switch (opcao) {
                case 1 -> gestor.listar();
                case 2 -> gestor.cadastrar(scanner);
                case 3 -> gestor.editar(scanner);
                case 4 -> gestor.remover(scanner);
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void menuViagens() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Viagens ---");
            System.out.println("1. Iniciar Viagem");
            System.out.println("2. Finalizar Viagem");
            System.out.println("0. Voltar");
            opcao = scanOption();

            switch (opcao) {
                case 1 -> gestorViagens.startTrip(scanner);
                case 2 -> gestorViagens.endTrip(scanner);
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static int scanOption() {
        System.out.print("Escolha uma opção: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Opção inválida! Por favor, insira um número.");
            scanner.next(); // descarta a entrada inválida
            System.out.print("Escolha uma opção: ");
        }
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        return opcao;
    }
}
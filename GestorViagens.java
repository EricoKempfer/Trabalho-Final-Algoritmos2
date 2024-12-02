import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorViagens {
    private List<Viagem> tripList = new ArrayList<>();
    private GestorMotoristas driverManager;
    private GestorClientes customerManager;
    private GestorProdutos productManager;

    public GestorViagens(GestorMotoristas driverManager, GestorClientes customerManager, GestorProdutos productManager) {
        this.driverManager = driverManager;
        this.customerManager = customerManager;
        this.productManager = productManager;
    }

    public void listTrips() {
        if (tripList.isEmpty()) {
            System.out.println("Nenhuma viagem cadastrada.");
        } else {
            tripList.forEach(System.out::println);
        }
    }

    public void startTrip(Scanner scanner) {
        System.out.print("Digite uma descrição para a viagem: ");
        String tripDescription = scanner.nextLine();
        System.out.print("Digite a cidade de origem: ");
        String originCity = scanner.nextLine();
        System.out.print("Digite a cidade de destino: ");
        String destinationCity = scanner.nextLine();

        System.out.println("Selecione um motorista disponível:");
        driverManager.listar();
        System.out.print("Digite o ID do motorista: ");
        int driverId = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        Motorista driver = driverManager.buscarPorId(driverId);

        if (driver == null || driver.isOnTrip()) {
            System.out.println("Motorista inválido ou já em viagem.");
            return;
        }

        System.out.println("Selecione um cliente:");
        customerManager.listar();
        System.out.print("Digite o ID do cliente: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        Cliente customer = customerManager.buscarPorId(customerId);

        if (customer == null) {
            System.out.println("Cliente inválido.");
            return;
        }

        List<Produto> selectedProducts = new ArrayList<>();
        System.out.println("Selecione os produtos (digite 0 para encerrar):");
        productManager.listar();
        while (true) {
            System.out.print("Digite o ID do produto: ");
            int productId = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            if (productId == 0) break;

            Produto product = productManager.buscarPorId(productId);
            if (product != null) {
                selectedProducts.add(product);
            } else {
                System.out.println("Produto inválido.");
            }
        }

        if (selectedProducts.isEmpty()) {
            System.out.println("Você deve selecionar ao menos um produto.");
            return;
        }

        Viagem newTrip = new Viagem(tripDescription, originCity, destinationCity, selectedProducts, driver, customer);
        tripList.add(newTrip);
        driver.setOnTrip(true);
        System.out.println("Viagem iniciada com sucesso!");
    }

    public void endTrip(Scanner scanner) {
        listTrips();
        System.out.print("Digite o ID da viagem para finalizar: ");
        int tripId = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        Viagem trip = buscarViagemPorId(tripId);

        if (trip == null) {
            System.out.println("Viagem não encontrada.");
        } else if ("Finalizada".equals(trip.getTripStatus())) {
            System.out.println("A viagem já está finalizada.");
        } else {
            trip.setTripStatus("Finalizada");
            trip.getDriver().setOnTrip(false);
            System.out.println("Viagem finalizada com sucesso!");
        }
    }

    private Viagem buscarViagemPorId(int id) {
        return tripList.stream()
                .filter(trip -> trip.getTripId() == id)
                .findFirst()
                .orElse(null);
    }
}
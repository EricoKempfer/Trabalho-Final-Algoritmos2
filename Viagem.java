import java.util.List;

public class Viagem {
  private static int idCounter = 1;
  private int tripId;
  private String tripDescription;
  private String originCity;
  private String destinationCity;
  private List<Produto> productList;
  private Motorista driver;
  private Cliente customer;
  private String tripStatus; // "Iniciada" ou "Finalizada"

  public Viagem(String tripDescription, String originCity, String destinationCity,
    List<Produto> productList, Motorista driver, Cliente customer) {
  this.tripId = idCounter++;
  this.tripDescription = tripDescription;
  this.originCity = originCity;
  this.destinationCity = destinationCity;
  this.productList = productList;
  this.driver = driver;
  this.customer = customer;
  this.tripStatus = "Iniciada";
}

    // Getters e Setters
    public int getTripId() { return tripId; }
    public String getTripDescription() { return tripDescription; }
    public void setTripDescription(String tripDescription) { this.tripDescription = tripDescription; }
    public String getOriginCity() { return originCity; }
    public void setOriginCity(String originCity) { this.originCity = originCity; }
    public String getDestinationCity() { return destinationCity; }
    public void setDestinationCity(String destinationCity) { this.destinationCity = destinationCity; }
    public List < Produto > getProductList() { return productList; }
    public void setProductList(List < Produto > productList) { this.productList = productList; }
    public Motorista getDriver() { return driver; }
    public void setDriver(Motorista driver) { this.driver = driver; }
    public Cliente getCustomer() { return customer; }
    public void setCustomer(Cliente customer) { this.customer = customer; }
    public String getTripStatus() { return tripStatus; }
    public void setTripStatus(String tripStatus) { this.tripStatus = tripStatus; }

@Override
public String toString() {
  return "ID: " + tripId + ", Descrição: " + tripDescription +
    ", Cidade Origem: " + originCity + ", Cidade Destino: " + destinationCity +
    ", Motorista: " + driver.getDriverName() +
    ", Cliente: " + customer.getCustomerName() +
    ", Status: " + tripStatus +
    ", Produtos: " + productList.stream()
      .map(Produto::getProductName)
      .toList().toString();
}
}
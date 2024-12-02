public class Cliente {
    private static int customerIdCounter = 1;
    private int customerId;
    private String customerName;
    private String customerCpf;
    private String customerCity;

    public Cliente(String customerName, String customerCpf, String customerCity) {
        this.customerId = customerIdCounter++;
        this.customerName = customerName;
        this.customerCpf = customerCpf;
        this.customerCity = customerCity;
    }

    // Getters e Setters
    public int getCustomerId() { return customerId; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getCustomerCpf() { return customerCpf; }
    public void setCustomerCpf(String customerCpf) { this.customerCpf = customerCpf; }
    public String getCustomerCity() { return customerCity; }
    public void setCustomerCity(String customerCity) { this.customerCity = customerCity; }

    @Override
    public String toString() {
        return "ID: " + customerId + ", Nome: " + customerName + ", CPF: " + customerCpf + ", Cidade: " + customerCity;
    }
}
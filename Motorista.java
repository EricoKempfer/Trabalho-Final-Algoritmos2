public class Motorista {
    private static int driverIdCounter = 1;
    private int driverId;
    private String driverName;
    private String driverCpf;
    private String driverCnh;
    private String driverCity;
    private boolean onTrip;

    public Motorista(String driverName, String driverCpf, String driverCnh, String driverCity) {
        this.driverId = driverIdCounter++;
        this.driverName = driverName;
        this.driverCpf = driverCpf;
        this.driverCnh = driverCnh;
        this.driverCity = driverCity;
        this.onTrip = false;
    }

    // Getters e Setters
    public int getDriverId() { return driverId; }
    public String getDriverName() { return driverName; }
    public void setDriverName(String driverName) { this.driverName = driverName; }
    public String getDriverCpf() { return driverCpf; }
    public void setDriverCpf(String driverCpf) { this.driverCpf = driverCpf; }
    public String getDriverCnh() { return driverCnh; }
    public void setDriverCnh(String driverCnh) { this.driverCnh = driverCnh; }
    public String getDriverCity() { return driverCity; }
    public void setDriverCity(String driverCity) { this.driverCity = driverCity; }
    public boolean isOnTrip() { return onTrip; }
    public void setOnTrip(boolean onTrip) { this.onTrip = onTrip; }

    @Override
    public String toString() {
        return "ID: " + driverId + ", Nome: " + driverName + ", CPF: " + driverCpf + ", CNH: " + driverCnh + 
        ", Cidade: " + driverCity + ", Em Viagem: " + (onTrip ? "Sim" : "Não");
    }
}
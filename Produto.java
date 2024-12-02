public class Produto {
    private static int productIdCounter = 1;
    private int productId;
    private String productName;
    private int productQuantity;

    public Produto(String productName, int productQuantity) {
        this.productId = productIdCounter++;
        this.productName = productName;
        this.productQuantity = productQuantity;
    }

    // Getters, Setters
    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public int getProductQuantity() { return productQuantity; }
    public void setProductQuantity(int productQuantity) { this.productQuantity = productQuantity; }

    @Override
    public String toString() {
        return "ID: " + productId + ", Nome: " + productName + ", Quantidade: " + productQuantity;
    }
}

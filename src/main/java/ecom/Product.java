package ecom;

public class Product {
    private final String productName;

    private final float price;

    public Product(String productName, float price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public float getPrice() {
        return price;
    }
}

package ecom.cart;

import ecom.Product;

public class CartItem {

    private final Product product;

    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void updateQuantity(int quantity) {
        if (quantity == 0) throw new RuntimeException();
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}

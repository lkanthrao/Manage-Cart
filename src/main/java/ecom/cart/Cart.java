package ecom.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cart {

    private List<CartItem> cartItemList = new ArrayList<>();

    private double totalPrice;

    public void addItemToCart(CartItem cartItem) {
        if (cartItem == null) return;


        Optional<CartItem> existingCartItem = cartItemList.stream().filter(eachCartItem -> eachCartItem.getProduct().getProductName().
                        equals(cartItem.getProduct().getProductName()))
                .findFirst();

        if (existingCartItem.isPresent())
            existingCartItem.ifPresent(cartItem2 -> cartItem2.updateQuantity(cartItem2.getQuantity() + cartItem.getQuantity()));
        else
            cartItemList.add(cartItem);

        updateTotalPrice();

    }

    private void updateTotalPrice() {
        totalPrice = cartItemList.stream().mapToDouble(cartItem -> cartItem.getQuantity() * cartItem.getProduct().getPrice())
                .sum();
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

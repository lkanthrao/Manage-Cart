package ecom;

import ecom.cart.Cart;
import ecom.cart.CartItem;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartItemTest {

    private static final String DOVE = "Dove";

    @Test
    public void story1() {

        Product dove = new Product(DOVE, 39.99F);
        CartItem cartItem = new CartItem(dove, 5);

        Cart cart = new Cart();
        cart.addItemToCart(cartItem);
        assertEquals(cart.getCartItemList().size(), 1);

        assertEquals(cart.getCartItemList().get(0).getProduct().getProductName(), dove.getProductName());

        assertEquals(cart.getTotalPrice(), 199.95D, 1);
        assertEquals(cart.getCartItemList().get(0).getQuantity(), 5);


    }

    @Test
    public void story2() {

        Product dove = new Product(DOVE, 39.99F);
        CartItem cartItem = new CartItem(dove, 5);

        CartItem cartItem2 = new CartItem(dove, 3);

        Cart cart = new Cart();
        cart.addItemToCart(cartItem);
        cart.addItemToCart(cartItem2);

        assertEquals(cart.getTotalPrice(), 319.92, 1);
        assertEquals(cart.getCartItemList().get(0).getQuantity(), 8);

    }
}
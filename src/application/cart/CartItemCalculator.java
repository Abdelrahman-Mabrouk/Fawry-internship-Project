package application.cart;

import domain.cart.entity.CartItem;

public class CartItemCalculator {

    public static double calculateTotal(CartItem item) {
        return item.getProduct().getPrice() * item.getQuantity();
    }
}

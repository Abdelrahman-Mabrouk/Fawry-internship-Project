package application.cart;

import domain.cart.entity.Cart;
import domain.cart.entity.CartItem;

public class CartCalculator {

    public static double calculateSubtotal(Cart cart) {
        double total = 0;
        for (CartItem item : cart.getItems()) {
            total += CartItemCalculator.calculateTotal(item);
        }
        return total;
    }
}

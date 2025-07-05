package application.shipping;

import domain.cart.entity.CartItem;

import java.util.List;

public class ThresholdBasedFreeShipping implements ShippingFeeStrategy {

    private final double threshold = 500.0;
    private final double flatRate = 30.0;

    @Override
    public double calculate(List<CartItem> items) {
        double subtotal = 0;
        for (CartItem item : items) {
            subtotal += item.getProduct().getPrice() * item.getQuantity();
        }

        return subtotal >= threshold ? 0.0 : flatRate;
    }
}

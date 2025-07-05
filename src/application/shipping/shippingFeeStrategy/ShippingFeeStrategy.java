package application.shipping.shippingFeeStrategy;

import domain.cart.entity.CartItem;

import java.util.List;

public interface ShippingFeeStrategy {
    double calculate(List<CartItem> items);
}

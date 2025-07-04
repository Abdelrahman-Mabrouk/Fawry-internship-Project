package application.shipping;

import domain.cart.entity.CartItem;
import domain.product.type.ShippableProduct;

import java.util.List;

public class ShippingFeeCalculator {

    private final double ratePerKg;

    public ShippingFeeCalculator(double ratePerKg) {
        this.ratePerKg = ratePerKg;
    }

    public double calculate(List<CartItem> items) {
        int totalWeight = 0;
        ShippableProduct product ;
        for (CartItem item : items) {
            product = (ShippableProduct) item.getProduct();
            totalWeight += product.getWeight() * item.getQuantity();
        }
        return (totalWeight/1000) * ratePerKg;
    }
}

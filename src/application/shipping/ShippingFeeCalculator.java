package application.shipping;

import domain.product.entity.Product;
import domain.product.interfaces.Shippable;
import domain.product.type.ShippableProduct;

import java.util.List;

public class ShippingFeeCalculator {

    private final double ratePerKg;

    public ShippingFeeCalculator(double ratePerKg) {
        this.ratePerKg = ratePerKg;
    }

    public double calculate(List<ShippableProduct> items) {
        double totalWeight = 0;
        for (ShippableProduct item : items) {
            totalWeight += item.getPrice();
        }
        return totalWeight * ratePerKg;
    }
}

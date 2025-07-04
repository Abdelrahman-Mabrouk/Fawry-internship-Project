package domain.product.type;

import domain.product.entity.Product;
import domain.product.interfaces.Shippable;

public abstract class ShippableProduct extends Product implements Shippable {

    protected double weight;

    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}

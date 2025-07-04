package domain.product.entity;

import domain.product.interfaces.Shippable;

public class TV extends Product implements Shippable {

    private double weight;

    public TV(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getweight() {
        return weight;
    }

    @Override
    public void setweight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean requiresShipping() {
        return true;
    }
}

package domain.product.entity;

import domain.product.type.ShippableProduct;

public class TV extends ShippableProduct {

    public TV(String name, double price, int quantity, double weight) {
        super(name, price, quantity,weight);
    }

    @Override
    public double getweight() {
        return weight;
    }

    @Override
    public void setweight(double weight) {
        this.weight = weight;
    }


}

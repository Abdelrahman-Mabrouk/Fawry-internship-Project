package domain.product.type;

import domain.product.entity.Product;

public abstract class NonShippableProduct extends Product {

    public NonShippableProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }

}

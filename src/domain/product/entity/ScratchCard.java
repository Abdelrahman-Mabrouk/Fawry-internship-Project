package domain.product.entity;


import domain.product.type.NonShippableProduct;

public class ScratchCard extends NonShippableProduct {

    public ScratchCard(String name, double price, int quantity) {
        super(name, price, quantity);
    }


}

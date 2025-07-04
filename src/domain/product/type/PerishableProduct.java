package domain.product.type;

import domain.product.entity.Product;
import domain.product.interfaces.Expirable;

import java.time.LocalDate;

public abstract class PerishableProduct extends Product implements Expirable {

    protected LocalDate expirationDate;

    public PerishableProduct(String name, double price, int quantity, LocalDate expirationDate) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }

}

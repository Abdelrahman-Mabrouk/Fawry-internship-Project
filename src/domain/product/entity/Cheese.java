package domain.product.entity;

import domain.product.interfaces.Expirable;
import domain.product.interfaces.Shippable;
import java.time.LocalDate;

public class Cheese extends Product implements Shippable, Expirable {

    private double weight;
    private LocalDate expirationDate;

    public Cheese(String name, double price, int quantity, double weight, LocalDate expirationDate) {
        super(name, price, quantity);
        this.weight = weight;
        this.expirationDate = expirationDate;
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
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    @Override
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean isExpired() {
        return expirationDate.isBefore(LocalDate.now());
    }

    @Override
    public boolean requiresShipping() {
        return true;
    }
}

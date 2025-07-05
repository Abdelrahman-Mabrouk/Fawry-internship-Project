package domain.product.factory;


import domain.product.entity.*;
import domain.product.entity.Product;

import java.time.LocalDate;

/**
 * ProductFactory is responsible for creating instances of concrete Product types.
 * This provides a single point of creation and encapsulates complex initialization logic.
 */
public class ProductFactory {


    public static Product createProduct(String type) {
        switch (type.toLowerCase()) {
            case "cheese":
                return new Cheese("Cheese", 100.0, 10, 0.2, LocalDate.now().plusDays(30));
            case "biscuits":
                return new Biscuits("Biscuits", 150.0, 10, 0.7, LocalDate.now().plusDays(80));
            case "tv":
                return new TV("TV", 5000.0, 5, 3000);
            case "mobile":
                return new Mobile("Mobile", 3000.0, 10, 300);
            case "scratchcard":
                return new ScratchCard("Scratch Card", 100.0, 20);
            default:
                throw new IllegalArgumentException("Unknown product type: " + type);
        }
    }

    /**
     * Overloaded method for custom initialization.
     * We can implement additional creation logic here as needed.
     */
    public static Product createCheese(String name, double price, int quantity, double weight, LocalDate expiry) {
        return new Cheese(name, price, quantity, weight, expiry);
    }

    public static Product createTV(String name, double price, int quantity, double weight) {
        return new TV(name, price, quantity, weight);
    }

    public static Product createScratchCard(String name, double price, int quantity) {
        return new ScratchCard(name, price, quantity);
    }

}

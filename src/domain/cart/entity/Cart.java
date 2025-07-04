package domain.cart.entity;

import domain.product.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static Cart instance;

    private List<CartItem> items;

    private Cart() {
        this.items = new ArrayList<>();
    }
    /**
     * Returns the singleton instance of the Cart.
     * <p>
     * This method uses Double-Checked Locking to ensure that
     * only one instance is created in a thread-safe way.
     * </p>
     * @return the unique Cart instance shared across the application
     */
    public static Cart getInstance() {
        if (instance == null) {
            synchronized (Cart.class) {
                if (instance == null) {
                    instance = new Cart();
                }
            }
        }
        return instance;
    }

    public void addProduct(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }


    public void clear() {
        items.clear();
    }
}

package domain.cart.entity;

import domain.product.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items;
/*
 * <p>
 * This Strategy Depends on single user scenario
 * </p>
     private static Cart instance;

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
    */
    public Cart(){
        this.items = new ArrayList<>();
    }
    public void addProduct(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
    }
    public void removeProduct(Product product) {
        for (CartItem item : items) {
            if (item.getProduct().equals(product)) {
                items.remove(item);
            }
        }


    }

    public void editProduct(Product product, int quantity) {
        for (CartItem item : items) {
            if (item.getProduct().equals(product)) {
                item.setQuantity(quantity);
            }
        }
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

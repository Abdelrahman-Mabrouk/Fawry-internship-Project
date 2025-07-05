package domain.cart.entity;


import domain.customer.entity.Customer;
import domain.product.entity.Product;

import java.util.HashMap;
import java.util.Map;

public class CartManager {

    private static final Map<Integer, Cart> customerCarts = new HashMap<>();

    public static Cart getCartForCustomer(Customer customer) {
        return customerCarts.computeIfAbsent(customer.getId(), id -> new Cart());
    }

    public static void addProduct(Customer customer, Product product, int quantity) {
        Cart cart = getCartForCustomer(customer);
        cart.addProduct(product, quantity);
    }

    public static void clearCart(Customer customer) {
        Cart cart = getCartForCustomer(customer);
        cart.clear();
    }

    public static boolean isEmpty(Customer customer) {
        return getCartForCustomer(customer).isEmpty();
    }

}

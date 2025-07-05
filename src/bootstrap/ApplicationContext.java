package bootstrap;

import application.checkout.CheckoutService;
import application.checkout.factory.CheckoutServiceFactory;

import application.shipping.ShippingService;

import application.shipping.shippingServiceFactory.ShippingServiceFactory;
import domain.cart.entity.Cart;
import domain.cart.entity.CartManager;
import domain.customer.entity.Customer;
import domain.product.entity.*;
import domain.product.factory.ProductFactory;

public class ApplicationContext {

    public static CheckoutService initializeWithThresholdStrategy() {
        ShippingService shippingService = ShippingServiceFactory.createShippingServiceWithThreshold();
        return  CheckoutServiceFactory.create(shippingService);
    }

    public static CheckoutService initializeWithWeightStrategy() {
        ShippingService shippingService = ShippingServiceFactory.createShippingServiceWithWeight(30);
        return CheckoutServiceFactory.create(shippingService);
    }

    public static Customer createCustomer(String name, int balance) {
        return new Customer(name, balance);
    }

    public static Cart prepareCart(Customer customer) {
        Cart cart = CartManager.getCartForCustomer(customer);

        Product cheese = ProductFactory.createProduct("cheese");
        Product biscuits = ProductFactory.createProduct("biscuits");
        Product tv = ProductFactory.createProduct("tv");
        Product mobile = ProductFactory.createProduct("mobile");
        Product card = ProductFactory.createProduct("scratchcard");

        cart.addProduct(cheese, 2);
        cart.addProduct(biscuits, 1);
        cart.addProduct(tv, 1);
        cart.addProduct(mobile, 3);
        cart.addProduct(card, 2);

        return cart;
    }
}

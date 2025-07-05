package bootstrap;

import application.checkout.CheckoutService;
import application.checkout.Printer.ReceiptPrinter;
import application.checkout.validator.CheckoutValidator;
import application.shipping.ShippingFeeStrategy;
import application.shipping.ShippingService;
import application.shipping.ThresholdBasedFreeShipping;
import application.shipping.WeightBasedShippingStrategy;
import domain.cart.entity.Cart;
import domain.cart.entity.CartManager;
import domain.customer.entity.Customer;
import domain.product.entity.*;
import domain.product.factory.ProductFactory;

import java.time.LocalDate;

public class ApplicationContext {

    public static CheckoutService initializeWithThresholdStrategy() {
        ShippingFeeStrategy strategy = new ThresholdBasedFreeShipping();
        ShippingService shippingService = new ShippingService(strategy);
        CheckoutValidator validator = new CheckoutValidator();
        ReceiptPrinter printer = new ReceiptPrinter();
        return new CheckoutService(shippingService, validator, printer);
    }

    public static CheckoutService initializeWithWeightStrategy() {
        ShippingFeeStrategy strategy = new WeightBasedShippingStrategy(25.0);
        ShippingService shippingService = new ShippingService(strategy);
        CheckoutValidator validator = new CheckoutValidator();
        ReceiptPrinter printer = new ReceiptPrinter();
        return new CheckoutService(shippingService, validator, printer);
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

import application.checkout.CheckoutService;
import application.shipping.ShippingFeeStrategy;
import application.shipping.ShippingService;
import application.shipping.ThresholdBasedFreeShipping;
import application.shipping.WeightBasedShippingStrategy;
import domain.cart.entity.Cart;
import domain.customer.entity.Customer;
import domain.product.entity.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Abdelrahman", 100000.0);
        Cart cart = Cart.getInstance();

        // Uncomment to test: Expired product
        // Cheese expiredCheese = new Cheese("Expired Cheese", 80.0, 5, 0.2, LocalDate.of(2020, 1, 1));
        // cart.addProduct(expiredCheese, 1);

        // Uncomment to test: Out of stock
        // TV tv = new TV("TV", 5000.0, 5, 3000);
        // cart.addProduct(tv, 10);

        // Uncomment to test: Insufficient balance
        // Customer brokeCustomer = new Customer("Broke", 50.0);
        // TV tv = new TV("TV", 5000.0, 5, 3000);
        // cart.addProduct(tv, 5);
        // CheckoutService checkoutServiceForBroke = new CheckoutService(new ShippingService());
        // checkoutServiceForBroke.processCheckout(brokeCustomer, cart);

        // Uncomment to test: Empty cart
        // Cart emptyCart = new Cart();
        // CheckoutService checkoutEmpty = new CheckoutService(new ShippingService());
        // checkoutEmpty.processCheckout(customer, emptyCart);

        Biscuits biscuits = new Biscuits("Biscuits", 150.0, 10, 700, LocalDate.of(2027, 1, 1));
        Cheese cheese = new Cheese("Cheese", 100.0, 10, 200, LocalDate.of(2027, 1, 1));
        TV tv = new TV("TV", 5000.0, 50, 3000);
        Mobile mobile = new Mobile("Mobile", 3000.0, 8, 300);
        ScratchCard card = new ScratchCard("Scratch Card", 100.0, 20);

        cart.addProduct(cheese, 2);
        cart.addProduct(biscuits, 1);
        cart.addProduct(tv, 5);
        cart.addProduct(mobile, 3);
        cart.addProduct(card, 2);

        // Demonstrate different shipping strategies
        System.out.println("=== DEMONSTRATING SHIPPING STRATEGY PATTERN ===\n");

        // Test 1: Threshold-Based shipping (default)
        System.out.println("1. Threshold-Based Shipping Strategy:");
        ShippingFeeStrategy ThresholdBasedStrategy = new ThresholdBasedFreeShipping();
        ShippingService ThresholdBasedShippingService = new ShippingService(ThresholdBasedStrategy );
        CheckoutService checkoutService1 = new CheckoutService(ThresholdBasedShippingService);

        try {
            checkoutService1.processCheckout(customer, cart);
        } catch (RuntimeException e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }

        // Clear cart for next test
        cart.clear();
        cart.addProduct(cheese, 2);
        cart.addProduct(biscuits, 1);
        cart.addProduct(tv, 1);
        cart.addProduct(mobile, 1);

        // Test 2: Weight-Based shipping
        System.out.println("\n" + "=".repeat(50) + "\n");
        System.out.println("2. Flat-Rate Shipping Strategy:");
        ShippingFeeStrategy WeightBasedStrategy = new WeightBasedShippingStrategy(25.0);
        ShippingService WeightBasedShippingService = new ShippingService(WeightBasedStrategy);
        CheckoutService checkoutService2 = new CheckoutService(WeightBasedShippingService);

        try {
            checkoutService2.processCheckout(customer, cart);
        } catch (RuntimeException e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }


    }
}


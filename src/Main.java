import application.checkout.CheckoutService;
import bootstrap.ApplicationContext;
import domain.cart.entity.Cart;
import domain.customer.entity.Customer;

public class Main {
    public static void main(String[] args) {

        //======================== 1. Threshold-Based Strategy ================================
        Customer customer = ApplicationContext.createCustomer("Mabrouk",100000);
        Cart cart = ApplicationContext.prepareCart(customer);

        System.out.println("1. Threshold-Based Shipping Strategy:");
        CheckoutService checkoutService1 = ApplicationContext.initializeWithThresholdStrategy();

        try {
            checkoutService1.processCheckout(customer, cart);
        } catch (RuntimeException e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }

        //======================== 2. Weight-Based Strategy ================================
        System.out.println("\n" + "=".repeat(50) + "\n");
        System.out.println("2. Weight-Based Shipping Strategy:");

        Customer customer2 = ApplicationContext.createCustomer("Mohamed",200000);

        Cart cart2 = ApplicationContext.prepareCart(customer);;
        CheckoutService checkoutService2 = ApplicationContext.initializeWithWeightStrategy();

        try {
            checkoutService2.processCheckout(customer2, cart2);
        } catch (RuntimeException e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }
    }


}

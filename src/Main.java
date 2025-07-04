
import application.checkout.CheckoutService;
import application.shipping.ShippingService;
import domain.cart.entity.Cart;
import domain.customer.entity.Customer;
import domain.product.entity.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer("Abdelrahman", 2000.0);

        Cart cart = new Cart();

        Cheese cheese = new Cheese("Cheddar", 100.0, 10, 2.5, LocalDate.of(2025, 1, 1));
        Biscuits biscuits = new Biscuits("Oreo", 50.0, 15, 0.5, LocalDate.of(2024, 12, 30));
        TV tv = new TV("Samsung TV", 1500.0, 3, 10.0);
        Mobile mobile = new Mobile("iPhone", 900.0, 5, 0.3);
        ScratchCard card = new ScratchCard("Vodafone 100", 100.0, 20);

        cart.addProduct(cheese, 2);
        cart.addProduct(biscuits, 3);
        cart.addProduct(tv, 1);
        cart.addProduct(card, 1);

        // 5. تنفيذ Checkout
        ShippingService shippingService = new ShippingService();
        CheckoutService checkoutService = new CheckoutService(shippingService);

        try {
            checkoutService.processCheckout(customer, cart);
        } catch (RuntimeException e) {
            System.out.println("\n Checkout Failed: " + e.getMessage());
        }

        // 6. عرض الرصيد المتبقي
        System.out.printf("\n Remaining Balance: %.2f EGP%n", customer.getBalance());
    }
}

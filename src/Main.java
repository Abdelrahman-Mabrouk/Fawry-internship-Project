
import application.checkout.CheckoutService;
import application.shipping.ShippingService;
import domain.cart.entity.Cart;
import domain.customer.entity.Customer;
import domain.product.entity.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Abdelrahman", 100000.0);
        Cart cart = new Cart();

        Biscuits biscuits = new Biscuits("Biscuits", 150.0, 10, 700, LocalDate.of(2027, 1, 1)); // 700g لكل واحدة
        Cheese cheese = new Cheese("Cheese", 100.0, 10, 200, LocalDate.of(2027, 1, 1));
        TV tv = new TV("TV", 5000.0, 5, 3000);
        Mobile mobile = new Mobile("Mobile", 3000.0, 8, 300);
        ScratchCard card = new ScratchCard("Scratch Card", 100.0, 20);

        cart.addProduct(cheese, 2);
        cart.addProduct(biscuits, 1);
        cart.addProduct(tv, 5);
        cart.addProduct(mobile, 3);
        cart.addProduct(card, 2);

        ShippingService shippingService = new ShippingService();
        CheckoutService checkoutService = new CheckoutService(shippingService);

        try {
            checkoutService.processCheckout(customer, cart);
        } catch (RuntimeException e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }
    }
}


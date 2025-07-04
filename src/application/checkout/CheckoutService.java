package application.checkout;

import application.cart.CartCalculator;
import domain.cart.entity.Cart;
import domain.cart.entity.CartItem;
import domain.customer.entity.Customer;
import application.shipping.ShippingService;

import java.util.List;

public class CheckoutService {

    private final CheckoutValidator validator;
    private final ReceiptPrinter printer;
    private final ShippingService shippingService;

    public CheckoutService(ShippingService shippingService) {
        this.validator = new CheckoutValidator();
        this.printer = new ReceiptPrinter();
        this.shippingService = shippingService;
    }

    public void processCheckout(Customer customer, Cart cart) {
        validator.validate(customer, cart);

        List<CartItem> itemsToShip = shippingService.extractShippableItems(cart);
        double shippingFees = shippingService.calculateShippingFees(itemsToShip);

        shippingService.processShipment(itemsToShip);

        double subtotal = CartCalculator.calculateSubtotal(cart);
        double total = subtotal + shippingFees;
        customer.deduct(total);

        cart.getItems().forEach(item ->
                item.getProduct().reduceQuantity(item.getQuantity()));

        printer.print(customer, cart, shippingFees);

        cart.clear();
    }
}

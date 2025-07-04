package application.checkout;

import application.cart.CartCalculator;
import domain.cart.entity.Cart;
import domain.customer.entity.Customer;
import domain.product.interfaces.Shippable;
import application.shipping.ShippingService;
import domain.product.type.ShippableProduct;

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

        List<ShippableProduct> itemsToShip = shippingService.extractShippableItems(cart);
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

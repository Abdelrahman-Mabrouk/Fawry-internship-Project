package application.checkout.Printer;

import domain.cart.entity.Cart;
import domain.customer.entity.Customer;

public interface IPrinter {
    public void print(Customer customer, Cart cart, double shippingFees);
}

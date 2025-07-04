package application.checkout;

import domain.cart.entity.Cart;
import domain.cart.entity.CartItem;
import domain.customer.entity.Customer;
import domain.product.entity.Product;
import domain.product.interfaces.Expirable;
import exception.*;

import application.cart.CartCalculator;

public class CheckoutValidator {

    public void validate(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new EmptyCartException();
        }

        double subtotal = CartCalculator.calculateSubtotal(cart);
        if (!customer.hasSufficientBalance(subtotal)) {
            throw new InsufficientBalanceException();
        }

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();

            if (product instanceof Expirable) {
                Expirable exp = (Expirable) product;
                if (exp.isExpired()) {
                    throw new ExpiredProductException(product.getName());
                }
            }

            if (item.getQuantity() > product.getQuantity()) {
                throw new OutOfStockException(product.getName());
            }
        }
    }
}

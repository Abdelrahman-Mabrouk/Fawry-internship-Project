package application.checkout.validator;

import domain.cart.entity.Cart;
import domain.cart.entity.CartItem;
import domain.customer.entity.Customer;
import domain.product.entity.Product;
import domain.product.interfaces.Expirable;
import exception.*;

import application.cart.CartCalculator;

public class CheckoutValidator implements IValidator {

    public void validate(Customer customer, Cart cart) {
        emptyValidator(customer,cart);
        sufficientValidator(customer,cart);
        expiredValidator(customer,cart);
        outOfStockValidator(customer,cart);

    }
    public void emptyValidator(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new EmptyCartException();
        }
    }
    public void sufficientValidator(Customer customer, Cart cart) {
        double subtotal = CartCalculator.calculateSubtotal(cart);
        if (!customer.hasSufficientBalance(subtotal)) {
            throw new InsufficientBalanceException();
        }
    }
    public void expiredValidator(Customer customer, Cart cart) {
        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();

            if (product instanceof Expirable) {
                Expirable exp = (Expirable) product;
                if (exp.isExpired()) {
                    throw new ExpiredProductException(product.getName());
                }
            }

        }
    }
    public void outOfStockValidator(Customer customer, Cart cart) {
        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            if (item.getQuantity() > product.getQuantity()) {
                throw new OutOfStockException(product.getName());
            }
        }
    }
}

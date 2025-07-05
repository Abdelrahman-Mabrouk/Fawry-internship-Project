package application.checkout.validator;

import domain.cart.entity.Cart;
import domain.customer.entity.Customer;

public interface IValidator {
    void validate(Customer customer, Cart cart);

    void emptyValidator(Customer customer, Cart cart);

    void expiredValidator(Customer customer, Cart cart);

    void outOfStockValidator(Customer customer, Cart cart);
}
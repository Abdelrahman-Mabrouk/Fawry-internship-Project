package application.checkout;

import domain.cart.entity.Cart;
import domain.cart.entity.CartItem;
import domain.customer.entity.Customer;
import domain.product.entity.Product;
import application.cart.CartItemCalculator;
import application.cart.CartCalculator;

public class ReceiptPrinter {

    public void print(Customer customer, Cart cart, double shippingFees) {
        System.out.println("\n🧾 Receipt");
        System.out.println("Customer: " + customer.getName() + " (ID: " + customer.getId() + ")");
        System.out.println("-----------------------------------");

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();
            double total = CartItemCalculator.calculateTotal(item);

            System.out.printf("%dx %-15s %.2f\n", quantity, product.getName(), total);
        }

        double subtotal = CartCalculator.calculateSubtotal(cart);
        double grandTotal = subtotal + shippingFees;

        System.out.println("-----------------------------------");
        System.out.printf("Subtotal:        %.2f\n", subtotal);
        System.out.printf("Shipping:        %.2f\n", shippingFees);
        System.out.printf("Total:           %.2f\n", grandTotal);
        System.out.println("===================================");
    }
}

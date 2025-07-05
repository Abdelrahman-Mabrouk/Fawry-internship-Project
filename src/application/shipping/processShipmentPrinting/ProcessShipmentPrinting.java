package application.shipping.processShipmentPrinting;

import application.checkout.Printer.IPrinter;
import domain.cart.entity.Cart;
import domain.cart.entity.CartItem;
import domain.customer.entity.Customer;
import domain.product.type.ShippableProduct;

import java.util.List;


public class ProcessShipmentPrinting implements IProcessShipmentPrinting {
    double totalItemsWeight = 0.0;


    public void processShipmentPrint(List<CartItem> items)  {
        ShippableProduct product = null;
        System.out.println("\nProcessing Shipment:");
        for (CartItem item : items) {
            product = (ShippableProduct) item.getProduct();
            System.out.printf("%dx %-15s %.2f\n",item.getQuantity(), item.getProduct().getName(),product.getweight() * item.getQuantity());
            totalItemsWeight +=product.getWeight()*item.getQuantity();
        }
        System.out.println("Total package weight " + totalItemsWeight/1000 + "Kg");

    }

}

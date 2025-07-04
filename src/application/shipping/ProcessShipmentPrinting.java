package application.shipping;

import domain.cart.entity.CartItem;
import domain.product.type.ShippableProduct;

import java.util.List;


public class ProcessShipmentPrinting {
    double totalItemsWeight = 0.0;


    public void processShipment(List<CartItem> items) {
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

package application.shipping;

import domain.cart.entity.Cart;
import domain.cart.entity.CartItem;

import domain.product.type.ShippableProduct;

import java.util.ArrayList;
import java.util.List;

public class ShippingService {

    private final ShippingFeeCalculator feeCalculator;

    public ShippingService() {
        this.feeCalculator = new ShippingFeeCalculator(10.0); // مثال: 10 جنيه لكل كجم
    }

    public List<ShippableProduct> extractShippableItems(Cart cart) {
        List<ShippableProduct> shippables = new ArrayList<>();
        for (CartItem item : cart.getItems()) {
            ShippableProduct product = (ShippableProduct) item.getProduct();
                shippables.add( product);

        }
        return shippables;
    }


    public double calculateShippingFees(List<ShippableProduct> items) {
        return feeCalculator.calculate(items);
    }


    public void processShipment(List<ShippableProduct> items) {
        System.out.println("\n🚚 Processing Shipment:");
        for (ShippableProduct item : items) {
            System.out.println("- " + item.getWeight()+ " | Weight: " + item.getWeight() + " kg");
        }
    }


    }


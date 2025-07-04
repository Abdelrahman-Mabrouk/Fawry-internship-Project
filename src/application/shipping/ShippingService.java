package application.shipping;

import domain.cart.entity.Cart;
import domain.cart.entity.CartItem;

import java.util.List;

public class ShippingService {

    private final ShippingFeeCalculator feeCalculator;
    private final ProcessShipmentPrinting processShipmentPrinting;
    private final ExtractShippableItems extractShippableItems;

    public ShippingService() {
        this.processShipmentPrinting = new ProcessShipmentPrinting();
        this.extractShippableItems = new ExtractShippableItems();
        this.feeCalculator = new ShippingFeeCalculator(30.0);
    }

    public List<CartItem> extractShippableItems(Cart cart) {
        return extractShippableItems.extractShippableItems(cart);
    }


    public double calculateShippingFees(List<CartItem> items) {
        return feeCalculator.calculate(items);
    }


    public void processShipment(List<CartItem> items) {
      processShipmentPrinting.processShipment(items);
    }


    }


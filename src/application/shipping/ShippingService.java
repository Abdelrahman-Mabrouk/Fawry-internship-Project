package application.shipping;

import domain.cart.entity.Cart;
import domain.cart.entity.CartItem;

import java.util.List;

public class ShippingService {

    private final ShippingFeeStrategy feeCalculator;
    private final ProcessShipmentPrinting processShipmentPrinting;
    private final ExtractShippableItems extractShippableItems;

    public ShippingService(ShippingFeeStrategy shippingFeeStrategy) {
        this.processShipmentPrinting = new ProcessShipmentPrinting();
        this.extractShippableItems = new ExtractShippableItems();
        this.feeCalculator = shippingFeeStrategy;
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


package application.shipping;

import application.shipping.extractShippableItems.IExtractShippableItems;
import application.shipping.processShipmentPrinting.IProcessShipmentPrinting;
import application.shipping.processShipmentPrinting.ProcessShipmentPrinting;
import application.shipping.shippingFeeStrategy.ShippingFeeStrategy;
import domain.cart.entity.Cart;
import domain.cart.entity.CartItem;

import java.util.List;

public class ShippingService {

    private final ShippingFeeStrategy feeCalculator;
    private final IProcessShipmentPrinting processShipmentPrinting;
    private final IExtractShippableItems extractShippableItems;

    public ShippingService(ShippingFeeStrategy shippingFeeStrategy , IExtractShippableItems extractShippableItems, IProcessShipmentPrinting processShipmentPrinting) {
        this.processShipmentPrinting = processShipmentPrinting;
        this.extractShippableItems = extractShippableItems;
        this.feeCalculator = shippingFeeStrategy;
    }

    public List<CartItem> extractShippableItems(Cart cart) {
        return extractShippableItems.extractShippableItems(cart);
    }


    public double calculateShippingFees(List<CartItem> items) {
        return feeCalculator.calculate(items);
    }


    public void processShipmentPrint(List<CartItem> items) {
      processShipmentPrinting.processShipmentPrint(items);
    }

    }


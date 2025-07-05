package application.shipping.processShipmentPrinting;

import domain.cart.entity.CartItem;

import java.util.List;

public interface IProcessShipmentPrinting {
    public void processShipmentPrint(List<CartItem> items);
}

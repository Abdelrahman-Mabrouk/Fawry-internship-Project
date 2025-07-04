package application.shipping;

import domain.cart.entity.Cart;
import domain.cart.entity.CartItem;
import domain.product.type.ShippableProduct;

import java.util.ArrayList;
import java.util.List;

public class ExtractShippableItems {
    public List<CartItem> extractShippableItems(Cart cart) {
        List<CartItem> shippables = new ArrayList<>();
        for (CartItem item : cart.getItems()) {
            if (item.getProduct() instanceof ShippableProduct)
                shippables.add(item);

        }
        return shippables;
    }

}

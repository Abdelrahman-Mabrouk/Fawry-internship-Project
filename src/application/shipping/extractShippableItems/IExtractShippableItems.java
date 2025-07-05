package application.shipping.extractShippableItems;

import domain.cart.entity.Cart;
import domain.cart.entity.CartItem;

import java.util.List;

public interface IExtractShippableItems {
    public List<CartItem> extractShippableItems(Cart cart);
}

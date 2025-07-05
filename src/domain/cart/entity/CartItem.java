package domain.cart.entity;

import domain.product.entity.Product;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
    // to edit or set product
    public void setProduct(Product product) {
        this.product = product;
    }
    // to edit or set quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}

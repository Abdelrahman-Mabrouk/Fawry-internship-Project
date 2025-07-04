package domain.product.entity;

public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;
    public Product(String name, double price, int quantity) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public  void reduceQuantity(int quantity){
        this.quantity -= quantity;
    }
    public abstract boolean  requiresShipping() ;
}

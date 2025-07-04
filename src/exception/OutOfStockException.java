package exception;

public class OutOfStockException extends RuntimeException {

    public OutOfStockException(String productName) {
        super("Out of stock: " + productName);
    }
}

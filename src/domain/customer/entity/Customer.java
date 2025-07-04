package domain.customer.entity;

public class Customer {
    private static int id = 0;
    private String name;
    private double balance;
    public Customer(String name, double balance) {
        this.id = id++;
        this.name = name;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deduct(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }

    public boolean hasSufficientBalance(double amount) {
        return balance >= amount;
    }
}

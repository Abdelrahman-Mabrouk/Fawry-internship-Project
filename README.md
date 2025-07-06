# 🛒 E-Commerce Checkout System

[![Java](https://img.shields.io/badge/Java-17+-orange.svg)](https://openjdk.java.net/)
[![Architecture](https://img.shields.io/badge/Architecture-Clean%20Architecture-green.svg)](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
[![Status](https://img.shields.io/badge/Status-Production%20Ready-brightgreen.svg)]()

A robust, scalable E-commerce checkout system built with **Clean Architecture** principles, demonstrating advanced **Object-Oriented Programming** concepts and **SOLID** design patterns. This project showcases a complete checkout workflow with product management, cart operations, shipping calculations, and comprehensive validation.

## 📋 Table of Contents

- [Features](#-features)
- [Architecture](#-architecture)
- [UML Diagrams](#-uml-diagrams)
- [Project Structure](#-project-structure)
- [Installation](#-installation)
- [Usage](#-usage)
- [SOLID Principles Implementation](#-solid-principles-implementation)
- [Design Patterns](#-design-patterns)
- [Contributing](#-contributing)


## ✨ Features

### 🛍️ Core Functionality
- **Product Management**: Support for various product types (perishable, shippable, digital)
- **Shopping Cart**: Dynamic cart with item management and quantity tracking
- **Checkout Process**: Complete checkout workflow with validation
- **Shipping Integration**: Automatic shipping fee calculation and processing
- **Customer Management**: Balance tracking and payment processing

### 🏗️ Technical Features
- **Clean Architecture**: Separation of concerns with domain, application, and infrastructure layers
- **SOLID Principles**: Well-structured, maintainable, and extensible codebase
- **Exception Handling**: Comprehensive error management with custom exceptions
- **Type Safety**: Strong typing with interfaces and abstract classes
- **Modular Design**: Loosely coupled components for easy testing and maintenance

### 📦 Product Types Supported
| Product Type | Examples | Characteristics |
|-------------|----------|-----------------|
| **Perishable & Shippable** | Cheese, Biscuits | Expiration date, weight-based shipping |
| **Non-Perishable & Shippable** | TV, Mobile | Weight-based shipping, no expiration |
| **Digital/Non-Shippable** | Scratch Cards | No shipping required |

## 🏛️ Architecture

This project follows **Clean Architecture** principles with clear separation of concerns:

```
┌─────────────────────────────────────────────────────────────┐
│                    Application Layer                        │
├─────────────────────────────────────────────────────────────┤
│  CheckoutService │ ShippingService │ CartCalculator        │
└─────────────────────────────────────────────────────────────┘
                              │
┌─────────────────────────────────────────────────────────────┐
│                     Domain Layer                            │
├─────────────────────────────────────────────────────────────┤
│  Product │ Customer │ Cart │ CartItem │ Interfaces         │
└─────────────────────────────────────────────────────────────┘
                              │
┌─────────────────────────────────────────────────────────────┐
│                   Exception Layer                           │
├─────────────────────────────────────────────────────────────┤
│  Custom Exceptions for Business Logic Validation           │
└─────────────────────────────────────────────────────────────┘
```

### Key Design Patterns
- **Strategy Pattern**: Different product behaviors (shipping, expiration)
- **Template Method**: Abstract product classes with common functionality
- **Dependency Injection**: Services injected into checkout process
- **Single Responsibility**: Each class has a specific, well-defined purpose

## 📊 UML Diagrams

This project includes comprehensive UML class diagrams that visualize the system architecture and relationships:

### 🏗️ Complete System Architecture

![Complete Class Diagram](./assets/Class-Diagram.svg)

**Features:**
- Complete system overview with all classes and relationships
- Inheritance hierarchies for products
- Interface implementations
- Service dependencies and associations
- Exception handling relationships

### 🚨 Exception Handling Architecture
![Exception Diagram](./assets/Exception-Diagram.svg)

**Features:**
- **Custom Exception Hierarchy**: All business exceptions extending `RuntimeException`
- **Exception Types**: 
  - `OutOfStockException` - When product quantity is insufficient
  - `ExpiredProductException` - When product has expired
  - `InsufficientBalanceException` - When customer balance is insufficient
  - `EmptyCartException` - When cart is empty during checkout
- **Exception Usage**: Shows which classes throw which exceptions
- **Validation Flow**: Demonstrates how `CheckoutValidator` uses exceptions for business rule validation

**Exception Flow:**
```
CheckoutValidator
    ├── throws OutOfStockException (product quantity < requested)
    ├── throws ExpiredProductException (product.isExpired() == true)
    ├── throws InsufficientBalanceException (customer.balance < total)
    └── throws EmptyCartException (cart.isEmpty() == true)
```

**Benefits:**
- **Type Safety**: Specific exception types for different error scenarios
- **Error Handling**: Clear distinction between different validation failures
- **Debugging**: Easy identification of what went wrong during checkout
- **User Experience**: Specific error messages for different failure cases

## 📁 Project Structure

```
src/
├── Main.java
├── bootstrap/
│   └── ApplicationContext.java
├── domain/
│   ├── customer/
│   │   └── entity/
│   │       └── Customer.java
│   ├── cart/
│   │   └── entity/
│   │       ├── Cart.java
│   │       ├── CartManager.java
│   │       └── CartItem.java
│   └── product/
│       ├── entity/
│       │   ├── Product.java
│       │   ├── Cheese.java
│       │   ├── Biscuits.java
│       │   ├── TV.java
│       │   ├── Mobile.java
│       │   └── ScratchCard.java
│       ├── type/
│       │   ├── ShippableProduct.java
│       │   ├── NonShippableProduct.java
│       │   └── PerishableProduct.java
│       ├── interfaces/
│       │   ├── Shippable.java
│       │   └── Expirable.java
│       └── factory/
│           └── ProductFactory.java
├── application/
│   ├── cart/
│   │   ├── CartCalculator.java
│   │   └── CartItemCalculator.java
│   ├── checkout/
│   │   ├── CheckoutService.java
│   │   ├── factory/
│   │   │   └── CheckoutServiceFactory.java
│   │   ├── validator/
│   │   │   ├── IValidator.java
│   │   │   └── CheckoutValidator.java
│   │   └── Printer/
│   │       ├── IPrinter.java
│   │       └── ReceiptPrinter.java
│   └── shipping/
│       ├── ShippingService.java
│       └── shippingServiceFactory/
│           └── ShippingServiceFactory.java
│       ├── shippingFeeStrategy/
│       │   ├── ShippingFeeStrategy.java
│       │   ├── WeightBasedShippingStrategy.java
│       │   └── ThresholdBasedFreeShipping.java
│       ├── processShipmentPrinting/
│       │   ├── IProcessShipmentPrinting.java
│       │   └── ProcessShipmentPrinting.java
│       ├── extractShippableItems/
│       │   ├── IExtractShippableItems.java
│       │   └── ExtractShippableItems.java
│       
└── exception/
├── EmptyCartException.java
├── ExpiredProductException.java
├── InsufficientBalanceException.java
└── OutOfStockException.java
```


### Example Usage



```java
public static void main(String[] args) {

    //======================== 1. Threshold-Based Strategy ================================
    Customer customer = ApplicationContext.createCustomer("Mabrouk",100000);
    Cart cart = ApplicationContext.prepareCart(customer);

    System.out.println("1. Threshold-Based Shipping Strategy:");
    CheckoutService checkoutService1 = ApplicationContext.initializeWithThresholdStrategy();

    try {
        checkoutService1.processCheckout(customer, cart);
    } catch (RuntimeException e) {
        System.out.println("Checkout failed: " + e.getMessage());
    }

    //======================== 2. Weight-Based Strategy ================================
    System.out.println("\n" + "=".repeat(50) + "\n");
    System.out.println("2. Weight-Based Shipping Strategy:");

    Customer customer2 = ApplicationContext.createCustomer("Mohamed",200000);

    Cart cart2 = ApplicationContext.prepareCart(customer);;
    CheckoutService checkoutService2 = ApplicationContext.initializeWithWeightStrategy();

    try {
        checkoutService2.processCheckout(customer2, cart2);
    } catch (RuntimeException e) {
        System.out.println("Checkout failed: " + e.getMessage());
    }
}
```


### Sample Output


```
1. Threshold-Based Shipping Strategy:

Processing Shipment:
2x Cheese          0.40
1x Biscuits        0.70
1x TV              3000.00
3x Mobile          900.00
Total package weight 3.9011Kg

Receipt
Customer: Mabrouk (ID: 1)
-----------------------------------
2x Cheese          200.00
1x Biscuits        150.00
1x TV              5000.00
3x Mobile          9000.00
2x Scratch Card    200.00
-----------------------------------
Subtotal:        14550.00
Shipping:        0.00
Total:           14550.00
===================================

==================================================

2. Weight-Based Shipping Strategy:

Processing Shipment:
2x Cheese          0.40
1x Biscuits        0.70
1x TV              3000.00
3x Mobile          900.00
Total package weight 3.9011Kg

Receipt
Customer: Mohamed (ID: 2)
-----------------------------------
2x Cheese          200.00
1x Biscuits        150.00
1x TV              5000.00
3x Mobile          9000.00
2x Scratch Card    200.00
-----------------------------------
Subtotal:        14550.00
Shipping:        90.00
Total:           14640.00
===================================
```
#### **📊 Strategy Comparison:**

| Strategy | Order Value | Shipping Fee | Total |
|----------|-------------|--------------|-------|
| **Threshold-Based** | $14,550 | $0.00 (Free) | $14,550 |
| **Weight-Based** | $14,550 | $90.00 | $14,640 |

The output clearly shows how different shipping strategies affect the final cost, demonstrating the flexibility and extensibility of the Strategy pattern implementation.

## 🎯 SOLID Principles Implementation

This project demonstrates a comprehensive implementation of **SOLID** principles throughout the codebase:

### 1. **S** - Single Responsibility Principle (SRP)

Each class has **one reason to change** and **one responsibility**:

#### ✅ **Well-Implemented Examples:**

**`CheckoutService.java`**
```java
public class CheckoutService {
    // Single Responsibility: Orchestrate the checkout process
    public void processCheckout(Customer customer, Cart cart) {
        validator.validate(customer, cart);           // Delegates validation
        // ... shipping processing
        printer.print(customer, cart, shippingFees);  // Delegates printing
    }
}
```

**`CheckoutValidator.java`**
```java
public class CheckoutValidator {
    // Single Responsibility: Validate business rules
    public void validate(Customer customer, Cart cart) {
        // Only handles validation logic
    }
}
```

**`ReceiptPrinter.java`**
```java
public class ReceiptPrinter {
    // Single Responsibility: Print receipts
    public void print(Customer customer, Cart cart, double shippingFees) {
        // Only handles receipt formatting and printing
    }
}
```

**`ShippingService.java`**
```java
public class ShippingService {
    // Single Responsibility: Handle shipping operations
    public List<CartItem> extractShippableItems(Cart cart) { /* ... */ }
    public double calculateShippingFees(List<CartItem> items) { /* ... */ }
    public void processShipment(List<CartItem> items) { /* ... */ }
}
```

### 2. **O** - Open/Closed Principle (OCP)

The system is **open for extension** but **closed for modification**:

#### ✅ **Extension Points:**

**Product Hierarchy**
```java
// Base class - closed for modification
public abstract class Product {
    // Common functionality
}

// New product types can be added without modifying existing code
public class NewProduct extends ShippableProduct {
    // Extends functionality without changing base classes
}
```

**Interface Implementations**
```java
// New behaviors can be added through interfaces
public interface Shippable {
    double getweight();
    void setweight(double weight);
}

public interface Expirable {
    boolean isExpired();
    LocalDate getExpirationDate();
}

// Products can implement multiple interfaces
public class Cheese extends ShippableProduct implements Expirable {
    // Implements both shipping and expiration behaviors
}
```

### 3. **L** - Liskov Substitution Principle (LSP)

Subtypes are **substitutable** for their base types:

#### ✅ **Proper Substitution:**

**Product Substitution**
```java
// Any Product subtype can be used where Product is expected
Product product1 = new Cheese("Cheddar", 10.0, 5, 0.5, LocalDate.now());
Product product2 = new TV("Smart TV", 500.0, 2, 15.0);
Product product3 = new ScratchCard("Gift Card", 50.0, 10);

// All work seamlessly in the cart system
cart.addProduct(product1, 2);
cart.addProduct(product2, 1);
cart.addProduct(product3, 3);
```

**Interface Substitution**
```java
// Shippable products can be used interchangeably
List<Shippable> shippableItems = new ArrayList<>();
shippableItems.add(new Cheese("Cheese", 10.0, 5, 0.5, LocalDate.now()));
shippableItems.add(new TV("TV", 500.0, 2, 15.0));

// Shipping service works with any Shippable implementation
shippingService.calculateShippingFees(shippableItems);
```

### 4. **I** - Interface Segregation Principle (ISP)

Clients are **not forced to depend** on interfaces they don't use:

#### ✅ **Focused Interfaces:**

**`Shippable` Interface**
```java
// Only methods related to shipping
public interface Shippable {
    double getweight();
    void setweight(double weight);
}
```

**`Expirable` Interface**
```java
// Only methods related to expiration
public interface Expirable {
    boolean isExpired();
    void setExpirationDate(LocalDate date);
    LocalDate getExpirationDate();
}
```

**Product Implementations**
```java
// Products only implement interfaces they need
public class Cheese extends ShippableProduct implements Expirable {
    // Needs both shipping and expiration functionality
}

public class TV extends ShippableProduct {
    // Only needs shipping functionality
}

public class ScratchCard extends NonShippableProduct {
    // Doesn't need either interface
}
```

### 🏆 **SOLID Benefits in This Project**

| Principle | Benefit | Example |
|-----------|---------|---------|
| **SRP** | Easy to test and maintain | Each service has one job |
| **OCP** | Easy to extend | New products without changing existing code |
| **LSP** | Polymorphic behavior | Any product works in cart |
| **ISP** | No unnecessary dependencies | Products only implement needed interfaces |

## 🎯 Design Patterns

### 📦 Design Patterns Used by Class

| Class / Component                   | Design Pattern Used            | Description |
|------------------------------------|--------------------------------|-------------|
| `ProductFactory`                   | **Factory Pattern** 🏭         | Responsible for creating concrete product instances (Cheese, TV, etc.) from type input. |
| `ShippingServiceFactory`           | **Factory Pattern** 🏭         | Centralizes creation of `ShippingService` with default wiring for extractors and printers. |
| `CheckoutServiceFactory`           | **Factory Pattern** 🏭         | Builds `CheckoutService` with injected dependencies (shipping, printer, validator). |
| `ShippingFeeStrategy` (interface)  | **Strategy Pattern** 🔀        | Allows switching between different shipping cost calculation methods. |
| `CartManager`                      | **Facade Pattern** 🧱          | Provides a simplified interface to operate on cart (add, update, subtotal...) without exposing internals. |
| `Cart` (Singleton version)         | **Singleton Pattern** 🧍‍♂️      | Ensures a single cart instance per user/session for centralized management. |
| `ApplicationContext`               | **Builder Pattern + DI** 🛠️    | Composes services and dependencies in a clean, maintainable way; simulates manual Dependency Injection. |
| `CheckoutService`                  | **Dependency Injection** 💉    | Depends on interfaces (IShippingService, IValidator, IPrinter) to follow DIP and promote testability. |



## 🚀 Installation

### Prerequisites
- **Java 17** or higher
- **IntelliJ IDEA** (recommended) or any Java IDE
- **Git** for version control

### Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/ecommerce-checkout-system.git
   cd ecommerce-checkout-system
   ```

2. **Open in IDE**
   - Open the project in IntelliJ IDEA
   - Ensure Java 17+ is configured as the project SDK

3. **Verify Setup**
   - The project should compile without errors
   - All dependencies should be resolved automatically

## 💻 Usage

### Running the Application

1. **Navigate to Main Class**
   ```
   src/Main.java
   ```

2. **Run the Application**
   - Right-click on `Main.java` and select "Run"
   - Or use the keyboard shortcut `Shift + F10`

## 🤝 Contributing

We welcome contributions! Please follow these steps:

1. **Fork the repository**
2. **Create a feature branch**
   ```bash
   git checkout -b feature/amazing-feature
   ```
3. **Commit your changes**
   ```bash
   git commit -m 'Add amazing feature'
   ```
4. **Push to the branch**
   ```bash
   git push origin feature/amazing-feature
   ```
5. **Open a Pull Request**

### Contribution Guidelines
- Follow the existing code style and conventions
- Add tests for new functionality
- Update documentation as needed
- Ensure all tests pass before submitting

## 👨‍💻 Author

**Abdelrahman Mabrouk**
- 🎓 Computer & AI Student
- 🏢 Fawry Quantum Internship Trainee
- 🔗 [LinkedIn](https://www.linkedin.com/in/abdelrahman-mabrouk-2b579026b)
- 📧 [Email](mailto:abdelrahman.mabrouk@example.com)

## 🙏 Acknowledgments

- **Fawry** for the internship opportunity
- **Clean Architecture** principles by Robert C. Martin
- **SOLID** principles for robust design
- **Java Community** for excellent documentation and tools

## 📊 Project Status

| Status | Description |
|--------|-------------|
| ✅ **Production Ready** | Core functionality complete and tested |
| ✅ **Documentation** | Comprehensive README and code comments |
| ✅ **Architecture** | Clean Architecture implemented |
| 🔄 **Enhancement** | Open for new features and improvements |

---

**⭐ Star this repository if you find it helpful!**

**🐛 Found a bug?** Please open an issue with detailed steps to reproduce.

**💡 Have a suggestion?** We'd love to hear your ideas for improvement!

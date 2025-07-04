# 🍎 E-Commerce Checkout System (Fawry Internship Challenge)

This project simulates a simplified e-commerce checkout system built as part of the **Fawry Quantum Internship Challenge**.
It demonstrates clean code architecture using principles of **Object-Oriented Programming (OOP)**, **SOLID**, and **Clean Architecture**.

---

## 📁 Project Structure

```
src/
├── domain/                            
│   ├── cart/
│   │   ├── entity/
│   │   │   ├── Cart.java
│   │   │   └── CartItem.java
│
│   ├── customer/
│   │   └── entity/
│   │       └── Customer.java
│
│   ├── product/
│   │   ├── entity/
│   │   │   ├── Cheese.java
│   │   │   ├── Biscuits.java
│   │   │   ├── TV.java
│   │   │   ├── Mobile.java
│   │   │   └── ScratchCard.java
│   │   │
│   │   ├── interfaces/
│   │   │   ├── Shippable.java
│   │   │   └── Expirable.java
│   │   │
│   │   └── type/
│   │       ├── Product.java 
│   │       ├── ShippableProduct.java 
│   │       ├── PerishableProduct.java 
│   │       └── NonShippableProduct.java 
│
│   └── exception/
│       ├── CartEmptyException.java
│       ├── InsufficientBalanceException.java
│       ├── OutOfStockException.java
│       └── ProductExpiredException.java
│
├── application/                       
│   ├── checkout/
│   │   ├── CheckoutService.java
│   │   ├── CheckoutValidator.java
│   │   └── ReceiptPrinter.java
│
│   ├── shipping/
│   │   ├── ShippingService.java
│   │   └── ShippingFeeCalculator.java
│
│   └── cart/
│       ├── CartCalculator.java
│       └── CartItemCalculator.java
│
├── main/                              
│   └── Main.java
│
└── assets/                            
    └── class-diagram.png
                # Entry point for running the app
```

---
---


## 📸 UML Class Diagram

> ![UML Diagram](./assets/Class-Diagram.svg)

---


## 🧱 Key Components

### ✅ Products

* Cheese 🧀
* Biscuits 🍪
* TV 📺
* Mobile 📱
* ScratchCard 💳

Each product extends the `Product` class and implements interfaces like `Shippable` and/or `Expirable` depending on its nature.

---

### ✅ Cart

* Composed of multiple `CartItem` objects
* Supports subtotal calculation, shipping extraction, and clearing

---

### ✅ Checkout Layer

* `CheckoutService`: Handles the full checkout process
* `CheckoutValidator`: Validates balance, stock, and expiry
* `ReceiptPrinter`: Prints a detailed purchase receipt

---

### ✅ Shipping Layer

* `ShippingService`: Extracts shippable items and processes shipments
* `ShippingFeeCalculator`: Calculates shipping cost based on weight

---

## 🔄 Flow Overview

1. Customer adds products to their cart
2. Checkout is initiated via `CheckoutService`
3. Validator checks balance, expiry, and stock
4. Shippable items are processed and charged
5. Receipt is printed
6. Cart is cleared

---

## ✅ How to Run

```bash
1. Open the project in IntelliJ IDEA or any Java IDE                  
2. Run the Main.java class:                  
   src/main/Main.java
```

---

## ⚙️ Requirements

* Java 17 or higher
* IntelliJ IDEA (recommended) or VS Code
* Maven (optional if using build tools)

---

## ✨ Features

* Clean architecture (separation of concerns)
* SOLID principles applied
* Fully OOP-based design
* Extendable and easy to maintain

---

## 🤛️ Developed By

**👤 Abdelrahman Mabrouk**

* Computer & AI Student
* Fawry Quantum Internship Trainee
* 🔗 [LinkedIn Profile](https://www.linkedin.com/in/abdelrahman-mabrouk-2b579026b)       &#x20;

---


## 🚀 Project Status

✅ Completed and ready for testing, enhancement, or deployment.

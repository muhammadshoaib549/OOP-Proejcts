# Bank Management System (BMS) - OOP Implementation

This is a comprehensive Bank Management System implemented in Java, focusing on core Object-Oriented Programming principles and file-based data persistence.

## OOP Concepts Used

| Category | Concept | How is it working in BMS |
| :--- | :--- | :--- |
| **Foundation** | **Classes & Objects** | Every entity like `Bank`, `Account`, `Customer`, and `ATM` is defined as a class, and their instances (objects) drive the system logic. |
| **Data Hiding** | **Encapsulation** | Fields like `balance` in `Account.java` are `private`. Access is strictly controlled through `public` getter and setter methods. |
| **Hierarchy** | **Inheritance** | **`SavingAccount`** and **`CurrentAccount`** extend **`Account.java`**, inheriting shared attributes (ID, Balance) while adding specialized ones. |
| **Initialization** | **Constructor Chaining**| Subclasses use **`super()`** in their constructors to initialize the parent `Account` class attributes before their own. |
| **Relationships** | **Composition** | An `Account` object **owns** a `Customer` object (`accountHolder`), showing a strong "**Has-A**" relationship. |
| **Relationships** | **Aggregation** | The `Bank` class contains a `List` of `Customers`. Customers exist as independent entities that the bank manages. |
| **Referencing** | **`this` Keyword** | Used extensively (e.g., `this.balance = balance`) to distinguish between class fields and constructor parameters. |
| **Utility** | **Static Methods**| `InterestCalculator` uses **static methods** for calculations that don't require creating an object instance. |
| **Lifecycle** | **Static Initializer** | `App.java` uses a **`static { }`** block to run the initial welcome logic as soon as the class is loaded. |
| **Persistence** | **File Handling** | Uses `java.io` classes (Scanner, FileWriter) to simulate a database with `accounts.txt` and `transaction_history.txt`. |
| **Safety** | **Exception Handling**| **`try-catch-finally`** blocks in `FundsTransferServices.java` manage file errors and ensure resources are cleaned up. |
| **Validation** | **Data Integrity** | Logic in `Validations.java` and `Verifications.java` ensures input correctness (e.g., Email format, PIN verification). |
| **Abstraction** | **Interface Usage** | Decoupling logic by using `List` (Interface) for collections instead of specific implementations like `ArrayList`. |

## Key Features
- **Account Management**: Create and manage Savings and Current accounts.
- **Funds Transfer**: Securely transfer money between accounts with real-time balance updates.
- **Interest Calculation**: Automatically calculate interest for Savings accounts.
- **Transaction History**: Logs all activities to a text file for auditing.
- **Receipt Generation**: Generates digital receipts for all transactions.

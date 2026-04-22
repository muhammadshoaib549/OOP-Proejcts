# OOP Projects - Employee Management System

This project is a Java-based Employee Management System that utilizes Object-Oriented Programming (OOP) concepts and Java Swing for the GUI.

## OOP Concepts Used

| Concept Name | How is it working |
| :--- | :--- |
| **Encapsulation** | Used in `Employee.java` by keeping attributes (`id`, `name`, `age`, etc.) **private** and providing **public getters/setters** to access/modify them securely. |
| **Inheritance** | The `Mian` class **extends `JFrame`** to inherit Swing functionality. `Employee` also implements `Serializable` and `Comparable` interfaces. |
| **Polymorphism** | Demonstrated by **method overriding**. The `toString()` and `compareTo()` methods are overridden in `Employee`, and `actionPerformed()` is overridden in `Mian`. |
| **Abstraction** | Implemented using **interfaces** like `ActionListener` to handle UI events without knowing the internal details of how Swing triggers them. |
| **Interface Implementation** | The `Employee` class **implements `Comparable<Employee>`** to define custom sorting logic, and the `Mian` class **implements `ActionListener`** to handle button clicks. |
| **Serialization** | Used in `EmployeeDataHandler.java` to save and load `Employee` objects from the file `employees.ser` using `ObjectOutputStream` and `ObjectInputStream`. |
| **Marker Interface** | `Employee` implements the **`Serializable` marker interface**, which has no methods but tells the Java Virtual Machine (JVM) that the object can be converted into a byte stream. |
| **Functional Interface** | Used with **`Comparator<Employee>`** in `Collections.sort()` (in `Mian.java`) to define custom sorting logic on the fly. |
| **Transient Keyword** | This keyword is used in the context of Serialization to mark fields that should **not be saved** to the file (e.g., sensitive data or temporary variables). |
| **Exception Handling** | Used `try-catch` blocks to handle `IOException` during file operations and `Exception` during data conversion to ensure the program doesn't crash. |

## Features
- **Add Employee**: Create and store new employee records.
- **View Employees**: Display sorted list of employees (by ID/Name).
- **Update/Delete**: Modify or remove existing records using their ID.
- **Serialization**: Data is saved to a file (`employees.ser`) so it persists even after closing the program.

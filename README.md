# 📚 Library Management System (Java + Maven)

A modular, object-oriented **Library Management System** built using Java to help librarians manage books, patrons, and lending operations. This project demonstrates core OOP principles, SOLID design, and includes logging support via SLF4J.

---

## 🔧 Features

### ✅ Book Management
- Add, remove, update books
- Search books by title, author, or ISBN
- Track availability status

### ✅ Patron Management
- Register and update patrons
- Track patron borrowing history

### ✅ Lending Process
- Check out books to patrons
- Return books and update availability

### ✅ Inventory
- Maintain real-time status of books
- Prevent double-checkout of the same book

---

## 📦 Tech Stack

- **Java 17**
- **Maven** (Project Management & Build Tool)
- **Java Collections** (List, Map, etc.)

---

## 💡 OOP Concepts Used

- **Encapsulation**: Private fields with getters/setters
- **Abstraction**: Services abstract business logic
- **Polymorphism**: Future extensibility with strategies
- **Single Responsibility**: One purpose per class/service

---


## 🧠 SOLID Principles

- **S**: Each service has one clear responsibility
- **O**: Open for extension (via Strategy/Observer)
- **L**: Substitution-ready service interfaces
- **I**: Interfaces can be split if extended further
- **D**: Services injected where needed

# Parking Lot Management System

## 📌 Overview
A console-based Java application to manage parking lot operations using **Object-Oriented Programming (OOP)** principles.

## 🚀 Features
- Assigns parking spots based on vehicle type
- Generates tickets with entry time
- Calculates parking fee based on time and vehicle type
- Singleton design pattern for managing parking lot instance
- Easy to extend with database or web interface

## 🛠 Tech Stack
- Java
- OOP Concepts (Abstraction, Inheritance, Polymorphism, Encapsulation)
- Design Pattern: Singleton

## 📂 Folder Structure
```
parkinglot/
│
├── Main.java
├── enums/
│   └── VehicleType.java
├── models/
│   ├── Vehicle.java
│   ├── Car.java
│   ├── Bike.java
│   ├── Bus.java
│   ├── ParkingSpot.java
│   ├── Ticket.java
├── services/
│   ├── FeeCalculator.java
│   ├── CarFeeCalculator.java
│   ├── BikeFeeCalculator.java
│   ├── BusFeeCalculator.java
│   ├── ParkingLot.java
│   ├── ParkingLotManager.java
```

## ▶️ How to Run
1. Compile all `.java` files:
```
javac */*.java */*/*.java Main.java
```
2. Run the program:
```
java Main
```

## 📈 Future Enhancements
- GUI Interface using JavaFX
- MySQL database integration
- REST API using Spring Boot
```

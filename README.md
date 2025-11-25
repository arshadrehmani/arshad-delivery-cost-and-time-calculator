# Delivery Cost & Time Estimator

Calculates discount amount, delivery costs, and estimated delivery times for packages 
based on weight, distance, and vehicle availability. 

---

# Features
- **Cost Estimator Service**: Calculates delivery cost based on base cost, package weight, and delivery distance.
- **Time Estimator Service**: Calculates the delivery time of each package by using vehicle speed and availability. Picks up heavier packages first.
- **Discount Rules Service**: This is a map of discount codes along with the rules of discounts. We can add/modify discount rules and coupon names here.
- **Print Service**: Prints the results to the console.
- **Models (POJOs)**: Represent Packages, Shipments, and Vehicles, etc.
- **Sample Unit Tests**: Added some unit tests to check some functionalities.

---

## Prerequisites
- **Java 17** (tested with JDK 17.0.12)
- **Maven 3.9+** (tested with 3.9.11)

---

## Setup & Run

The project can be imported into Eclipse/IntelliJ as a Maven project and run directly.
Alternatively, we can build the project directly using Maven (as outlined in the Build steps)

### Build
```bash
mvn clean install

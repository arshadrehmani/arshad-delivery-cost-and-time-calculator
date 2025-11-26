# Delivery Cost & Time Estimator

Calculates discount amount, delivery costs and estimated delivery times for packages 
based on weight, distance, and vehicle availability. 

---

# Features
- **Cost Estimator Service**: Calculates delivery cost based on base cost, package weight and delivery distance.
- **Time Estimator Service**: Calculates delivery time of each package by using vehicle speed and availability. Picks up heavier packages first.
- **Discount Rules Service**: This is map of discount code along with the rule of discounts. We can add/modify discount rules and coupon names here.
- **Print Service**: Prints the results to console.
- **Models (POJOs)**: Represents Packages, Shipments and Vehicles etc.
- **Sample Unit Tests**: Added some unit tests to check some functionalities.

---

## Prerequisites
- **Java 17** (tested with JDK 17.0.12)
- **Maven 3.9+** (tested with 3.9.11)

---

## Setup & Run

- Option 1: The project can be imported into Eclipse/IntelliJ as a Maven project and run class com.arshad.courier.cli.DeliveryApp.
- Option 2: Alternatively, we can build the project using maven and run the jar.
```bash
		mvn clean install
		java -jar target/arshad-delivery-cost-and-time-calculator.jar
```

## Sample inputs and expected outputs
**Sample Input:**
```
100 5
PKG1 50 30 OFR001
PKG2 75 125 OFR008
PKG3 175 100 OFR003
PKG4 110 60 OFR002
PKG5 155 95 NA
2 70 200
```
**Expected output:**
```
PKG1 0 750 3.98
PKG2 0 1475 1.78
PKG3 0 2350 1.42
PKG4 105 1395 0.85
PKG5 0 2125 4.19
```

If we are only interested in the cost and not the delivery time, we can pass in 0s for the vehicle info data.

**Sample Input:**
100 3
PKG1 5 5 OFR001
PKG2 15 5 OFR002
PKG3 10 100 OFR003
0 0 0

**Expected output:**
PKG1 0 175 0.0
PKG2 0 275 0.0
PKG3 35 665 0.0
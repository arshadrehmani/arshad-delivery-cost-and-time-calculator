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

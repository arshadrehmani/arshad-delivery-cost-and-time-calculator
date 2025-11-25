package com.arshad.courier.service;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import com.arshad.courier.model.PackageInfo;
import com.arshad.courier.model.Shipment;
import com.arshad.courier.model.VehicleInfo;

/**
 *  Service class to estimate the delivery time for individual packages.
 *  
 * @author Arshad
 */
public class DeliveryTimeEstimator {
	
	/**
	 *  It sorts the packages by weight. Creates a shipment with max number of packages (heaviest first).
	 *  Then assigns them to the queue for calculating the delivery time.
	 * @param packageInfoList
	 * @param baseDeliveryCost
	 * @param vehicleInfo
	 * @return ArrayList of PackageInfo 
	 */
	public static List<PackageInfo> estimateDeliveryTime(List<PackageInfo> packageInfoList, int baseDeliveryCost, VehicleInfo vehicleInfo) {
		
		
		//sorting the package by their weight, descending order 
		List<PackageInfo> sortedPackages = new ArrayList<>(packageInfoList);
		sortedPackages.sort((package1, package2)->Integer.compare(package2.getPackageWeight(), package1.getPackageWeight()));
		
		List<Shipment> shipmentList = new ArrayList<>();
		boolean[] used = new boolean[sortedPackages.size()];
		
		//allowed weight limit
		int maxCarriableWeight = vehicleInfo.getMaxCarriableWeight();

		PackageInfo p1;
		PackageInfo p2;
		
		for(int i=0; i<sortedPackages.size(); i++) {
			if (used[i]) continue;
			
			Shipment shipment = new Shipment();
			p1 = sortedPackages.get(i);
			
			if(p1.getPackageWeight() > maxCarriableWeight) {
				continue; //For now, we are just ignoring the heavier package. will print 0 as time for now.
			}
			
			shipment.addPackage(p1);
			used[i] = true;
			
			for(int j=i+1; j<sortedPackages.size(); j++) {
				
				p2 = sortedPackages.get(j);
					
				if (!used[j] && shipment.getWeight() + p2.getPackageWeight() <= maxCarriableWeight) {
                   shipment.addPackage(p2);
                   used[j] = true;
                }
			}
			
			shipmentList.add(shipment);
		}
		
		//temp test code for testing sorting base on weight and distance
		/*
		Shipment ship = new Shipment();
		ship.addPackage(new PackageInfo("VEry first", 185, 100,"Code1"));
		shipmentList.add(ship);
		
		Shipment ship2 = new Shipment();
		ship2.addPackage(new PackageInfo("Before last-", 110, 50,"Code1"));
		shipmentList.add(ship2);
		
		Shipment ship3 = new Shipment();
		ship3.addPackage(new PackageInfo("In-Last", 110, 150,"Code1"));
		shipmentList.add(ship3);

		Shipment ship4 = new Shipment();
		ship4.addPackage(new PackageInfo("Mid", 155, 80,"Code1"));
		shipmentList.add(ship4);
		
		System.err.println(shipmentList);
		*/
		
		
		shipmentList.sort((s1, s2) -> {
            if (s1.getWeight() != s2.getWeight()) {
                return Integer.compare(s2.getWeight(), s1.getWeight()); // heavier first
            } else {
                return Integer.compare(s1.getDistance(), s2.getDistance()); // shorter distance first
            }
        });
		
		//System.out.println(shipmentList);
		////////////////////
		int noOfVehicles = vehicleInfo.getNoOfVehicles();
		int maxSpeed = vehicleInfo.getMaxSpeed();
		
		PriorityQueue<Double> vehicleAvailability = new PriorityQueue<>();
		for (int i = 0; i < noOfVehicles; i++) {
		    vehicleAvailability.add(0.0); // all vehicles free at time 0
		}
		
		for (Shipment shipment : shipmentList) {
		    // Get the earliest available vehicle
		    double availableTime = vehicleAvailability.poll();

		    // Calculate delivery times for each package in this shipment
		    for (PackageInfo pkg : shipment.getPackages()) {
		        double travelTime = (double) pkg.getPackageDistance() / maxSpeed;
		        double deliveryTime = availableTime + travelTime;
		     
		        deliveryTime = Math.floor(deliveryTime * 100) / 100.0;
		        
		        pkg.setDeliveryTime(deliveryTime);
		    }

		    // Shipment trip time = go to farthest distance and return
		    double tripTime =  ((double) shipment.getDistance() / maxSpeed);
		    tripTime = Math.floor(tripTime * 100) / 100.0;
		    tripTime = 2.0 * tripTime;
		    
		    // Update vehicle availability
		    vehicleAvailability.add(availableTime + tripTime);
		}
		
		return packageInfoList;
	}

}

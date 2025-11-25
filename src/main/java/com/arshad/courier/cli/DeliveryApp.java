package com.arshad.courier.cli;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.arshad.courier.model.PackageInfo;
import com.arshad.courier.model.VehicleInfo;
import com.arshad.courier.service.DeliveryCostEstimator;
import com.arshad.courier.service.DeliveryTimeEstimator;
import com.arshad.courier.service.PrintService;


/**
 * Reads inputs from user (command line) and creates the required
 * data structures used for cost and time calculations.
 * 
 * 
 * @author Arshad
 */
public class DeliveryApp {

	public static void main(String[] args) {

		List<PackageInfo> packageInfoList = new ArrayList<>();

		try (Scanner scanner = new Scanner(System.in)) {

			int baseDeliveryCost = scanner.nextInt();
			int numberOfPackages = scanner.nextInt();

			// for package info
			for (int i = 0; i < numberOfPackages; i++) {
				String packageId = scanner.next();
				int packageWeight = scanner.nextInt();
				int packageDistance = scanner.nextInt();
				String couponCode = scanner.next();

				packageInfoList.add(new PackageInfo(packageId, packageWeight, packageDistance, couponCode));
			}

			// for vehicle info
			int noOfVehicles = scanner.nextInt();
			int maxSpeed = scanner.nextInt();
			int maxWeightItCanCarry = scanner.nextInt();

			VehicleInfo vehicleInfo = new VehicleInfo(noOfVehicles, maxSpeed, maxWeightItCanCarry);

			packageInfoList = DeliveryCostEstimator.estimateDeliveryCost(packageInfoList, baseDeliveryCost);

			packageInfoList = DeliveryTimeEstimator.estimateDeliveryTime(packageInfoList, baseDeliveryCost,
					vehicleInfo);

			PrintService.printResults(packageInfoList);
		}

	}

}

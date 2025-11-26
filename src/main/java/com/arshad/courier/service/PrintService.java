package com.arshad.courier.service;

import java.util.List;

import com.arshad.courier.model.PackageInfo;

/**
 *  Simple Service to print the results to console in the required format.
 * 
 * @author Arshad
 */

public class PrintService {
	
	/**
	 * Uses supplied PackageInfoList to print the results to console.
	 * @param packageInfoList
	 */
	public static void printResults(List<PackageInfo> packageInfoList) {
		
		System.out.println("\nResult:");

		for(PackageInfo pkg: packageInfoList) {
			System.out.println(pkg.getPackageId()+" "+ pkg.getDiscountAmount() +" "+ pkg.getDeliveryCost() + " " + pkg.getDeliveryTime());
		}
		
	}

}

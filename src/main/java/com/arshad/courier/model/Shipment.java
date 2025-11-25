package com.arshad.courier.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Shipment containing one of more {@link PackageInfo} .
 * We can create a new Shipment object and use {@link #addPackage(PackageInfo)} method.
 * 
 * 
 * @author Arshad
 */

public class Shipment {
	//private String shipmentName;
	private List<PackageInfo> packages = new ArrayList<>();
    private int weight;     //assume in kg
    private int distance; //km
    
	/*
	 * public Shipment(String shipmentName, int weight, int distance) { super();
	 * this.shipmentName = shipmentName; this.weight = weight; this.distance =
	 * distance; }
	 */
    
	/*
	 * public Shipment(PackageInfo p) { super(); this.packages.add(p); this.weight =
	 * p.getPackageWeight(); this.distance = p.getPackageDistance(); }
	 */
    
    /**
     * Used to add PackageInfo to the current shipment.
     * @param PackageInfo object
     */
    public void addPackage(PackageInfo p) {
    	this.packages.add(p); 
    	this.weight += p.getPackageWeight();
    	this.distance = Math.max(this.distance, p.getPackageDistance());
    	
    }
    
    public List<PackageInfo> getPackages(){
    	return packages;
    }
    
	public int getWeight() {
		return weight;
	}
	public int getDistance() {
		return distance;
	}
	
	//Helpful for debugging purposes.
	@Override
    public String toString() {
		
		String pkgids = "";
		for(PackageInfo pkg : getPackages()) {
			pkgids = pkgids+ ","+pkg.getPackageId();
		}
		
        return  pkgids + "[Weight=" + weight + "kg, Distance=" + distance + "km]";
    }
}

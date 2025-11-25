package com.arshad.courier.model;


/**
 * This class represents Vehicle information.
 * 
 * @author Arshad
 */
public class VehicleInfo {
	
	private int noOfVehicles;
	private int maxSpeed;
	private int maxCarriableWeight;
	
	
	public VehicleInfo(int noOfVehicles, int maxSpeed, int maxCarriableWeight) {
		super();
		this.noOfVehicles = noOfVehicles;
		this.maxSpeed = maxSpeed;
		this.maxCarriableWeight = maxCarriableWeight;
	}


	public int getNoOfVehicles() {
		return noOfVehicles;
	}


	public int getMaxSpeed() {
		return maxSpeed;
	}


	public int getMaxCarriableWeight() {
		return maxCarriableWeight;
	}
	
	

}

package com.arshad.courier.model;

/**
 * This class represents Package information.
 *  Used to capture information of package supplied by user.
 *  Also, used to store their respective discount amount, delivery cost and time.
 * 
 * @author Arshad
 */

public class PackageInfo {
	
	private String packageId;
    private int packageWeight;
    private int packageDistance;
    private String couponCode;
    
    //new improvements
    private int discountAmount;
    private int deliveryCost;
    private double deliveryTime;
    
	public PackageInfo(String packageId, int packageWeight, int packageDistance, String couponCode) {
		super();
		this.packageId = packageId;
		this.packageWeight = packageWeight;
		this.packageDistance = packageDistance;
		this.couponCode = couponCode;
		
		this.discountAmount = 0;
		this.deliveryCost = 0;
		this.deliveryTime = 0.0;
	}
	
	public String getPackageId() {
		return packageId;
	}
	public int getPackageWeight() {
		return packageWeight;
	}
	public int getPackageDistance() {
		return packageDistance;
	}
	public String getCouponCode() {
		return couponCode;
	}
	
	//new added getters and setters
	public int getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(int discountAmount) {
		this.discountAmount = discountAmount;
	}

	public int getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(int deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public double getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(double deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

}

package com.arshad.courier.model;

/**
 * This model is used by class {@link DiscountRulesService} to hold the Discount Rules.
 * 
 * @author Arshad
 */

public class DiscountRule {
	
	private int discountPercentage;
	private Range distanceRange;
	private Range weightRange;
	
	public DiscountRule(int discountPercentage, Range distanceRange, Range weightRange) {
		super();
		this.discountPercentage = discountPercentage;
		this.distanceRange = distanceRange;
		this.weightRange = weightRange;
	}
	
	public boolean isApplicable(int distance, int weight) {
		return distanceRange.isWithinRange(distance) && weightRange.isWithinRange(weight);
	}

	public int getDiscountPercentage() {
		return discountPercentage;
	}

	public Range getDistanceRange() {
		return distanceRange;
	}

	public Range getWeightRange() {
		return weightRange;
	}
	
}

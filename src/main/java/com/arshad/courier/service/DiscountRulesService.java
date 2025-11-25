package com.arshad.courier.service;

import java.util.HashMap;
import java.util.Map;

import com.arshad.courier.model.DiscountRule;
import com.arshad.courier.model.Range;

/**
 *  Uses {@link DiscountRule} class to create a map of coupon code and
 *  applicable discount rules.
 * 
 * @author Arshad
 */
public class DiscountRulesService {

	private static Map<String, DiscountRule> couponAndRulesMap = new HashMap<>();

	static {
		//along with discount percentage, applicable distanceRange and weightRange are passed in.
		//e.g. 10% discount, applicable for 1 to 200 km distance for packages weighing 0 to 200 kgs.
		couponAndRulesMap.put("OFR001", new DiscountRule(10, new Range(0, 200), new Range(70, 200)));
		couponAndRulesMap.put("OFR002", new DiscountRule(7, new Range(50, 150), new Range(100, 150)));
		couponAndRulesMap.put("OFR003", new DiscountRule(5, new Range(50, 250), new Range(10, 150)));
	}
	
	public static Map<String, DiscountRule> getDiscountRules() {
		return couponAndRulesMap;
	}

}

package com.arshad.courier.service;

import java.util.List;
import java.util.Map;

import com.arshad.courier.model.DiscountRule;
import com.arshad.courier.model.PackageInfo;

/**
 *  Service class to estimate the delivery cost for individual packages.
 *  
 * @author Arshad
 */
public class DeliveryCostEstimator {

	private static Map<String, DiscountRule> discountRules = DiscountRulesService.getDiscountRules();;

	/**
	 * Uses supplied {@code baseDeliveryCost} to calculate base cost. Also, gets the
	 * Discount Rules using {@link DiscountRulesService} and tries to apply the discounts when applicable. 
	 *
	 * @param packageInfoList
	 * @param baseDeliveryCost
	 * @return @return ArrayList of PackageInfo
	 */
	public static List<PackageInfo> estimateDeliveryCost(List<PackageInfo> packageInfoList, int baseDeliveryCost) {

		for (PackageInfo packageInfo : packageInfoList) {
			int deliveryCost = baseDeliveryCost + packageInfo.getPackageWeight() * 10
					+ packageInfo.getPackageDistance() * 5;

			int discountAmount = 0;

			if (discountRules.containsKey(packageInfo.getCouponCode())) {
				DiscountRule discountRule = discountRules.get(packageInfo.getCouponCode());
				if (discountRule.isApplicable(packageInfo.getPackageDistance(), packageInfo.getPackageWeight())) {
					discountAmount = (deliveryCost * discountRule.getDiscountPercentage() / 100);
					deliveryCost = deliveryCost - discountAmount;

				}
			}

			packageInfo.setDeliveryCost(deliveryCost);
			packageInfo.setDiscountAmount(discountAmount);
		}
		
		return packageInfoList;

	}

}

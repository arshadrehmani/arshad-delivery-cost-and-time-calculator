package com.arshad.courier.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.arshad.courier.model.PackageInfo;

class DeliveryCostEstimatorTest {

	@Test
	void testCalculateDeliveryCost_appliesCouponWhenApplicable() {
        
		List<PackageInfo> packageInfoList = new ArrayList<>();
		// PKG1: weight=100, distance=100, coupon=OFR002, it has 7% discount
        PackageInfo pkg = new PackageInfo("PKG1", 100, 100, "OFR002");
        packageInfoList.add(pkg);

        packageInfoList = DeliveryCostEstimator.estimateDeliveryCost(packageInfoList, 100);

        pkg = packageInfoList.get(0);
        
        //base=100 + 100*10 + 100*5 = 1600
        //after 7% discount, cost is 1488
        assertEquals(112, pkg.getDiscountAmount());
        assertEquals(1488, pkg.getDeliveryCost());
    }
	
	@Test
	void testCalculateDeliveryCost_noDiscountWhenInvalidCoupon() {
        /*Take same inputs as above but give invalid coupon code*/
		List<PackageInfo> packageInfoList = new ArrayList<>();
		// PKG1: weight=100, distance=100, coupon=INVALIDCODE
        PackageInfo pkg = new PackageInfo("PKG1", 100, 100, "INVALIDCODE");
        packageInfoList.add(pkg);

        packageInfoList = DeliveryCostEstimator.estimateDeliveryCost(packageInfoList, 100);

        // base=100 + 100*10 + 100*5 = 1600
        // No discount shoudl be given because of invalid code
        // final cost = 1600
        
        pkg = packageInfoList.get(0);
        assertEquals(0, pkg.getDiscountAmount());
        assertEquals(1600, pkg.getDeliveryCost());
    }
	
	@Test
    void testCalculateDeliveryCost_noDiscountWhenCouponNotApplicable() {
        
        List<PackageInfo> packageInfoList = new ArrayList<>();
        // PKG2: weight=50, distance=40, coupon=OFR002 (not applicable)
        PackageInfo pkg = new PackageInfo("PKG2", 50, 40, "OFR002");
        packageInfoList.add(pkg);

        packageInfoList = DeliveryCostEstimator.estimateDeliveryCost(packageInfoList, 100);

        //base=100 + 50*10 + 40*5 = 800
        //no discount
        assertEquals(0, pkg.getDiscountAmount());
        assertEquals(800, pkg.getDeliveryCost());
    }

}

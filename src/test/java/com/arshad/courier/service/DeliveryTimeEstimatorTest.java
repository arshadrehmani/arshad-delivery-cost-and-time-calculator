package com.arshad.courier.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.arshad.courier.model.PackageInfo;
import com.arshad.courier.model.VehicleInfo;

class DeliveryTimeEstimatorTest {

	@Test
	void testCalculateDeliveryTime() {
        
		List<PackageInfo> packageInfoList = new ArrayList<>();
        PackageInfo pkg = new PackageInfo("PKG1", 50, 30, "OFR001");
        packageInfoList.add(pkg);
        
        pkg = new PackageInfo("PKG2", 75, 125, "OFR008");
        packageInfoList.add(pkg);
        
        VehicleInfo vehicleInfo = new VehicleInfo(2, 70, 200);

        packageInfoList = DeliveryTimeEstimator.estimateDeliveryTime(packageInfoList, 100, vehicleInfo);
        
        pkg = packageInfoList.get(0);
        assertEquals(0.42, pkg.getDeliveryTime());
        
        pkg = packageInfoList.get(1);
        assertEquals(1.78, pkg.getDeliveryTime());
    }

}

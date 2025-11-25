package com.arshad.courier.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.arshad.courier.model.DiscountRule;

class DiscountRulesServiceTest {

    @Test
    void defaultRulesPresent() {
        Map<String, DiscountRule> rulesMap = DiscountRulesService.getDiscountRules();
        assertNotNull(rulesMap);
        assertTrue(rulesMap.containsKey("OFR001"));
        assertTrue(rulesMap.containsKey("OFR002"));
        assertTrue(rulesMap.containsKey("OFR003"));
        
        DiscountRule rules = rulesMap.get("OFR001");
        assertEquals(10, rules.getDiscountPercentage());
        
        rules = rulesMap.get("OFR002");
        assertEquals(7, rules.getDiscountPercentage());
        
        rules = rulesMap.get("OFR003");
        assertEquals(5, rules.getDiscountPercentage());

    }
}

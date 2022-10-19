package com.miramontes.learningunittesting.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BusinessImplTest {

    @Test
    void calculateSum_basic() {
        BusinessImpl business = new BusinessImpl();
        int actualResult = business.calculateSum(new int[] {1, 2, 3});
        assertEquals(6, actualResult);
    }

    @Test
    void calculateSum_empty() {
        BusinessImpl business = new BusinessImpl();
        int actualResult = business.calculateSum(new int[] {});
        assertEquals(0, actualResult);
    }

    @Test
    void calculateSum_oneValue() {
        BusinessImpl business = new BusinessImpl();
        int actualResult = business.calculateSum(new int[] {1});
        assertEquals(1, actualResult);
    }
}

package com.miramontes.learningunittesting.business;

import static org.junit.jupiter.api.Assertions.*;

import com.miramontes.learningunittesting.data.SomeDataService;
import com.miramontes.learningunittesting.data.SomeDataServiceImpl;
import org.junit.jupiter.api.Test;

class BusinessImplMockTest {

    private final BusinessImpl business = new BusinessImpl();

    // All test will fail since service always returns the same array.
    private SomeDataService someDataService;

    @Test
    void calculateSum_basic() {
        BusinessImpl business = new BusinessImpl();
        business.setSomeDataService(new SomeDataServiceImpl());
        int actualResult = business.calculateSumUsingDataService();
        assertEquals(6, actualResult);
    }

    @Test
    void calculateSum_empty() {
        BusinessImpl business = new BusinessImpl();
        business.setSomeDataService(new SomeDataServiceImpl());
        int actualResult = business.calculateSumUsingDataService();
        assertEquals(0, actualResult);
    }

    @Test
    void calculateSum_oneValue() {
        BusinessImpl business = new BusinessImpl();
        business.setSomeDataService(new SomeDataServiceImpl());
        int actualResult = business.calculateSumUsingDataService();
        assertEquals(1, actualResult);
    }
}

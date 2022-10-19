package com.miramontes.learningunittesting.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.miramontes.learningunittesting.data.SomeDataServiceImpl;
import org.junit.jupiter.api.Test;

class BusinessImplMockTest {

    private final BusinessImpl business = new BusinessImpl();

    @Test
    void calculateSum_basic() {
        BusinessImpl business = new BusinessImpl();

        // Mock service using Mockito.
        SomeDataServiceImpl someDataServiceMock = mock(SomeDataServiceImpl.class);

        // Mock call to service method. Make it return the array we need.
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {1, 2, 3});

        // Pass Mock service to business class.
        business.setSomeDataService(someDataServiceMock);

        // Check results.
        int actualResult = business.calculateSumUsingDataService();
        assertEquals(6, actualResult);
    }

    @Test
    void calculateSum_empty() {
        BusinessImpl business = new BusinessImpl();

        // Mock service using Mockito.
        SomeDataServiceImpl someDataServiceMock = mock(SomeDataServiceImpl.class);

        // Mock call to service method. Make it return the array we need.
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {});

        // Pass Mock service to business class.
        business.setSomeDataService(someDataServiceMock);

        // Check results.
        int actualResult = business.calculateSumUsingDataService();
        assertEquals(0, actualResult);
    }

    @Test
    void calculateSum_oneValue() {
        BusinessImpl business = new BusinessImpl();

        // Mock service using Mockito.
        SomeDataServiceImpl someDataServiceMock = mock(SomeDataServiceImpl.class);

        // Mock call to service method. Make it return the array we need.
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {1});

        // Pass Mock service to business class.
        business.setSomeDataService(someDataServiceMock);

        // Check results.
        int actualResult = business.calculateSumUsingDataService();
        assertEquals(1, actualResult);
    }
}

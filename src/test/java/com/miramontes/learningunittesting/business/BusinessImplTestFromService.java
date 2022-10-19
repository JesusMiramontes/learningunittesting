package com.miramontes.learningunittesting.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.miramontes.learningunittesting.data.SomeDataServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BusinessImplMockTest {

    private final BusinessImpl business = new BusinessImpl();
    private final SomeDataServiceImpl someDataServiceMock = mock(SomeDataServiceImpl.class);

    @BeforeEach
    void setUp() {
        business.setSomeDataService(someDataServiceMock);
    }

    @Test
    void calculateSum_basic() {
        // Mock call to service method. Make it return the array we need.
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {1, 2, 3});

        // Check results.
        int actualResult = business.calculateSumUsingDataService();
        assertEquals(6, actualResult);
    }

    @Test
    void calculateSum_empty() {
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
        // Mock call to service method. Make it return the array we need.
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {1});

        // Pass Mock service to business class.
        business.setSomeDataService(someDataServiceMock);

        // Check results.
        int actualResult = business.calculateSumUsingDataService();
        assertEquals(1, actualResult);
    }
}

package com.miramontes.learningunittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.miramontes.learningunittesting.data.SomeDataServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BusinessImplMockTest {

    @InjectMocks private final BusinessImpl business = new BusinessImpl();

    @Mock private SomeDataServiceImpl someDataServiceMock;

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

        // Check results.
        int actualResult = business.calculateSumUsingDataService();
        assertEquals(0, actualResult);
    }

    @Test
    void calculateSum_oneValue() {
        // Mock call to service method. Make it return the array we need.
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {1});

        // Check results.
        int actualResult = business.calculateSumUsingDataService();
        assertEquals(1, actualResult);
    }
}

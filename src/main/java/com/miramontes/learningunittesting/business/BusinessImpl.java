package com.miramontes.learningunittesting.business;

import com.miramontes.learningunittesting.data.SomeDataService;
import lombok.Setter;

public class BusinessImpl {

    @Setter private SomeDataService someDataService;

    /**
     * Simple sum method.
     *
     * @param data
     * @return
     */
    public int calculateSum(int[] data) {
        int sum = 0;
        for (int value : data) sum += value;
        return sum;
    }

    public int calculateSumUsingDataService() {
        int sum = 0;
        int[] data = someDataService.retrieveAllData();

        for (int value : data) sum += value;
        return sum;
    }
}

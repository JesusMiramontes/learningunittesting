package com.miramontes.learningunittesting.business;

public class BusinessImpl {

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
}

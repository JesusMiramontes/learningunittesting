package com.miramontes.learningunittesting.data;

public class SomeDataServiceImpl implements SomeDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[] {1, 2, 3, 4};
    }
}

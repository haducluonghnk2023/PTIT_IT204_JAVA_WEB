package com.data.session07.repository;

public class NumberRepositoryImpl implements  NumberRepository {
    @Override
    public int getTotal(int a, int b) {
        return a + b;
    }
}

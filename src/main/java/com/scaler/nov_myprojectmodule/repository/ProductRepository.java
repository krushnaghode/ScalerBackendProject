package com.scaler.nov_myprojectmodule.repository;

public class ProductRepository {
    private static ProductRepository instance;
    private ProductRepository() {
    }
    public static ProductRepository getInstance() {
        if (instance == null) {
            instance = new ProductRepository();
        }
        return instance;
    }
}
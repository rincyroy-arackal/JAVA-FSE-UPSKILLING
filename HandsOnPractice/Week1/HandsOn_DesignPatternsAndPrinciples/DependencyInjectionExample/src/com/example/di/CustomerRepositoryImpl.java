package com.example.di;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Map<String, Customer> database = new HashMap<>();

    public CustomerRepositoryImpl() {
        // Simulate some stored data
        database.put("C101", new Customer("C101", "Alice"));
        database.put("C102", new Customer("C102", "Bob"));
    }

    @Override
    public Customer findCustomerById(String id) {
        return database.get(id);
    }
}

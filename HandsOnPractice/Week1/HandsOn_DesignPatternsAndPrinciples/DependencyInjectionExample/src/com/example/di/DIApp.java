package com.example.di;

public class DIApp {
    public static void main(String[] args) {
        // Manually wiring dependencies
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        // Use the service
        service.getCustomerDetails("C101");
        service.getCustomerDetails("C999"); // Not found case
    }
}

package com.di;

public class CustomerService {
    private final CustomerRepository repository;

    // Constructor Injection
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer getCustomerDetails(String id) {
        return repository.findCustomerById(id);
    }

    public void createCustomer(Customer customer) {
        repository.saveCustomer(customer);
    }

    public void updateCustomer(Customer customer) {
        repository.updateCustomer(customer);
    }

    public void removeCustomer(String id) {
        repository.deleteCustomer(id);
    }
}

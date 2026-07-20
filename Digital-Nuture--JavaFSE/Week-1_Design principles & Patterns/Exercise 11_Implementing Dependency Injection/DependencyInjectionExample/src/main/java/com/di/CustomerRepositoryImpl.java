package com.di;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Map<String, Customer> customers;

    public CustomerRepositoryImpl() {
        customers = new HashMap<>();
        // Add some sample data
        customers.put("1", new Customer("1", "John Doe", "john@example.com"));
        customers.put("2", new Customer("2", "Jane Smith", "jane@example.com"));
    }

    @Override
    public Customer findCustomerById(String id) {
        Customer customer = customers.get(id);
        if (customer == null) {
            System.out.println("Customer not found with ID: " + id);
        }
        return customer;
    }

    @Override
    public void saveCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
        System.out.println("Customer saved: " + customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        if (customers.containsKey(customer.getId())) {
            customers.put(customer.getId(), customer);
            System.out.println("Customer updated: " + customer);
        } else {
            System.out.println("Customer not found for update: " + customer.getId());
        }
    }

    @Override
    public void deleteCustomer(String id) {
        if (customers.remove(id) != null) {
            System.out.println("Customer deleted with ID: " + id);
        } else {
            System.out.println("Customer not found for deletion: " + id);
        }
    }
}

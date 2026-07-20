package com.di;

public interface CustomerRepository {
    Customer findCustomerById(String id);
    void saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(String id);
}

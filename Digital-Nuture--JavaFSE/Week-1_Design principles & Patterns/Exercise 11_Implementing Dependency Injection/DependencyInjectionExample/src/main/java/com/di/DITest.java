package com.di;

public class DITest {
    public static void main(String[] args) {
        // Create the repository
        CustomerRepository repository = new CustomerRepositoryImpl();
        
        // Create the service with injected repository
        CustomerService service = new CustomerService(repository);

        System.out.println("\nTesting Customer Service Operations:");
        System.out.println("------------------------------------");

        // Test finding an existing customer
        System.out.println("\n1. Finding existing customer (ID: 1):");
        Customer customer1 = service.getCustomerDetails("1");
        if (customer1 != null) {
            System.out.println("Found: " + customer1);
        }

        // Test finding a non-existing customer
        System.out.println("\n2. Finding non-existing customer (ID: 999):");
        service.getCustomerDetails("999");

        // Test creating a new customer
        System.out.println("\n3. Creating a new customer:");
        Customer newCustomer = new Customer("3", "Alice Johnson", "alice@example.com");
        service.createCustomer(newCustomer);

        // Test updating the customer
        System.out.println("\n4. Updating customer:");
        Customer updatedCustomer = new Customer("3", "Alice Johnson Updated", "alice.updated@example.com");
        service.updateCustomer(updatedCustomer);

        // Test deleting customers
        System.out.println("\n5. Deleting customers:");
        service.removeCustomer("3");  // Should succeed
        service.removeCustomer("999");  // Should fail
    }
}

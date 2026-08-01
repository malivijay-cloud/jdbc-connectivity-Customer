package org.example.service;

import org.example.Repository.CustomerRepository;
import org.example.model.Customer;

import java.util.List;

public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // CREATE
    public boolean addCustomer(Customer customer) {
        return customerRepository.saveCustomer(customer);
    }

    // READ ALL
    public List<Customer> viewCustomers() {
        return customerRepository.getAllCustomers();
    }

    // READ BY ID
    public Customer getCustomerById(int id) {
        return customerRepository.getCustomerById(id);
    }

    // UPDATE
    public boolean editCustomer(Customer customer) {
        return customerRepository.updateCustomer(customer);
    }

    // DELETE
    public boolean removeCustomer(int id) {
        return customerRepository.deleteCustomer(id);
    }
}
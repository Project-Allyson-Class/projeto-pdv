package com.pdv.demo.core.customers;

import com.pdv.demo.core.customers.entities.Customer;

import java.util.List;
import java.util.UUID;

public interface ICustomerUseCase {
    Customer create(Customer customer);
    List<Customer> getAll();
    Customer getById(UUID id);
    Customer update(Customer customer);
    void delete(UUID id);
}

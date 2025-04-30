package com.pdv.demo.application.customers;

import com.pdv.demo.core.customers.ICustomerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService implements ICustomerUseCase {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(UUID id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);  // Vai atualizar o cliente, se existir
    }

    @Override
    public void delete(UUID id) {
        customerRepository.delete(id);
    }
}

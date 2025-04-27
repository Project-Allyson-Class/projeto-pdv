package com.pdv.demo.infra.customers;

import com.pdv.demo.core.customers.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    // Aqui você pode adicionar métodos personalizados depois, se precisar
}

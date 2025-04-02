package com.pdv.demo.infra.repositories;

import com.pdv.demo.core.products.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}

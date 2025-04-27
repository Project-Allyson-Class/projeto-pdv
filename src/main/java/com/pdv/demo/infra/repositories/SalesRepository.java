package com.pdv.demo.infra.sales;

import com.pdv.demo.core.sales.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SalesRepository extends JpaRepository<Sale, UUID> {
    // Se precisar depois, podemos criar métodos personalizados aqui também
}

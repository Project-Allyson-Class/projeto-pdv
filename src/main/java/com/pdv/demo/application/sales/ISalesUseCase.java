package com.pdv.demo.core.sales;

import com.pdv.demo.core.sales.entities.Sale;

import java.util.List;
import java.util.UUID;

public interface ISalesUseCase {
    Sale create(Sale sale);
    List<Sale> getAll();
    Sale getById(UUID id);
    void delete(UUID id);
}

package com.pdv.demo.application.sales;

import com.pdv.demo.core.sales.ISalesUseCase;
import com.pdv.demo.core.sales.ISalesRepository;
import com.pdv.demo.core.sales.entities.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SalesService implements ISalesUseCase {

    @Autowired
    private ISalesRepository salesRepository;

    @Override
    public Sale create(Sale sale) {
        // Aqui você pode adicionar regras de negócio, validações, etc.
        return salesRepository.save(sale);
    }

    @Override
    public List<Sale> getAll() {
        return salesRepository.findAll();
    }

    @Override
    public Sale getById(UUID id) {
        return salesRepository.findById(id);
    }

    @Override
    public void delete(UUID id) {
        salesRepository.delete(id);
    }
}

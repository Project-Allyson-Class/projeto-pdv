package com.pdv.demo.core.products;

import com.pdv.demo.application.products.dtos.ProductDto;
import com.pdv.demo.core.products.entities.ISalesUseCase;
import com.pdv.demo.core.products.entities.Product;
import com.pdv.demo.infra.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class ProductService implements IProductsUseCase {

    @Autowired
    private ProductRepository repository;

    @Override
    public Product create(ProductDto dto) {
        var product = new Product(dto);
        return this.repository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product getById(UUID id) {
        return repository.findById(id)
            .orElse(null);
    }

    @Override
    public Product update(ProductDto dto) {
        return repository.findById(dto.id())
            .map(product -> {
                if (Objects.nonNull(dto.name()))
                    product.setName(dto.name());

                if (dto.price() != 0)
                    product.setPrice(dto.price());

                return repository.save(product);
            })
            .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Service
    public static class SalesService implements ISalesUseCase {

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
}

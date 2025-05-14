package com.data.session07.repository;

import com.data.session07.model.Product09;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements  ProductRepository {
    private final List<Product09> products = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public List<Product09> findAll() {
        return new ArrayList<>(products);
    }

    @Override
    public Optional<Product09> findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    @Override
    public void save(Product09 product) {
        if (product.getId() == null) {
            product.setId(idGenerator.getAndIncrement());
            products.add(product);
        } else {
            deleteById(product.getId());
            products.add(product);
        }
    }

    @Override
    public void deleteById(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    @Override
    public List<Product09> search(String keyword) {
        return products.stream()
                .filter(p -> p.getName() != null && p.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}

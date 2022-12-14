package com.example.productservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);
    List<Product> findByPrice(Double price);

    Product save(Product product);
}
package com.example.productservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public void save(Product delivery) {
        productRepository.save(delivery);
    }

    public ResponseEntity deleteProductById(Long id) {
        Optional<Product> toDelete = productRepository.findById(id);
        if(toDelete.isPresent()) {
            productRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @Transactional
    public ResponseEntity updateProductById(Long id, Product delivery) {
        Optional<Product> toUpdate = productRepository.findById(id);
        if(toUpdate.isPresent()){
            Product l1 = toUpdate.get();
            l1.setName(delivery.getName());
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    public Product getSpecificProduct(String name) {
        Product product = productRepository.findByName(name);
        return product;
    }

    public List<Product> getSpecificProductByPrice(Double price) {
        List<Product> products = productRepository.findByPrice(price);
        return products;
    }
}
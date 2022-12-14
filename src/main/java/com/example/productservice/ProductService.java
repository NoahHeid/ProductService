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

    public Product save(Product product) {
        return productRepository.saveAndFlush(product);
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
    public ResponseEntity updateProductById(Long id, Product product) {
        Optional<Product> toUpdate = productRepository.findById(id);
        if(toUpdate.isPresent()){
            Product l1 = toUpdate.get();
            l1.setName(product.getName());
            l1.setDescription(product.getDescription());
            l1.setPrice(product.getPrice());
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    public Product getSpecificProduct(String name) {
        return productRepository.findByName(name);
    }

    public List<Product> getSpecificProductByPrice(Double price) {
        return productRepository.findByPrice(price);
    }
}
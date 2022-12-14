package com.example.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List> getAllProducts(){
        List<Product> lieferungen = productService.getAllProducts();
        return new ResponseEntity(lieferungen, HttpStatus.OK);
    }
    @GetMapping("/product")
    public ResponseEntity getSpecificProduct(@RequestParam String name){
        Product delivery = productService.getSpecificProduct(name);
        return new ResponseEntity(delivery, HttpStatus.OK);
    }

    @GetMapping("/products-by-price")
    public ResponseEntity<List> getSpecificProductByPrice(@RequestParam Double price){
        List<Product> deliveries = productService.getSpecificProductByPrice(price);
        return new ResponseEntity(deliveries, HttpStatus.OK);
    }
    @PostMapping("/product")
    public ResponseEntity saveProduct(@RequestBody Product delivery){
        productService.save(delivery);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @DeleteMapping("/product")
    public ResponseEntity deleteProduct(@RequestParam Long id){
        return productService.deleteProductById(id);
    }
    @PutMapping("/product")
    public ResponseEntity updateProduct(@RequestParam Long id, @RequestBody Product delivery){
        return productService.updateProductById(id, delivery);

    }


}
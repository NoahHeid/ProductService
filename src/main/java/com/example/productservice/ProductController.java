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
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity(products, HttpStatus.OK);
    }
    @GetMapping("/product")
    public ResponseEntity getSpecificProduct(@RequestParam String name){
        Product product = productService.getSpecificProduct(name);
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @GetMapping("/products-by-price")
    public ResponseEntity<List> getSpecificProductByPrice(@RequestParam Double price){
        List<Product> products = productService.getSpecificProductByPrice(price);
        return new ResponseEntity(products, HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity saveProduct(@RequestBody Product product){
        try {
            productService.save(product);
        } catch (Exception e){
            return new ResponseEntity("Fehlerhafte Anfrage!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(product, HttpStatus.CREATED);
    }
    @DeleteMapping("/product")
    public ResponseEntity deleteProduct(@RequestParam Long id){
        return productService.deleteProductById(id);
    }
    @PutMapping("/product")
    public ResponseEntity updateProduct(@RequestParam Long id, @RequestBody Product product){
        return productService.updateProductById(id, product);

    }


}
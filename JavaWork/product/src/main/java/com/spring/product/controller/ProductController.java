package com.spring.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.product.dao.ProductDao;
import com.spring.product.model.Product;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductDao productRepository;

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        int result = productRepository.addProduct(product);
        if (result > 0) {
            return new ResponseEntity<>("Product added successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add product.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productRepository.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}


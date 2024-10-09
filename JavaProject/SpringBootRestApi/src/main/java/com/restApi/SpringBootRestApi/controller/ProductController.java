package com.restApi.SpringBootRestApi.controller;

import com.restApi.SpringBootRestApi.entity.Product;
import com.restApi.SpringBootRestApi.exception.ProductNotFoundException;
import com.restApi.SpringBootRestApi.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products") // Base URL for all product-related endpoints
public class ProductController {
    private final ProductService productService;

    @Autowired // Constructor injection for the ProductService
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addProducts") // Endpoint to add a new product
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
        Product createdProduct = productService.addProduct(product); // Call the service to add the product
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED); // Return created product with 201 status
    }

    @GetMapping("/viewAllProducts") // Endpoint to retrieve all products
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.viewAllProducts(); // Call service to get all products
        return ResponseEntity.ok(products); // Return the list of products with 200 status
    }

    @DeleteMapping("/deleteProduct/{id}") // Endpoint to delete a product by ID
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long productId) throws ProductNotFoundException {
        productService.deleteProduct(productId); // Call the service to delete the product
        return ResponseEntity.ok("Product deleted successfully"); // Returns 200 OK status with the success message
    }

    @GetMapping("/searchProduct/{name}") // Endpoint to search for products by name
    public ResponseEntity<List<Product>> searchProduct(@PathVariable("name") String productName) throws ProductNotFoundException {
        List<Product> products = productService.searchProduct(productName); // Call service to search for products
        return ResponseEntity.ok(products); // Return the list of found products with 200 status
    }

    @GetMapping("/discount/{id}") // Endpoint to get the discount for a specific product
    public ResponseEntity<String> getDiscount(@PathVariable("id") long productId) throws ProductNotFoundException {
        int discount = productService.discount(productId); // Call service to get the discount for the product
        return ResponseEntity.ok("Discount for the given product is: " + discount + "%"); // Return the discount with 200 status
    }
}

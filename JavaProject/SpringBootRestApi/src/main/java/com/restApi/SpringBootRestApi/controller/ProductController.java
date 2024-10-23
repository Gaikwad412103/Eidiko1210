package com.restApi.SpringBootRestApi.controller;

import com.restApi.SpringBootRestApi.dto.ProductAddRequest;
import com.restApi.SpringBootRestApi.dto.ProductDTO;
import com.restApi.SpringBootRestApi.entity.Product;
import com.restApi.SpringBootRestApi.exception.ProductNotFoundException;
import com.restApi.SpringBootRestApi.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "Products",
        description = "Doing The Crud Operation After User Successful login"
)
@RestController
@RequestMapping("/products") // Base URL for all product-related endpoints
public class ProductController {
    private final ProductService productService;

    @Autowired // Constructor injection for the ProductService
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @Operation(
            summary = "Add The New Product"
    )
    @PostMapping("/addProducts") // Endpoint to add a new product
    public ResponseEntity<ProductDTO> addProduct(@Valid @RequestBody ProductAddRequest product) {
        ProductDTO createdProduct = productService.addProduct(product); // Call the service to add the product
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED); // Return created product with 201 status
    }
    @Operation(
            summary = "Fetch all products",
            description = "fetches all products entities and their data from data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping("/viewAllProducts") // Endpoint to retrieve all products
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.viewAllProducts(); // Call service to get all products
        return ResponseEntity.ok(products); // Return the list of products with 200 status
    }
    @Operation(
            summary = "Delete The Product By Id"
    )
    @DeleteMapping("/deleteProduct/{id}") // Endpoint to delete a product by ID
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long productId) throws ProductNotFoundException {
        productService.deleteProduct(productId); // Call the service to delete the product
        return ResponseEntity.ok("Product deleted successfully"); // Returns 200 OK status with the success message
    }
    @Operation(
            summary = "Search Product by name",
            description = "fetches product entities and their data from data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping("/searchProduct/{name}") // Endpoint to search for products by name
    public ResponseEntity<List<ProductDTO>> searchProduct(@PathVariable("name") String productName) throws ProductNotFoundException {
        List<ProductDTO> products = productService.searchProduct(productName); // Call service to search for products
        return ResponseEntity.ok(products); // Return the list of found products with 200 status
    }
    @Operation(
            summary = "Check The Discount By Id"
    )
    @GetMapping("/discount/{id}") // Endpoint to get the discount for a specific product
    public ResponseEntity<String> getDiscount(@PathVariable("id") long productId) throws ProductNotFoundException {
        int discount = productService.discount(productId); // Call service to get the discount for the product
        return ResponseEntity.ok("Discount for the given product is: " + discount + "%"); // Return the discount with 200 status
    }
}

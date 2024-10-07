package com.restApi.SpringBootRestApi.controller;

import com.restApi.SpringBootRestApi.entity.Product;
import com.restApi.SpringBootRestApi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/products/addProducts")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
    @GetMapping("/products/viewAllProducts")
    public List<Product> viewAllProducts(){
        return productService.viewAllProducts();
    }
    @DeleteMapping("/products/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") long productId){
       productService.deleteProduct(productId);
       return "product Deleted Successfully";
    }
    @GetMapping("/products/searchProduct/{name}")
    public List<Product> searchProduct(@PathVariable("name") String productName){
        return productService.searchProduct(productName);
    }


}

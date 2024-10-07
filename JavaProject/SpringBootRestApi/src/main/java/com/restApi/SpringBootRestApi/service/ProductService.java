package com.restApi.SpringBootRestApi.service;

import com.restApi.SpringBootRestApi.entity.Product;

import java.util.List;

public interface ProductService {
    public Product addProduct(Product product);

    public List<Product> viewAllProducts();

    public void deleteProduct(long id);

    public List<Product> searchProduct(String productName);
}

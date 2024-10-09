package com.restApi.SpringBootRestApi.service;

import com.restApi.SpringBootRestApi.entity.Product;
import com.restApi.SpringBootRestApi.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    public Product addProduct(Product product);

    public List<Product> viewAllProducts();

    public void deleteProduct(long id) throws ProductNotFoundException;

    public List<Product> searchProduct(String productName) throws ProductNotFoundException;

    public int discount(long productId) throws ProductNotFoundException;
}

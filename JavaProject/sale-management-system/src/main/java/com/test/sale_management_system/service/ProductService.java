package com.test.sale_management_system.service;

import com.test.sale_management_system.entity.Product;

import java.util.List;

public interface ProductService {
    public Product addProduct(Product product);

    public List<Product> fetchAllProducts();
}

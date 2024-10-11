package com.restApi.SpringBootRestApi.service;

import com.restApi.SpringBootRestApi.dto.ProductDTO;
import com.restApi.SpringBootRestApi.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    public ProductDTO addProduct(ProductDTO product);

    public List<ProductDTO> viewAllProducts();

    public void deleteProduct(long id) throws ProductNotFoundException;

    public List<ProductDTO> searchProduct(String productName) throws ProductNotFoundException;

    public int discount(long productId) throws ProductNotFoundException;
}

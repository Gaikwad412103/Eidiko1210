package com.restApi.SpringBootRestApi.service.implementation;

import com.restApi.SpringBootRestApi.entity.Product;
import com.restApi.SpringBootRestApi.repository.ProductRepository;
import com.restApi.SpringBootRestApi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService {
    private ProductRepository productRepository;
    @Autowired
    public ProductServiceImplementation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> viewAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> searchProduct(String productName) {
        return productRepository.findByName(productName);
    }
}

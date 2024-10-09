package com.restApi.SpringBootRestApi.service.implementation;

import com.restApi.SpringBootRestApi.entity.Product;
import com.restApi.SpringBootRestApi.exception.ProductNotFoundException;
import com.restApi.SpringBootRestApi.repository.ProductRepository;
import com.restApi.SpringBootRestApi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public void deleteProduct(long id) throws ProductNotFoundException {
        Optional<Product> product=productRepository.findById(id);
        if(product.isEmpty()){
            throw new ProductNotFoundException("Product is not exist!!");
        }
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> searchProduct(String productName) throws ProductNotFoundException {
        List<Product> product=productRepository.findByName(productName);
        if(product.isEmpty()){
            throw new ProductNotFoundException("Product is not exist!!");
        }
        return productRepository.findByName(productName);
    }

    @Override
    public int discount(long productId) throws ProductNotFoundException {
        Optional<Product> product=productRepository.findById(productId);
        if(product.isPresent()){
            throw new ProductNotFoundException("Product is not exist!!");
        }
        if(product.get().getPrice()<=50){
            return 0;
        }
        else if(product.get().getPrice()<=200){
            return 5;
        }
        else if(product.get().getPrice()<=500){
            return 10;
        }
        else if(product.get().getPrice()<=1000){
            return 15;
        }
        else if(product.get().getPrice()<=2000){
            return 20;
        }
        return 30;
    }
}

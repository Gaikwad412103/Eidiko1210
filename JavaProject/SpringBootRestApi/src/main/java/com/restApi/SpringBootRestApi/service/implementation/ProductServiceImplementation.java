package com.restApi.SpringBootRestApi.service.implementation;

import com.restApi.SpringBootRestApi.dto.ProductAddRequest;
import com.restApi.SpringBootRestApi.dto.ProductDTO;
import com.restApi.SpringBootRestApi.entity.Product;
import com.restApi.SpringBootRestApi.exception.ProductNotFoundException;
import com.restApi.SpringBootRestApi.repository.ProductRepository;
import com.restApi.SpringBootRestApi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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
    public ProductDTO addProduct(ProductAddRequest productDTO) {
        Product product=this.mapToEntity(productDTO);
        Product saveProduct=productRepository.save(product);
        return this.mapToDTO(saveProduct);
    }

    @Override
    public List<ProductDTO> viewAllProducts() {
        List<Product> products=productRepository.findAll();
        List<ProductDTO> productDTOs = new ArrayList<>();

        for (Product product : products) {
            productDTOs.add(mapToDTO(product));
        }

        return productDTOs;
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
    public List<ProductDTO> searchProduct(String productName) throws ProductNotFoundException {
        List<Product> product=productRepository.findByName(productName);
        if(product.isEmpty()){
            throw new ProductNotFoundException("Product is not exist!!");
        }
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product1 : product) {
            productDTOs.add(mapToDTO(product1));
        }

        return productDTOs;
    }

    @Override
    public int discount(long productId) throws ProductNotFoundException {
        Optional<Product> product=productRepository.findById(productId);
        if(product. isEmpty()){
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

    // Convert DTO to Entity
    private Product mapToEntity(ProductAddRequest productDTO) {
        return Product.builder()
                .name(productDTO.getName())
                .productType(productDTO.getProductType())
                .productDetails(productDTO.getProductDetails())
                .price(productDTO.getPrice())
                .build();
    }

    // Convert Entity to DTO
    private ProductDTO mapToDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .productType(product.getProductType())
                .productDetails(product.getProductDetails())
                .price(product.getPrice())
                .created_date(LocalDate.parse(product.getCreated_date().toString()))
                .build();
    }
}

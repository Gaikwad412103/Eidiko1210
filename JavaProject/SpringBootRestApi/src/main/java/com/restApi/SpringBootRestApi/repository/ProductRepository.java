package com.restApi.SpringBootRestApi.repository;

import com.restApi.SpringBootRestApi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    public List<Product> findByName(String name);
}

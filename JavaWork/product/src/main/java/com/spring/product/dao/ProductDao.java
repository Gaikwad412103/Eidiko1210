package com.spring.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.product.model.Product;

@Repository
public class ProductDao {
	@Autowired
    private JdbcTemplate jdbcTemplate;

    public int addProduct(Product product) {
        String sql = "INSERT INTO products (name, price) VALUES (?, ?)";
        return jdbcTemplate.update(sql, product.getName(), product.getPrice());
    }

    public List<Product> getAllProducts() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }
}
